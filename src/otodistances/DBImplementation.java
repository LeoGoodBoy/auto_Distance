package otodistances;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBImplementation {
    
    private final String QUERY_PTK      ="select id, nama, latitude, longitude from ptk where id>=1857 and id<=1868";
    private final String QUERY_SEKOLAH  ="select id, nama, latitude, longitude from sekolah where id>0";
    
    public Connection getConnection(){
        Connection conn = null;
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otodistance?zeroDateTimeBehavior=convertToNull","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return conn;
    }
    
    public ArrayList<Location> getPTKLocation(){
        ArrayList<Location> ptkList = new ArrayList<Location>(); 
        Connection conn = getConnection();
        
        try {
            Statement st = conn.createStatement();            
            ResultSet rs = st.executeQuery(QUERY_PTK);
            while(rs.next()){
                Location loc = new Location();
                loc.setId(rs.getString("id"));
                loc.setName(rs.getString("nama"));
                loc.setLongitude(rs.getString("longitude").replaceAll("(^\\h*)|(\\h*$)", ""));
                loc.setLatitude(rs.getString("latitude").replaceAll("(^\\h*)|(\\h*$)", ""));
                
                ptkList.add(loc);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return ptkList;
    }
    
    public ArrayList<Location> getSekolahLocation(){
        ArrayList<Location> sekList = new ArrayList<Location>(); 
        Connection conn = getConnection();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(QUERY_SEKOLAH);            
            while(rs.next()){
                Location loc = new Location();
                loc.setId(String.valueOf(rs.getInt("id")));
                loc.setName(rs.getString("nama"));
                loc.setLongitude(rs.getString("longitude").replaceAll("(^\\h*)|(\\h*$)", ""));
                loc.setLatitude(rs.getString("latitude").replaceAll("(^\\h*)|(\\h*$)", ""));
                
                sekList.add(loc);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return sekList;
    }
    
    public void insertDistanceToDB(Distance dist){
        Connection conn = getConnection();
        try {
            String sql = "insert into distances values(?,?,?,?);";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, dist.getId());
            st.setString(2, dist.getOrigin().getId());
            st.setInt(3, Integer.parseInt(dist.getDestination().getId()));
            st.setDouble(4, dist.getDistance());
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
