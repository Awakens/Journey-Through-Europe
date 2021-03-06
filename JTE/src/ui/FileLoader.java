/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.io.*;
import java.util.ArrayList;
import javafx.scene.image.ImageView;
/**
 *
 * @author Antony Kwok
 */

public class FileLoader {
    FileLoader()
    { try{loadFile();} catch(Exception e){System.out.println("file loading error");}}
    
    ArrayList<City> cities1= new ArrayList<City>();
    ArrayList<City> cities2= new ArrayList<City>();
    ArrayList<City> cities3= new ArrayList<City>();
    ArrayList<City> cities4= new ArrayList<City>();

     
    ArrayList<Card> greenCards = new ArrayList<Card>();
    ArrayList<Card> redCards = new ArrayList<Card>();
    ArrayList<Card> yellowCards = new ArrayList<Card>();
    ArrayList<Card> cards = new ArrayList<Card>();

    
void loadFile() throws Exception {

BufferedReader file = 
new BufferedReader(new FileReader("cities.csv"));
System.out.println("Loaded file");
City NY;
int airportRegion = 0;
int num = 0;
Card card;
String readLine = file.readLine(); 
while (readLine != null)
{ 
  String[] data = readLine.split(",");
  String[] land = null;
  if(!(data[5].equals("null")))
    land = data[5].split(" ");   //get land neighbors
  else
    land = new String[]{data[6]};  
  String[] sea = null;
   if(!(data[6].equals("null")))
  sea = data[6].split(" ");
   else
    sea = new String[]{data[6]};   
       
  airportRegion = Integer.parseInt(data[7]);
  num = Integer.parseInt(data[8]);
  
    int region = Integer.parseInt(data[2]); //add in neighbors after
   //   System.out.println(data[0] + "  " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
    int x = Integer.parseInt(data[3]);
    int y = Integer.parseInt(data[4]);
  card = new Card(data[0], data[1], region, num);
    cards.add(card);

  card.setGraphic(new ImageView("file:images/" + data[1] + "/" + data[0] + ".jpg"));

  NY = new City(data[0], data[1], region, x, y, land, sea, airportRegion, num);  
  if(data[1].equals("green"))
    greenCards.add(card);
  if(data[1].equals("red"))
    redCards.add(card);
  if(data[1].equals("yellow"))
    yellowCards.add(card);
  if(region == 1)
    cities1.add(NY);
  if(region == 2)
    cities2.add(NY);
  if(region == 3)
    cities3.add(NY);
  if(region == 4)
    cities4.add(NY);
    //next line
  readLine = file.readLine(); 
}
  file.close();  //done and close



} 
  public ArrayList<Card> getCards() {
        return cards;
    }
 public  ArrayList<City> getCities1() {
        return cities1;
    }

    public ArrayList<City> getCities2() {
        return cities2;
    }

    public ArrayList<City> getCities3() {
        return cities3;
    }

    public ArrayList<City> getCities4() {
        return cities4;
    }

    public void setCities1(ArrayList<City> cities1) {
        this.cities1 = cities1;
    }

    public void setCities2(ArrayList<City> cities2) {
        this.cities2 = cities2;
    }

    public void setCities3(ArrayList<City> cities3) {
        this.cities3 = cities3;
    }

    public void setCities4(ArrayList<City> cities4) {
        this.cities4 = cities4;
    }
    public ArrayList<Card> getGreenCards() {
        return greenCards;
    }

    public ArrayList<Card> getRedCards() {
        return redCards;
    }

    public ArrayList<Card> getYellowCards() {
        return yellowCards;
    }

    public void setGreenCards(ArrayList<Card> greenCards) {
        this.greenCards = greenCards;
    }

    public void setRedCards(ArrayList<Card> redCards) {
        this.redCards = redCards;
    }

    public void setYellowCards(ArrayList<Card> yellowCards) {
        this.yellowCards = yellowCards;
    }

} 