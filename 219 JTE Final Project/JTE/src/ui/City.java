/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 *
 * @author Antony Kwok
 */
public class City extends Button{
    String name;
    ArrayList<City> neighbors;
    double x;
    double y;
    int i;
    int j;
    String specialInstructions;
    int playerPiece;
    boolean isOccupied;
    boolean isAirport;
    int region;
    boolean isSpecialCity;

    String color;

    public City(String name, String color, int region, int x, int y)
    { this.name = name;
      this.color = color;
      this.region = region;
     this.x = x; this.y = y;
     Tooltip tip = new Tooltip(name);
     setTooltip(tip); 
    // tip.setGraphic(new ImageView("file:images/flag_white.png"));
     setOnMouseClicked(e ->{
         System.out.println("mouse coordinates (" + e.getX() + "," + e.getY() + ")");
      System.out.println(name + "'s location is (" + x + "," + y + ")");
     }
     );
    }
    
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;}
    
    public void setName(String name) {
        this.name = name;
    }

    public void setNeighbors(ArrayList<City> neighbors) {
        this.neighbors = neighbors;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public void setPlayerPiece(int playerPiece) {
        this.playerPiece = playerPiece;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public void setIsAirport(boolean isAirport) {
        this.isAirport = isAirport;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public void setIsSpecialCity(boolean isSpecialCity) {
        this.isSpecialCity = isSpecialCity;
    }

    public String getName() {
        return name;
    }

    public ArrayList<City> getNeighbors() {
        return neighbors;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public int getPlayerPiece() {
        return playerPiece;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public boolean isIsAirport() {
        return isAirport;
    }

    public int getRegion() {
        return region;
    }

    public boolean isIsSpecialCity() {
        return isSpecialCity;
    }
    
    public boolean isNeighbor(City NY){return false;}
}
