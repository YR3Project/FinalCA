/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;
import Daos.*;
import Dtos.*;
import java.util.*;
import javax.servlet.http.*;
import java.security.*;
import java.text.*;
public class BattleScoreCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        //Gets the names of the champions selected
        String topName = request.getParameter("topChamp");
        String jungName = request.getParameter("jungChamp");
        String midName = request.getParameter("midChamp");
        String adcName = request.getParameter("adcChamp");
        String supportName = request.getParameter("supportChamp");
        
        if(topName != null && jungName != null && midName != null && adcName != null && supportName != null)
        {
            try
            {
                BattleSystemDao bDao = new BattleSystemDao("swgw");
                
                BattleSystem battle = new BattleSystem();
                //get their values
                int topValue = bDao.getChampValue(topName);
                int jungValue = bDao.getChampValue(jungName);
                int midValue = bDao.getChampValue(midName);
                int adcValue = bDao.getChampValue(adcName);
                int supportValue = bDao.getChampValue(supportName);
                //Add the values up and divide by 5
                double avg = (topValue + jungValue + midValue + adcValue + supportValue)/5;

                if(avg > 0)
                {
                    session.setAttribute("battleSuccess", avg);
                    forwardToJsp = "BattleResult.jsp";
                }
            }
            catch(InputMismatchException e)
            {
                forwardToJsp = "error.jsp";
                session.setAttribute("errorMessage" , "There was an error with the results");
            }
        }
        
        else
        {
            session.setAttribute("errorMessage", "There was an error with the Champions selected");
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
    
}
