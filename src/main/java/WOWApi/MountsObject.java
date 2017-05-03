/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;

import java.io.*;
import javax.json.*;
import java.net.*;
import java.util.*;
public class MountsObject {
    public Mounts getMount(String realm, String name) throws MalformedURLException, IOException
   {
       URL url = new URL("https://eu.api.battle.net/wow/character/"+realm+"/"+name+"?fields=mounts&locale=en_GB&apikey=5vqst2ugb8xbbzyyhq3u5uebr3g9q6a2");
       
       try(
               InputStream in = url.openStream();
               
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
        {
            Mounts mount = new Mounts();
            JsonReader jsonReader = Json.createReader(in);
            
            JsonObject jsonObject = jsonReader.readObject();
            
            jsonReader.close();
            in.close();
            
            JsonArray collected = jsonObject.getJsonObject("mounts").getJsonArray("collected");
            int test = jsonObject.getJsonObject("mounts").getInt("numCollected");
            
            mount.setTest(test);
            
            int arraysize = collected.size();
            ArrayList mountsCollected = new ArrayList();
            
            
            
            for(int i = 0; i < arraysize; i++)
            {
                mountsCollected.add(collected.getJsonObject(i).getJsonString("name").toString());
                
                mount.setName(mountsCollected);
            }
            
            
            return mount;
        }
       
   }
}