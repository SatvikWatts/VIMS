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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author satvi
 */
public class up_det extends HttpServlet {

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
            String inp=request.getParameter("data");
            String arr[]=inp.split(" ");
            int vid=Integer.parseInt(arr[0]);
            arr[7]=arr[7]+" "+arr[8];
            arr[8]=arr[9];
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vims","root","Cordinjack@35");
                
                PreparedStatement ps = con.prepareStatement("SELECT visitor_id FROM visitor where email=?");
                ps.setString(1, arr[6]);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    int hid=rs.getInt("visitor_id");
                    
                    ps = con.prepareStatement("Update visitor set pass=?,id_type=?,id=?,cnumber=? where visitor_id=?");
                    ps.setString(1, arr[1]);
                    ps.setString(2, arr[2]);
                    ps.setString(3, arr[3]);
                    ps.setString(4, arr[4]);
                    ps.setInt(5, vid);
                    ps.executeUpdate();
                    
                    ps = con.prepareStatement("Update vihost set host_id=? where visitor_id=?");
                    ps.setInt(1, hid);
                    ps.setInt(2, vid);
                    ps.executeUpdate();
                    
                    ps = con.prepareStatement("Update stay set building=?,days=? where visitor_id=?");
                    ps.setString(1, arr[7]);
                    ps.setString(2, arr[8]);
                    ps.setInt(3, vid);
                    ps.executeUpdate();
                    out.println("0");
                }
                else
                {
                    out.println("1");
                }
            }
            catch(Exception e){out.println(e);}
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
