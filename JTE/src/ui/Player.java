/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Antony Kwok
 */
public class Player extends ImageView{
    ArrayList<Card> cards;
    City homeCity;
    ArrayList<String> history;
    City myCity;
    City prevCity;
    City prevPrevCity;
    String name;
    boolean isUser;
    int num;
    
    public void addCard(Card c)
    {  cards.add(c);
    }       

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
        this.num=num;
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

    public boolean getIsUser() {
        return isUser;
    }

    public int getNum() {
        return num;
    }
    
    Player(TextField p, int num, String s)
    { name = p.getText();
     this.num = num;
     if(s.equals("User"))
         isUser = true;
     if(s.equals("Computer"))
         isUser = false;
   cards = new ArrayList<Card>();
   setScaleX(.3);
   setScaleY(.3);
    
    history = new ArrayList<String>();
              if(num == 0)
             setImage(new Image("file:images/piece_black.png"));
              if(num == 1)
             setImage(new Image("file:images/piece_blue.png"));
              if(num == 2)
             setImage(new Image("file:images/piece_green.png"));
              if(num == 3)
             setImage(new Image("file:images/piece_red.png"));
              if(num == 4)
             setImage(new Image("file:images/piece_white.png"));
              if(num == 5)
             setImage(new Image("file:images/piece_yellow.png"));
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
