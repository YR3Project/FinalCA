<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <title>Battle Result</title>
    </head>

     <%@ include file="Includes/Slideshow.php" %>
    <body>
        <div id="wrapper">
            <header>
            <h1>Result!</h1>
        <%@ include file="Includes/nav.jsp" %>
            </header>
            <article>
        <%
            Object Battle = session.getAttribute("battleSuccess");
            if (Value2 != null)
            {
                Users successUser = (Users) Value2;
                BattleSystem battlesystem = new BattleSystem();
                int battlesystem2 = (Integer) Battle;
                BattleSystemDao bDao = new BattleSystemDao();
                
                
        %>
        <%=battlesystem.getChampName()%>
            <% out.println(battlesystem2); %>
        <%
            }
        %>
    </body>
</html>
