/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Antony Kwok
 */
public class Player {
    ArrayList<Card> cards;
    City homeCity;
    ArrayList<String> history;
    City myCity;
    City prevCity;
    City prevPrevCity;
    String name;
    boolean isUser;
    int flag;
    
    Player(TextField p, int theFlag, String s)
    { name = p.getText();
     flag = theFlag;
     if(s.equals("User"))
         isUser = true;
     if(s.equals("Computer"))
         isUser = false;
   
    }
    
    
}
