/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;

import java.util.*;
public class Pets {
    ArrayList<String> name = new ArrayList<>(); 

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "name " + name;
    }
    
    
}
