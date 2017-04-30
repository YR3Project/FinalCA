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
public class MasterObject {
    public Master getMaster() throws MalformedURLException, IOException
   {
       URL url = new URL("https://na.api.riotgames.com/api/lol/NA/v2.5/league/master?type=RANKED_SOLO_5x5&api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
       
       //try(
               InputStream in = url.openStream();
               
        //       BufferedReader reader = new BufferedReader(
        //       new InputStreamReader(in, "UTF-8")))
        //{
            Master master = new Master();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
            
           
            
            
            String jsonArrayTest = null;
            for(int i = 0; i < 10; i++)
            {
                jsonArrayTest = jsonObject.getJsonArray("entries").getJsonObject(i).getString("playerOrTeamName");
                master.setPlayerName(jsonArrayTest);
            }
            
           
            int jsonArrayTest2;
            ArrayList<String> arrays = new ArrayList();
            
            for(int j = 0; j < 10; j++)
            {
                //jsonArrayTest = jsonObject.getJsonArray("entries").getJsonObject(j).getString("playerOrTeamName") + "\n";
                
              //  arrays.add(jsonArrayTest);
                
                master.setPlayerName(jsonObject.getJsonArray("entries").getJsonObject(0).getString("playerOrTeamName"));
                master.setPlayerName2(jsonObject.getJsonArray("entries").getJsonObject(1).getString("playerOrTeamName"));
                master.setPlayerName3(jsonObject.getJsonArray("entries").getJsonObject(2).getString("playerOrTeamName"));
                master.setPlayerName4(jsonObject.getJsonArray("entries").getJsonObject(3).getString("playerOrTeamName"));
                master.setPlayerName5(jsonObject.getJsonArray("entries").getJsonObject(4).getString("playerOrTeamName"));
                master.setPlayerName6(jsonObject.getJsonArray("entries").getJsonObject(5).getString("playerOrTeamName"));
                master.setPlayerName7(jsonObject.getJsonArray("entries").getJsonObject(6).getString("playerOrTeamName"));
                master.setPlayerName8(jsonObject.getJsonArray("entries").getJsonObject(7).getString("playerOrTeamName"));
                master.setPlayerName9(jsonObject.getJsonArray("entries").getJsonObject(8).getString("playerOrTeamName"));
                master.setPlayerName10(jsonObject.getJsonArray("entries").getJsonObject(9).getString("playerOrTeamName"));
                master.setWins(jsonObject.getJsonArray("entries").getJsonObject(0).getInt("wins"));
                master.setWins2(jsonObject.getJsonArray("entries").getJsonObject(1).getInt("wins"));
                master.setWins3(jsonObject.getJsonArray("entries").getJsonObject(2).getInt("wins"));
                master.setWins4(jsonObject.getJsonArray("entries").getJsonObject(3).getInt("wins"));
                master.setWins5(jsonObject.getJsonArray("entries").getJsonObject(4).getInt("wins"));
                master.setWins6(jsonObject.getJsonArray("entries").getJsonObject(5).getInt("wins"));
                master.setWins7(jsonObject.getJsonArray("entries").getJsonObject(6).getInt("wins"));
                master.setWins8(jsonObject.getJsonArray("entries").getJsonObject(7).getInt("wins"));
                master.setWins9(jsonObject.getJsonArray("entries").getJsonObject(8).getInt("wins"));
                master.setWins10(jsonObject.getJsonArray("entries").getJsonObject(9).getInt("wins"));
                master.setLosses1(jsonObject.getJsonArray("entries").getJsonObject(0).getInt("losses"));
                master.setLosses2(jsonObject.getJsonArray("entries").getJsonObject(1).getInt("losses"));
                master.setLosses3(jsonObject.getJsonArray("entries").getJsonObject(2).getInt("losses"));
                master.setLosses4(jsonObject.getJsonArray("entries").getJsonObject(3).getInt("losses"));
                master.setLosses5(jsonObject.getJsonArray("entries").getJsonObject(4).getInt("losses"));
                master.setLosses6(jsonObject.getJsonArray("entries").getJsonObject(5).getInt("losses"));
                master.setLosses7(jsonObject.getJsonArray("entries").getJsonObject(6).getInt("losses"));
                master.setLosses8(jsonObject.getJsonArray("entries").getJsonObject(7).getInt("losses"));
                master.setLosses9(jsonObject.getJsonArray("entries").getJsonObject(8).getInt("losses"));
                master.setLosses10(jsonObject.getJsonArray("entries").getJsonObject(9).getInt("losses"));
                master.setLeaguePoints(jsonObject.getJsonArray("entries").getJsonObject(0).getInt("leaguePoints"));
                master.setLeaguePoints2(jsonObject.getJsonArray("entries").getJsonObject(1).getInt("leaguePoints"));
                master.setLeaguePoints3(jsonObject.getJsonArray("entries").getJsonObject(2).getInt("leaguePoints"));
                master.setLeaguePoints4(jsonObject.getJsonArray("entries").getJsonObject(3).getInt("leaguePoints"));
                master.setLeaguePoints5(jsonObject.getJsonArray("entries").getJsonObject(4).getInt("leaguePoints"));
                master.setLeaguePoints6(jsonObject.getJsonArray("entries").getJsonObject(5).getInt("leaguePoints"));
                master.setLeaguePoints7(jsonObject.getJsonArray("entries").getJsonObject(6).getInt("leaguePoints"));
                master.setLeaguePoints8(jsonObject.getJsonArray("entries").getJsonObject(7).getInt("leaguePoints"));
                master.setLeaguePoints9(jsonObject.getJsonArray("entries").getJsonObject(8).getInt("leaguePoints"));
                master.setLeaguePoints10(jsonObject.getJsonArray("entries").getJsonObject(9).getInt("leaguePoints"));
               
                
            }
            master.getPlayerName();
            master.getName();
            master.getTier();
            master.getEntry();
            return master;
        //}    
    }
}
