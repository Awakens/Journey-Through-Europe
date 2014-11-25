/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Timer;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.SequentialTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author Antony Kwok
 */
public class move extends Timer implements Runnable{
    Player p;
    City NY;
    int currentPlayerPoints;
    move(Player p, City NY, int currentPlayerPoints)
    { this.p = p;
      this.NY=NY;
      this.currentPlayerPoints = currentPlayerPoints;
    }
    public void run(){
        
         if(currentPlayerPoints != 0 && p.getMyCity().getRegion() == NY.getRegion())  //check if points and NY is possible city
        {   if(p.getMyCity() != null)
            {    p.setPrevCity(p.getMyCity());
                  for(int g = 0; g<p.getMyCity().getEdges().size(); g++)
                    {  p.getMyCity().getEdges().get(g).setStroke(Color.BLACK);
                       p.getMyCity().getEdges().get(g).setStroke(Color.BLACK);
                    //come  should reset all to black???
                    }
            }

            for(int g = 0; g<NY.getEdges().size(); g++)
            {  NY.getEdges().get(g).setStroke(Color.RED);
              NY.getEdges().get(g).setFill(Color    .RED);
            }  //come need to take off red for prev city if it exists
            p.relocate(NY.getNewX(), NY.getNewY());
             System.out.println(p.getName() + " added to " + NY.getName());
             
              Line line = new Line(p.getX(), p.getY(), NY.getNewX()-100, NY.getNewY()-100);
            p.setMyCity(NY);
            p.setX(NY.getNewX());
            p.setY(NY.getNewY());
            Path path = new Path();
        path.getElements().add(new MoveTo(30, 30));
         
        final PathTransition pathTransition = PathTransitionBuilder.create()
                .node(p)
                .path(path)
                .duration(Duration.millis(9000))
                .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(1)
                .build();

             pathTransition.playFromStart(); }
            try{Thread.sleep(5000);}
            catch(Exception e){}
}}