
package Azmin.SERVLETS;

import Azmin.USER.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Azmin.INTERFACES.Information;



public class UserInformation extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String userName = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            Users usr = new Users(userName,email,phone,address);
            usr.toSQL();
            String fn = Information.Users;
         
             try (FileWriter FW = new FileWriter(fn, true);
             BufferedWriter BW = new BufferedWriter(FW)) {

            String formattedString = String.format("UserID: %s, Username: %s, Email: %s, Phone: %s, Address: %s", 
                                                   usr.getUsrid(), usr.getUsername(), usr.getEmail(), usr.getPhone(), usr.getAddress());
            
            BW.write(formattedString);
            BW.newLine();
             }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserInformation</title>"); 
            out.println("<link rel=\"stylesheet\"\n" +
"       href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" \n" +
"       integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" \n" +
"       crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
             out.println("<div class=\"jumbotron\">\n" +
"  <h1 class=\"display-4\">Your Acoount:</h1>\n" +
"  <p class=\"lead\">"+usr.toHTML()+"</p>\n" +
"  <hr class=\"my-4\">\n" +
"  <p></p>\n" +
"  <a class=\"btn btn-primary btn-lg\" href=\"StoreUsers\" role=\"button\">Save Information</a>\n" +
"</div>");

            out.println("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" \n" +
"        integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" \n" +
"        crossorigin=\"anonymous\"></script>\n" +
"        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\" \n" +
"        integrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\"\n" +
"        crossorigin=\"anonymous\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
