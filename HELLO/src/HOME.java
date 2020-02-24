import javax.ejb.Init;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet(name = "/HOME")
public class HOME extends HttpServlet {
    public static DriverManager MySQLConnection;
    static private String url = "jdbc:mysql://localhost:3306/USERS";
    static private String user = "root";
    static private String password = "";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DriverManager MySQLConnection;

            PrintWriter out = response.getWriter();
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
                    "</table>\n"+
                    "<input type=\"submit\" value=\"Submit\" name=\"Submit\">\n"+
                    "</form>\n"+
                    "<form action=\"MaServlet\" method=\"get\">"+
                    "<a href=\"SignUp?action=Signup\">SIGN UP</a>"+
                    "</form>"+
                    "</div>"+
                    "</BODY>"+
                    "</HTML>"
            );
            out.close();

        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(name + " " + pass);
        try {
            if (DBConnection.isConnected(name,pass)) {
                    PrintWriter out = response.getWriter();
                    System.out.println("TRUE");
                    out.println("<HTML>" +
                            "<BODY>\n" +
                            "<H1 ALIGN=CENTER>" + "Hello world" + "</H1><br>" +
                            "<UL>\n" +
                            "<L1><B>username:" + request.getParameter("username") + "<br>" +
                            "<L1><B>password:" + request.getParameter("password") + "<br>" +
                            "</UL>" + "\n" +
                            "</BODY>" +
                            "</HTML>"
                    );
                }
            else{
                System.out.println("FALSE");

                PrintWriter out = response.getWriter();
                out.println("<HTML>" +
                        "<BODY>\n" +
                        "<H1 ALIGN=CENTER>" + "Wrong data" + "</H1><br>" +
                        "</BODY>" +
                        "</HTML>");
                out.close();

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        }

    }


