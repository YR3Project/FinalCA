<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.*"%>
<%@page import="Daos.*"%>
<%@page import="LeagueAPI.*"%>
<%@page import="WOWApi.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>

        <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css"/>
       <link href="CSS/Common.css" rel="stylesheet" type="text/css"/>
        
            <!--Wow factor: I used jquery and imported a little cssfrom bootstrap for the drop down navigation bar ( useful for the two icon it gives
            for login and sign-up--> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <link href="CSS/nav.css" rel="stylesheet" type="text/css"/>


  <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
                <%
                    Object Value2  = session.getAttribute("CurrentUser");
                    UsersDao navaccount = new UsersDao("swgw");
                    if (Value2!= null) {
                        Users successUser = (Users) Value2;

                %>
                <li id="active"><a href="index.jsp" id="current">Home</a></li>
                <li><a href="viewProfile.jsp">View your own profile</a></li>
                <li><a href="WoWPage.jsp">World of Warcraft</a></li>
                <li><a href="LeaguePage.jsp">League of Legends</a></li>
                <li><a href="BattlePage.jsp">Battle System</a></li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href ="">Twitch-Area
                    <span class="caret"></span></a>
                 <ul class="dropdown-menu">
                       <li><a href ="Lol-Section.jsp">League of Legends</a>
                       <li><a href ="Wow-Section.jsp">World of Warcraft</a></li>
                        </ul>
                 </li>
                 
      </ul>
                 <ul class="nav navbar-nav navbar-right">
                <li><a href="logout.jsp"><img src="<%=navaccount.GetPicPath(successUser.getUserID())%>" height="40" width="40" /> Log-Out</a></li>
                 </ul>
               
        </ul>
        </div>
    </nav>
           
        <%
        } else {
        %>
 <li><a href="index.jsp">Home</a></li>
 <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href ="">Twitch-Area
                    <span class="caret"></span></a>
                 <ul class="dropdown-menu">
                       <li><a href ="Lol-Section.jsp">League of Legends</a>
                       <li><a href ="Wow-Section.jsp">World of Warcraft</a></li>
                        </ul>
                 </li>
</ul>
<ul class="nav navbar-nav navbar-right">
<li><a href="LoginForm.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
<li><a href="registration.jsp"><span class="glyphicon glyphicon-user"></span> Register</a></li>
</ul>
</nav>
<%
    }
%>  
</html>
