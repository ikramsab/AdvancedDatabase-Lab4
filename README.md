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
You have acces to the lab paper [here](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/jdbc.lab.pdf)

If you want to test the different exercises of the lab , you can uncomment the part that contains the exercise you want to test in the **main()** method of the **Main.java** class.

Link your url in the launch.json file ann also dowload the .jar files and set thel in the settings.json file. If you dowload this repository the informations set are mine so you will need to change them.


### Prerequisites

For the purpose of this lab you will need 
* IDE such as Netbeans, Visual Studio Code or IntelliJ .
In my case , I used Visual Studio Code.
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

Also, you might get an error because for some, the password might be empty. To fix this, you can add the following line :
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
  The class was already given in the lab paper.

  [Click here to go directly to the EmployeeInfo class](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/b58b6774d92bafbf2f82b5b476451fe58866dc20/model/EmployeeInfo.java)

[Click here to see the output test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo1-output.png)


### Exercice 3

To write the method boolean raiseSalary(String job, float amount) that raises the salary of the employees with the specified job by the specified amount i did the following steps :

* Create a new statement.
* Execute the query by using **executeUpdate()** method since we are using an update query.
* keep the number of rows affected by the query in a variable. (executeUpdate() returns the number of rows affected by the query)
* If the number of rows affected is greater than 0, return true. Else, return false.

[Click here to go directly to the raiseSalary() method](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/b58b6774d92bafbf2f82b5b476451fe58866dc20/model/DataAccess.java#L43C4-L43C4)

Next we performed an SQL injection attack. To do so, we used the following code :

```sh
dataAccess.raiseSalary("CLERK OR 1=1", 100);
```
Since 1=1 is always true.

, the query will affect all the employees. To prevent this, we will use the **prepareStatement()** method instead of the **createStatement()** method. This way, the query will be prepared before being executed.

[Click here to see the line test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo3-code-line-test.png)

[Click here to see the output test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo3-output.png)

<hr>

### Exercise 4

To write the second version of **getEmployees()** and **raiseSalary()**, named **getEmployeesPS()** and **raiseSalaryPS()**, that uses prepared statements instead of statements, I did the following steps :

* Create a new prepared statement. 
* Set the parameters of the prepared statement. To do so we will use the **setString()** method and the **setFloat()** method.
* Execute the query by using **executeQuery()** method since we are using a select query( for getEmployeesPS() method) and **executeUpdate()** method since we are using an update query (for raiseSalaryPS() method).
* And finish the same way as the previous methods.

[Click here to go directly to the getEmployeesPS() method](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/model/DataAccess.java#L80C5-L80C12)

[Click here to go directly to the raiseSalaryPS() method](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/model/DataAccess.java#L59)

Prepare statrement are more efficient than statements because they are precompiled. This means that the database will not have to compile the query each time it is executed. This is why we should always use prepared statements instead of statements.

Now if we try to perform an SQL injection attack, we will get an error because the query will be prepared before being executed.

[Click here to see the line test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo4-code-line-test.png)

[Click here to see the output test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo4-PS-output.png)

<hr>

### Exercise 5

To write the method **List<DepartmentInfo> getDepartments()** that returns the list of all the departments, I did the following steps :

For the one using statements :

* Create an array list of DepartmentInfo.
* Create a string that contains the query.
* Check every possibility , it mens checking if either name, id, location is null or not.
* Create a new statement.
* Creating a result set by executing the query.
* Create a new DepartmentInfo object for each row of the result set.To go from one row to another, we will use the **next()** method.
* Add the DepartmentInfo object to the array list.

[Click here to go directly to the getDepartments()](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/model/DataAccess.java#L98)

For the one using prepared statements :

* Create an array list of DepartmentInfo.
* Create a string that contains the query.
* Check every possibility , it mens checking if either name, id, location is null or not. But this time in the query there will be a ? instead of the value.
* Create a new prepared statement.
* Set the parameters of the prepared statement. To do so we will use the **setString()** method and the **setInt()** method. And to know how many parameters we have , we will increment a counter for each parameter wich is not null.
* Creating a result set by executing the query.
* Create a new DepartmentInfo object for each row of the result set.To go from one row to another, we will use the **next()** method.
* Add the DepartmentInfo object to the array list.

[Click here to go directly to the getDepartmentsPS()](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/model/DataAccess.java#L141)

[Click here to see the first test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo5-test-and-output.png)

[Click here to see the second test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo5-test-and-output-2.png)

<hr>

### Exercise 6

To write the method **List<String>executeQuery(String query)** that executes the specified query (i.e. select statement) on the database. This method will be used to execute any query. I did the following steps :

* Create an array list of String.
* Create a new statement.
* Execute the query by using **executeQuery()** method since we are using a select query.
* Create a new String object for each row of the result set.To go from one row to another, we will use the **next()** method.
* Add the String object to the array list. By using sur function **toString()** we can get the result of the query in a String format.

[Click here to go directly to the executeQuery()](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/model/DataAccess.java#L191)


To write List<String> executeStatement(String statement) that executes any statement (e.g. select, insert, update, etc.) on the database. I did the following steps :

* Change the query into lower case.
* Check if the query contains the word select.
* If it contains the word select, we will use the **executeQuery()** method.
* If it doesn't contain the word select, we will use the **executeUpdate()** method. And we will keep the number of rows affected by the query in a variable. (executeUpdate() returns the number of rows affected by the query)

[Click here to go directly to the executeStatement()](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/model/DataAccess.java#L212)

We can do the same thing using prepared statements. To do so, we will use the following code :
But it requires more code. Since we need to check if the query contains dept or emp. And we need to set the parameters of the prepared statement. This is the following steps :

*Create an array list of String.
*Change the query into lower case.
*create a new prepared statement.
*Check if the query contains the word dept.
*If it contains the word dept, we will set the parameters of the prepared statement. To do so we will use the **setString()** method and the **setInt()** method.
*Check if the query contains the word emp.
*Do the same but with the right arguments.

[Click here to go directly to the executeQueryPS()](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/model/DataAccess.java#L233C25-L233C39)


To do the ExecuteUpdatePS() method, we will do the same thing but we will use the **executeUpdate()** method instead of the **executeQuery()** method. And count the number of rows affected by the query.

[Click here to go directly to the executeUpdatePS()](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/f35c292488a713f506c86b47ade65fbc1a81863f/model/DataAccess.java#L261)

[Click here to see the first test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo6-test-and-output-part1.png)

[Click here to see the second test](https://github.com/ikramsab/AdvancedDatabase-Lab4/blob/391a25760ba501c45fb13920c06821df006fdd94/images/exo6-test-and-output-part2.png)

<hr>


### Contributors


Github :  [@ikramsab](https://github.com/ikramsab)

<hr>
