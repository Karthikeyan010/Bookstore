import http from 'k6/http';
import { check, sleep } from 'k6';
import { Counter } from 'k6/metrics';

export let options = {
  stages: [
    { duration: '3m', target: 700 },  // Ramp up to 500 users
    { duration: '2m', target: 700 },  // Hold 500 users for 3 minutes
    { duration: '2m', target: 0 },    // Ramp down
  ],
};

export default function () {

    let res;
    try {
        res = http.get('http://34.89.118.25:8080/api/catalog', { timeout: '250s' });
    } catch (error) {
        console.error(`[ERROR] Request failed: ${error.message}`);
        return;
    }

    // Print response status and a part of the response body (check if body exists)
    if (res && res.body) {
        console.log(`Response: ${res.status} - ${res.body.substring(0, 100)}`);
    } else {
        console.log(`Response: ${res ? res.status : 'Unknown'} - No response body`);
    }
}

