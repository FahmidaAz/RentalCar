
package Azmin.SERVLETS;


import Azmin.CAR.Booking;
import Azmin.DBSPT.DBSupport;
import Azmin.FACTORY.CarBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Azmin.INTERFACES.Information;


public class DisplayBooking extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("name");
            String startDateStr = request.getParameter("pickup");
            String endDateStr = request.getParameter("dropoff");
            String carid = request.getParameter("carid");
            String carTypeStr = request.getParameter("carlist");
            String pricePerDay= CarBuilder.getCar(carid,carTypeStr);
            
            Date startDate = Date.valueOf(startDateStr);
            Date endDate = Date.valueOf(endDateStr);
             
         Booking b = new Booking(username,pricePerDay,startDate,endDate,carid);
//         String q = "SELECT carType FROM car WHERE carID = "+carid;
//        try (Connection conn = DBSupport.establishConnection();
//     PreparedStatement pstmt = conn.prepareStatement(q)) {
//    
//    pstmt.setString(1, carid);
//    try (ResultSet rs = pstmt.executeQuery()) {
//        if (rs.next()) {
//            carTypeStr = rs.getString("carType");
//        }
//    }
//    } catch (SQLException e) {
//    e.printStackTrace();
//    // Handle exception
//    }
         String fn = Information.booking;
         //FileWriter FW = new FileWriter(fn);
           // BufferedWriter BW =  new BufferedWriter(FW);
             try (FileWriter FW = new FileWriter(fn, true);
             BufferedWriter BW = new BufferedWriter(FW)) {

            String formattedString = String.format("BookingID: %s, Username: %s, PickUp: %s, DropOff: %s, CarID: %s, CarType: %s", 
                                                   b.getBookingid(), b.getUsername(), b.getStartDate(), b.getEndDate(), carid, carTypeStr);
            
            
            BW.write(formattedString);
            BW.newLine();  
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
            b.toSQL();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DisplayBooking</title>"); 
            out.println("<link rel=\"stylesheet\"\n" +
"       href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" \n" +
"       integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" \n" +
"       crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class=\"jumbotron\">\n" +
"  <h1 class=\"display-4\">Your Booking Information:</h1>\n" +
"  <p class=\"lead\">"+b.toHTML()+"</p>\n" +
"  <hr class=\"my-4\">\n" +
"  <p></p>\n" +
"  <a class=\"btn btn-primary btn-lg\" href=\"StoreBookings\" role=\"button\">Confirmed Your Booking</a>\n" +
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
            Logger.getLogger(DisplayBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   

}
