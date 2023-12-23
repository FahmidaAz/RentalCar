
package Azmin.SERVLETS;

import Azmin.CAR.Car;
import Azmin.FACTORY.CarBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DisplayCars extends HttpServlet {

    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Car> cars= CarBuilder.BuildCar(); // Replace with your method if it has a different name
            CarBuilder.fileCarAccount(cars);
       
           try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayCars</title>");  
            out.println("<link rel=\"stylesheet\"\n" +
"       href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" \n" +
"       integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" \n" +
"       crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
             out.println("<table class='table' border='1'>");
              out.println("<thead>");
        out.println("<tr>"); // Table header row
        out.println("<th scope='col'>Car ID</th>");
        out.println("<th scope='col'>Make</th>");
        out.println("<th scope='col'>Model</th>");
        out.println("<th scope='col'>Price Per Day</th>");
        out.println("<th scope='col'>Availability</th>");
        out.println("</tr>"); 
         out.println("</thead>");
        for (Car car : cars) {
            out.println(car.toHTML()); 
            
                    }
         for (Car car : cars) {
             car.toSQL();
             
         }
        out.println("</table>");
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
        } catch (SQLException ex) {
            Logger.getLogger(DisplayCars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayCars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayCars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayCars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
