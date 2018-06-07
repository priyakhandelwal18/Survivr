import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
 * 
 * Class GameRunner
 * Includes all GUI parts
 */


public class GameRunner extends Application
{
    // double to hold the speed of movement of the character
    static final int moveSpeed = 1;
    // will hold the size of the window
    static int windowX, windowY;
    // border around the edge where player cannot travel
    static final int BORDER = 60;
    // size of player
    static double pWidth, pHeight;
    // Player
    static Player p;
    static int choice;
    static TimTheEnchanter tim;
    static String playerImage;
    static int scale;
    static String wol; 
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    
    @Override
    public void start(Stage theStage) 
    {
        // returns the screen size as a Rectangle2D
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        // save the width and height of the window and scale it by 66%
        windowY = (int)(bounds.getHeight());
        windowX = windowY;
        
        scale = (int)(windowX*.9/200);
        
        // create a VBox to organize the other nodes
        VBox vb = new VBox(20);

        // Group to hold the children
        Group r1 = new Group();
        // Scene with the start menu
        Scene startScreen = new Scene(r1);
        // make a new borderpane to organize buttons
        GridPane gp = new GridPane();
        
        // put the screen on the stage
        theStage.setScene(startScreen);

        // Button to start the game
        Button startB = new Button("Start");
        // Button to start the instructions
        Button instB = new Button("How to play");
        // Button to show credits
        Button creditB = new Button("Credits");
        // make a welcome text
        Label welcome = new Label("Welcome to:\nSurvivor");
        welcome.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        welcome.setTextAlignment(TextAlignment.CENTER);
        
        // add the buttons to the VBox
        vb.getChildren().addAll(welcome, startB, instB, creditB);
        vb.setPrefWidth(windowX / 5);
        vb.setPrefHeight(windowY / 3);
        
        vb.setAlignment(Pos.CENTER);
        
        // add the VBox to the scene
        r1.getChildren().add(vb);

        // create a player
        p = new Player("  ");
        
        tim = new TimTheEnchanter();
        
        
        
        // When the start button is pressed
        startB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    choosePlayer(theStage);
                }
            });
  
        // when the instructions button is pressed
        instB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // show the instructions page
                    showInstructions(theStage);
                }
            });
            
        // When the credits button is pressed
        creditB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // show credits
                    showCredits(theStage);
                }
            });

        // show the main menu window
        theStage.show();
    }
    
    private static void choosePlayer(Stage theStage)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g, windowX * .8, windowX * .4);
        
        popup.sizeToScene(); 
        
        Canvas c = new Canvas(s.getWidth(), s.getHeight());
        
        HBox hbButtons = new HBox(70);
        HBox hbLabels = new HBox(20);
        
        theStage.close();
        
        VBox vb = new VBox(s.getWidth() / 15);
        vb.setPrefHeight(windowX / 10);
        
        
        HBox hb = new HBox(20);
        hb.setPrefHeight(c.getHeight());
        hb.setPrefWidth(c.getWidth());
        
        HBox images = new HBox(60);
        
        GraphicsContext gc = c.getGraphicsContext2D();
        
        Label title = new Label("Choose Your Player");
        
        Button pic1 = new Button("       ");
        Button pic2 = new Button("       ");
        Button pic3 = new Button("       ");
        Button pic4 = new Button("       ");
        Button pic5 = new Button("       ");
        
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        
        hbButtons.getChildren().addAll(pic1, pic2, pic3, pic4, pic5);
        
        Label l1 = new Label("Boring Standard\nPlayer");
        Label l2 = new Label("Bill the Cat");
        Label l3 = new Label("The Lantsberger");
        Label l4 = new Label("Henry the Stressed");
        Label l5 = new Label("Zaphod Beeblebrox");
        
        hbLabels.getChildren().addAll(l1, l2, l3, l4, l5);
        
        Image bsp = new Image("Person.png");
        Image btc = new Image("bill the cat.png");
        Image l = new Image("mr. lantsberger.png");
        Image hs = new Image("henry.PNG");
        Image zb = new Image("Zaphod Beeblebrox.png");
        
        ImageView vbsp = new ImageView(bsp);
        vbsp.setFitWidth(50);
        vbsp.setFitHeight(70);
        ImageView vbtc = new ImageView(btc);
        vbtc.setFitWidth(50);
        vbtc.setFitHeight(70);
        ImageView vl = new ImageView(l);
        vl.setFitWidth(50);
        vl.setFitHeight(70);
        ImageView vhs = new ImageView(hs);
        vhs.setFitWidth(50);
        vhs.setFitHeight(70);
        ImageView vzb = new ImageView(zb);
        vzb.setFitWidth(50);
        vzb.setFitHeight(70);
        
        images.getChildren().addAll(vbsp, vbtc, vl, vhs, vzb);
        
        vb.getChildren().addAll(title, hbButtons,hbLabels, images);
        
        // center everything
        title.setAlignment(Pos.CENTER);
        hbButtons.setAlignment(Pos.CENTER);
        hbLabels.setAlignment(Pos.CENTER);
        images.setAlignment(Pos.CENTER);
        vb.setAlignment(Pos.CENTER);
        
        g.getChildren().addAll(vb);
        
        popup.setScene(s);
        
        popup.setTitle("Player");
        
        // When the pic1 button is pressed
        pic1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "Person.png";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        // When the pic2 button is pressed
        pic2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "bill the cat.png";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        // When the pic3 button is pressed
        pic3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "mr. lantsberger.png";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        // When the pic4 button is pressed
        pic4.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "henry.PNG";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        // When the pic5 button is pressed
        pic5.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                playerImage = "Zaphod Beeblebrox.png";
                popup.close();
                // start the game
                startGame(theStage);
            }
        });
        
        popup.show();
    }
    
    private static void startGame(Stage theStage)
    {
        // Close the menu window
        theStage.close();
        // create a new window
        Stage game = new Stage();
        // set the window title
        game.setTitle("Survivor");
        // create the top of the nodes
        Group root = new Group();
        // create a new scene
        Scene theScene = new Scene(root);
        // set the scene to the window
        game.setScene(theScene);
    
        // create a canvas for the game
        Canvas c = new Canvas(windowX * .9, windowY * .9);
        
        // set size of player
        pWidth = windowX /40.0;
        pHeight = windowY / 20.0;
        
        HBox hb = new HBox(10);
        VBox vb = new VBox(20);
        HBox lr = new HBox(5);
        
        Button up = new Button("      up      ");
        Button down = new Button("     down     ");
        Button left = new Button("left");
        Button right = new Button("right");
        
        lr.getChildren().addAll(left, right);
        
        hb.getChildren().addAll(c, vb);
        // add canvas to group
        root.getChildren().add(hb);
        
        Text health = new Text("Health: " + p.getHealth());
        Text wood = new Text("Wood: " + p.getWood());
        Text metal = new Text("Metal: " + p.getMetal());
        Text food = new Text("Food: " + p.getFood());
        Text water = new Text("Water: " + p.getWater());
        Text bAndA = new Text("Bow And Arrow: " + p.getBowAndArrow());
        Text armor = new Text("Armor: " + p.getArmor());
        Text pick = new Text("Pickaxe: " + p.getPickaxe());
        Text fireproof = new Text("Fire-Proof Shield: " + p.getFireProofShield());
        Text rope = new Text("Rope: " + p.getRope());
        Text spear = new Text("Spear: " + p.getSpear());
        
        Image h = new Image("HEART.png");
        Image wo = new Image("WOOD.png");
        Image m = new Image("METAL.png");
        Image fo = new Image("FOOD.png");
        Image wa = new Image("WATER.png");
        Image b = new Image("BOW AND ARROW.png");
        Image a = new Image("ARMOR.png");
        Image pi = new Image("PICK AXE.png");
        Image fi = new Image("FIREPROOF SHIELD.png");
        Image r = new Image("ROPE.png");
        Image s = new Image("SPEAR.png");
        
        ImageView vh = new ImageView(h);
        vh.setFitWidth(20);
        vh.setFitHeight(20);
        ImageView vwo = new ImageView(wo);
        vwo.setFitWidth(20);
        vwo.setFitHeight(20);
        ImageView vm = new ImageView(m);
        vm.setFitWidth(20);
        vm.setFitHeight(20);
        ImageView vfo = new ImageView(fo);
        vfo.setFitWidth(20);
        vfo.setFitHeight(20);
        ImageView vwa = new ImageView(wa);
        vwa.setFitWidth(20);
        vwa.setFitHeight(20);
        ImageView vB = new ImageView(b);
        vB.setFitWidth(20);
        vB.setFitHeight(20);
        ImageView va = new ImageView(a);
        va.setFitWidth(20);
        va.setFitHeight(20);
        ImageView vpi = new ImageView(pi);
        vpi.setFitWidth(20);
        vpi.setFitHeight(20);
        ImageView vfi = new ImageView(fi);
        vfi.setFitWidth(20);
        vfi.setFitHeight(20);
        ImageView vr = new ImageView(r);
        vr.setFitWidth(20);
        vr.setFitHeight(20);
        ImageView vs = new ImageView(s);
        vs.setFitWidth(20);
        vs.setFitHeight(20);
        
        HBox IandL = new HBox(5);
        VBox images = new VBox(15);
        VBox labels = new VBox(19);
        
        images.getChildren().addAll(vh, vwo, vm, vfo, vwa, vB, va, vpi, vfi, vr, vs);
        labels.getChildren().addAll(health, wood, metal, food, water, bAndA, armor, pick, fireproof, rope, spear);
        
        IandL.getChildren().addAll(images, labels);
        
        Button craft = new Button("Craft");
        Button eat = new Button("Eat Food");
        Button drink = new Button("Drink");
        vb.getChildren().addAll(IandL, craft, eat, drink);
        
        vb.getChildren().addAll(up, lr, down);
        
        // create a graphics context
        GraphicsContext gc = c.getGraphicsContext2D();
    
        // make two new images
        // person image
        Image pImage = new Image(playerImage);
        // map image
        Image map = new Image("map_finalfinal1.png");
    
        // Rectangle with the size of the map in it
        Rectangle mapBox = new Rectangle((int)map.getWidth(), (int)map.getHeight());
        
        // holds the inputs
        ArrayList<String> input = new ArrayList<String>();
    
        // // when a key is pressed
        // theScene.setOnKeyPressed(
            // new EventHandler<KeyEvent>()
            // {
                // public void handle(KeyEvent e)
                // {
                    // keycode
                    // String code = e.getCode().toString();
    
                    // only add once... prevent duplicates
                    // if (!input.contains(code))
                        // input.add(code);
                // }
            // }
        // );
    
        // // when the key is released
        // theScene.setOnKeyReleased(
            // new EventHandler<KeyEvent>()
            // {
                // public void handle(KeyEvent e)
                // {
                    // remove code from arraylist
                    // String code = e.getCode().toString();
                    // input.remove(code);
                // }
            // }
        // );
    
        // make a new AnimationTimer 
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // refresh the canvas
                gc.setFill(new Color(0, 0, 0, 0));
                gc.fillRect(0, 0, windowX, windowY);
                
                // if the key pressed is LEFT, RIGHT, DOWN, or UP
                // and the player will not move out of the board
                // move the player to the desired location
                // if(input.contains("LEFT") && p.getLocation().getX() >= moveSpeed + BORDER)
                    // {
                        // p.move((int)p.getLocation().getX() - moveSpeed, (int)p.getLocation().getY());
                        // checkForStuff(game, p);
                    // }
                    // else
                        // if(input.contains("RIGHT") && p.getLocation().getX() <= c.getWidth() - pWidth - moveSpeed - BORDER)
                        // {
                            // p.move((int)p.getLocation().getX() + moveSpeed, (int)p.getLocation().getY());
                            // checkForStuff(game, p);
                        // }
                        // else
                            // if(input.contains("DOWN") && p.getLocation().getY() <= c.getWidth() - pHeight - moveSpeed - BORDER)
                            // {
                                // p.move((int)p.getLocation().getX(), (int)p.getLocation().getY() + moveSpeed);
                                // checkForStuff(game, p);
                            // }
                            // else
                                // if(input.contains("UP") && p.getLocation().getY() >= moveSpeed + BORDER / 10.)
                                // {
                                    // p.move((int)p.getLocation().getX(),(int)p.getLocation().getY() - moveSpeed);
                                    // checkForStuff(game, p);
                                // }
        
                // draw the map and the players again        
                gc.drawImage(map, 0, 0, c.getWidth(), c.getWidth());
                
                if (p.playerBiomeString(p.getLocation()).equalsIgnoreCase("desert"))
                    gc.drawImage(pImage, scale * p.getLocation().getX(), scale * p.getLocation().getY(), pWidth, pHeight);
                else
                    if (p.playerBiomeString(p.getLocation()).equalsIgnoreCase("rainforest"))
                        gc.drawImage(pImage, scale * p.getLocation().getX(), scale * p.getLocation().getY(), pWidth, pHeight);
                    else
                        gc.drawImage(pImage, scale * p.getLocation().getX(), scale * p.getLocation().getY(), pWidth, pHeight);
                
                //System.out.println("Biome: " + p.playerBiomeString(p.getLocation()));
                        
                health.setText("Health: " + p.getHealth());
                wood.setText("Wood: " + p.getWood());
                metal.setText("Metal: " + p.getMetal());
                food.setText("Food: " + p.getFood());
                water.setText("Water: " + p.getWater());
                bAndA.setText("Bow And Arrow: " + p.getBowAndArrow());
                armor.setText("Armor: " + p.getArmor());
                pick.setText("Pickaxe: " + p.getPickaxe());
                fireproof.setText("Fire-Proof Shield: " + p.getFireProofShield());
                rope.setText("Rope: " + p.getRope());
                
                //System.out.println("pX " + p.getLocation().getX() + "   pY " + p.getLocation().getY());
                
                if(tim.die(p) != null)
                {
                    game.close();
                    finalScene(theStage, false);
                    stop();
                }
            }
        }.start();
    
        // enteredNewBiome(Player player)
        // runIntoObstacle(Player player)
        // runIntoSupply(Player player)
        // randomGift(Player player)
        
        up.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    if(p.getLocation().getY() * scale >= moveSpeed + BORDER / 10.)
                    {
                        p.move((int)p.getLocation().getX(),(int)p.getLocation().getY() - moveSpeed);
                        checkForStuff(game, p);
                    }
                }
            }
        );
        
        down.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    if(p.getLocation().getY() * scale <= c.getWidth() - pHeight - moveSpeed - BORDER)
                    {
                        p.move((int)(p.getLocation().getX()), (int)(p.getLocation().getY() + moveSpeed));
                        checkForStuff(game, p);
                    }
                }
            }
        );
        
        left.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    if(p.getLocation().getX() * scale >= moveSpeed + BORDER)
                    {
                        p.move((int)p.getLocation().getX() - moveSpeed, (int)p.getLocation().getY());
                        checkForStuff(game, p);
                    }
                }
            }
        );
        
        right.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    if(p.getLocation().getX() * scale <= c.getWidth() - pWidth - moveSpeed - BORDER)
                    {
                        p.move((int)p.getLocation().getX() + moveSpeed, (int)p.getLocation().getY());
                        checkForStuff(game, p);
                    }
                }
            }
        );
        
        craft.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    showCraftMenu(theStage);
                }
            }
        );
        
        eat.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    try
                    {
                        tim.eat(p);
                    }
                    catch (IllegalArgumentException ex)
                    {
                        showErrorMessage(theStage, ex.toString());
                    }
                }
            }
        );
        
        drink.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    try
                    {
                        tim.drink(p);
                    }
                    catch (IllegalArgumentException ex)
                    {
                        showErrorMessage(theStage, ex.toString());
                    }
                }
            }
        );
        
        theStage.toFront();
        // show the window with the game
        game.show();
    }
    
    private static void checkForStuff(Stage theStage, Player p)
    {
        if(tim.runIntoObstacle(p) != null)
        {
            Obstacles ob = (Obstacles)tim.returnMaterial(p);
            String weapon = ob.weapon();
            theStage.close();
            if (ob.toString().equalsIgnoreCase("goto heat wave"))
                atFinal(theStage, tim.runIntoObstacle(p), weapon);
            else
                atObstacle(theStage, tim.runIntoObstacle(p), weapon);
        }
        else
            if(tim.runIntoSupply(p) != null)
            {
                Supplies su = (Supplies)tim.returnMaterial(p);
                String supply = su.toString();
                String msg = tim.runIntoSupply(p);
                theStage.close();
                atSupply(theStage, msg, supply);

            }
        
        String gift = tim.randomGift(p);
        if(gift != null)
        {
            theStage.close();
            giftMessage(theStage, gift);
        }
    }
    
    private static void showInstructions(Stage theStage)
    {
        // close the menu
        theStage.close();

        // create a new group of nodes
        Group instG = new Group();
        // make a new window
        Stage instStage = new Stage();

        // set the title of the window
        instStage.setTitle("Instructions");

        // create a VBox to organize the texts
        VBox textVB = new VBox(20);
        HBox pixHB = new HBox(10);

        // button to go back to the main menu
        Button backB = new Button("Back");

        // create and add scene with instructions
        Scene instScene = new Scene(instG);
        instStage.setScene(instScene);
        
        Image timImage = new Image("tim the enchanter.png"); // Replace with picture of Tim
        ImageView tim = new ImageView(timImage);
        
        tim.setFitHeight(windowX / 6);
        tim.setFitWidth(windowX / 6);
        
        Canvas timSpace = new Canvas(windowX / 4, windowY/ 4);
        GraphicsContext gc = timSpace.getGraphicsContext2D();

        // label the window
        Label title = new Label("Instructions:");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        
        Font txtFont = new Font(15);
        // create two 'paragraphs'
        Text p1 = new Text("I...am an enchanter. There are some who call me...Tim. ");
        Text p2 = new Text("Welcome to British Software Island.\nMany brave souls like you that once set" + 
                            " foot on this island were never seen again…");
        Text p3 = new Text("Those before you that tried to escape the island all failed,\nbut" +
                            "I will give you the best form of guidance- a magical map.\nThis map" + 
                            " will help you find your way from the Rainforest and the Grassland\nto the end of the" + 
                            " Desert,where you can escape. As you explore these puzzling lands,\nyou may run into" + 
                            " metal, wood, water, and food,which you can\nutilize to build useful tools and nourish" + 
                            " your health." +
                            "\nThe map shows you the three terrains - Rainforest, Grassland, and Desert." +
                            "\nFood and water are available in both the rainforest and grassland.In the rainforest, you can find\n" +
                            "some wood, and in the grassland, you may come across some metal." +
                            "\nBut in the desert, there will be no supplies and only challenges.");
        Text p4 = new Text("You will also encounter various obstacles along the way. Know that the journey only gets\n" + 
                            "harder as you get closer to the escape zone." +
                            "\nIf you do doubt your courage or your strength,\ncome no further for DEATH AWAITS YOU ALL WITH " + 
                            "NASTY BIG POINTY TEETH. Wait... no, wrong line...");

        Text p5 = new Text( "Of course, I’m not" + 
                            " entirely cruel either.\nI will attempt to lend you my help and be...helpful.\n" +
                            "You might find random gifts along the way if you have earned them.\nBe warned, I know of many hidden dangers...");
        p1.setFont(txtFont);
        p2.setFont(txtFont);
        p3.setFont(txtFont);
        p4.setFont(txtFont);
        p5.setFont(txtFont);
        
        backB.setFont(txtFont);
        
        pixHB.getChildren().addAll(p3, tim);
        
        // add everything to VBox
        textVB.getChildren().addAll(title, p1, p2, pixHB, p4, p5, backB);
        // textVB.setPrefWidth(windowX / 3);
        // textVB.setPrefHeight(windowY / 3);
        
        textVB.setAlignment(Pos.CENTER_LEFT);
        
        
        // add VBox to window
        instG.getChildren().add(textVB);

        // when the back button is pressed
        backB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // close instructions window
                    instStage.close();
                    // show the main menu window
                    theStage.show();
                }
            }
        );

        // show the instructions window
        instStage.show();
    }
    
    private static void showCredits(Stage theStage)
    {
        theStage.close();
        
        // create a new group of nodes
        Group credG = new Group();
        // make a new window
        Stage credStage = new Stage();

        // set the title of the window
        credStage.setTitle("Credits");

        // create a VBox to organize the texts
        VBox textVB = new VBox(20);

        // button to go back to the main menu
        Button backB = new Button("Back");

        // create and add scene with instructions
        Scene credScene = new Scene(credG);
        credStage.setScene(credScene);

        // label the window
        Label title = new Label("Credits");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        // create two 'paragraphs'
        Text p1 = new Text("Varun Agarwal");
        Text p2 = new Text("Arushi Dogra");
        Text p3 = new Text("Satvik Nagpal");
        Text p4 = new Text("Priya Khatri");
        Text p5 = new Text("HUGE THANKS TO MR. L FOR EVERYTHING!!!!!!!!");
        
        // add everything to VBox
        textVB.getChildren().addAll(title, p1, p2, p3, p4, p5, backB);
        textVB.setPrefWidth(windowX / 3);
        textVB.setPrefHeight(windowY / 3);
        
        textVB.setAlignment(Pos.CENTER);
        
        
        // add VBox to window
        credG.getChildren().add(textVB);

        // when the back button is pressed
        backB.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    // close instructions window
                    credStage.close();
                    // show the main menu window
                    theStage.show();
                }
            }
        );

        // show the instructions window
        credStage.show();
    }
    
    private static void atObstacle(Stage theStage, String message, String weapon)
    {
        Group g3 = new Group();
        Scene pop = new Scene(g3);
        Stage popup = new Stage();
        
        
        
        popup.setScene(pop);
        popup.setTitle("Obstacle");
        
        
        
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        
        double rand = Math.random() * 2;
        String s = "";
        
        if(rand < 1)
            s = "Ack! ";
        else
            s = "Oh No! ";
        
        Text obstacle = new Text(s + message);
        Text nope = new Text("Sorry, you don't have the weapons that can fight this one.");
        Button counterB1 = new Button(" Use Weapon ");
        Button counterB2 = new Button(" Don't Use Weapon ");
        Button ok = new Button(" Ok ");
        int number = 0;
        if (weapon.equals("bow and arrow"))
            number = p.getBowAndArrow();
        else
            if (weapon.equals("rope"))
                number = p.getRope();
            else
                if (weapon.equals("spear"))
                    number = p.getSpear();
                else
                    if (weapon.equals("armor"))
                        number = p.getArmor();
                    else
                        if (weapon.equals("pickaxe"))
                            number = p.getPickaxe();
                        else
                            if (weapon.equals("fire-proof shield"))
                                number = p.getFireProofShield();
        
        if (number == 0)
            vb2.getChildren().addAll(obstacle, nope, ok);
        else
            vb2.getChildren().addAll(obstacle, counterB1, counterB2);
        vb2.setPrefWidth(windowX / 4);
        vb2.setPrefHeight(windowY / 4);
        
        vb2.setAlignment(Pos.CENTER);
        
        g3.getChildren().add(vb2);
        
        
        // when the option 1 button is pressed
        counterB1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                // do the first option
                wol = tim.fightObstacle(p, true);
                if (weapon.equals("bow and arrow"))
                    p.subtractBowAndArrow(1);
                else
                    if (weapon.equals("rope"))
                        p.subtractRope(1);
                    else
                        if (weapon.equals("spear"))
                            p.subtractSpear(1);
                        else
                            if (weapon.equals("armor"))
                                p.subtractArmor(1);
                            else
                                if (weapon.equals("pickaxe"))
                                    p.subtractPickaxe(1);
                                else
                                    if (weapon.equals("fire-proof shield"))
                                        p.subtractFireProofShield(1);
                popup.close();
                winOrLose(theStage, wol);
                
                theStage.show();
                theStage.toFront();
            }
        });
        
        counterB2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                // do the second option
                wol = tim.fightObstacle(p, false);
                popup.close();
                winOrLose(theStage, wol);
                
                theStage.show();
                theStage.toFront();
            }
        });
        
        ok.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                // do the second option
                wol = tim.fightObstacle(p, false);
                popup.close();
                winOrLose(theStage, wol);
                
                theStage.show();
                theStage.toFront();
            }
        });
        
        
        popup.show();
    }
    
    private static void winOrLose(Stage theStage, String status)
    {
        Group g = new Group();
        Stage s = new Stage();
        Scene results = new Scene(g);
        s.setScene(results);
        s.setTitle("Results");
        
        VBox vB = new VBox(20);
        
        Label title = new Label("RESULTS:");
        Text msg = new Text(wol);
        
        vB.getChildren().addAll(title, msg);
        
        g.getChildren().add(vB);
        
        s.showAndWait();
    }
    
    private static void atSupply(Stage theStage, String msg, String sup)
    {
        Group g3 = new Group();
        Scene pop = new Scene(g3);
        Stage popup = new Stage();
        
        popup.setScene(pop);
        
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        
        double rand = Math.random() * 2;
        String s = "";
        
        if(rand < 1)
            s = "Cool! ";
        else
            s = "Awesome! ";
        
        Text obstacle = new Text(s + " =) You found a some supplies. " + msg);
        
        Button supplyB1 = new Button("Take and Leave");
        
        vb2.getChildren().addAll(obstacle, supplyB1);
        vb2.setPrefWidth(windowX / 4);
        vb2.setPrefHeight(windowY / 4);
        
        vb2.setAlignment(Pos.CENTER);
        
        g3.getChildren().add(vb2);
        
        int supNum = tim.collectSupply(p);
        
        // when the button is pressed
        supplyB1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                supMessage(popup, sup, supNum);
                theStage.show();
                theStage.toBack();
            }
        });
        
        popup.showAndWait();
    }
    
    private static void supMessage(Stage theStage, String msg, int num)
    {
        Group g2 = new Group();
        Scene msgS = new Scene(g2);
        Stage s = new Stage();
        
        theStage.close();
        
        Canvas c = new Canvas(windowX / 5, windowX / 5);
        
        s.setScene(msgS);
        s.setTitle("Supply");
        
        VBox vb = new VBox(20);
        
        g2.getChildren().addAll(vb);
        
        vb.setPrefWidth(windowX / 6);
        vb.setPrefHeight(windowY / 4);
        
        Label title = new Label("You got:");
        Text msgT = new Text(num + " " + msg);
        Button close = new Button("Close");
        
        vb.getChildren().addAll(title, msgT, close);
        vb.setAlignment(Pos.CENTER);
        
        
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                s.close();
            }
        });
        
        s.toFront();
        s.show();
    }
    
    private static void showCraftMenu(Stage theStage)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g);
        
        popup.setScene(s);
        
        
        Button close = new Button("Close");
        Button bowArrow = new Button("Bow and Arrow");
        Button spear = new Button("Spear");
        Button armor = new Button("Armor");
        Button pick = new Button("Pickaxe");
        Button fireproof = new Button("Fire-Proof Shield");
        Button rope = new Button("Rope");
        
        HBox buttons = new HBox(20);
        VBox vb = new VBox(30);
        
        buttons.getChildren().addAll(bowArrow, spear, armor, pick, fireproof, rope);
        vb.getChildren().addAll(buttons, close);
        g.getChildren().add(vb);
           
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                popup.close();
            }
        });
        
        bowArrow.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addBowAndArrow(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        spear.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addSpear(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        armor.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addArmor(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        pick.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addPickaxe(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        fireproof.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addFireProofShield(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        
        rope.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                try
                {
                    p.addRope(1);
                }
                catch(IllegalArgumentException error)
                {
                    showErrorMessage(theStage, error.toString());
                }
            }
        });
        
        popup.showAndWait();
    }
    
    private static void showErrorMessage(Stage theStage, String err)
    {
        Group g = new Group();
        Stage s = new Stage();
        Scene error = new Scene(g);
        s.setScene(error);
        s.setTitle("Error");
        
        VBox vB = new VBox(20);
        
        err = err.substring(36);
        
        Text msg = new Text("Oops. Unfortunately, you can't do that.");
        Text msg1 = new Text(err);
        
        vB.getChildren().addAll(msg, msg1);
        
        g.getChildren().add(vB);
        
        s.showAndWait();
    }
    
    private static void giftMessage(Stage theStage, String gift)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g);
        
        theStage.close();
        
        popup.setScene(s);
        
        Button close = new Button("Close");
        
        VBox vb = new VBox();
        Label title = new Label("MESSAGE:");
        Text msg = new Text("Tim granted you a gift. You got " + gift);
        
        Image tim = new Image("FULL ON TIM.png");
        ImageView iv = new ImageView(tim);
        vb.getChildren().addAll(title, msg, iv, close);
        vb.setAlignment(Pos.CENTER);
        g.getChildren().add(vb);
           
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                popup.close();
                theStage.show();
            }
        });
        
        popup.show();
    }
    
    private static void finalScene(Stage theStage, boolean wonGame)
    {
        if(wonGame)
        {
            finalBoss(theStage);
        }
        else
        {
            loseGame(theStage);
        }
    }
    
    private static void finalBoss(Stage theStage)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g);
        
        theStage.close();
        
        popup.setScene(s);
        
        Button close = new Button("Close");
        
        Text msg = new Text("congrats you wasted ur time on this game and won.");
        Text msg2 = new Text("you have made your friend tim proud.");
        
        VBox vb = new VBox();
        vb.getChildren().addAll(msg, msg2, close);
        g.getChildren().add(vb);
        
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        popup.show();
    }
    
    private static void loseGame(Stage theStage)
    {
        Group g = new Group();
        Stage popup = new Stage();
        Scene s = new Scene(g);
        
        theStage.close();
        
        popup.setScene(s);
        
        Button close = new Button("Close");
        
        Text msg = new Text("congrats you wasted ur time on this game and lost.");
        Text msg2 = new Text("you have dissapointed tim. you have no friends now.");
            
        VBox vb = new VBox();
        vb.getChildren().addAll(msg, msg2, close);
        g.getChildren().add(vb);
           
        close.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        popup.show();
    }
    
    private static void atFinal(Stage theStage, String message, String weapon)
    {
        Group g3 = new Group();
        Scene pop = new Scene(g3);
        Stage popup = new Stage();
        
        popup.setScene(pop);
        popup.setTitle("FINAL OBSTACLE");
        
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        
        double rand = Math.random() * 2;
        String s = "";
        
        if(rand < 1)
            s = "ACK! ";
        else
            s = "OH NO! ";
        
        Text obstacle = new Text(s + message);
        Text nope = new Text(weapon);
        
        Button ok = new Button(" Ok ");

        vb2.getChildren().addAll(obstacle, nope, ok);
        
        vb2.setPrefWidth(windowX / 4);
        vb2.setPrefHeight(windowY / 4);
        
        vb2.setAlignment(Pos.CENTER);
        
        g3.getChildren().add(vb2);
        
        ok.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                wol = tim.fightObstacle(p, false);
                popup.close();
                //waiting(theStage);
                if(tim.win(p) != null)
                    finalScene(popup, true);
                else
                    if(tim.die(p) != null)
                        finalScene(popup, true);
                theStage.show();
                theStage.toFront();
            }
        });
        
        popup.show();
    }
    
    private static void waiting(Stage theStage)
    {
        theStage.close();
        int numPops = (int)(Math.random() * 5) + 5;
        
        for(int i = 0; i < numPops; i++)
        {
            // create a new group of nodes
            Group g = new Group();
            Scene s = new Scene(g);
            // make a new window
            Stage popup = new Stage();
    
            popup.setScene(s);
            
            // set the title of the window
            popup.setTitle("THE ANTICIPATION ESCALATES...");
    
            // create a VBox to organize the texts
            VBox textVB = new VBox(20);
            
            Text msg = new Text(" ");
            Button close = new Button("Close");
    
            // add everything to VBox
            textVB.getChildren().addAll(msg, close);
            textVB.setPrefWidth(windowX / 3);
            textVB.setPrefHeight(windowY / 3);
            
            textVB.setAlignment(Pos.CENTER);
            
            
            // add VBox to window
            g.getChildren().add(textVB);
    
            // when the back button is pressed
            close.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override public void handle(ActionEvent e)
                    {
                        // close instructions window
                        popup.close();
                    }
                }
            );
    
            // show the instructions window
            popup.show();
        }
        
    }
}