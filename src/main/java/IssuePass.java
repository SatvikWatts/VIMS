
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satvi
 */
public class IssuePass {

    /**
     *
     * @param vid
     * @param hid
     * @return
     */
    private int visid;
    private int hoid;
    public IssuePass(int vid,int hid)
    {
        visid=vid;hoid=hid;
    }
    
    public String[] getpass(){
        String arr[]=new String[8];
        try{
                arr[0]=Integer.toString(visid);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vims","root","Cordinjack@35");
            
                PreparedStatement ps = con.prepareStatement("SELECT * FROM visitor where visitor_id=?");
                ps.setInt(1, visid);
                ResultSet rs = ps.executeQuery();
                rs.next();
                arr[1]=rs.getString("vname");
                arr[2]=rs.getString("email");
                arr[3]=rs.getString("cnumber");
                
                ps = con.prepareStatement("SELECT * FROM visitor where visitor_id=?");
                ps.setInt(1, hoid);
                rs = ps.executeQuery();
                rs.next();
                arr[4]=rs.getString("vname");
                arr[5]=rs.getString("email");
                
                ps = con.prepareStatement("SELECT * FROM stay where visitor_id=?");
                ps.setInt(1, visid);
                rs = ps.executeQuery();
                rs.next();
                arr[6]=rs.getString("building");
                arr[7]=rs.getString("days");
            }
            catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        return arr;
    }
}
