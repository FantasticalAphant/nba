# NBA Stats

This application converts data stored in CSV files and uses Spring Batch to convert and store these data into an in-memory database.

## Running locally:

### Prerequisites:
- yarn or npm
- Java

### Backend
`$ ./mvnw spring-boot:run`

### Frontend
```sh
$ cd src/frontend/src/images
$ sh logo_downloader.sh # download team logos
$ cd ../..
$ yarn install || npm install
$ yarn start || npm start
```
