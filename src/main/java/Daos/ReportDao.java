package Daos;

/**
 *
 * @author Ben
 */
import Dtos.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDao extends Dao implements ReportDaoInterface {

    public ReportDao(String databaseName) {
        super(databaseName);
    }

   @Override
    public int getReportsByComment(int commentID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int reports=0;
        try {
            con = getConnection();

            String query = "SELECT commentID AS reports FROM report where commentID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, commentID);
            rs = ps.executeQuery();
            reports=0;
            while(rs.next()){
            reports++;
            }
            
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCommentsByArticle() method: " + e.getMessage());
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the final section of the getCommentsByArticle() method: " + e.getMessage());
            }
        }
        
        return reports;
    }
    
    @Override
    public boolean fileReport(int commentID, int reporterID) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            int rowsAffected = 0;
            try{
                con = getConnection();

                String query = "Insert INTO report (commentID, reporterID) values(?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1,commentID);
                ps.setInt(2, reporterID);
                
                //Updates the rowsAffected variable to 1 if the insert works
                rowsAffected = ps.executeUpdate();
                
            }catch (SQLException e) {
                System.out.println("Exception occured in the setComment() method: " + e.getMessage());

            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section of the setComment() method");
                    e.getMessage();

                }
            }
            //Check to see if the insert went through
            if(rowsAffected > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
    }
   
    
    }