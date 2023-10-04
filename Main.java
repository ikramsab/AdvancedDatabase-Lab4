import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;

import model.DataAccess;
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
    
        //exercice 2
        List<EmployeeInfo> employees = database.getEmployees();
        System.out.println(employees);
    
        //exercice 3
        boolean result  = database.raiseSalaryPS("CLERK", 100);

         if (result) {
            System.out.println("Salary raised");
        } else {
            System.out.println("Salary not raised");
        }
        
        employees = database.getEmployees();
        System.out.println(employees);



        database.closeConnection();

    }

}
