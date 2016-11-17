
package wis.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import wis.datastore.patientBean;
import wis.listener.Config;

public class patientDB {
    
    
    private final DataSource dataSource;
    
    public patientDB(ServletContext context){
        dataSource = Config.getInstance(context).getDataSource();
    }
    
    public List getPatientInfo(){
        List<patientBean> patients = new ArrayList<>();
        
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = getAllPatientStatement(con); 
                ResultSet rs = ps.executeQuery()
            ) {
            
            while(rs.next()){
                patientBean patient = new patientBean();
                patient.setBed(rs.getString("bed"));
                patient.setBuilding(rs.getString("building"));
                patient.setDescription(rs.getString("description"));
                patient.setAddress(rs.getString("address"));
                patient.setDob(rs.getString("dob"));
                patient.setIc(rs.getString("ic_num"));
                patient.setId(rs.getInt("patient_id"));
                patient.setName(rs.getString("name"));
                patient.setRoom(rs.getString("room"));
                patient.setStatus(rs.getInt("status"));
                
                patients.add(patient);
            }
            return patients;
            
        } catch (Exception e) { 
            System.out.println(e.getMessage());
            return null; }
    }
    
    
    // Statement Builder
    
    private PreparedStatement getAllPatientStatement(Connection con) throws SQLException {
        String sql = "SELECT * FROM patient";
        PreparedStatement ps = con.prepareStatement(sql);
        return ps;
    }
}
