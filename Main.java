
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    /** Le programme commence ici */

    public static void main(String[] args) {

        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");


       /*  String url = "jdbc:mysql://localhost:3306/lab3?serverTimezone=UTC";
        String utilisateur = "root";
        String motDePasse = "";

        try {
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            if (connexion != null) {
                System.out.println("Connexion à la base de données établie avec succès !");
            } else {
                System.out.println("La connexion à la base de données a échoué.");
            }
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // System.out.println("Hello World test !");*/

    }
}

