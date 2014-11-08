/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 *
 * @author Antony Kwok
 */
public class Card extends Button{
    String color;
    String special;
    Image image;
    ImageView imageView;
    int x;
    int y;
    String letter;
    int number;
    int region;
    City city;

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getColor() {
        return color;
    }

    public String getSpecial() {
        return special;
    }

    public Image getImage() {
        return image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    public int getRegion() {
        return region;
    }

    public City getCity() {
        return city;
    }
    
  
    
    
}
