/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import Dtos.*;

import java.sql.*;
import java.util.*;
public class BattleSystemDao extends Dao implements BattleSystemDaoInterface{
    public BattleSystemDao(String databaseName){
        super(databaseName);
    }

    @Override
    public BattleSystem getChampName(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BattleSystem b = null;
        try
        {
            con = getConnection();
            String query = "Select * from Battle WHERE ChampID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                b = new BattleSystem(rs.getInt("ChampID"), rs.getString("ChampName"), rs.getInt("ChampValue"), rs.getString("Position"));
            }
            
        }catch(SQLException e)
        {
            System.out.println("Exception occured in the getChampName method " + e.getMessage());
        }
        finally
        {
            try
            {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getChampName() method: " + e.getMessage());
            }
        }
        return b;
    }

    @Override
    public int getChampValue(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int value = 0;
        try
        {
            con = getConnection();
            String query = "Select champValue from Battle WHERE ChampName = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while(rs.next())
            {
                value = rs.getInt("ChampValue");
            }
            
        }catch(SQLException e)
        {
            System.out.println("Exception occured in the getChampName method " + e.getMessage());
        }
        finally
        {
            try
            {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getChampName() method: " + e.getMessage());
            }
        }
        return value;
    }

    @Override
    public String getChampPosition(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String position = null;
        try
        {
            con = getConnection();
            String query = "Select position from Battle WHERE ChampID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                position = rs.getString("Position");
            }
            
        }catch(SQLException e)
        {
            System.out.println("Exception occured in the getChampName method " + e.getMessage());
        }
        finally
        {
            try
            {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getChampName() method: " + e.getMessage());
            }
        }
        return position;
    }

    @Override
    public ArrayList<BattleSystem> getChampsBasedOnPosition(String position) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BattleSystem> battle = new ArrayList();
        BattleSystem b;
        
        try{
            con = getConnection();

            String query = "Select ChampName, position from Battle WHERE Position = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, position);
            
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                b = new BattleSystem( rs.getString("ChampName"),rs.getString("position"));
                battle.add(b);
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getChampsBasedOnPosition() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getChampBasedOnPosition() method: " + e.getMessage());
            }
        }
        
        return battle;
    }

    
}
