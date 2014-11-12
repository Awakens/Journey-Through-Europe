/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import static java.lang.System.gc;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Antony Kwok   
 */                             //use grid[][], get coordinates,  and path transaction
public class Map extends AnchorPane{   

    ArrayList<City> cities = new ArrayList<City>();

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<City> getCities() {
        return cities;
    }
    
    
    Map(int type){
            this.setWidth(800);
            this.setHeight(600);
           if(type == 1) 
               setStyle("-fx-background-image: url('" + "file:images/gameplay_AC14resized.jpg" + "'); -fx-max-width: 800; -fx-max-height: 600;");
           if(type == 2) 
               setStyle("-fx-background-image: url('" + "file:images/gameplay_AC58resized.jpg" + "'); -fx-max-width: 800; -fx-max-height: 600;");
           if(type == 3) 
               setStyle("-fx-background-image: url('" + "file:images/gameplay_DF14resized.jpg" + "'); -fx-max-width: 800; -fx-max-height: 600;");
           if(type == 4) 
               setStyle("-fx-background-image: url('" + "file:images/gameplay_DF58resized.jpg" + "'); -fx-max-width: 800; -fx-max-height: 600;");
    }
  }
        //   {gc.drawImage(map1Image, 0, 0, 1000, 600);
        //   gc.drawImage(view,  1093*1000/1000, 1932*600/2000);
           // cities.add(new City("ABERDEEN", 1093*1000/2000, 1093*1000/2000));
          //  cities.get(0).setTooltip(new Tooltip());
//Circle circle = new Circle(cities.get(0).getWidth() / 2);
//cities.get(0).setShape(circle);
         //  }
         //  if(type == 2)
         //      gc.drawImage(map2Image, 0, 0, 1000, 600);
         //  if(type == 3)
          //     gc.drawImage(map3Image, 0, 0, 1000, 600);
          // if(type ==4)
           //    gc.drawImage(map4Image, 0, 0, 1000, 600);
          //  gridColumns = 200;
           // gridRows = 40;
           //  grid = x;
        //}

      /*  public void repaint() {
            gc = this.getGraphicsContext2D();
            gc.clearRect(0, 0, this.getWidth(), this.getHeight());

            // CALCULATE THE GRID CELL DIMENSIONS
            double w = this.getWidth() / gridColumns;
            double h = this.getHeight() / gridRows;

            gc = this.getGraphicsContext2D();

            // NOW RENDER EACH CELL
            int x = 0, y = 0;
            int sokobanx = 0;
            int sokobany = 0;
           
            for (int i = 0; i < gridColumns; i++) {
                y = 0;
                for (int j = 0; j < gridRows; j++) {
                    // DRAW THE CELL
                    gc.setFill(Color.LIGHTBLUE);
                    gc.strokeRoundRect(x, y, w, h, 10, 10);

                    switch (grid[i][j]) {
                        case 0:
                            gc.strokeRoundRect(x, y, w, h, 10, 10);
                            break;
                        case 1:
                            gc.drawImage(wallImage, x, y, w, h);
                            break;
                        case 2:
                            gc.drawImage(boxImage, x, y, w, h);
                            break;
                        case 3:
                            gc.drawImage(placeImage, x, y, w, h);
                            break;
                        case 4:
                            gc.drawImage(sokobanImage, x, y, w, h);
                            sokobanx = i;
                            sokobany = j;
                            break;
                    }

                    // THEN RENDER THE TEXT
                    String numToDraw = "" + grid[i][j];
                    double xInc = (w / 2) - (10 / 2);
                    double yInc = (h / 2) + (10 / 4);
                    x += xInc;
                    y += yInc;
                    gc.setFill(Color.RED);
                    //gc.fillText(numToDraw, x, y);
                    x -= xInc;
                    y -= yInc;

                    // ON TO THE NEXT ROW
                    y += h;
                }
                // ON TO THE NEXT COLUMN
                x += w;
            }
            int i = sokobanx;
            int j = sokobany;
            if (grid[i][j - 1] == 2) {
                direction[0] = true;
            } else {
                direction[0] = false;
            }
            if (grid[i][j + 1] == 2) {
                direction[1] = true;
            } else {
                direction[1] = false;
            }
            if (grid[i - 1][j] == 2) {
                direction[2] = true;
            } else {
                direction[2] = false;
            }
            if (grid[i + 1][j] == 2) {
                direction[3] = true;
            } else {
                direction[3] = false;
            }
        }

        public void repaint(String direct) {
            gc = this.getGraphicsContext2D();
            gc.clearRect(0, 0, this.getWidth(), this.getHeight());

            // CALCULATE THE GRID CELL DIMENSIONS
            double w = this.getWidth() / gridColumns;
            double h = this.getHeight() / gridRows;

            gc = this.getGraphicsContext2D();

            // NOW RENDER EACH CELL
            int x = 0, y = 0;
            int sokobanx = 0;
            int sokobany = 0;
            int grid[][] = getgrid();
            for (int i = 0; i < gridColumns; i++) {
                y = 0;
                for (int j = 0; j < gridRows; j++) {
                    // DRAW THE CELL
                    gc.setFill(Color.LIGHTBLUE);
                    gc.strokeRoundRect(x, y, w, h, 10, 10);

                    switch (grid[i][j]) {
                        case 0:
                            gc.strokeRoundRect(x, y, w, h, 10, 10);
                            break;
                        case 1:
                            gc.drawImage(wallImage, x, y, w, h);
                            break;
                        case 2:
                            if (direct == "") {
                                gc.drawImage(boxImage, x, y, w, h);

                            } else {
                                moveAnimation(direct, gc, i, j, x, y, w, h);
                            }
                            break;
                        case 3:
                            gc.drawImage(placeImage, x, y, w, h);
                            break;
                        case 4:
                            if (direct == "") {
                                gc.drawImage(sokobanImage, x, y, w, h);

                            } else {
                                moveAnimation(direct, gc, i, j, x, y, w, h);
                            }
                            sokobanx = i;
                            sokobany = j;

                            break;
                    }

                    // THEN RENDER THE TEXT
                    double xInc = (w / 2) - (10 / 2);
                    double yInc = (h / 2) + (10 / 4);
                    x += xInc;
                    y += yInc;
                    x -= xInc;
                    y -= yInc;

                    // ON TO THE NEXT ROW
                    y += h;
                }
                // ON TO THE NEXT COLUMN
                x += w;
            }
            int i = sokobanx;
            int j = sokobany;
            if (grid[i][j - 1] == 2) {
                direction[0] = true;
            } else {
                direction[0] = false;
            }
            if (grid[i][j + 1] == 2) {
                direction[1] = true;
            } else {
                direction[1] = false;
            }
            if (grid[i - 1][j] == 2) {
                direction[2] = true;
            } else {
                direction[2] = false;
            }
            if (grid[i + 1][j] == 2) {
                direction[3] = true;
            } else {
                direction[3] = false;
            }
        }

        public void moveAnimation(int[][] mastergrid, String direct, GraphicsContext gc, int i, int j, int x, int y, double w, double h) {
            DoubleProperty a = new SimpleDoubleProperty();
            DoubleProperty b = new SimpleDoubleProperty();
            DoubleProperty c = new SimpleDoubleProperty();
            int grid[][] = mastergrid;
            switch (direct) {
                case "LEFT": {
                    if ((grid[i][j] == 2 && grid[i + 1][j] == 4 && direction[2])
                            || grid[i][j] == 4) {
                        Timeline timeline = new Timeline(
                                new KeyFrame(
                                        Duration.seconds(0),
                                        new KeyValue(a, x + w),
                                        new KeyValue(b, x + 2 * w),
                                        new KeyValue(c, 0)),
                                new KeyFrame(Duration.seconds(AnimaLength),
                                        new KeyValue(a, x),
                                        new KeyValue(b, x + w),
                                        new KeyValue(c, w)));
                        timeline.setCycleCount(1);
                        timeline.setAutoReverse(false);
                        int sign = grid[i][j];
                        int yy = y;
                        AnimationTimer timer = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                if (sign == 4) {
                                    gc.drawImage(sokobanImage, a.doubleValue(), yy, w, h);
                                    gc.setFill(Color.WHITE);
                                    gc.fillRect(b.doubleValue(), yy, c.doubleValue(), h);
                                } else if (sign == 2) {
                                    gc.drawImage(boxImage, a.doubleValue(), yy, w, h);
                                }
                            }
                        };
                        timer.start();
                        timeline.play();
                    } else {
                        gc.drawImage(boxImage, x, y, w, h);
                    }
                    break;
                }
                case "RIGHT": {
                    if ((grid[i][j] == 2 && grid[i - 1][j] == 4 && direction[3])
                            || grid[i][j] == 4) {
                        Timeline timeline = new Timeline(
                                new KeyFrame(
                                        Duration.seconds(0),
                                        new KeyValue(a, x - w),
                                        new KeyValue(b, x - w),
                                        new KeyValue(c, 0)),
                                new KeyFrame(
                                        Duration.seconds(AnimaLength),
                                        new KeyValue(a, x),
                                        new KeyValue(b, x - w),
                                        new KeyValue(c, w)));
                        timeline.setCycleCount(1);
                        timeline.setAutoReverse(false);
                        int sign = grid[i][j];
                        int yy = y;
                        AnimationTimer timer = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                if (sign == 4) {
                                    gc.drawImage(sokobanImage, a.doubleValue(), yy, w, h);
                                    gc.setFill(Color.WHITE);
                                    gc.fillRect(b.doubleValue(), yy, c.doubleValue(), h);
                                } else if (sign == 2) {
                                    gc.drawImage(boxImage, a.doubleValue(), yy, w, h);
                                }
                            }
                        };
                        timer.start();
                        timeline.play();
                    } else {
                        gc.drawImage(boxImage, x, y, w, h);
                    }
                    break;
                }
                case "UP": {
                    if ((grid[i][j] == 2 && grid[i][j + 1] == 4 && direction[0])
                            || grid[i][j] == 4) {
                        Timeline timeline = new Timeline(
                                new KeyFrame(
                                        Duration.seconds(0),
                                        new KeyValue(a, y + h),
                                        new KeyValue(b, y + 2 * h),
                                        new KeyValue(c, 0)),
                                new KeyFrame(
                                        Duration.seconds(AnimaLength),
                                        new KeyValue(a, y),
                                        new KeyValue(b, y + h),
                                        new KeyValue(c, h)));
                        timeline.setCycleCount(1);
                        timeline.setAutoReverse(false);
                        int sign = grid[i][j];
                        int xx = x;
                        AnimationTimer timer = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                if (sign == 4) {
                                    gc.drawImage(sokobanImage, xx, a.doubleValue(), w, h);
                                    gc.setFill(Color.WHITE);
                                    gc.fillRect(xx, b.doubleValue(), w, c.doubleValue());
                                } else if (sign == 2) {
                                    gc.drawImage(boxImage, xx, a.doubleValue(), w, h);
                                }
                            }
                        };
                        timer.start();
                        timeline.play();
                    } else {
                        gc.drawImage(boxImage, x, y, w, h);
                    }
                    break;
                }
                case "DOWN": {
                    if ((grid[i][j] == 2 && grid[i][j - 1] == 4 && direction[1])
                            || grid[i][j] == 4) {
                        Timeline timeline = new Timeline(
                                new KeyFrame(
                                        Duration.seconds(0),
                                        new KeyValue(a, y - h),
                                        new KeyValue(b, y - h),
                                        new KeyValue(c, 0)),
                                new KeyFrame(
                                        Duration.seconds(AnimaLength),
                                        new KeyValue(a, y),
                                        new KeyValue(b, y - h),
                                        new KeyValue(c, h)));
                        timeline.setCycleCount(1);
                        timeline.setAutoReverse(false);
                        int sign = grid[i][j];
                        int xx = x;
                        AnimationTimer timer = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                if (sign == 4) {
                                    gc.drawImage(sokobanImage, xx, a.doubleValue(), w, h);
                                    gc.setFill(Color.WHITE);
                                    gc.fillRect(xx, b.doubleValue(), w, c.doubleValue());
                                } else if (sign == 2) {
                                    gc.drawImage(boxImage, xx, a.doubleValue(), w, h);
                                }
                            }
                        };
                        timer.start();
                        timeline.play();
                    } else {
                        gc.drawImage(boxImage, x, y, w, h);
                    }
                    break;
                }
            } 
        } */
   // }
