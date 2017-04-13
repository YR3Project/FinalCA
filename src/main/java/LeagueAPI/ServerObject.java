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
public class ServerObject {
    public ServerStatus getServerStatus() throws MalformedURLException, IOException
        {
            URL url = new URL("https://euw1.api.riotgames.com/lol/status/v3/shard-data?api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
            
            try(InputStream in = url.openStream();
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
            {
                ServerStatus status = new ServerStatus();
                JsonReader jsonReader = Json.createReader(in);
                
                JsonObject jsonObject = jsonReader.readObject();
                
                jsonReader.close();
                in.close();
                
                String name = jsonObject.getString("name");
                status.setName(name);
                
                String statusGet = jsonObject.getJsonArray("services").getJsonObject(1).getString("status");
                status.setStatus(statusGet);
                
                status.getName();
                status.getStatus();
                
                return status;
            }
        }
}
