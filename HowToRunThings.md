TO RUN THE MICROSERVICES (BOTH cart-service and catalog-service), RUN THE FOLLOWING COMMAND:
./mvnw spring-boot:run

TO RUN bookstore-frontend, RUN THE FOLLOWING COMMAND:
npm start

TO ADD A BOOK INTO DATABASE, USE THE FOLLOWING COMMAND FOR POSTGRESQL:
 INSERT INTO book (title, author, price) VALUES (‘book_title’, ‘author_name’, 0.0);

THE FOLLOWING IS HOW I WENT IN EDITOR MODE FOR DATABASE LOCALLY. JUST PUTTING IT HERE IN CASE:
psql -U aryanpatronia -d bookstore
