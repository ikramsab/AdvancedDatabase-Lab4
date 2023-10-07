# Lab: Java Database Connectivity (JDBC)

The goal of the lab is to write a utility class named DataAccess that enables an application to transparently access its data, using high-level Java methods. The DataAccess class is meant to hide from the application how its data is actually stored (here, in a relational database) as well as all the complex machinery required to access it (here, JDBC library and SQL statements).


## Table of contents
- [Getting Started](#Getting-Started)
- [Exercice 1](#Exercise-1)
- [Exercise 2](#Exercise-2)
- [Exercise 3](#Exercse-3)
- [Exercise 4](#Exercise-4)
- [Exercise 5](#Exercise-5)
- [Exercise 6](#Exercice-6)
- [Contributors](#contributors)
- [Licence](#licence)

<hr>

## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

For the purpose of this lab you will need 
* IDE such as Netbeans, IntellijCode or Visual Studio Code
In my case , i work on VS code
* You will also need the Java Extension :[Extention pack for java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)


### Installation
**This part is from the Lab paper**

1. Download the jar file at : [Dowload MySQL connector](https://github.com/ikramsab/MySQL-JDBC-Connector)
   Add those files to the library of your project.
2. Set the name of the driver by executing the following statement:
   ```sh
   System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
   ```
3. .Set the JDBC URL by executing the following statement:
   ```sh
   String url = "jdbc:mysql://[host][:port]/[database]";
   ```

<hr>

**The following parts show how I resolved each exercise. I won't be sharing a lot of code here since it's in the project file within the repository. However, I will clearly indicate where you can find the code to illustrate my explanations**


### Exercise 1

1. The first thing to do is to create a new project. In my case, I created a new folder named **LabJDBC**. Then, I opened it with VS code and created a new file named **DataAccess.java**. This file will contain the class DataAccess.

    [Code source de la classe DataAccess](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/main/model/DataAccess.java)

2. The role of the class DataAccess is to hide from the application how its data is actually stored (here, in a relational database) as well as all the complex machinery required to access it (here, JDBC library and SQL statements). To do so, we will use the following methods :

* **public DataAccess(String url, String login, String password)** : This is the constructor of the class. It will be used to initialize the connection with the database. The needed arguments are :

  * url link
  * username
  * passeword

  Those arguments will be taken from the **String[] args** . To set them in the args array, you need to open the **Run configuration** and add the following line :
  ```sh
   "args" : ["URL", "Username", "Password"]
  ```

In this class the only instance variable is **Connection connection**. It will be used to store the connection with the database. 

* **public static void closeConnection()** : This method is used to close the connection with the database.

* **public Statement createStatement()** : This method is used to create a statement. It will be used to execute the SQL queries.

* **public PreparedStatement prepareStatement(String query)** : This method is used to prepare a statement. It will be used to execute the SQL queries.

3. Now that we have the DataAccess class, we need to create a new class named **Main.java**. This class will be used to test the DataAccess class.

4. In the Main class, we will create a new instance of the DataAccess class. To do so, we will use the following line :
```sh
DataAccess dataAccess = new DataAccess(args[0], args[1], args[2]);
```
You might be wondering why we are using the args array. Well, it's because we want to be able to change the url, username and password without having to change the code. This way, we can use the same code for different databases.

Also, you might get an error because in for some, the password might be empty. To fix this, you can add the following line :
```sh
if (args.length == 2) {
            args = Arrays.copyOf(args, 3);
            args[2] = "";
        }
```
### Exercise 2

 To write the metho **List<EmployeeInfo>getAllEmployees()** we will use the following code :
  
  I did the following steps :

  * Create an array list of EmployeeInfo.
  * Create a new statement.
  * Execute the query by using **executeQuery()** method since we are using a select query.
  * Create a new EmployeeInfo object for each row of the result set.To go from one row to another, we will use the **next()** method.
  * Add the EmployeeInfo object to the array list.

  [Click here to go directly to the getAllEmployees() method](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/d005ca198b5c50ee7250fbccf9019f27e9c4f62c/model/DataAccess.java#L29)

  Note : EmployeeInfo is a class created to store the data of each employee. 












### Exercice 3
  🚧 👷‍ ⛏ 👷 🔧️ 🚧
- [x] Create An Android Projects ReadMe.
- [x] Create a flutter Projects ReadMe.
- [x] Create a website ReadMe for Html and css and JS projects.
- [x] Create a brief ReadMe for the quick ones.
- [ ] Creat a Scripts ReadMe file for Python, php, js type projects
- [ ] Create a ReadMe file for IOS projects
- [ ] Create a ReadMe generator for VSCode
- [ ] Create a documenation page: [WIP documenation](https://tamzi.github.io/ReadMe-MasterTemplates/)


You are welcome to help in making  **readMe master templates** better.

The project is still very incomplete but under development. If there's an [issue](https://github.com/tamzi/ReadMe-MasterTemplates/issues) you'd like to see addressed sooner rather than later:

- [Open an issue](https://github.com/tamzi/ReadMe-MasterTemplates/issues),

    or JUST,

- [Fork the project and send a pull request](https://github.com/tamzi/ReadMe-MasterTemplates/pulls).


Before you contribute though read the contributing guide here: [CONTRIBUTING GUIDE](https://github.com/tamzi/ReadMe-MasterTemplates/blob/master/contributing.md)

<hr>

### Exercise 4

to do ...

<hr>

### Exercise 5

to do ...

<hr>

### Exercise 6

to do ...

<hr>


### Contributors


Twitter:  [@tamrefrank](https://twitter.com/tamrefrank)

### Licence


[![license](https://img.shields.io/github/license/mashape/apistatus.svg?style=for-the-badge)](#)



[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Ftamzi%2FReadMe-MasterTemplates.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Ftamzi%2FReadMe-MasterTemplates?ref=badge_large)

<a href="https://www.producthunt.com/posts/readme-master-templates?utm_source=badge-featured&utm_medium=badge&utm_souce=badge-readme-master-templates" target="_blank"><img src="https://api.producthunt.com/widgets/embed-image/v1/featured.svg?post_id=186076&theme=light" alt="ReadMe Master Templates - Better ReadMe projects for your projects! | Product Hunt Embed" style="width: 250px; height: 54px;" width="250px" height="54px" /></a>
