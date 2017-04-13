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
public class ItemDes implements JsonDeserializer<Item>{

    @Override
    public Item deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        final JsonObject jsonObject = je.getAsJsonObject();
        
        final String title = jsonObject.get("id").getAsString();
        final int id = jsonObject.get("id").getAsInt();
        final String desc = jsonObject.get("description").getAsString();
    
        Item items = new Item();
        
        items.setDesc(desc);
        items.setId(id);
        items.setName(title);
        
        return items;
    }
    
}
