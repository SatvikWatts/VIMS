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
public class get_det extends HttpServlet {

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
            String inp1=request.getParameter("data");
            int inp=Integer.parseInt(inp1);
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vims","root","Cordinjack@35");
            
                PreparedStatement ps = con.prepareStatement("SELECT * FROM visitor where visitor_id=?");
                ps.setInt(1, inp);
                ResultSet rs = ps.executeQuery();
                rs.next();
                out.print(rs.getString("vname"));
                out.print(" ");
                out.print(rs.getString("email"));
                out.print(" ");
                out.print(rs.getString("pass"));
                out.print(" ");
                out.print(rs.getString("id_type"));
                out.print(" ");
                out.print(rs.getString("id"));
                out.print(" ");
                out.print(rs.getString("cnumber"));
                out.print(" ");
                
                ps = con.prepareStatement("SELECT * FROM vihost where visitor_id=?");
                ps.setInt(1, inp);
                rs = ps.executeQuery();
                rs.next();
                int hid=rs.getInt("host_id");
                
                ps = con.prepareStatement("SELECT * FROM visitor where visitor_id=?");
                ps.setInt(1, hid);
                rs = ps.executeQuery();
                rs.next();
                out.print(rs.getString("vname"));
                out.print(" ");
                out.print(rs.getString("email"));
                out.print(" ");
                
                ps = con.prepareStatement("SELECT * FROM stay where visitor_id=?");
                ps.setInt(1, inp);
                rs = ps.executeQuery();
                rs.next();
                out.print(rs.getString("building"));
                out.print(" ");
                out.print(rs.getString("days"));
            }
            catch(ClassNotFoundException | SQLException e){out.println(e);}
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
