package Daos;

/**
 *
 * 
 *
 * @author Ben
 */
import Dtos.Report;
import java.util.ArrayList;


public interface ReportDaoInterface {

    public int getReportsByComment(int commentID);
    
    public boolean fileReport(int commentID, int reporterID);
}
