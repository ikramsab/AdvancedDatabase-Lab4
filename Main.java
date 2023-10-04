
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import model.DataAccess;
public class Main {
    /** Le programme commence ici */

    public static void main(String[] args) {

        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");


       try {

          if (args.length == 2) {
                args = Arrays.copyOf(args, 3);
                args[2] = "";
             }
          DataAccess da = new DataAccess(args[0],args[1],args[2]);

           // System.out.println("Connexion à la base de données !"+args[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       

   }
}

