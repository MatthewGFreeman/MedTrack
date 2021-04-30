# MedTrack

A web application where users can track medical injections by medicine, date, and location on the body the shot was given.


## What do you need to use MedTrack?
- [ ] Docker (https://www.docker.com/get-started)
- [ ] Gradle (https://gradle.org/install/) (Instructions to install Java are provided at this link)
- [ ] A web browser


Database: Run and Load data in Docker environment and Access data
```bash
# To ensure all necessary drivers and dependencies are intalled:
gradle build

# In resources folder:
docker build -t medtrack .

# In another prompt:
docker run -d -e POSTGRES_PASSWORD=p4ssw0rd -p 5432:5432 medtrack

# To get the container name:
docker ps

# To access database in command line where <container-name> is from list generated from above:
docker exec -it <container-name> psql -U medtrack
```

MedTrack: Test and Run
```bash
# To run test:
gradle test

# To begin:
gradle appRun
```

## User stories & Features


### Features
- [x] Agile User Stories
- [x] Java SE 8
- [x] Gradle
- [x] JDBC
- [x] PostgreSQL
- [x] JavaEE Servlet
- [x] HTML/CSS/JS
- [x] Fetch
- [x] JUnit
- [ ] log4j
- [ ] Jest
- [x] Docker
- [x] Bootstrap
- [x] Data Access Object
- [ ] SQL Normilization (3rd form)
- [ ]  CRUD
    - [x] Create
    - [x] Read
    - [ ] Update
    - [ ] Delete
- [x] Login
- [x] Database persistnace
- [x] Session management

### User Stories
- [x] can login
- [x] can logout
- [x] can view previous injections
- [x] can submit a new record
    - [x] new medicine
    - [x] new injection given
        - [x] notes about inection
- [ ] can update
    - [ ] medicine
    - [ ] location
    - [ ] notes
