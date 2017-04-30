<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Forms.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="Images/favicon.ico" type="image/x-icon">
            <link rel="icon" href="Images/favicon.ico" type="image/x-icon">
        <title>SWGW</title>
    </head>

     <%@ include file="Includes/Carousel.html" %> 
    <body>
        <div id="wrapper">
            <header>
            <h1>Result!</h1>
        <%@ include file="Includes/nav.jsp" %>
            </header>
            <article>
                <section>
        <%
            Object Battle = session.getAttribute("battleSuccess");
            if (Value2 != null)
            {
                Users successUser = (Users) Value2;
                BattleSystemDao bDao = new BattleSystemDao("swgw");
                BattleSystem battlesystem = new BattleSystem();
                
                double battlesystem2 = (Double) Battle;
                double result = battlesystem2;
                NumberFormat formatter = new DecimalFormat("#.00");
                String finalResult = formatter.format(result);
                
        %>
                    <h2 id="title">The Results</h2>
                    <p>The results from our epic Battle simulation system has come up the following result</p>
                    <p id="battleResult">Based on the champions you've selected you have a <%=finalResult %>% chance to win your game</p>
                    
                </section>
            </article>
        <%
            }
        %>
        <%@ include file="Includes/footer.jsp" %>
        </div>
    </body>
</html>
