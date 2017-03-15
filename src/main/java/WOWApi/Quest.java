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
public class Quest {
    protected String title;
    protected int id;
    protected int lvl;
    
    public Quest(String title, int id, int lvl) {
        this.title = title;
        this.id = id;
        this.lvl = lvl;
    }

    public Quest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    
    
}
