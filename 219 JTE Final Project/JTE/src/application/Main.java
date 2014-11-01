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

