<!-- This Retrieves the image from the database to be used as a profile picture on Website
the reason why i did not do this in a command is the difficulty i had when trying to move this around it refused to move through the session to the profile-page

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%
    //Setting up connection
 String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/swgw";
        String username = "root";
        String password = "";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex1) {
            System.out.println("Failed to find driver class " + ex1.getMessage());
            System.exit(1);
        } catch (SQLException ex2) {
            System.out.println("Connection failed " + ex2.getMessage());
        }   
    
    
//geting current user Id    
int img_id = Integer.parseInt(request.getParameter("your_id"));
//Sql for getting image back and formating the stored blob into a readable image;
ResultSet rs = null;
PreparedStatement pstmt = null;
OutputStream oImage;
try {
pstmt = con.prepareStatement("Select photo from users where userID = ?");
pstmt.setInt(1, img_id);
rs = pstmt.executeQuery();
    if(rs.next()) {
        byte barray[] = rs.getBytes(1);
        response.setContentType("image/gif");
        oImage=response.getOutputStream();
        oImage.write(barray);
        oImage.flush();
        oImage.close();
    }
}
catch(Exception ex){
    //ex.printStackTrace();
}finally {
    try{
    if(con!=null)
       con.close();
    }catch(Exception ex){
       // ex.printStackTrace();
    }
}




        
       
    
%>

