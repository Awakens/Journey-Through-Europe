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
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Antony Kwok
 */
public class JTEUI extends Pane{
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
   VBox gamePanelRight, gamePanelLeft;
   StackPane cardStack;
   BorderPane historyPanel;
   BorderPane flightPanel;
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
   ArrayList<String> move;
   Button dieButton;
   Button returnButton;
   ArrayList<Player> players;
   FileLoader file;
   ArrayList<City> cities1;
   ArrayList<City> cities2;
   ArrayList<City> cities3;
   ArrayList<City> cities4;
   HashMap<String, City>  citiesHash;
   Insets marginlessInsets;
   ArrayList<BorderPane> playerPanels; 
   ArrayList<String> playerType;
   private HBox northToolbar;
   

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
    
    public void startUI()
    { mainPane = new BorderPane();
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
               load();});
            aboutButton.setOnAction(e -> {
                boolean xd = false;
                if(mainPane.getCenter() == splashPane)
                    xd = true;
                mainPane.getChildren().clear();   
                 mainPane.setCenter(aboutPanel);
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
       {playerPanels.get(i).setTop(new ImageView("file:images/flag_black.png"));
       Mrbox.getChildren().addAll(selectUser0, selectComputer0); 
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 1)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag_blue.png"));
       Mrbox.getChildren().addAll(selectUser1, selectComputer1);
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 2)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag_green.png"));
       Mrbox.getChildren().addAll(selectUser2, selectComputer2);
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 3)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag_red.png"));
       Mrbox.getChildren().addAll(selectUser3, selectComputer3);
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 4)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag_white.png"));
       Mrbox.getChildren().addAll(selectUser4, selectComputer4);
       playerPanels.get(i).setCenter(Mrbox);}
       if(i == 5)
       {playerPanels.get(i).setTop(new ImageView("file:images/flag_yellow.png"));
       Mrbox.getChildren().addAll(selectUser5, selectComputer5);
       playerPanels.get(i).setCenter(Mrbox);}
       
   }}
 
   
   public void initPanels(){
       map1 = new Map(1);
       map2 = new Map(2);
       map3 = new Map(3);
       map4 = new Map(4);
       gamePanelLeft = new VBox();
       cardStack = new StackPane();
       gamePanelLeft.getChildren().addAll(cardStack);
       gamePanelRight = new VBox();
       gamePanelRight.getChildren().addAll(dieButton, saveButton);
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
          
          gamePanel.setPrefWidth(800);
          gamePanel.setPrefHeight(600);
           gamePanel.setStyle("-fx-background-color: red;");
         // gamePanel.setStyle("-fx-background-image: url('" + "file:images/gameplay_AC14resized.jpg" + "'); -fx-max-width: 800; -fx-max-height: 600;");
        // gamePanel.getChildren().add(map1);
           gamePanel.setMaxSize(800, 600);
        //   gamePanel.getChildren().addAll(map1, map2, map3, map4);
           gamePanel.setCenter(map1);
        // gamePanel.setTopAnchor(cities1.get(0), 200.0);
         // gamePanel.getChildren().add(cities1.get(0));  //add in City button
           for(int i = 0; i < cities1.size(); i++)
           { City NY = cities1.get(i);
               map1.getChildren().add(NY);
            NY.relocate(NY.getX()*800/2010-10, NY.getY()*600/2569-10);
                Circle circle = new Circle(3, Color.GREEN);
            NY.setShape(circle);
            NY.setPrefSize(1,1);
            NY.setStyle("-fx-background-color: Transparent; -fx-cursor:crosshair;");
           }
       /*    for(int i = 0; i < cities2.size(); i++)
           { City NY = cities2.get(i);
               gamePanel.getChildren().add(NY);
            NY.relocate(NY.getX()*800/2010-10, NY.getY()*600/2569-10);
                Circle circle = new Circle(3, Color.GREEN);
            NY.setShape(circle);
            NY.setPrefSize(1,1);
            NY.setStyle("-fx-background-color: Transparent; -fx-cursor:crosshair;");
           }
           for(int i = 0; i < cities3.size(); i++)
           { City NY = cities3.get(i);
               gamePanel.getChildren().add(NY);
            NY.relocate(NY.getX()*800/2010-10, NY.getY()*600/2569-10);
                Circle circle = new Circle(3, Color.GREEN);
            NY.setShape(circle);
            NY.setPrefSize(1,1);
            NY.setStyle("-fx-background-color: Transparent; -fx-cursor:crosshair;");
           }
           for(int i = 0; i < cities4.size(); i++)
           { City NY = cities4.get(i);
               gamePanel.getChildren().add(NY);
            NY.relocate(NY.getX()*800/2010-10, NY.getY()*600/2569-10);
                Circle circle = new Circle(3, Color.GREEN);
            NY.setShape(circle);
            NY.setPrefSize(1,1);
            NY.setStyle("-fx-background-color: Transparent; -fx-cursor:crosshair;");
           }
          */ 
           
          //    gamePanel.setAlignment(cities1.get(0), Pos.TOP_RIGHT);
          //  cities1.get(0).setTranslateX(500);
           //cities1.get(0).setGraphic(new ImageView("file:images/flag_white.png"));
          //  cities1.get(1).setGraphic(new ImageView("file:images/flag_black.png"));
           
          historyPanel = new BorderPane();
          flightPanel = new BorderPane();
             mapPanel = new GridPane();
         TheBox = new VBox();
            }
   public void loadGamePanel(){
       mainPane.getChildren().clear();
      mainPane.setTop(northToolbar);
      mainPane.setLeft(gamePanelLeft);
      mainPane.setRight(gamePanelRight);
       mainPane.setCenter(gamePanel);
   }
   public void initButtons(){
       gameButton = new Button("Game");
       gameButton.setPrefSize(250, 50);
        gameButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
       gameButton.setGraphic(new ImageView("file:images/arrow water GIF.gif"));    
       gameButton.setOnAction(e -> {
        loadGamePanel();
       });
       splashButton = new Button("Splash");
       splashButton.setStyle("-fx-background-color: lightblue; -fx-cursor: pointer;");
        splashButton.setMaxSize(250, 50);
       splashButton.setOnAction(e ->{
           mainPane.getChildren().clear();
       initSplashScreen();
       });
       historyButton = new Button("History");
       historyButton.setPrefSize(250, 50);
       historyButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
        historyButton.setGraphic(new ImageView("file:images/115.png"));
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
           historyPanel.setCenter(aboutLabel);
             mainPane.getChildren().clear();
             mainPane.setTop(northToolbar);
             mainPane.setCenter(historyPanel);
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
                      
       GO = new Button();
       GO.setPrefSize(30, 30);
        GO.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
       GO.setGraphic(new ImageView("file:images/images (1).jpg"));  
       GO.setOnAction(e -> {
           mainPane.setStyle("");
           if(numPlayers != 0)
           { for(int i = 0; i < numPlayers; i++)
         { 
         
             players.add(new Player(playerNames.get(i), i, playerType.get(i)));
         }   mainPane.getChildren().clear();
             mainPane.setCenter(gamePanel);
             mainPane.setTop(northToolbar);
             mainPane.setRight(gamePanelRight);
                mainPane.setLeft(gamePanelLeft);
       } }); 
        
      
       OK = new Button("OK");
       startGameButton = new Button();
       startGameButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
       startGameButton.setGraphic(new ImageView("file:images/Background - Light.png"));              
       startGameButton.setPrefSize(250, 50);
        loadGameButton = new Button();
        loadGameButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
        loadGameButton.setGraphic(new ImageView("file:images/greenb.png"));
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
        aboutButton = new Button();
        aboutButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
         aboutButton.setGraphic(new ImageView("file:images/500px-HILLBLU_button_background.svg.png"));
        aboutButton.setPrefSize(250, 50);
        aboutButton.setOnAction(e -> {        
          mainPane.getChildren().clear();
          mainPane.setTop(northToolbar);
          mainPane.setCenter(aboutPanel);
        });
        aboutButton.setPrefSize(250, 50);
        quitButton = new Button();
        quitButton.setStyle("-fx-background-color: Transparent; -fx-cursor: pointer;");
        quitButton.setGraphic(new ImageView("file:images/redb.png"));
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
        numPlayers = 2;   num2P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num3P.setStyle(""); num4P.setStyle(""); num5P.setStyle(""); num6P.setStyle("");
          addPlayerPanels(2);   });
    num3P.setOnAction(e ->{
        numPlayers = 3; num3P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num2P.setStyle(""); num4P.setStyle(""); num5P.setStyle(""); num6P.setStyle("");
          addPlayerPanels(3);   });
    num4P.setOnAction(e ->{
        numPlayers = 4;  num4P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num2P.setStyle(""); num3P.setStyle(""); num5P.setStyle(""); num6P.setStyle("");
          addPlayerPanels(4);   });
    num5P.setOnAction(e ->{
        numPlayers = 5; num5P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num2P.setStyle(""); num3P.setStyle(""); num4P.setStyle(""); num6P.setStyle("");
          addPlayerPanels(5);   });
    num6P.setOnAction(e ->{
        numPlayers = 6; num6P.setStyle("-fx-background-color: red; -fx-cursor: pointer;");
        num3P.setStyle(""); num4P.setStyle(""); num5P.setStyle(""); num2P.setStyle("");
          addPlayerPanels(6);   });
    mapB1 = new Button();
   mapB2 = new Button();
    mapB3 = new Button();
    mapB4 = new Button();
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
       dieButton.setOnAction(e -> {   
        int points = throwDie();
        //come check add in things for player turns ,use this ActionHandler to select new player turn ?? 
        //currentPlayer.setPoints(points);
       });
    returnButton = new Button();
   }
   
   public void initLabels(){
    selectNumPlayers = new Label("Select Number of players:  ");
    selectNumPlayers.setPrefHeight(30);
    selectNumPlayers.setStyle("-fx-background-color:white; ");
    nameLabel = new Label("  Name:  ");
    nameLabel.setPrefHeight(25);
     winLabel = new Label("You win!");
     loseLabel = new Label("You lose!");
    aboutLabel = new Label("Journey through Europe is a family board game published by Ravensburger. The board is a map of Europe with various major cities marked, for example, Athens, Amsterdam and London. \n The players are given a home city from which they will begin and are then dealt a number of cards with various other cities on them. \n They must plan a route between each of the cities in their hand of cards. On each turn they throw a die and move between the cities. \n The winner is the first player to visit each of their cities and then return to their home base.");
   }
   
   public void initValues(){
       file = new FileLoader();
       cities1 = file.getCities1();
       cities2 = file.getCities2();
       cities3 = file.getCities3();
       cities4 = file.getCities4();
       
        paneWidth = 1300;
        paneHeight = 700;
        playerNames = new ArrayList<TextField>();
        playerNames.add(new TextField("Player 1"));
        playerNames.add(new TextField("Player 2"));
        playerNames.add(new TextField("Player 3"));
        playerNames.add(new TextField("Player 4"));
        playerNames.add(new TextField("Player 5"));
        playerNames.add(new TextField("Player 6"));
        players = new ArrayList<Player>();
       playerType = new ArrayList<String>();
       playerType.add("Computer");
       playerType.add("Computer");
       playerType.add("Computer");
       playerType.add("Computer");
       playerType.add("Computer");
       playerType.add("Computer");
        }

   public void saveMap(){}
   public void savePlayers(){}
   public int throwDie(){
       int xs = (int) Math.random() * 5 + 1;
       System.out.println("Die rolled "+ xs);
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
   public void moveToCity(Player p, City NY){}
   public void selectPlayerNum(int x){}
   public boolean checkNeighbor(City NY){return false;}
   public boolean checkIfWinner(Player p){return false;}
   public void repaint(Map m, int[][] x){}
   public void won(){}
   public void lost(){}
   

}
