# Phase 3 End Project - Create a Task Manager
## Application
## Project Objective:
### Create a task manager application with spring boot and spring Data JPA.

### Background of Problem Statement:
The Task Manager is for organizing tasks (or to-dos) for workers.

The logged in user should be able to create, display, delete, and update tasks (basically to-do items.)

Tasks are the user's own tasks. Users create and edit tasks to themselves but can neither create tasks for others, reassign existing tasks to other users or even view tasks that do not belong to them.

The application will have UI in JSP.

### Suggested JSP Pages:

create task
display tasks
delete tasks
update task.
Login
User Registration
Index/Welcome
Important Notes:
Project must be well organized in packages.
Usage of Repository, Service, Entity, and custom exception handling
All data must persist in the database. (User information should also be stored in database)
User must be logged in before adding or seeing the tasks. (spring boot security is acceptable but not mandatory.)
User must get registered, to perform the login.
Either monolithic or microservice based architecture is acceptable.
Important fields of this application:
Task name (text box)
Start date (date picker)
End date (date picker)
Description (text area)
Email (text box)
Severity (drop down) (High, medium, low)
User (tasks should belong to a user)