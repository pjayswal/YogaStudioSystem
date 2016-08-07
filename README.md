Running YogaStudio System.
-------------------------

Tools required:
----------------
1. Spring Tool Suite
2. MySql server running on localhost

Running the application:
----------------------
1. Git clone the project
2. Import the project in Spring Tool Suite as existing Maven project
3. Create a database with name 'yogadb' in mysql.
4. Set up mysql user name password in the highlighted lines here: https://github.com/pjayswal/YogaStudioSystem/blob/master/YogaStudioWebPortal/src/main/webapp/WEB-INF/spring/root-context.xml#L80-L81
 Current configuration contains username and password both as 'root', replace them with your mysql server credentials.
5. Set up the spring configuration to start the application in a way to create the SQL Tables on start. replace the string 'update' with 'create' on line: https://github.com/pjayswal/YogaStudioSystem/blob/master/YogaStudioWebPortal/src/main/webapp/WEB-INF/spring/root-context.xml#L68

6. Run YogaStudioWebPortal on Tomcat or any supported Http server.
