import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "/SignUp?action=Signup")
public class SignUp extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        String repass = request.getParameter("Repassword");
        if(repass.equals(pass)){
            System.out.println(name + " " + pass+ " "+repass);

            try {
                if (DBConnection.isSignUp(name,pass)) {
                    PrintWriter out = response.getWriter();
                    System.out.println("TRUE");
                    out.println("<HTML>" +
                            "<BODY>\n" +
                            "<H1 ALIGN=CENTER >" + "Your data is saved !" + "</H1><br>" +
                            "<H1 ALIGN=CENTER >" + "Redirection in 5s ..." + "</H1><br>"+
                            "<form method=\"get\">"+
                            "<meta http-equiv=\"refresh\" content=\"5; URL=http://localhost:8080/web_war_exploded\">"+
                            "<UL>\n" +
                            "</UL>" + "\n" +
                            "</BODY>" +
                            "</HTML>"
                    );
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }}
        else{
            System.out.println("Passwords is not the same !");
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String costumerName = request.getParameter("ID");
        System.out.println(costumerName);
        out.println("<HTML>"+"<HEAD>"+"<title>Home</title>"+"</HEAD>"+
                "<BODY>\n"+
                "<div align=\"center\"><h1>login in</h1>"+
                "<form  method=\"post\" name=\"login form\" align=\"center\">"+
                "<table align=\"center\" width=\"232\" border=\"2\">\n"+
                "<tr>\n"+
                "<td>Username</td>\n" +
                "<td><input type=\"text\" name=\"username\"></td>"+
                "</tr>"+"\n"+
                "<tr>\n"+
                "<td>Password</td>\n" +
                "<td><input type=\"password\" name=\"password\"></td>"+
                "</tr>"+"\n"+
                "<tr>\n"+
                "<td>Repeat Password</td>\n" +
                "<td><input type=\"password\" name=\"Repassword\"></td>"+
                "</tr>"+"\n"+
                "</table>\n"+
                "<input type=\"submit\" value=\"Submit\" name=\"Submit\">\n"+
                "</form>\n"+
                "</div>"+
                "</BODY>"+
                "</HTML>"
        );
        out.close();;

    }
}
