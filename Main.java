import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;

import model.DataAccess;
import model.DepartmentInfo;
import model.EmployeeInfo;

public class Main {
    public static void main(String[] args) throws Exception {

        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        if (args.length == 2) {
            args = Arrays.copyOf(args, 3);
            args[2] = "";
        }

        DataAccess database = new DataAccess(args[0], args[1], args[2]);// step 1 = making a connection

        // ---------------------exercice 2 test------------------------------------------

        /*
          List<EmployeeInfo> employees = database.getEmployees();
          System.out.println(employees);
         */

        // ---------------------exercice 2 test END -------------------------------------

        // ---------------------exercice 3 test------------------------------------------

        

          //diplay the list of employees first

        /*  List<EmployeeInfo> employees = database.getEmployees();
          System.out.println(employees);  

          boolean result = database.raiseSalary("CLERK", 100); 
          if (result) {
          System.out.println("Salary raised");
          } else {
          System.out.println("Salary not raised");
          }
            //display the list of employees after
            
            employees = database.getEmployees();
            System.out.println(employees); */

         

        // ---------------------exercice 3 test END -------------------------------------

        // ---------------------exercice 4 test------------------------------------------

        
          //diplay the list of employees first
        /*   List<EmployeeInfo> employees = database.getEmployeesPS();
         System.out.println(employees);
          
         boolean result = database.raiseSalaryPS("MANAGER", 100);
          
          if (result) {
          System.out.println("Salary raised");
          } else {
          System.out.println("Salary not raised");
          }
          
          //display the list of employees after
          employees = database.getEmployeesPS();
          System.out.println(employees);*/
         
        
        // ---------------------exercice 4 test END -------------------------------------

        // ---------------------exercice 5 test------------------------------------------

        
          /*List<DepartmentInfo> departments = database.getDepartmentsPS(10,null,
          null); System.out.println(departments);*/
        

        // ---------------------exercice 5 test END -------------------------------------

        // ---------------------exercice 6 test------------------------------------------

        
         /*  List<String> ResultQuery = database.executeQuery("SELECT * FROM emp ");
          System.out.println(ResultQuery);
          ResultQuery = database.ExecuteStatement("Update emp set sal = sal + 100 where job = 'ANALYST' "
          ); System.out.println(ResultQuery);*/
         

          List<String> ResultQuery = database.executeQueryPS("SELECT * FROM emp where job = 'CLERK'");
          System.out.println(ResultQuery);
          ResultQuery = database.ExecuteStatementPS("Update emp set sal = sal + 100 where job = 'CLERK' ");
          System.out.println(ResultQuery);

        database.closeConnection();

    }

}
