This project has been created in-order to creatte selenium testing functionalities for the CICD accelerator.

This is an simple maven war project, which I used to test the functionalities of the CICD accelerator tool

mvn clean install -> Clean the existing target folder and creates the new target folder along with the war file inside the target folder.
mvn clean -> Cleans the existing target folder and deletes the war file.
mvn package -> Similar to clean install, but it updates the existing war file onto the newer version of it.
mvn test -> Run the testcases on the application.
