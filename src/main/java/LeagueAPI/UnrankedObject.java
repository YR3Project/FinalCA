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
                String name = null;
                    JsonObject object = jsonArray.getJsonObject(8);
                    int assists = jsonArray.size();
                    unranked.setTotalAssists(assists);
                    //get the unranked name
                    for(int i = 0; i < 10; i++)
                    {
                        String playerStatSummaryType = jsonArray.getJsonObject(i).getJsonString("playerStatSummaryType").toString();
                        if(playerStatSummaryType.contains("Unranked"))
                        {
                            name = "Unranked";
                            JsonObject aggregatedStats = jsonArray.getJsonObject(i).getJsonObject("aggregatedStats");
                            int totalChampKills = aggregatedStats.getInt("totalChampionKills");
                            unranked.setTotalChampionKills(totalChampKills);
                        }
                    }
                    //int wins = jsonArray.getJsonObject(0).getInt("wins");
                    int wins = object.getInt("wins");
                    unranked.setWins(wins);
                   
                    
                       
                        
                       

                        
//                        int totalTurretKills = aggregatedStats.getInt("totalTurretKills");
                       // int totalMinionKills = aggregatedStats.getInt("totalMinionKills");
                       // int totalNeutralMinionsKilled = aggregatedStats.getInt("totalNeutralMinionsKilled");
                       // int totalAssits = aggregatedStats.getInt("totalAssits");
                        
                        
                       // unranked.setTotalChampionKills(totalChampKills);
                        //unranked.setTotalMinionKills(totalMinionKills);
                        //unranked.setTotalNeutralMinionsKilled(totalNeutralMinionsKilled);
                        
                       // unranked.setTotalTurretsKilled(totalTurretKills);
                    
                return unranked;
            }
        }
}
