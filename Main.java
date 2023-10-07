import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;

import model.DataAccess;
import model.DepartmentInfo;
import model.EmployeeInfo;

public class Main {
    /** Le programme commence ici */

    public static void main(String[] args) throws Exception {

        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        if (args.length == 2) {
            args = Arrays.copyOf(args, 3);
            args[2] = "";
        }

        DataAccess database = new DataAccess(args[0], args[1], args[2]);// step 1 = making a connection

        // exercice 2 test
         List<EmployeeInfo> employees = database.getEmployees();
         System.out.println(employees);

         boolean result = database.raiseSalary("CLERK OR 1=1", 100);
          if (result) {
          System.out.println("Salary raised");
          } else {
          System.out.println("Salary not raised");
          }
          
         employees = database.getEmployees();
         System.out.println(employees);
        // exercice 5 test
        // List<DepartmentInfo> departments = database.getDepartmentsPS(null,null,
        // null);
        // System.out.println(departments);

        // exercice 4/3 test
        /*
         * boolean result = database.raiseSalaryPS("CLERK", 100);
         * 
         * if (result) {
         * System.out.println("Salary raised");
         * } else {
         * System.out.println("Salary not raised");
         * }
         * 
         * employees = database.getEmployees();
         * System.out.println(employees);
         */

        // exercise 6 part 1 test success
        // List<String> ResultQuery = database.executeQuery("SELECT * FROM emp ");
        // System.out.println(ResultQuery);
        // ResultQuery = database.ExecuteStatement("Update emp set sal = sal + 100 where
        // job = 'CLERK' ");
        // System.out.println(ResultQuery);

        // exercise 6 part 2 test success
       /*  List<String> ResultQuery = database.executeQueryPS("SELECT * FROM emp where job = 'CLERK'");
        System.out.println(ResultQuery);
        ResultQuery = database.ExecuteStatementPS("Update emp set sal = sal + 100 where job = 'CLERK' ");
        System.out.println(ResultQuery);
        ResultQuery = database.executeQueryPS("SELECT * FROM emp where job = 'CLERK'");
        System.out.println(ResultQuery);
        database.closeConnection();   */ 

    }

}
