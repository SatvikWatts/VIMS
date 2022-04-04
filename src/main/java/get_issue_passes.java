/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author satvi
 */
public class get_issue_passes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width,initial-scale=1'/>");
            out.println("<link rel='stylesheet' type='text/css' href='table.css'>");
            //out.println("<script src='login.js'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='background'>");
            out.println("<div class='shape'></div>");
            out.println("<div class='shape'></div>");
            out.println("</div>");
            out.println("<form>");
            out.println("<table>");
                out.println("<tr class='tbl-header'>");
                    out.println("<td width='100px'><a>Visitor id</a></td>");
                    out.println("<td width='150px'><a>Visitor Name</a></td>");
                    out.println("<td width='250px'><a>Visitor Email</a></td>");
                    out.println("<td><a>Visitor Contact No.</a></td>");
                    out.println("<td width='150px'><a>Host Name</a></td>");
                    out.println("<td width='250px'><a>Host Email</a></td>");
                    out.println("<td width='100px'><a>Building</a></td>");
                    out.println("<td width='100px'><a>Days</a></td>");
                out.println("</tr>");
                
                
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vims","root","Cordinjack@35");
            
                PreparedStatement ps = con.prepareStatement("SELECT * FROM vihost");
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    int vid=rs.getInt("visitor_id");
                    int hid=rs.getInt("host_id");
                    IssuePass p=new IssuePass(vid,hid);
                    String arr[]=p.getpass();
                out.println("<tr>");
                    out.println("<td width='100px'><a>"+arr[0]+"</a></td>");
                    out.println("<td width='150px'><a>"+arr[1]+"</a></td>");
                    out.println("<td width='250px'><a>"+arr[2]+"</a></td>");
                    out.println("<td><a>"+arr[3]+"</a></td>");
                    out.println("<td width='150px'><a>"+arr[4]+"</a></td>");
                    out.println("<td width='250px'><a>"+arr[5]+"</a></td>");
                    out.println("<td width='100px'><a>"+arr[6]+"</a></td>");
                    out.println("<td width='100px'><a>"+arr[7]+"</a></td>");
                out.println("</tr>");
                }
            }
            catch(ClassNotFoundException | SQLException e){System.out.println(e);}
            out.println("</table>");
            out.println("<input type=\"button\" value=\"Return\" class=\"button\" onclick=\"window.location.href='Front_Screen.html';\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
