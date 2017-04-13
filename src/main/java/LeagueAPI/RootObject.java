/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;

import java.io.*;
import com.google.gson.*;
import java.net.*;


/**
 *
 * @author Chris
 */
public class RootObject {
   public Champion getChamp() throws MalformedURLException, IOException
   {
       URL url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/23?api_key=RGAPI-fdf965a6-41b8-4fac-831a-f4aaeb133659");
   
       try(InputStream in = url.openStream();
               BufferedReader reader = new BufferedReader(
               new InputStreamReader(in, "UTF-8")))
       {
           Gson gson = new GsonBuilder().create();
           
           
           Champion myObject = gson.fromJson(reader, Champion.class);
           
           myObject.getName();
           
           return myObject;
       }
   
   }
}
