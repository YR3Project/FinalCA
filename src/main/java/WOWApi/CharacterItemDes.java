/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;

import com.google.gson.*;
import java.lang.reflect.Type;

/**
 *
 * @author Chris
 */
public class CharacterItemDes implements JsonDeserializer<CharacterItem>{

    @Override
    public CharacterItem deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        final JsonObject jsonObject = je.getAsJsonObject();
        
        final String name = jsonObject.get("name").getAsString();
        final int id = jsonObject.get("faction").getAsInt();
        final JsonObject jsonObject2 = jsonObject.getAsJsonObject();
        final int avgLvl2 = jsonObject.get("averageItemLevel").getAsInt();
        final int avgLvl = jsonObject2.get("averageItemLevel").getAsInt();
    
        CharacterItem items = new CharacterItem();
        
        items.setLvl(avgLvl2);
        items.setId(id);
        items.setName(name);
        
        return items;
    }
    
}
