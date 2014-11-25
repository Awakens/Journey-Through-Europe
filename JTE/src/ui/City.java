/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.shape.Line;

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
    String[] land;
    String[] sea;
    String color;
    ArrayList<City> landNeighbors = new ArrayList<City>();
    ArrayList<City> seaNeighbors = new ArrayList<City>();
    int airport;
    double newX;
    double newY;
    int num;
    ArrayList<Line> edges = new ArrayList<Line>(); 
    ArrayList<City> haveEdgeTo = new ArrayList<City>();

    
    public City(String name, String color, int region, int x, int y, String[] land, String[] sea, int airport, int num)
    { this.name = name;
      this.color = color;
      this.region = region;
     this.x = x; this.y = y;
     this.airport = airport;
     this.land = land;
     this.sea = sea;
     this.num = num;
     if(region == 1)
     {newX = x*800/2010-10;
     newY = y*600/2569-10;  }
     if(region == 2)
     {newX = x*800/1903-10;
     newY = y*600/2585-10;  }
     if(region == 3)
     {newX = x*800/1985-10;
     newY = y*600/2583-10;  }
     if(region == 4)
     {newX = x*800/1927-10;
     newY = y*600/2561-10;  }
     
     
     Tooltip tip = new Tooltip(name);
     setTooltip(tip); 
    // tip.setGraphic(new ImageView("file:images/flag_white.png"));
    
    }
       public String[] getLand() {
        return land;
    }

    public String[] getSea() {
        return sea;
    }
    public double getNewX() {
        return newX;
    }
    public ArrayList<City> getHaveEdgeTo() {
        return haveEdgeTo;
    }

    public void setHaveEdgeTo(ArrayList<City> haveEdgeTo) {
        this.haveEdgeTo = haveEdgeTo;
    }
    public double getNewY() {
        return newY;
    }
        public void setLandNeighbors(ArrayList<City> landNeighbors) {
        this.landNeighbors = landNeighbors;
    }

    public void setSeaNeighbors(ArrayList<City> seaNeighbors) {
        this.seaNeighbors = seaNeighbors;
    }
    public String getColor() {
        return color;
    }
     public void setLand(String[] land) {
        this.land = land;
    }

    public void setSea(String[] sea) {
        this.sea = sea;
    }

    public void setAirport(int airport) {
        this.airport = airport;
    }

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setEdges(ArrayList<Line> edges) {
        this.edges = edges;
    }

    public int getNum() {
        return num;
    }

    public ArrayList<Line> getEdges() {
        return edges;
    }
    
    public ArrayList<City> getLandNeighbors() {
        return landNeighbors;
    }

    public ArrayList<City> getSeaNeighbors() {
        return seaNeighbors;
    }

    public int getAirport() {
        return airport;
    }

    public static double getUSE_PREF_SIZE() {
        return USE_PREF_SIZE;
    }

    public static double getUSE_COMPUTED_SIZE() {
        return USE_COMPUTED_SIZE;
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
