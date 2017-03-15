/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeagueAPI;
import com.google.gson.*;
import java.lang.reflect.Type;
/**
 *
 * @author Chris
 */
public class ChampionDes implements JsonDeserializer<Champion>{

    @Override
    public Champion deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        final JsonObject jsonObject = je.getAsJsonObject();
        
        
    
        final String name = jsonObject.get("name").getAsString();
        final String title = jsonObject.get("title").getAsString();
        
        Champion champ = new Champion();
        
        champ.setName(name);
        champ.setTitle(title);
    
        return champ;
    }
    
}
