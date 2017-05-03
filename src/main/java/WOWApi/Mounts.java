/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WOWApi;
import java.util.ArrayList;
public class Mounts {
    ArrayList<String> name = new ArrayList<>();
    public int test;
    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
    
    public Mounts()
    {
        
    }

    @Override
    public String toString() {
        return "Mounts" + "name " + name;
    }
    
    
}
