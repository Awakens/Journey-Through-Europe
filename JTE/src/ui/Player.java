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

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setHomeCity(City homeCity) {
        this.homeCity = homeCity;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

    public void setMyCity(City myCity) {
        this.myCity = myCity;
    }

    public void setPrevCity(City prevCity) {
        this.prevCity = prevCity;
    }

    public void setPrevPrevCity(City prevPrevCity) {
        this.prevPrevCity = prevPrevCity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public City getHomeCity() {
        return homeCity;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public City getMyCity() {
        return myCity;
    }

    public City getPrevCity() {
        return prevCity;
    }

    public City getPrevPrevCity() {
        return prevPrevCity;
    }

    public String getName() {
        return name;
    }

    public boolean isIsUser() {
        return isUser;
    }

    public int getFlag() {
        return flag;
    }
    
    Player(TextField p, int theFlag, String s)
    { name = p.getText();
     flag = theFlag;
     if(s.equals("User"))
         isUser = true;
     if(s.equals("Computer"))
         isUser = false;
   cards = new ArrayList<Card>();
    
    history = new ArrayList<String>();
    /*
    City homeCity;
    City myCity;
    City prevCity;
    City prevPrevCity;
    String name;
    boolean isUser;
    int flag;
            */
    }
    public void addHistory(String cityName)
    { history.add(cityName);
    }
    
}
