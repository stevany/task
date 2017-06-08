This application build in Java, using Spring Boot, Spring Rest, Spring Data JPA
I've seperated the application backend and frontend.
-backend=task-backend
 db name=task
 db provider=mysql
 the configuration files can be found in resources/application.properties.
-frontend=task-frontend
 change url backend in file app.js, with var urlApi;
 then run the web server

 Application:
   * There are two input : name and description.
   * When create the task, after input name and description, click add button, to cancel, just click cancel
   * The data would be added on the table list down.
   * Two button available on the table list: update and delete.
   * When update the task, after updating name or description, click update button, to cancel, just click cancel
