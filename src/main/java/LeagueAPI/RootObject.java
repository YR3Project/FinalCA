/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;

import java.io.*;

import java.net.*;
import javax.json.*;


/**
 *
 * @author Chris
 */
public class RootObject {
   
   public Master getMaster() throws MalformedURLException, IOException
   {
       URL url = new URL("https://euw.api.riotgames.com/api/lol/EUW/v2.5/league/challenger?type=RANKED_SOLO_5x5&api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
       
       try(InputStream in = url.openStream();
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
        {
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
            
            master.getPlayerName();
            master.getName();
            master.getTier();
            
            return master;
        }    
    }
}

