import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.sql.Connection;

@WebServlet(name = "/BD")
class DBConnection {
    static private String url = "jdbc:mysql://localhost:3306/USERS";
    static private String user = "root";
    static private String pass = "";

    public static void DBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pass);

    }

//    public static boolean issignup(String Name, String Email, String Password) throws ClassNotFoundException {
//        boolean stat = false;
//        Connection myConn = null;
//        PreparedStatement pst = null;
//        try {
//
//            myConn = HOME.MySQLConnection.getConnection(url, user, password);
//            pst = myConn.prepareStatement("insert into users values(?,?,?)");
//            pst.setString(1, Name);
//            pst.setString(2, Email);
//            pst.setString(3, Password);
//            int i = pst.executeUpdate();
//            if (i > 0) {
//                stat = true;
//            } else {
//
//            }
//        } catch (Exception e) {
//            stat = false;
//        }
//
//        return stat;
//
//    }

//    public static boolean getname(String Name){
//        boolean stat = false;
//
//        try{
//
//
//            Connection myConn = MySQLConnection.getConnection(url,user,password);
//            String mySqlQuery =
//                    "SELECT  Name FROM users WHERE Name = '"+
//                            Name+
//                            "'";
//            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()){
//                Name = resultSet.getString("Name");
//                stat=true;
//
//            }
//
//        }catch (Exception exception){
//
//        }
//
//        return stat;
//
//    }
    public static boolean isConnected(String name, String password) throws ClassNotFoundException {
        boolean etatname = false;
        Connection connexion;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/TEST", "root", "");
            String mySqlQuery =
                    "SELECT  name,password FROM test WHERE name = '" +
                            name +
                            "' AND password = '" +
                            password +
                            "'";
            PreparedStatement preparedStatement = connexion.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                name = resultSet.getString("name");
                password = resultSet.getString("password");
                System.out.println("done");
                etatname = true;
            }

        } catch (Exception exception) {
            System.out.println(exception.toString());

        }

        return etatname;
    }
    public static boolean isSignUp(String name, String password) throws ClassNotFoundException {
        boolean stat = false;
        Connection connection ;
        PreparedStatement pst ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/TEST", "root", "");
            pst = connection.prepareStatement("insert into test values(?,?)");
            pst.setString(1, name);
            pst.setString(2, password);
            int i = pst.executeUpdate();
            if (i > 0) {
                stat = true;

            } else {

            }
        } catch (Exception e) {

        }

        return stat;

    }

}

