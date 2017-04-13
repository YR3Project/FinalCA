/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;

/**
 *
 * @author Chris
 */
public class CharacterItem {
    protected int id;
    protected int avgLvl;
    protected String name;

    public CharacterItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAvgLvl()
    {
        return avgLvl;
    }
    public void setLvl(int avgLvl)
    {
        this.avgLvl = avgLvl;
    }
}
