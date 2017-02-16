
    <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stat-Tacking Website</title>
    </head>
    <body>
    <?php

$sumName = "chips97";
$apiKey = "RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659";


$return = file_get_contents("https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/chips97?api_key=" . $apiKey);
$returnContents = json_decode($return);

print $returnContents -> name;
print $returnContents -> summonerLevel;
?>
</body>
</html>