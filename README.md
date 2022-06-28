# Simple File Parser
This is a console application which receives a path to a directory as argument to start analyzing files with the supported extensions that the program manages. For now, the program only processes .txt files.

This application checks continuously the directory for files to take statistics from, which right now are: total number of dots, total number of words and most repeated word. When a file gets processed, the program will make a copy of it and move it to a sub-directory in the previously specified path called "processed". 

The application has a class called "TxtFile" which defines how the parsing is going to be made for this type of file. In the future, we would add more classes like this for the required file types to have the same result. The "App" class is the one that handles all the logic about the statistics and runs the main method to keep checking the directory until stopped by the user.
## Installation
Before installing, make sure to have installed in your machine:
 - Java 11
 - Maven 3.8.6 or newer
## Maven Dependencies
- Junit:
```xml
<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-api</artifactId>
	<version>5.9.0-M1</version>
	<scope>test</scope>
</dependency>
```
- Maven Shade:
``` xml
<dependency>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-shade-plugin</artifactId>
	<version>3.3.0</version>
	<type>maven-plugin</type>
</dependency>
```
To start using this application, clone the repository: 
``` bash
git clone https://github.com/Dave2207/SimpleFileParser 
```
After cloning the repository, enter the project directory:
``` bash
cd SimpleFileParser
```
To build the application run the following command in the terminal:
``` bash
mvn clean compile package
```
After having the application compiled, you can proceed to run the program typing the following:
``` bash
java -jar target/SimpleFileParser-1.0-SNAPSHOT.jar <path/to/directory>
```
## Testing
To execute the unit tests, type the following in your terminal inside the root directory of the repository:
``` bash
mvn clean test
```
The remaining tests remain commented at the moment due to them presenting unexpected errors.
