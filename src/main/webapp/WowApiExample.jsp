<%-- 
    Document   : WowApiExample
    Created on : 16-Feb-2017, 09:47:05
    Author     : AleksMtt
--%>
<%@page import="Dtos.WowCharacterAPI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <title>Wow Character Profile</title>
        <script>
            function getAverageItemLevel(realm, profile, handler) {
                $.ajax({
                    url: "https://eu.api.battle.net/wow/character/" + realm + "/" + profile,
                    jsonp: "jsonp",
                    dataType: "jsonp",
                    data: {
                        apiKey: "4t5bsyufrehzx4a98wazgax79tbhbur",
                        fields: "items"
                    },
                    success: function (response) {
                        handler(response.items.averageItemLevel);
                    },
                    error: function () {
                        handler("Unable to complete request");
                    }

                });
            }
        </script>
    </head>
    <body>
        <script type="text/javascript">
            document.write(getAverageItemLevel("Silvermoon", "Aleksm"));
        </script>
    </body>
</html>
