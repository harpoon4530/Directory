### To Build
You need to have OpenJDK installed: _openjdk-21_

https://docs.oracle.com/en/java/javase/21/install/installation-jdk-macos.html#GUID-EB197354-E07E-4C6A-8AF6-642E23241D39

You need to have mac ports installed on your machine
Follow the instructions to install _maven_.
https://ports.macports.org/port/maven3/

Download dependencies
_mvn dependency:resolve_

_mvn clean package_


_mvn clean package_
java -cp ./target/DirectoryJ-1.0-SNAPSHOT.jar org.personio.App

java -cp ./target/PersonIo.jar org.personio.App


You need:

CI/CD
Config params
Better logging
Metrics tracking
Proper class abstraction