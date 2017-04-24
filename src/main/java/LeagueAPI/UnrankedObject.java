/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;

import java.io.*;
import javax.json.*;
import java.net.*;
import java.util.*;
public class UnrankedObject {
    public Unranked getUnranked(String region, String id) throws MalformedURLException, IOException
        {
            URL url = new URL("https://"+ region+ ".api.riotgames.com/api/lol/"+region+"/v1.3/stats/by-summoner/"+id+"/summary?season=SEASON2017&api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
            
            try(InputStream in = url.openStream();
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
            {
                Unranked unranked = new Unranked();
                JsonReader jsonReader = Json.createReader(in);
                
                JsonObject jsonObject = jsonReader.readObject();
                
                jsonReader.close();
                in.close();
                
                JsonArray jsonArray = jsonObject.getJsonArray("playerStatSummaries");
                for(int i = 0; i < jsonArray.size(); i++)
                {
                    //get the unranked name
                    String playerStatSummaryType = jsonArray.getJsonObject(8).getString("playerStatSummaryType");
                    int wins = jsonArray.getJsonObject(8).getInt("wins");
                    if(playerStatSummaryType.equals("Unranked"))
                    {
                        //print off detailed stats
                        JsonObject aggregatedStats = jsonArray.getJsonObject(i).getJsonObject("aggregatedStats");
                        
                        String unrankedStats = jsonArray.getJsonObject(i).getString("playerStatSummaryType");

                        int totalChampKills = aggregatedStats.getInt("totalChampionKills");
                        int totalTurretKills = aggregatedStats.getInt("totalTurretKills");
                        int totalMinionKills = aggregatedStats.getInt("totalMinionKills");
                        int totalNeutralMinionsKilled = aggregatedStats.getInt("totalNeutralMinionsKilled");
                        int totalAssits = aggregatedStats.getInt("totalAssits");
                        
                        unranked.setTotalAssists(totalAssits);
                        unranked.setTotalChampionKills(totalChampKills);
                        unranked.setTotalMinionKills(totalMinionKills);
                        unranked.setTotalNeutralMinionsKilled(totalNeutralMinionsKilled);
                        unranked.setWins(wins);
                        unranked.setTotalTurretsKilled(totalTurretKills);
                    }
                }
                return unranked;
            }
        }
}
