# QR Code Generator with Spring Boot

A simple Spring Boot web application that generates and stores QR codes using the ZXing library. Generated QR codes are saved locally and stores address in  Oracle database, and they can be accessed via REST API or a user-friendly HTML interface.

---

##  Features

- Generate QR codes from user input
- Save QR code images locally under `/static/qrcodes`
- Persist QR code metadata (data + file path) in Oracle DB
- Display generated QR code on an HTML page
- REST API and frontend integration


---

##  Tech Stack

- **Java**: 17  
- **Spring Boot**: 3.4.3  
- **Frontend**: HTML/CSS  
- **QR Library**: ZXing (core & javase)  
- **Database**: Oracle  
- **Build Tool**: Maven  

---

## Project Structure

QrGeneration/

├── src/

│   ├── main/

│   │   ├── java/

│   │   │   └── com/qrcode/QrGeneration/

│   │   │       ├── QRCodeController.java

│   │   │       ├── QRCodeService.java

│   │   │       ├── QRCodeEntity.java

│   │   │       └── QRCodeRepository.java

│   │   └── resources/

│   │       ├── static/

│   │       │   ├── index.html

│   │       │   └── qrcodes/

│   │       └── application.properties

├── pom.xml

---


##  How to Run (Windows & CentOS)

##  Windows

##  Prerequisites

- Java 17 installed (`JAVA_HOME` set)
- Maven installed and in `PATH`
- Oracle DB running

####  Steps


git clone https://github.com/your-username/QrGeneration.git

cd QrGeneration

 ## Edit src/main/resources/application.properties:

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe

spring.datasource.username=your_username

spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

Then run:


command: mvn spring-boot:run

Open your browser:

http://localhost:8080

## CentOS

##  Prerequisites

sudo yum install java-17-openjdk

sudo yum install maven

sudo yum install git

Clone the project:

git clone https://github.com/your-username/QrGeneration.git

cd QrGeneration

## Edit your database config in application.properties, then run:

mkdir -p src/main/resources/static/qrcodes

chmod -R 755 src/main/resources/static/qrcodes

mvn spring-boot:run

Open in browser:

    http://<your-server-ip>:8080

## Optional: Allow port through firewall:

sudo firewall-cmd --add-port=8080/tcp --permanent

sudo firewall-cmd --reload

# API Endpoint

Method - POST

URL - /api/qrcode/generate

Description - Generates a QR code and stores it


    
# Frontend (HTML)

Open src/main/resources/static/index.html in your browser or serve via Live Server.

or 

http://localhost:8080

Enter data → Click Generate → Click Display → See QR

# Build Jar

mvn clean package


# for Docker image

expose port:8080




