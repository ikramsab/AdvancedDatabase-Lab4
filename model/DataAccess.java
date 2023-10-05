package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {

    private Connection connection;

    public DataAccess(String url, String login, String password) throws SQLException {
        connection = DriverManager.getConnection(url, login, password);
        System.out.println("connected to " + url);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException { // add by me
        return connection.createStatement();
    }

    public PreparedStatement prepareStatement(String query) throws SQLException { // add by me
        return connection.prepareStatement(query);
    }

    // EXERCICE 2
    public List<EmployeeInfo> getEmployees() throws SQLException {
        List<EmployeeInfo> employees = new ArrayList<>();
        Statement stat1 = connection.createStatement(); // step 2 = creating a statement
        ResultSet result1 = stat1.executeQuery("SELECT * FROM emp"); // step 3 = executing a query because we are
                                                                     // reading data 'select'
        while (result1.next()) {
            employees.add(new EmployeeInfo(result1.getInt("eid"), result1.getString("ename"), result1.getFloat("sal")));
        }
        return employees;
    }


    // EXERCICE 3 avec statement
    public boolean raiseSalary(String job, float amount) throws SQLException {
        int nbRows = 0;
        try {
            Statement stat1 = connection.createStatement();
            nbRows = stat1.executeUpdate("UPDATE emp SET sal = sal + " + amount + " WHERE job = '" + job + "'");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (nbRows > 0) {
            return true;
        } else {
            return false;
        }
    }




    // EXERCICE 4 car preparedStatement

    public boolean raiseSalaryPS(String job, float amount) throws SQLException {
            int nbRows = 0;
        try {

            PreparedStatement stat2 = connection.prepareStatement("UPDATE emp SET sal = sal + ? WHERE job = ?");
            stat2.setFloat(1, amount);
            stat2.setString(2, job);

             nbRows = stat2.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        if (nbRows > 0) {
            return true;
        } else {
            return false;
        }
        
    
    }


//exercice 5
 public List<DepartmentInfo> getDepartments(Integer id, String name, String location){

    List<DepartmentInfo> departments = new ArrayList<>();

    String query = "SELECT * FROM dept  ";
    if (id != null || name != null || location != null) {
        query += " WHERE";
    
        if (id != null) {
            query += " did = " + id;
        }
    
        if (name != null) {
            if (id != null) {
                query += " AND";
            }
            query += " dname = '" + name + "'";
        }
    
        if (location != null) {
            if (id != null || name != null) {
                query += " AND";
            }
            query += " dloc = '" + location + "'";
        }
    }
    
    try {
        System.out.println(query);
        Statement stat1 = connection.createStatement();
        ResultSet result1 = stat1.executeQuery(query);
        while (result1.next()) {
            departments.add(new DepartmentInfo(result1.getInt("did"), result1.getString("dname"), result1.getString("dloc")));
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return departments;

 }
// same exercice 5 but with preparedStatement

public List<DepartmentInfo> getDepartmentsPS(Integer id, String name, String location){

    List<DepartmentInfo> departments = new ArrayList<>();
    String query = "SELECT * FROM dept  ";

    if (id != null || name != null || location != null) {
        query += " WHERE ";

        if(id != null){
            query += "did = ?";
        }
        if(name != null){
            if(id != null){
                query += " AND ";
            }
            query += "dname = ?";
        }
        if(location != null){
            if(id != null || name != null){
                query += " AND ";
            }
            query += "dloc = ?";
        }
    }
    try {
        PreparedStatement stat2 = connection.prepareStatement(query);
        int i = 1;
        if (id != null) {
            stat2.setInt(i, id);
            i++;
        }
        if (name != null) {
            stat2.setString(i, name);
            i++;
        }
        if (location != null) {
            stat2.setString(i, location);
        }
        ResultSet result1 = stat2.executeQuery();
        while (result1.next()) {
            departments.add(new DepartmentInfo(result1.getInt("did"), result1.getString("dname"), result1.getString("dloc")));
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return departments;
}






}
