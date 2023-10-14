# API VollMed
This project is an API built using Java, Java Spring, Flyway Migrations, MySQL as the database, and Spring Security and JWT for authentication control.

## Table of Contents

- [Development IDE](#development-ide)
- [Development Operating System](#development-operating-system)
- [Language Used](#language-used)
- [Database](#database)

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## API Endpoints
The API provides the following endpoints:

```markdown
GET /medicos - Retrieve a list of all data.
GET /pacientes - Retrieve a list of all data.

POST /medicos - Register a new data.
POST /pacientes - Register a new data.

PUT /medicos - Alter data.
PUT /pacientes - Alter data.

DELETE /medicos/{id} - Inactivate data.
DELETE /pacientes/{id} - Inactivate data.

POST /login - Login into the App
```

## Development IDE:

* Description: The project was fully developed using Eclipse, and all of its functionalities were tested on it.

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/eclipse/eclipse-original.svg" title="eclipse" alt="eclipse" width="60" height="60"/>&nbsp;

## Development Operating System:

* Description: The project was initially developed on Windows 11.
  
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/windows8/windows8-original.svg" title="Windows" alt="Windows" width="60" height="60"/>&nbsp;

## Language Used:

* Description: Project developed using the SpringBoot framework.

<div>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" title="spring" alt="spring" width="60" height="60"/>&nbsp;

## Database
The project uses MySQL as the database. The necessary database migrations are managed using Flyway.

To install MySQL locally you can [click here](https://dev.mysql.com/downloads/).

