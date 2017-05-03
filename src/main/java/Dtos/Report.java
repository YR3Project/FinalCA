package Dtos;

public class Report {
    public int reportID;
    public int commentID;
    public int reporterID;
    
    public Report(int reportID, int commentID, int reporterID){
        this.reportID = reportID;
        this.reportID = reportID;
        this.reportID = reportID;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getReporterID() {
        return reporterID;
    }

    public void setReporterID(int reporterID) {
        this.reporterID = reporterID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.reportID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Report other = (Report) obj;
        if (this.reportID != other.reportID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Report{" + "reportID=" + reportID + ", commentID=" + commentID + ", reporterID=" + reporterID + '}';
    }
    
}
