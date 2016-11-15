package wis.utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

public class DBConnection {
    
    private final String url = "jdbc:mysql://localhost:3306/wis";
    private final String userName = "root";
    private final String password = "root";
    
    private int userId = 0;
    private int isAdmin = 0;
    
    
    /*
    * TODOS;
    * - Change doLogin to int?
    * - Implement error message to login page
    * - Implement session handling
    * RETURN CODES;
    * 0 = Default (Application Error)
    * 1 = Successfull Login
    * 2 = Authentication Error
    * 3 = User not found
    */
    public int doLogin(String uname, String passw) throws NoSuchAlgorithmException, 
            InvalidKeySpecException, ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        // Try with resource
        try (
                Connection con = DriverManager.getConnection(url, userName, password);
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
    
    public int getUserId(){
        return userId;
    }
    
    public boolean isAdmin(){
        return isAdmin != 0;
    }
    
    
    private PreparedStatement createLoginStatement(Connection con, String uname) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=? LIMIT 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, uname);
        return ps;
    }
}
