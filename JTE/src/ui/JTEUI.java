/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import game.JTEDataManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Antony Kwok
 */
public class JTEUI extends Pane implements Runnable{
   
    private Stage primaryStage;
   Image image;
   ImageView imageVIew;
   ImageView cardView;
   ImageView splashView;
   Image mapImage;
   ImageView mapVIew;
   JTEDataManager dataManager;
   VBox splashButtonBox;
   Label aboutLabel;
   BorderPane mainPane;
   StackPane splashPane;
   BorderPane aboutPanel;
   BorderPane gamePanel;
   VBox gamePanelRight;
   Pane cardStack;
   BorderPane historyPanel;
   BorderPane flightPanel;
   ArrayList<PathTransition> p;
   ArrayList<ScaleTransition> s;
   ArrayList<ParallelTransition> parallelTransition;
   ArrayList<PathTransition> path;
   GridPane mapPanel;
   Button mapB1, mapB2, mapB3, mapB4;
   int[][] grid1, grid2, grid3, grid4;
   Map map1, map2, map3, map4;
   Map flightMap;
   GridPane selectPlayersPanel;
   Label selectNumPlayers;
   Button num2P, num3P, num4P, num5P, num6P;
   Label nameLabel;
   int numPlayers;
   String name;
   int paneWidth;
   int paneHeight;
   Button selectComputer0,selectComputer1,selectComputer2,selectComputer3,selectComputer4,selectComputer5;
   Button selectUser0,selectUser1,selectUser2,selectUser3,selectUser4,selectUser5;
   Button startGameButton;
   Button loadGameButton;
   Button aboutButton;
   Button quitButton;
   Button historyButton;
   Button splashButton;
   Button gameButton;
   Label winLabel;
   Label loseLabel;
   ArrayList<TextField> playerNames;
   Button OK;
   VBox TheBox;
   Button saveButton;
   Button closeButton;
   Button flightButton;
   Button GO;
   Button map1Button;
   Button map2Button;
   Button map3Button;
   Button map4Button;
   ArrayList<Line> edges;
   Label mapLabel1; 
    Label mapLabel2; 
     Label mapLabel3; 
      Label mapLabel4; 
  Button endTurn;
  Label playerName;
  Player currentPlayer;
  int playerTurn;
  int currentPlayerPoints;
  int round;
  int pCount;
  int flag;
   ArrayList<String> move;
   Button dieButton;
   Button returnButton;
   ArrayList<Player> players;
   FileLoader file;
   ArrayList<Card> allCards;
   ArrayList<City> cities1;
   ArrayList<City> cities2;
   ArrayList<City> cities3;
   ArrayList<City> cities4;
   HashMap<String, City>  citiesHash;
   Insets marginlessInsets;
   ArrayList<BorderPane> playerPanels; 
   ArrayList<String> playerType;
   HBox northToolbar;
   ArrayList<Card> cardsDealt;
   int pathCount;
   boolean dragged;
  

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public BorderPane getMainPane(){return mainPane;}
    public int getPaneHeight(){return paneHeight;}
    public int getPaneWidth(){return paneWidth;}
    
    public JTEUI(Stage stage) throws IOException {
        setPrimaryStage(stage);
        dataManager = new JTEDataManager(this);
    }
   
    public void run()
    { 
        mainPane = new BorderPane();
        mainPane.resize(paneWidth, paneHeight);
        int insetsvalue = 10;
        marginlessInsets = new Insets(insetsvalue);
        mainPane.setPadding(marginlessInsets);
        initValues();
        initLabels();
          initButtons();     
        initPanels();
        initSplashScreen(); }
    
     public void initSplashScreen() {

        // INIT THE SPLASH SCREEN CONTROLS
        splashView = new ImageView("file:images/Game.JPG");
        splashView.setFitWidth(1300.0);
        splashView.setFitHeight(700.0);

        Label splashScreenImageLabel = new Label();
        splashScreenImageLabel.setGraphic(splashView);
        splashPane.getChildren().add(splashScreenImageLabel);

        // GET THE LIST OF LEVEL OPTIONS
        splashButtonBox = new VBox();
        splashButtonBox.setAlignment(Pos.BOTTOM_CENTER);
   
        // add key listener
        
       splashButtonBox.getChildren().addAll(startGameButton, loadGameButton, aboutButton, quitButton);
        
       
            startGameButton.setOnAction(e -> {
               newGame(); });
            loadGameButton.setOnAction(e -> {
                mainPane.setStyle("");
               load();});
            aboutButton.setOnAction(e -> {
                boolean xd = false;
                if(mainPane.getCenter() == splashPane)
                    xd = true;
                mainPane.getChildren().clear();   
                 mainPane.setCenter(aboutPanel);
                 mainPane.setStyle("-fx-background-image: url('" + "file:images/brown-vintage-background-18641-19113-hd-wallpapers.jpg" + "'); -fx-max-width: 1300; -fx-max-height: 700;");

               if(xd)
               mainPane.setBottom(splashButton);
                
               else
               mainPane.setTop(northToolbar);
            } );
            
        
        splashPane.getChildren().add(splashButtonBox);
        mainPane.setCenter(splashPane);
    }
    
   public void newGame(){
        initValues();
        initLabels();
          initButtons();
        initPanels();
       mainPane.getChildren().clear();
       HBox plays = new HBox();
       plays.getChildren().addAll(selectNumPlayers, num2P, num3P, num4P, num5P, num6P, GO);    
       mainPane.setTop(plays);
       mainPane.setCenter(selectPlayersPanel); 
       mainPane.setStyle("-fx-background-image: url('" + "file:images/brown-vintage-background-18641-19113-hd-wallpapers.jpg" + "'); -fx-max-width: 1300; -fx-max-height: 700;");
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(50);
        selectPlayersPanel.getColumnConstraints().addAll(col1,col2,col3);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(60);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(60);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(60);
        selectPlayersPanel.setHgap(10); //horizontal gap in pixels => that's what you are asking for
        selectPlayersPanel.setVgap(10);

        selectPlayersPanel.getRowConstraints().addAll(row1,row2,row3);
       selectPlayersPanel.add(playerPanels.get(0), 0,0);
       selectPlayersPanel.add(playerPanels.get(1), 1,0);
       selectPlayersPanel.add(playerPanels.get(2), 2,0);
       selectPlayersPanel.add(playerPanels.get(3), 0,1);
       selectPlayersPanel.add(playerPanels.get(4), 1,1);
       selectPlayersPanel.add(playerPanels.get(5), 2,1);
      
    }
   
   public void addPlayerPanels(int x){
       for(int i = 0; i <6; i++){
        //reset player panels
           playerPanels.get(i).getChildren().clear();
       }
       //add in things to player panels
       for(int i =0; i < numPlayers; i++)
       { playerPanels.get(i).setStyle("-fx-background-color:brown; -fx-border-style: solid; -fx-border-width: 1px;");
        HBox box = new HBox();                    //add in things inside the Player Panel
        nameLabel = new Label("  Name: ");
        nameLabel.setPrefHeight(25);
        nameLabel.setStyle("-fx-background-color:white;");
       box.getChildren().addAll(nameLabel, playerNames.get(i));   //label and textfield
       playerPanels.get(i).setLeft(box);
       HBox Mrbox = new HBox();
       if(i == 0)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag0.png"));
       Mrbox.getChildren().addAll(selectUser0, selectComputer0); 
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 1)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag1.png"));
       Mrbox.getChildren().addAll(selectUser1, selectComputer1);
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 2)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag2.png"));
       Mrbox.getChildren().addAll(selectUser2, selectComputer2);
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 3)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag3.png"));
       Mrbox.getChildren().addAll(selectUser3, selectComputer3);
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 4)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag4.png"));
       Mrbox.getChildren().addAll(selectUser4, selectComputer4);
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 5)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag5.png"));
       Mrbox.getChildren().addAll(selectUser5, selectComputer5);
       playerPanels.get(i).setCenter(Mrbox);}
       
   }}
 
   
   public void initPanels(){
       p = new ArrayList<PathTransition>();
       s = new ArrayList<ScaleTransition>();
       parallelTransition = new ArrayList<ParallelTransition>();
       path = new ArrayList<PathTransition>();
       map1 = new Map(1);
       map2 = new Map(2);
       map3 = new Map(3);
       map4 = new Map(4);
        map1.setOnMouseClicked(mouseX->{
                   System.out.println("map's clicked coords are "+ mouseX.getX() + " " + mouseX.getY()); });
          map2.setOnMouseClicked(mouseX->{
                   System.out.println("map's clicked coords are "+ mouseX.getX() + " " + mouseX.getY()); });
          map3.setOnMouseClicked(mouseX->{
                   System.out.println("map's clicked coords are "+ mouseX.getX() + " " + mouseX.getY()); });
          map4.setOnMouseClicked(mouseX->{
                   System.out.println("map's clicked coords are "+ mouseX.getX() + " " + mouseX.getY()); });
         mapPanel = new GridPane();
             mapPanel.add(mapLabel1, 1,0);
             mapPanel.add(mapLabel2, 2, 0);
             mapPanel.add(mapLabel3, 0, 1);
             mapPanel.add(mapLabel4, 0, 2);
             mapPanel.add(mapB1, 1, 1);
            mapPanel.add(mapB2, 2,1);
             mapPanel.add(mapB3, 1,2);
            mapPanel.add(mapB4, 2,2);
       gamePanelRight = new VBox();
       gamePanelRight.getChildren().addAll(dieButton, saveButton, mapPanel);
       selectPlayersPanel = new GridPane();   
       northToolbar = new HBox();
       northToolbar.setStyle("-fx-background-color:lightgray");
        northToolbar.setAlignment(Pos.CENTER);
        northToolbar.setPadding(marginlessInsets);
        northToolbar.setSpacing(10.0);
        northToolbar.getChildren().addAll(gameButton, aboutButton, historyButton, quitButton);
        
       playerPanels = new ArrayList<BorderPane>();
       playerPanels.add(new BorderPane());
       playerPanels.add(new BorderPane());
       playerPanels.add(new BorderPane());
       playerPanels.add(new BorderPane());
       playerPanels.add(new BorderPane());
       playerPanels.add(new BorderPane());
       selectPlayersPanel = new GridPane();
        splashButtonBox = new VBox();
         splashPane = new StackPane();
        aboutPanel = new BorderPane();
        aboutPanel.setCenter(aboutLabel);
          gamePanel = new BorderPane();
          
          gamePanel.setPrefWidth(1000);
          gamePanel.setPrefHeight(600);
         //  gamePanel.setStyle("-fx-background-color: red;");
         // gamePanel.setStyle("-fx-background-image: url('" + "file:images/gameplay_AC14resized.jpg" + "'); -fx-max-width: 800; -fx-max-height: 600;");
        // gamePanel.getChildren().add(map1);
           gamePanel.setMaxSize(1000, 600);
        //   gamePanel.getChildren().addAll(map1, map2, map3, map4);
           gamePanel.setCenter(map1);
        // gamePanel.setTopAnchor(cities1.get(0), 200.0);
         // gamePanel.getChildren().add(cities1.get(0));  //add in City button
           for(int i = 0; i < cities1.size(); i++)
           { City NY = cities1.get(i);
               map1.getChildren().add(NY);
            NY.relocate(NY.getNewX(), NY.getNewY());
            NY.setOnMouseClicked(e ->{       //clicking on a city
                
           //   System.out.println("mouse coordinates (" + e.getX() + "," + e.getY() + ")");
              System.out.println(NY.getName() + "'s location is (" + NY.getNewX() + "," + NY.getNewY() + ")");
             makeDrag(NY);  
        if(currentPlayer.getMyCity() != null || currentPlayer.getMyCity() != null)      
         {if(currentPlayer.getMyCity().getSeaNeighbors().indexOf(NY) != -1 || currentPlayer.getMyCity().getLandNeighbors().indexOf(NY) != -1)  //check if NY is a neighbor
                    { moveToCity(currentPlayer, NY);
              }
            }} );

                    
            setNeighbors(NY, cities1);
            setCityEdges(NY, NY.getLandNeighbors(), NY.getSeaNeighbors());
                Circle circle = new Circle(3, Color.GREEN);
            NY.setShape(circle);
            NY.setPrefSize(1,1);
            NY.setStyle("-fx-background-color: Transparent; -fx-cursor:crosshair;");
           }
       for(int i = 0; i < cities2.size(); i++)
           { City NY = cities2.get(i);
               map2.getChildren().add(NY);
            NY.relocate(NY.getNewX(), NY.getNewY());
            NY.setOnMouseClicked(e ->{
        //      System.out.println("mouse coordinates (" + e.getX() + "," + e.getY() + ")");
              System.out.println(NY.getName() + "'s location is (" + NY.getX() + "," + NY.getY() + ")");

        if(currentPlayer.getMyCity() != null || currentPlayer.getMyCity() != null)      
         {if(currentPlayer.getMyCity().getSeaNeighbors().indexOf(NY) != -1 || currentPlayer.getMyCity().getLandNeighbors().indexOf(NY) != -1)  //check if NY is a neighbor
                    { moveToCity(currentPlayer, NY);
              }
            }} );
            makeDrag(NY);
            setNeighbors(NY, cities2);
            setCityEdges(NY, NY.getLandNeighbors(), NY.getSeaNeighbors());
                Circle circle = new Circle(3, Color.GREEN);
            NY.setShape(circle);
            NY.setPrefSize(1,1);
            NY.setStyle("-fx-background-color: Transparent; -fx-cursor:crosshair;");
           }
       for(int i = 0; i < cities3.size(); i++)
           { City NY = cities3.get(i);
               map3.getChildren().add(NY);
            NY.relocate(NY.getNewX(), NY.getNewY());
            NY.setOnMouseClicked(e ->{
       //       System.out.println("mouse coordinates (" + e.getX() + "," + e.getY() + ")");
              System.out.println(NY.getName() + "'s location is (" + NY.getX() + "," + NY.getY() + ")");

        if(currentPlayer.getMyCity() != null || currentPlayer.getMyCity() != null)      
         {if(currentPlayer.getMyCity().getSeaNeighbors().indexOf(NY) != -1 || currentPlayer.getMyCity().getLandNeighbors().indexOf(NY) != -1)  //check if NY is a neighbor
                    { moveToCity(currentPlayer, NY);
              }
            }} );
            makeDrag(NY);
            setNeighbors(NY, cities3);
            setCityEdges(NY, NY.getLandNeighbors(), NY.getSeaNeighbors());
                Circle circle = new Circle(3, Color.GREEN);
            NY.setShape(circle);
            NY.setPrefSize(1,1);
            NY.setStyle("-fx-background-color: Transparent; -fx-cursor:crosshair;");
           }
       for(int i = 0; i < cities4.size(); i++)
           { City NY = cities4.get(i);
               map4.getChildren().add(NY);
            NY.relocate(NY.getNewX(), NY.getNewY());
            NY.setOnMouseClicked(e ->{
          //    System.out.println("mouse coordinates (" + e.getX() + "," + e.getY() + ")");
              System.out.println(NY.getName() + "'s location is (" + NY.getX() + "," + NY.getY() + ")");

        if(currentPlayer.getMyCity() != null || currentPlayer.getMyCity() != null)      
         {if(currentPlayer.getMyCity().getSeaNeighbors().indexOf(NY) != -1 || currentPlayer.getMyCity().getLandNeighbors().indexOf(NY) != -1)  //check if NY is a neighbor
                    { moveToCity(currentPlayer, NY);
              }
            }} );
            makeDrag(NY);
            setNeighbors(NY, cities4);
            
            setCityEdges(NY, NY.getLandNeighbors(), NY.getSeaNeighbors());
                Circle circle = new Circle(3, Color.GREEN);
            NY.setShape(circle);
            NY.setPrefSize(1,1);
            NY.setStyle("-fx-background-color: Transparent; -fx-cursor:crosshair;");
           }
           
          //    gamePanel.setAlignment(cities1.get(0), Pos.TOP_RIGHT);
          //  cities1.get(0).setTranslateX(500);
           //cities1.get(0).setGraphic(new ImageView("file:images/flag_white.png"));
          //  cities1.get(1).setGraphic(new ImageView("file:images/flag_black.png"));
           
          historyPanel = new BorderPane();
          flightPanel = new BorderPane();
           
         TheBox = new VBox();
            }
   public void loadGamePanel(){
       mainPane.getChildren().clear();
      mainPane.setTop(northToolbar);
      mainPane.setRight(gamePanelRight);
       mainPane.setCenter(gamePanel);
   }
   public void initButtons(){
       endTurn = new Button("end Turn");
       endTurn.setOnAction(e -> {
        endTurn();

       });
       gameButton = new Button("Game");
       gameButton.setPrefSize(250, 50);
      //  gameButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
      // gameButton.setGraphic(new ImageView("file:images/Background - Light.png"));    
       gameButton.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 5px; -fx-font: italic bold 25px Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
       gameButton.setOnAction(e -> {
           mainPane.setStyle("");
        loadGamePanel();
       });
      splashButton = new Button("Splash");
      // splashButton.setStyle("-fx-background-color: lightblue; -fx-cursor: pointer;");
        splashButton.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
        splashButton.setMaxSize(250, 50);
       splashButton.setOnAction(e ->{
           mainPane.getChildren().clear();
           mainPane.setStyle("");
       initSplashScreen();
       });
       historyButton = new Button("History");
       historyButton.setPrefSize(250, 50);
      // historyButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
       // historyButton.setGraphic(new ImageView("file:images/115.png"));
       historyButton.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 5px; -fx-font: italic bold 25px Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
       historyButton.setOnAction(e ->{
           String s = "";
           String p = "";
         if(numPlayers != 0)
         { if(players.get(0) != null)
         {  for(int i = 0; i < numPlayers; i++)
           {  s = s + "Player " + (i+1) + " history: \n";
             if(players.get(i) != null)
             {  for(int j = 0; j < players.get(i).getHistory().size(); j++)
               { p = players.get(i).getHistory().get(j) + ", "; 
                if(j % 5 == 0)
                    p = p + "\n";}}
            s = s + p + "\n";
           }}}  aboutLabel = new Label(s);
           aboutLabel.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 5px; -fx-font: italic bold 25px Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
           historyPanel.setCenter(aboutLabel);
             mainPane.getChildren().clear();
             mainPane.setTop(northToolbar);
             mainPane.setCenter(historyPanel);
             mainPane.setStyle("-fx-background-image: url('" + "file:images/brown-vintage-background-18641-19113-hd-wallpapers.jpg" + "'); -fx-max-width: 1300; -fx-max-height: 700;");
   });
         selectUser0 = new Button("User"); 
         selectUser1 = new Button("User");
         selectUser2 = new Button("User");
         selectUser3 = new Button("User");
         selectUser4 = new Button("User");
         selectUser5 = new Button("User");
          selectComputer0 = new Button("Computer"); 
          selectComputer0.setStyle("-fx-background-color: red;");
          selectComputer1 = new Button("Computer"); 
          selectComputer1.setStyle("-fx-background-color: red;");
          selectComputer2 = new Button("Computer"); 
          selectComputer2.setStyle("-fx-background-color: red;");
          selectComputer3 = new Button("Computer"); 
          selectComputer3.setStyle("-fx-background-color: red;");
          selectComputer4 = new Button("Computer"); 
          selectComputer4.setStyle("-fx-background-color: red;");
          selectComputer5 = new Button("Computer"); 
          selectComputer5.setStyle("-fx-background-color: red;");

          selectUser0.setOnAction(e ->{
           playerType.set(0, "User");
           selectUser0.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectComputer0.setStyle("");
          });
          selectUser1.setOnAction(e ->{
           playerType.set(1, "User");
           selectUser1.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectComputer1.setStyle("");
          });
          selectUser2.setOnAction(e ->{
           playerType.set(2, "User");
           selectUser2.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectComputer2.setStyle("");
          });
          selectUser3.setOnAction(e ->{
           playerType.set(3, "User");
           selectUser3.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectComputer3.setStyle("");
          });        
          selectUser4.setOnAction(e ->{
           playerType.set(4, "User");
           selectUser4.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectComputer4.setStyle("");
          });
          selectUser5.setOnAction(e ->{
           playerType.set(5, "User");
           selectUser5.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectComputer5.setStyle("");
          });
          selectComputer0.setOnAction(e ->{
           playerType.set(0, "Computer");
           selectComputer0.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectUser0.setStyle("");
          });
          selectComputer1.setOnAction(e ->{
           playerType.set(1, "Computer");
           selectComputer1.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectUser1.setStyle("");
          });
          selectComputer2.setOnAction(e ->{
           playerType.set(2, "Computer");
           selectComputer2.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectUser2.setStyle("");
          });
          selectComputer3.setOnAction(e ->{
           playerType.set(3, "Computer");
           selectComputer3.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectUser3.setStyle("");
          });
          selectComputer4.setOnAction(e ->{
           playerType.set(4, "Computer");
           selectComputer4.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectUser4.setStyle("");
          });
          selectComputer5.setOnAction(e ->{
           playerType.set(5, "Computer");
           selectComputer5.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
           selectUser5.setStyle("");
          });
                      
       GO = new Button("Go!");
      //  GO.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
      // GO.setGraphic(new ImageView("file:images/images (1).jpg"));  
       GO.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-background-color: red; -fx-text-fill: black;");
       GO.setOnAction(e -> {      
           if(numPlayers != 0)
           { mainPane.setStyle("");
              for(int i = 0; i < numPlayers; i++)
         { 
             Player play = new Player(playerNames.get(i), i, playerType.get(i));
             players.add(play);
             
             
            final Delta dragDelta = new Delta();
       /*    play.setOnMousePressed(new EventHandler<MouseEvent>() {      //set ragging
             @Override public void handle(MouseEvent mouseEvent) {
               // record a delta distance for the drag and drop operation.
               dragDelta.x = play.getLayoutX() - mouseEvent.getSceneX();
               dragDelta.y = play.getLayoutY() - mouseEvent.getSceneY();
               play.setCursor(Cursor.MOVE);
             }
           });
        */   play.setOnDragDetected(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        dragged = false;
        Dragboard db = play.startDragAndDrop(TransferMode.ANY);
        
        /* Put a string on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putImage(play.getImage());
        db.setContent(content);
        
        event.consume();
    }
});
        play.setOnMouseReleased(extra->{
            if(dragged = false)            //relocate if dragged not on city
                { currentPlayer.relocate(currentPlayer.getMyCity().getNewX(), currentPlayer.getMyCity().getNewY());}
        });
   /*        play.setOnMouseReleased(new EventHandler<MouseEvent>() {
             @Override public void handle(MouseEvent mousey) {
               play.setCursor(Cursor.HAND);  //come added *2 *3 2x
               System.out.println("released on "+(mousey.getX()-213) +"  "+(mousey.getY()-93));
              
               flag = 0;
               System.out.println("size of land neighbors is " + play.getMyCity().getLandNeighbors().size());
               for(int z = 0; z<play.getMyCity().getLandNeighbors().size(); z++)   //search Player's city's neighbors from before drag 
                 { //come add if play == currentPlayer
                   City n = play.getMyCity().getLandNeighbors().get(z);
                    System.out.println("city coors are : " + n.getName() +"  "+n.getNewX()+" "+n.getNewY());
                 //  System.out.println("comparison is "+Math.sqrt(Math.pow(mousey.getX()+30-n.getX(), 2) + Math.pow(mousey.getY()+30-n.getY(), 2)));
   
                   
                   if(Math.sqrt(Math.pow(mousey.getX()-n.getNewX(), 2) + Math.pow(mousey.getY()-n.getNewY(), 2)) <= 100 && Math.sqrt(Math.pow(mousey.getX()-n.getNewX(), 2) + Math.pow(mousey.getY()-n.getNewY(), 2)) >= -100)
                    { System.out.println("compared is good   move" + play.getName()+" to "+n.getName());
                        play.relocate(play.getMyCity().getX(), play.getMyCity().getY());
                        moveToCity(play, n);
                   //  play.relocate(n.getNewX(), n.getNewY());
                   //  play.setX(n.getNewX());
                   //  play.setY(n.getNewX());
                      flag = 1;
                    break;
                    }              
               }
               for(int z = 0; z<play.getMyCity().getSeaNeighbors().size(); z++)   //search Player's city's neighbors from before drag 
                 { City n = play.getMyCity().getSeaNeighbors().get(z);
                   System.out.println("comparison is "+Math.sqrt(Math.pow(mousey.getX()-n.getX(), 2) + Math.pow(mousey.getY()-n.getY(), 2)));
                   if(Math.sqrt(Math.pow(mousey.getX()-n.getNewX(), 2) + Math.pow(mousey.getY()-n.getNewY(), 2)) <= 100 && Math.sqrt(Math.pow(mousey.getX()-n.getNewX(), 2) + Math.pow(mousey.getY()-n.getNewY(), 2)) >= -100)
                    { System.out.println("compared is good   move" + play.getName()+" to "+n.getName());
                        moveToCity(play, n);
                    // play.relocate(n.getNewX(), n.getNewY());
                    // play.setX(n.getNewX());
                    // play.setY(n.getNewX());
                      flag = 1;
                    break;
                    }              
               }
               if(flag == 0)
                { play.relocate(play.getMyCity().getNewX(), play.getMyCity().getNewY()); }
                
             }
           });
         
       /*  play.setOnMouseDragged(new EventHandler<MouseEvent>() {
             @Override public void handle(MouseEvent mouseEvent) {
               play.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
               play.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
             }
           });
           play.setOnMouseEntered(new EventHandler<MouseEvent>() {
             @Override public void handle(MouseEvent mouseEvent) {
               play.setCursor(Cursor.HAND);
             }
           });               
        */ }   mainPane.getChildren().clear();
             mainPane.setCenter(gamePanel);
             mainPane.setTop(northToolbar);
             mainPane.setRight(gamePanelRight);
          Button Start = new Button("Start");
           Start.setOnAction(ex -> {
             gamePanelRight.getChildren().remove(Start);
            dealCards(); 
           });
           gamePanelRight.getChildren().add(Start);
           currentPlayer = players.get(0);
       } }); 
        
      
       OK = new Button("OK");
       OK.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 5px; -fx-font: italic bold 25px Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
       startGameButton = new Button("Start");
      // startGameButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
      startGameButton.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 5px; -fx-font: italic bold 25px Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
      // startGameButton.setGraphic(new ImageView("file:images/white-background-gold-button-md.png"));              
       startGameButton.setPrefSize(250, 50);
        loadGameButton = new Button("Load");
       // loadGameButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
      //  loadGameButton.setGraphic(new ImageView("file:images/greenb.png"));
        loadGameButton.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 5px; -fx-font: italic bold 25px Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
        loadGameButton.setPrefSize(250, 50);
        loadGameButton.setOnAction(e -> {
         if(dataManager.hasSave() == true)
         { players = dataManager.loadPlayers();
          map1 = dataManager.loadMaps().get(0);
          map2 = dataManager.loadMaps().get(1);
          map3 = dataManager.loadMaps().get(2);
          map4 = dataManager.loadMaps().get(3);
          
         
         }
        });
        aboutButton = new Button("About");
      //  aboutButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
        // aboutButton.setGraphic(new ImageView("file:images/500px-HILLBLU_button_background.svg.png"));
        aboutButton.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 5px; -fx-font: italic bold 25px Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
        aboutButton.setPrefSize(250, 50);
        aboutButton.setOnAction(e -> {        
          mainPane.getChildren().clear();
          mainPane.setTop(northToolbar);
          mainPane.setCenter(aboutPanel);
          mainPane.setStyle("-fx-background-image: url('" + "file:images/brown-vintage-background-18641-19113-hd-wallpapers.jpg" + "'); -fx-max-width: 1300; -fx-max-height: 700;");
        });
        aboutButton.setPrefSize(250, 50);
        quitButton = new Button("Quit");
       // quitButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
        //quitButton.setGraphic(new ImageView("file:images/redb.png"));
        quitButton.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 5px; -fx-font: italic bold 25px Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
        quitButton.setPrefSize(250, 50);
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {			
				System.exit(0);	}});
    num2P = new Button("2");
    num2P.setPrefSize(30, 30);
    num3P = new Button("3");
    num3P.setPrefSize(30, 30);
    num4P = new Button("4");
    num4P.setPrefSize(30, 30);
    num5P = new Button("5");
    num5P.setPrefSize(30, 30);
    num6P = new Button("6");
    num6P.setPrefSize(30, 30);
    num2P.setOnAction(e ->{
        numPlayers = 2;  
    num2P.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
    // num2P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num3P.setStyle(""); num4P.setStyle(""); num5P.setStyle(""); num6P.setStyle("");
          addPlayerPanels(2);   });
    num3P.setOnAction(e ->{
        numPlayers = 3; num3P.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
        //num3P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num2P.setStyle(""); num4P.setStyle(""); num5P.setStyle(""); num6P.setStyle("");
          addPlayerPanels(3);   });
    num4P.setOnAction(e ->{
        numPlayers = 4;  num4P.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
        //num4P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num2P.setStyle(""); num3P.setStyle(""); num5P.setStyle(""); num6P.setStyle("");
          addPlayerPanels(4);   });
    num5P.setOnAction(e ->{
        numPlayers = 5;num5P.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
        //num5P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num2P.setStyle(""); num3P.setStyle(""); num4P.setStyle(""); num6P.setStyle("");
          addPlayerPanels(5);   });
    num6P.setOnAction(e ->{
        numPlayers = 6; num6P.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
        //num6P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num3P.setStyle(""); num4P.setStyle(""); num5P.setStyle(""); num2P.setStyle("");
          addPlayerPanels(6);   });
    mapB1 = new Button();
    mapB1.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-background-color: orange; -fx-text-fill: black;");
    mapB1.setOnAction(e->{
      gamePanel.setCenter(map1);
    });
    mapB2 = new Button();
       mapB2.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-background-color: yellow; -fx-text-fill: black;");
        mapB2.setOnAction(e->{
      gamePanel.setCenter(map2);
        });
    mapB3 = new Button();
        mapB3.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-background-color: green; -fx-text-fill: black;");
         mapB3.setOnAction(e->{
      gamePanel.setCenter(map3);
            });
    mapB4 = new Button();
        mapB4.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-background-color: purple; -fx-text-fill: black;");
         mapB4.setOnAction(e->{
        gamePanel.setCenter(map4);
        });
   saveButton = new Button();
        saveButton.setGraphic(new ImageView("file:images/save-button-md.png"));
    closeButton = new Button();
    flightButton = new Button();
    map1Button = new Button();
    map2Button = new Button();
   map3Button = new Button();
    map4Button = new Button();
   dieButton = new Button();
       ImageView view = new ImageView("file:images/die_1.jpg");
        dieButton.setGraphic(view);
    returnButton = new Button();
   }
   
   public void initLabels(){    
    playerName = new Label("Player");
    mapLabel1 = new Label("A-C");
    mapLabel2 = new Label("D-F");
    mapLabel3 = new Label("1-4");
    mapLabel4 = new Label("5-8");
    selectNumPlayers = new Label("Select Number of players:  ");
    selectNumPlayers.setPrefHeight(30);
    selectNumPlayers.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
    nameLabel = new Label("  Name:  ");
    nameLabel.setMaxHeight(25);
    nameLabel.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
     winLabel = new Label("You win!");
     winLabel.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
     loseLabel = new Label("You lose!");
     loseLabel.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
    aboutLabel = new Label("Journey through Europe is a family board game published by Ravensburger. The board is a map of Europe with various major cities marked, for example, Athens, Amsterdam and London. \n The players are given a home city from which they will begin and are then dealt a number of cards with various other cities on them. \n They must plan a route between each of the cities in their hand of cards. On each turn they throw a die and move between the cities. \n The winner is the first player to visit each of their cities and then return to their home base.");
   aboutLabel.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 1px; -fx-font: italic bold Bauhaus, serif; -fx-padding: 10; -fx-background-color: brown; -fx-text-fill: yellow;");
   }
  
   public void initValues(){
       dragged = false;
       pCount = 0;
       round = 0;
       pathCount = 0;
       edges = new ArrayList(){};
       playerTurn = 0;
       currentPlayerPoints = 1;  //set to 1 so moveToCity functions when setting initally players
       file = new FileLoader();
       allCards = file.getCards();
       cardsDealt = new ArrayList<Card>();
       cities1 = file.getCities1();
       cities2 = file.getCities2();
       cities3 = file.getCities3();
       cities4 = file.getCities4();
       
        paneWidth = 1300;
        paneHeight = 700;
        playerNames = new ArrayList<TextField>();
        playerNames.add(new TextField("Player 1"));  playerNames.add(new TextField("Player 2")); playerNames.add(new TextField("Player 3")); playerNames.add(new TextField("Player 4"));playerNames.add(new TextField("Player 5")); playerNames.add(new TextField("Player 6"));
        players = new ArrayList<Player>();
       playerType = new ArrayList<String>();
       playerType.add("Computer"); playerType.add("Computer");playerType.add("Computer");playerType.add("Computer"); playerType.add("Computer"); playerType.add("Computer");
        }

   public void saveMap(){}
   public void savePlayers(){}
   public int throwDie(){
       int xs = (int) (Math.random() * 5 + 1);
    //   System.out.println("Die rolled "+ xs);
    ImageView view = new ImageView("file:images/die_1.jpg");
    if(xs == 1)
            view = new ImageView("file:images/die_1.jpg");
    else if(xs == 2)
            view = new ImageView("file:images/die_2.jpg");
    else if(xs == 3)
            view = new ImageView("file:images/die_3.jpg");
    else if(xs == 4)
            view = new ImageView("file:images/die_4.jpg");
    else if(xs == 5)
            view = new ImageView("file:images/die_5.jpg");
    else
            view = new ImageView("file:images/die_6.jpg");
        dieButton.setGraphic(view);
        return xs;
   }
   public void quit(){}
   public void changePanel(String x){}
   public void save(){}
   public void load(){}
   public void loadCards(Player p){}
   public void flyToCity(Player p, City NY){}
   public void moveToCity(Player p, City NY)
    {     
       
         if(currentPlayerPoints != 0 && p.getMyCity().getRegion() == NY.getRegion())  //check if points and NY is possible city
        {   if(round != 0)
            {     if(p.getPrevCity() != null)
                    {if (NY == currentPlayer.getPrevCity())
                        { p.relocate(p.getMyCity().getNewX(), p.getMyCity().getNewY());  return;} }
            
                  for(int g = 0; g<edges.size(); g++)   //reset all edges to black
                    {  edges.get(g).setStroke(Color.BLACK);
                       edges.get(g).setStroke(Color.BLACK);
                    }
            }

            for(int g = 0; g<NY.getEdges().size(); g++)  //fill in neighbors of current city with red
                {  NY.getEdges().get(g).setStroke(Color.RED);
                  NY.getEdges().get(g).setFill(Color.RED);
                }   
            if(p.getMyCity() != null)   //remove edge to previous city   come for special case where only previous city is only edge
                {   if(p.getMyCity().getLandNeighbors().size() + p.getMyCity().getSeaNeighbors().size() != 1 )
                    {  for(int g = 0; g<p.getMyCity().getEdges().size(); g++)
                            {  p.getMyCity().getEdges().get(g).setStroke(Color.BLACK);
                               p.getMyCity().getEdges().get(g).setStroke(Color.BLACK);                       
                            } 
                    }          
                }
            
            
             System.out.println(p.getName() + " placed at " + NY.getName());
             
             
              Line line = new Line(p.getX(), p.getY(), NY.getNewX(), NY.getNewY());
            if(round != 0)
            { p.setPrevCity(p.getMyCity());  }
            p.setMyCity(NY);
            p.setX(NY.getNewX());
            p.setY(NY.getNewY());
            PathTransition path = new PathTransition(Duration.millis(1000), line, p);
            if(round == 0)
                { path = new PathTransition(Duration.millis(3000), line, p);
                    path.setDelay(Duration.millis(2000)); }
            path.play();
     //  p.relocate(NY.getNewX(), NY.getNewY());
         if(round > 0)
            { currentPlayerPoints--;//come
            Card goldCard = allCards.get(NY.getNum() );   //get the card coresponding to the city
            System.out.println(""+ goldCard.getName() +" is cardName  city is " + NY.getName());
            if(p.getCards().indexOf(goldCard) != -1)    //player reaches a city for which he holds a card
                { if(goldCard.getName().equals(p.getHomeCity().getName()) && p.getCards().size() == 1)    //at home and only home card left
                    {   System.out.println("Someone is a winner!");          //winnerrrrrrrrrrrrrrrrrrrrrrrrrrr come
                         if(p.getIsUser() == true)   
                            {gamePanel.setCenter(winLabel);}  //record data?
                         else
                           { gamePanel.setCenter(loseLabel); }
                         gamePanel.setLeft(splashButton);
                    }
                 gamePanel.getChildren().remove(goldCard);
                  p.getCards().remove(goldCard);
                  cardsDealt.remove(goldCard);
                  System.out.println(goldCard.getName() + " removed");
                    endTurn();}
            
            if(currentPlayerPoints == 0)   //if 0 points
                  { currentPlayer.relocate(currentPlayer.getMyCity().getNewX(), currentPlayer.getMyCity().getNewY());
                    endTurn();  }                           
             
            }  
         }    
    }    
      
   public void setCityEdges(City NY, ArrayList<City> l, ArrayList<City> s)
   {  if(l != null)
        { 
            for(int z = 0; z < l.size(); z++)
            {  if(NY.getHaveEdgeTo().indexOf(l.get(z)) == -1)    //if edge is not already there
              { Line bladeEdge = new Line(NY.getNewX(), NY.getNewY(), l.get(z).getNewX(), l.get(z).getNewY());
                bladeEdge.setFill(Color.BLACK);
                bladeEdge.setStrokeWidth(5);
                bladeEdge.setStroke(Color.BLACK);
                
                NY.getHaveEdgeTo().add(l.get(z));   //add in to not overlap
                l.get(z).getHaveEdgeTo().add(NY);
                
                NY.getEdges().add(bladeEdge);
                l.get(z).getEdges().add(bladeEdge);
                
                edges.add(bladeEdge);
                
                if(NY.getRegion() == 1)
                map1.getChildren().add(bladeEdge);
                if(NY.getRegion() == 2)
                map2.getChildren().add(bladeEdge);
                if(NY.getRegion() == 3)
                map3.getChildren().add(bladeEdge);
                if(NY.getRegion() == 4)
                map4.getChildren().add(bladeEdge);
            }  }
        }
        if(s != null)
        { 
            for(int z = 0; z < s.size(); z++)
            {  if(NY.getHaveEdgeTo().indexOf(s.get(z)) == -1)    //if edge is not already there
              { Line bladeEdge = new Line(NY.getNewX(), NY.getNewY(), s.get(z).getNewX(), s.get(z).getNewY());
                bladeEdge.setFill(Color.BLACK);
                bladeEdge.setStrokeWidth(5);
                bladeEdge.setStroke(Color.BLACK);
                
                NY.getHaveEdgeTo().add(s.get(z));   //add in to not overlap
                s.get(z).getHaveEdgeTo().add(NY);
                
                NY.getEdges().add(bladeEdge);
                s.get(z).getEdges().add(bladeEdge);
                
                edges.add(bladeEdge);
                
                if(NY.getRegion() == 1)
                map1.getChildren().add(bladeEdge);
                if(NY.getRegion() == 2)
                map2.getChildren().add(bladeEdge);
                if(NY.getRegion() == 3)
                map3.getChildren().add(bladeEdge);
                if(NY.getRegion() == 4)
                map4.getChildren().add(bladeEdge);
            }  }
        }   
   }       

   public void selectPlayerNum(int x){}
   public boolean checkNeighbor(City NY){return false;}
   public boolean checkIfWinner(Player p){return false;}
   public void repaint(Map m, int[][] x){}
   public void won(){}
   public void lost(){}
   public void endTurn()
   {  playerTurn++;  
       round++;
       if(playerTurn % numPlayers == 0)  //if reached end of player list, go back
         { playerTurn = 0; }
        currentPlayer= players.get(playerTurn);
        System.out.println(""+currentPlayer.getName() +"'s turn,  round " + round);
        currentPlayerPoints = throwDie();
        while(currentPlayerPoints % 6 == 0)   //if rolled 6, roll again for more points
            { currentPlayerPoints += throwDie();
        }
        
        int r = currentPlayer.getMyCity().getRegion();
        if(r == 1)
        { gamePanel.setCenter(map1);
        }
        if(r == 2)
        { gamePanel.setCenter(map2);
        }
        if(r == 3)
        { gamePanel.setCenter(map3);
        }
        if(r == 4)
        { gamePanel.setCenter(map4);
        }
        for(int g = 0; g<edges.size(); g++)   //reset all edges to black
                    {  edges.get(g).setStroke(Color.BLACK);
                       edges.get(g).setStroke(Color.BLACK);
                    }        
        
      //  System.out.println("size of edges is "+currentPlayer.getMyCity().getEdges().size());
        for(int g = 0; g<currentPlayer.getMyCity().getEdges().size(); g++)  //fill in city neighbors red
                {  currentPlayer.getMyCity().getEdges().get(g).setStroke(Color.RED);
                   currentPlayer.getMyCity().getEdges().get(g).setFill(Color.RED);
                } 
        if(currentPlayer.getPrevCity() != null || (currentPlayer.getMyCity().getLandNeighbors().size() + currentPlayer.getMyCity().getLandNeighbors().size() == 1))   //remove edge to previous city
                {   
                      for(int g = 0; g<currentPlayer.getPrevCity().getEdges().size(); g++)
                        {  currentPlayer.getPrevCity().getEdges().get(g).setStroke(Color.BLACK);
                           currentPlayer.getPrevCity().getEdges().get(g).setStroke(Color.BLACK);
                        }
                }
   }       
   public void dealCards()
    {  int x = 0;
    int q = 0;
        Card c;
        Line line;
        ImageView home;           
          gamePanelRight.getChildren().add(endTurn);
        SequentialTransition sequentialTransition = new SequentialTransition();
        ArrayList<String[]> color = new ArrayList<String[]>();
        color.add(new String[] {"red", "green", "yellow"});
        color.add(new String[] {"green", "yellow", "red"});
        color.add(new String[] {"yellow", "red", "green"});
        color.add(new String[] {"red", "green", "yellow"});
        color.add(new String[] {"green", "yellow", "red"});
        color.add(new String[] {"yellow", "red", "green"});
        
        for(int o = 0; o<numPlayers; o++)
        { sequentialTransition = new SequentialTransition();
         System.out.println(" " + players.get(o).getName());
          int colorCount = -1;
            for(int i = 0; i < 3; i++)
        {  x = (int) (Math.random() * 180);
           c = allCards.get(x);          
           colorCount++;
           if(colorCount == 3)
            {  colorCount = 0;}
           String co = color.get(o)[colorCount];
           if(!(c.getColor().equals(co)))
            {  colorCount--; i--;  continue; }           //redo if incorrect color
           if(cardsDealt.indexOf(c) == -1)//if not in cardsDealt
            { players.get(o).addCard(c);   //give player the card
             cardsDealt.add(c);
             System.out.println("added card " + c.getName()+" with " + c.getColor() + " to "+ players.get(o).getName() );
            
             
            Line liner = new Line(550+10*q, 100+10*q, 0, 90+q*30);
           // line = new Line(30, 60+i*20+o*20, -50,110+50*(i+1)+o*60);
            q++;
            PathTransition p1 = new PathTransition();
            ScaleTransition s1 = new ScaleTransition(Duration .millis(1000), c);
            ParallelTransition parallelTransition = new ParallelTransition();
            ParallelTransition par = new ParallelTransition();
            
          par.getChildren().addAll(s1, p1);
          par.setDelay(Duration.millis(300));                     
            p1.setDuration(Duration.millis(1000));
            p1.setPath(liner);
            p1.setDelay(Duration.millis(1000));
            p1.setNode(c);
            c.setScaleX(.6);
            c.setScaleY(.3);
            s1.setFromX(.4);
            s1.setFromY(.4);
            s1.setToX(.4);
            s1.setToY(.3);
            sequentialTransition.getChildren().add(par);
        
            if(i == 0)     //first player and first card
            {   colorCard(c, o);
                home = new ImageView("file:images/flag" + o + ".png");
                home.setScaleX(.3);
                home.setScaleY(.3);
                City cc;
                if(c.getRegion() == 1)  
                { 
                map1.getChildren().addAll(players.get(o), home); 
                gamePanel.setCenter(map1);
                cc = findCity(c.getName(), cities1);                           
                }
                else if(c.getRegion() == 2)  
                {map2.getChildren().addAll(players.get(o), home); 
                gamePanel.setCenter(map2);
                cc = findCity(c.getName(), cities2);
                }
                else if(c.getRegion() == 3)  
                {map3.getChildren().addAll(players.get(o), home); 
                gamePanel.setCenter(map3);
                 cc = findCity(c.getName(), cities3);
               
                }
                else  
                {map4.getChildren().addAll(players.get(o), home); 
                gamePanel.setCenter(map4);
                cc = findCity(c.getName(), cities4);
                
                }         
                
                 System.out.println("moving "+players.get(o).getName()+" to "+cc.getNewX() +"  "+cc.getNewY() );
                players.get(o).setMyCity(cc);
                players.get(o).setHomeCity(cc);
                moveToCity(players.get(o), cc);    //move player to first city               
                home.relocate(cc.getNewX()-85, cc.getNewY()-110);
                
              //  players.get(o).relocate(cc.getNewX()-85, cc.getNewY()-110);
                
                 
      /*          for(int k = 0; k < path.size()-1; k++)
                { path.get(0).setOnFinished(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
       path.get(1).play();
    } 
}); }
     */       }
            
           }
           
           else
           {   colorCount--; i--; continue;   //this redoes the loop till non-dealt card is added
           }    
           gamePanel.getChildren().add(c);    //add in cards to pane
        }
                      sequentialTransition.setOnFinished((ActionEvent e)->  {
               gamePanel.setCenter(getMap(players.get(pCount).getMyCity().getRegion()));
               pCount++;
            });
        sequentialTransition.setDelay(Duration.millis(2000));   
        map1.setOpacity(.2);
        map2.setOpacity(.2);
        map3.setOpacity(.2);
        map4.setOpacity(.2);
        sequentialTransition.play();
        sequentialTransition.setOnFinished(e->{
         map1.setOpacity(1);  
         map2.setOpacity(1);
         map3.setOpacity(1);
         map4.setOpacity(1);
        });
        }
         
            playerTurn--;
             endTurn();
    }      
   public void colorCard(Card c, int num)
   {  c.setStyle("-fx-padding: 10; -fx-background-color: firebrick; -fx-background-radius: 5;");
       if(num == 0)
        { c.setEffect(new DropShadow(50, Color.BLACK)); }
       else if(num == 1)
        { c.setEffect(new DropShadow(50, Color.BLUE)); }
       else if(num == 2)
        { c.setEffect(new DropShadow(50, Color.GREEN)); }
        else if(num == 3)
        { c.setEffect(new DropShadow(50, Color.RED)); }
          else if(num == 4)
        { c.setEffect(new DropShadow(50, Color.WHITE)); }
        else if(num == 5)
        { c.setEffect(new DropShadow(50, Color.YELLOW)); }
   }
   public City findCity(String n, ArrayList<City> ct)
   {  for(int z = 0; z < ct.size(); z++)
        {  if(ct.get(z).getName().equals(n))
                {return ct.get(z);}
        }
       return null; 
   }
    class Delta {
        double x, y;
    }

   public void setNeighbors(City NY, ArrayList<City> c)
     { String[] lands = NY.getLand();  //get names of land neighbors
       String[] seas = NY.getSea();
       ArrayList<City> landN = new ArrayList<City>();
       ArrayList<City> seaN = new ArrayList<City>();
       for(int omg = 0; omg < c.size(); omg++)
        {  for(int qq = 0; qq < lands.length; qq++)
            { if(c.get(omg).getName().equals(lands[qq]))
            { landN.add(c.get(omg));}
            }
            for(int ss = 0; ss < seas.length; ss++)
            { if(c.get(omg).getName().equals(seas[ss]))
            {seaN.add(c.get(omg));}
            }
        }

      NY.setLandNeighbors(landN);
      NY.setSeaNeighbors(seaN);
     }    

    public Map getMap(int reg)
           {  if(reg == 1)
                { return map1;}
              else if(reg == 2)
                { return map2;}
             else if(reg == 3)
                { return map3;}
             else
                { return map4;}
           }   
    public void makeDrag(City NY)
        {                 
        NY.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                  currentPlayer.relocate(currentPlayer.getMyCity().getNewX(), currentPlayer.getMyCity().getNewY());  
               /* data is dragged over the target */
               /* accept it only if it is not dragged from the same node 
                * and if it has a string data */
               City cx = (City) event.getSource();
               if (event.getGestureSource() != cx &&
                       event.getDragboard().hasImage()) {  
                   /* allow for both copying and moving, whatever user chooses */
                   event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
               }

               event.consume();
              // System.out.println("Dragged Over "+cx.getName());
           }
});
            
    NY.setOnDragDropped(new EventHandler<DragEvent>() {
    public void handle(DragEvent event) {
        currentPlayer.relocate(currentPlayer.getMyCity().getNewX(), currentPlayer.getMyCity().getNewY());
        /* data dropped */
        /* if there is a string data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        City cx = (City) event.getSource();
       // System.out.println("DragDropped on "+cx.getName());
        if (db.hasImage()) { 
            
            currentPlayer.relocate(currentPlayer.getMyCity().getNewX(), currentPlayer.getMyCity().getNewY());
           for(int z = 0; z<currentPlayer.getMyCity().getLandNeighbors().size();z++ )
           { if(currentPlayer.getMyCity().getLandNeighbors().get(z) == NY && (currentPlayer.getMyCity().getLandNeighbors().get(z) != currentPlayer.getPrevCity() || currentPlayer.getMyCity().getLandNeighbors().size() == 1) )  //come if last condition is supposed to be (currentPlayer.getMyCity().getLandNeighbors().size() + currentPlayer.getMyCity().getLandNeighbors().size() == 1)
              { 
                     currentPlayer.relocate(currentPlayer.getMyCity().getNewX(), currentPlayer.getMyCity().getNewY());
                    moveToCity(currentPlayer, cx);  success = true; 
                    dragged = true;
                    break;
              }
            }
           for(int z = 0; z<currentPlayer.getMyCity().getSeaNeighbors().size();z++ )
           { if(currentPlayer.getMyCity().getSeaNeighbors().get(z) == NY && (currentPlayer.getMyCity().getSeaNeighbors().get(z) != currentPlayer.getPrevCity() || currentPlayer.getMyCity().getSeaNeighbors().size() == 1)) //come same
              { 
                     currentPlayer.relocate(currentPlayer.getMyCity().getNewX(), currentPlayer.getMyCity().getNewY());
                    moveToCity(currentPlayer, cx);  success = true; 
                    dragged = true;
                    break;
              }
            }
           if(success == false)   //city is not a neighbor
            {   currentPlayer.relocate(currentPlayer.getMyCity().getNewX(), currentPlayer.getMyCity().getNewY());
            }
       
           
           
          
        }
        /* let the source know whether the string was successfully 
         * transferred and used */
        event.setDropCompleted(success);
        
        event.consume();
     }
});
        }      
}
