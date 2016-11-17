package wis.dbutils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import wis.datastore.userBean;
import wis.listener.Config;
import wis.utils.SecurityHelper;

public class userDB {
    
    
    private int userId = 0;
    private int isAdmin = 0;
    
    private final DataSource dataSource;
    
    public userDB(ServletContext context){
        dataSource = Config.getInstance(context).getDataSource();
    }
    

    public int doLogin(String uname, String passw) throws NoSuchAlgorithmException, 
            InvalidKeySpecException, ClassNotFoundException{
        
        // Try with resource
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = createLoginStatement(con, uname); 
                ResultSet rs = ps.executeQuery()
            ) {

            if(rs.next()){
                
                // Get StoredHash from DB
                String securePass = rs.getString("password");
                userId = rs.getInt("user_id");
                isAdmin = rs.getInt("is_admin");
                
                // Validate password with StoredHash
                if(SecurityHelper.validatePassword(passw, securePass)==true){
                    return 1;
                } else { return 2; }    
            } else { return 3; }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int changePassword(String username, String oldPass, String newPass) 
            throws NoSuchAlgorithmException, InvalidKeySpecException{
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = createLoginStatement(con, username); 
                ResultSet rs = ps.executeQuery()
            ) {
            
                if(rs.next()){
                
                    // Get StoredHash from DB
                    String securePass = rs.getString("password");

                    // Validate password with StoredHash
                    if(SecurityHelper.validatePassword(oldPass, securePass)==true){
                        String newHash = SecurityHelper.genPassword(newPass);
                        try (
                            PreparedStatement ups = updatePassStatement(con, username, newHash);
                            ) { 
                            
                            int us = ups.executeUpdate();
                            
                            if(us!=0){ return 1; } else { return 0; }
                        } catch (Exception e) { return 0; }
                    } else { return 2; }    
                } else { return 2; }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 3;
        }
    }
    
    public int getUserId(){
        return userId;
    }
    
    public boolean isAdmin(){
        return isAdmin != 0;
    }
    
    public List getUsers(){
        List<userBean> users = new ArrayList<>();
        
        // Try with resource
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = getAllUser(con); 
                ResultSet rs = ps.executeQuery()
            ) {
            
            while (rs.next()) {
                userBean user = new userBean();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("username"));
                user.setIsAdmin(rs.getInt("is_admin"));
                users.add(user);
            }
            
            return users;
            
        } catch (Exception e) { 
            System.out.println("DB Error, Return NULL!");
            return null; 
        }
    }
    
        
    
    // SQL Statement 
    private PreparedStatement createLoginStatement(Connection con, String uname) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=? LIMIT 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, uname);
        return ps;
    }
    
    private PreparedStatement getAllUser(Connection con) throws SQLException {
        String sql = "SELECT * FROM users";
        PreparedStatement ps = con.prepareStatement(sql);
        return ps;
    }
    
    private PreparedStatement updatePassStatement(Connection con, String uname, String newPass) throws SQLException {
        String sql = "UPDATE users SET password=? WHERE username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, newPass);
        ps.setString(2, uname);
        return ps;
    }
}
