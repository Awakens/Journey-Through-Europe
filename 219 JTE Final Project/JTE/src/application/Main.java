/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.JTEUI;

/**
 *
 * @author Antony Kwok
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Journey Through Europe");
try{
            JTEUI root = new JTEUI(primaryStage);
            root.startUI();
            Scene scene = new Scene(root.getMainPane(), root.getPaneWidth(), root.getPaneHeight());
            primaryStage.setScene(scene);
            
            primaryStage.show();
               } catch (Exception e) {
            e.printStackTrace();
        }
    } }




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
package application; 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
*/
/*
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Journey Through Europe");
try{
          // JTEUI root = new JTEUI(primaryStage);
            //root.startUI();
           // Scene scene = new Scene(root.getMainPane(), root.getPaneWidth(), root.getPaneHeight());
           
                   AnchorPane  gamePanel = new AnchorPane();
                   Button b = new Button("lol");
                    b.setTooltip(new Tooltip("hi")); 
          gamePanel.setPrefWidth(300);
          gamePanel.setPrefHeight(300);
           gamePanel.setStyle("-fx-background-color: red;");
        //  gamePanel.setStyle("-fx-background-image: url('" + "file:images/gameplay_AC14.jpg" + "'); -fx-background-repeat: stretch;");
        // gamePanel.getChildren().add(map1);
           gamePanel.setMaxSize(300, 300);
        // gamePanel.setTopAnchor(cities1.get(0), 200.0);
          gamePanel.getChildren().add(b);  //add in City button
         // gamePanel.getChildren().add(cities1.get(1));
         //  cities1.get(0).setTooltip(new Tooltip("ABERDEEN"));   
        //cities1.get(0).relocate(135, 135);
           //cities1.get(0).relocate(1993*1000/2010, 1932*600/2569);
           // cities1.get(1).relocate(1985*1000/2010, 2124*600/2569);
            
           b.relocate(1093*gamePanel.getWidth()/2010, 1932*gamePanel.getHeight()/2569);
           b.relocate(300, 500);
              Circle circle = new Circle(3, Color.GREEN);
            b.setShape(circle);
           b.setPrefSize(50, 50);
          
           //   gamePanel.setAlignment(b, Pos.TOP_RIGHT);
                   primaryStage.setScene(new Scene(gamePanel));
            
            primaryStage.show();
               } catch (Exception e) {
            e.printStackTrace(); 

*/
  //      }
//    } }
