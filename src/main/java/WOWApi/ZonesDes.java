/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;
import java.lang.reflect.Type;

import com.google.gson.*;
/**
 *
 * @author PC
 */
public class ZonesDes implements JsonDeserializer<Zones>{

    @Override
    public Zones deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        final JsonObject jsonObject = je.getAsJsonObject();
        
        final String name = jsonObject.get("name").getAsString();
        final int id = jsonObject.get("id").getAsInt();
        final String desc = jsonObject.get("description").getAsString();
        final int maxLevel = jsonObject.get("advisedMaxLevel").getAsInt();
        
        final Zones zone = new Zones();
        
        zone.setId(id);
        zone.setDescription(desc);
        zone.setMaxLevel(maxLevel);
        zone.setName(name);
        return zone;
    }
    
}
