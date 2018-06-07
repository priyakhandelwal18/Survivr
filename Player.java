import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private int metal; //player metal
    private int wood; //player wood
    private int food; //player food
    private int water; //player water
    private int bowAndArrow; //lvl 2 built supply (requires wood and metal)
    private int spear; //lvl 1 built supply (requires wood and metal)
    private int armor; //lvl 2 built supply (requires metal)
    private int pickaxe; //lvl 1 built supply (requires wood and metal)
    private int fireProofShield; //lvl 2 built supply (requires wood and metal)
    private int rope; //lvl 1 built supply (requires wood)
    private int health; //player health
    private final int WOOD_DECREMENT = 70; //constant used in required amount of wood in each built supply
    private final int METAL_DECREMENT = 70; //constant used in required amount of metal in each built supply
    private String name; //player name
    private Point pos; //player location
    private Point oldPos; //player location from one move ago
    private Grassland grassland; //grassland biome
    private Rainforest rainforest; //rainforest biome
    private Desert desert; //desert biome

    // make a health/supply increment/decrement

    /**
     * Constructor Player() - Constructs objects of class Player
     * @param playerName name of the player
     */
    public Player(String playerName)
    {
        health = 100; //starts off with 100 health
        //starts off with 0 supplies and built supplies
        metal = 0;
        wood = 0;
        food = 0;
        water = 0;
        bowAndArrow = 0;
        spear = 0;
        armor = 0;
        pickaxe = 0;
        fireProofShield = 0;
        rope = 0;
        name = playerName;
        //starts off at a random location somewhere at the beginning of the rainforest or grassland
        int x = (int)(Math.random()*201);
        int y = (int)(Math.random()*50 + 150);
        pos = new Point(x, y);
        System.out.println("Initial x: " + x + ", Initial y: " + y + ", Biome: " + playerBiomeString(getLocation()));
        //old pos is set to pos
        oldPos = pos;
        //instantiate new biomes with obstacles and supplies
        grassland = new Grassland();
        rainforest = new Rainforest();
        desert = new Desert();
        grassland.buildObstacles();
        rainforest.buildObstacles();
        desert.buildObstacles();
        grassland.buildSupplies();
        rainforest.buildSupplies();
        System.out.println("In setName"); //debugging
        //System.out.println(4/0);
    }

    /**
     * Constructor Player() - constructs a Player object with a specified name and location
     * @param x x coordinate of player
     * @param y y coordinate of player
     */
    public Player(int x, int y, String playerName)
    {
        //start off with 100 health
        health = 100;
        //start off with 0 supplies
        metal = 0;
        wood = 0;
        food = 0;
        water = 0;
        bowAndArrow = 0;
        spear = 0;
        armor = 0;
        pickaxe = 0;
        fireProofShield = 0;
        rope = 0;
        name = playerName; 
        //starts off at specified location
        pos = new Point(x, y);
        //old position set to current position
        oldPos = pos;
        //instantiate new biomes with supplies and obstacles
        desert = new Desert();
        grassland.buildObstacles();
        rainforest.buildObstacles();
        desert.buildObstacles();
        grassland.buildSupplies();
        rainforest.buildSupplies();
        System.out.println(4/0); //debugging
    }
    // LOTS OF METHODS TO ADD TO THIS CLASS CHANGING THE AMOUNT OF SUPPLIES
    /**
     * <b>Summary</b> Method move() - moves player to a certain location
     * @param x new x coordinate of player
     * @parm y new y coordinate of player
     */
    public void move(int x, int y)
    {
        if(pos != null)
            setOldPosition(pos); //sets old location of player
        pos.setLocation(x, y); //sets current location of player
        System.out.println("After the move, the actual pos: " + pos + " and biome: " + playerBiomeString(getLocation()));
        System.out.println("x: " + pos.getX() + ", y: " + pos.getY());
    }
    
    /**
     * <b>Summary</b> Method setOldPosition() - sets old position of player
     * @param pos Point that will be set as player's old location
     */
    public void setOldPosition(Point pos)
    {
        oldPos.setLocation(pos.getX(), pos.getY()); //sets old location to specified point 
    }
    
    /**
     * <b>Summary</b> Method isAtObstacle() - determines whether player is at an obstacle
     * @return a boolean that tells whether the player is at an obstacle
     */
    public boolean isAtObstacle()
    {
        if (playerBiome(pos).equals(desert)) //if player is in desert
        {
            //checks whether there is an obstacle at location
            return desert.isObstacle((int)convertLoc(pos).getX(), (int)convertLoc(pos).getY());
        }
        else
            if (playerBiome(pos).equals(rainforest)) //if player is in rainforest
            {
                //checks whether there is an obstacle at location
                return rainforest.isObstacle((int)convertLoc(pos).getX(), (int)(convertLoc(pos).getY()));
            }
            else //player is in grassland
            //checks whether there is an obstacle at location
                return grassland.isObstacle((int)(convertLoc(pos).getX()), (int)(convertLoc(pos).getY()));
    }
    
    /**
     * <b>Summary</b> Method isAtSupply() - determines whether player is at a supply
     * @return boolean that tells whether player is at an obstacle or not
     */
    public boolean isAtSupply()
    {
        boolean supply = false;
        if (playerBiome(pos).equals(rainforest)) //player in rainforest
        //checks whether there is a supply at location
            supply = rainforest.isAtSupply((int)convertLoc(pos).getX(), (int)(convertLoc(pos).getY()));
        else
        //checks whether there is an obstacle at location
            if (playerBiome(pos).equals(grassland)) //player in grassland
                supply = grassland.isAtSupply((int)(convertLoc(pos).getX()), (int)(convertLoc(pos).getY()));
        if(supply != false)
        {
           System.out.println("supply: " + playerBiome(getLocation()).getMaterial((int)convertLoc(getLocation()).getX(), (int)convertLoc(getLocation()).getY()).toString());
        }
        return supply;
    }
    
    /**
     * <b>Summary</b> Method playerBiome() - returns biome that player is in
     * @param pos Point at which player is at
     * @return Biome in which player is in
     */
    public Biomes playerBiome(Point pos)
    {
        if (pos.getY() < 80) //if player is in first 2/5 of board
            return desert;
        else 
            if (pos.getX() < 125) //if player is in left half of board
                return rainforest;
            else
                return grassland;
    }
    
    public String playerBiomeString(Point pos)
    { 
        if (pos.getY() < 80) //if player is in first 2/5 of board
            return "desert";
        else 
            if (pos.getX() < 125) //if player is in left half of board
                return "rainforest";
            else
                return "grassland";
    }
    
    /**
     * <b>Summary</b> Method converLoc()
     * @param pos - board location of player
     * @return position of player in biome
     */
    public Point convertLoc(Point posTwo)
    {
        if (playerBiome(posTwo).equals(desert)) //if player is in desert
        {
            return posTwo; //same position
        }
        else
            if (playerBiome(pos).equals(rainforest)) //if player is in rainforest
            {
                //posTwo.setLocation(posTwo.getX(), posTwo.getY() - 80); //same position, but y coordinate is shifted down 80
                return new Point((int)posTwo.getX(), (int)posTwo.getY() - 80);
            }
            else //player is in grassland
            {
                //x coordinate is shifted down 100 and y coordinate is shifted down 80
                //posTwo.setLocation((posTwo.getX() - 100), (posTwo.getY() - 80));
                return new Point((int)posTwo.getX() - 125, (int)posTwo.getY() - 80);
                //return posTwo;
            }
    }

    /**
     * <b>Summary</b> Method getLocation() - returns current location of player
     * @return Point at which player is located
     */
    public Point getLocation()
    {
        return pos;
    }
    
    /**
     *  <b>Summary</b> Method getOldLocation() - returns old location of player
     *  @return Point of player one move ago
     */
    public Point getOldLocation()
    {
        return oldPos; 
    }

    /**
     *  <b>Summary</b> Method getHealth() - return health of player
     *  @return player health
     */
    public int getHealth()
    {
        return health;
    }

    /**
     *  <b>Summary</b> Method getMetal() - returns metal of player
     *  @return amount of metal player has
     */
    public int getMetal()
    {
        return metal;
    }
    
    /**
     *  <b>Summary</b> Method getWood() - returns wood of player
     *  @return amount of wood player has
     */
    public int getWood()
    {
        return wood;
    }
    
    /**
     *  <b>Summary</b> Method getWater() - returns water of player
     *  @return amount of water player has
     */
    public int getWater()
    {
        return water;
    }
    
    /**
     *  <b>Summary</b> Method getFood() - returns food of player
     *  @return amount of food player has
     */
    public int getFood()
    {
        return food;
    }
    
    /**
     *  <b>Summary</b> Method getBowAndArrow() - returns bows and arrows of player
     *  @return amount of bows and arrows player has
     */
    public int getBowAndArrow()
    {
        return bowAndArrow;
    }
    
    /**
     * <b>Summary</b> Method getSpear() - returns spears of player
     * @return amount of spears player has
     */
    public int getSpear()
    {
        return spear;
    }
    
    /**
     *  <b>Summary</b> Method getArmor() - returns armor of player
     *  @return amount of armor player has
     */
    public int getArmor()
    {
        return armor;
    }
    
    /**
     * <b>Summary</b> Method getPickaxe() - returns pickaxes of player
     * @return amount of pickaxes player has
     */
    public int getPickaxe()
    {
        return pickaxe;
    }
    
    /**
     *  <b>Summary</b> Method getFireProofShield() - returns fire proof shields of player
     *  @return amount of fire proof shields player has
     */
    public int getFireProofShield()
    {
        return fireProofShield;
    }
    
    /**
     *  <b>Summary</b> Method getRope() - returns rope of player
     *  @return amount of rope player has
     */
    public int getRope()
    {
        return rope;
    }
    
    /**
     *  <b>Summary</b> Method addMetal() - adds player metal
     *  @param myMetal metal to be added
     */
    public void addMetal(int myMetal)
    {
        metal += myMetal;
    }
    
    /**
     *  <b>Summary</b> Method addWood() - adds player wood
     *  @param myWood wood to be added
     */
    public void addWood(int myWood)
    {
        wood += myWood;
    }
    
    /**
     *  <b>Summary</b> Method addWater() - adds player water
     *  @param myWater water to be added
     */
    public void addWater(int myWater)
    {
        water += myWater;
    }
    
    /**
     *  <b>Summary</b> Method addBowAndArrow() - adds player bow and arrows
     *  @param amount bow and arrows to be added
     */
    public void addBowAndArrow(int amount)
    {
        //checks if there is enough wood
        if(wood - ((amount) * WOOD_DECREMENT) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        //checks if there is enough metal
        if(metal - ((amount) * METAL_DECREMENT/2) < 0)
            throw new IllegalArgumentException("You don't have enough metal"); 
        //takes away wood and metal to add bow and arrows
        subtractWood((amount) * WOOD_DECREMENT);
        subtractMetal((amount) * METAL_DECREMENT/2);
        bowAndArrow += amount;
    }
    
    /**
     *  <b>Summary</b> Method addSpear() - adds player spears
     *  @param amount spears to be added
     */
    public void addSpear(int amount)
    { 
        //checks if there is enough wood
        if(wood - ((amount) * WOOD_DECREMENT/2) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        //checks if there is enough metal
        if(metal - ((amount) * METAL_DECREMENT/4) < 0)
            throw new IllegalArgumentException("You don't have enough metal"); 
        //takes away wood and metal to add spears
        subtractWood((amount) * WOOD_DECREMENT/2);
        subtractMetal((amount) * METAL_DECREMENT/4);
        spear += amount;
    }
    
    /**
     *  <b>Summary</b> Method addFireProofShield() - adds player fire proof shields
     *  @param amount fire proof shields to be added
     */
    public void addFireProofShield(int amount)
    {
        //checks if there is enough wood
        if(wood - ((amount) * WOOD_DECREMENT/2) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        //checks if there is enough metal
        if(metal - ((amount) * METAL_DECREMENT) < 0)
            throw new IllegalArgumentException("You don't have enough metal");
        //takes away wood and metal to add shields
        subtractWood((amount) * WOOD_DECREMENT/2);
        subtractMetal((amount) * METAL_DECREMENT);
        fireProofShield += amount;
    }
    
    /**
     *  <b>Summary</b> Method addRope() - adds player rope
     *  @param amount rope to be added
     */
    public void addRope(int amount)
    {
        //checks if there is enough wood
        if(wood - ((amount) * (int)(WOOD_DECREMENT)) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        //takes away wood to add rope
        subtractWood((amount) * (int)(WOOD_DECREMENT));
        rope += amount;
    }
    
    /**
     *  <b>Summary</b> Method addArmor() - adds player armor
     *  @param amount armor to be added
     */
    public void addArmor (int amount)
    {
        //checks if there is enough metal
        if(metal - ((amount) * METAL_DECREMENT) < 0)
            throw new IllegalArgumentException("You don't have enough metal");
        //takes away metal to add armor
        subtractMetal((amount) * METAL_DECREMENT);
        armor += amount;
    }
    
    /**
     *  <b>Summary</b> Method addPickAxe() - adds player pickaxes
     *  @param amoung pickaxes to be added
     */
    public void addPickaxe (int amount)
    {
        //checks if there is enough wood
        if(wood - ((amount) * WOOD_DECREMENT/2) < 0)
            throw new IllegalArgumentException("You don't have enough wood");
        //checks if there is enough metal
        if(metal - ((amount) * METAL_DECREMENT/4) < 0)
            throw new IllegalArgumentException("You don't have enough metal");
        //takes away wood and metal to add pickaxe
        subtractWood((amount) * WOOD_DECREMENT/2);
        subtractMetal((amount) * METAL_DECREMENT/4);
        pickaxe += amount;
    }
    
    /**
     *  <b>Summary</b> Method addFood() - adds player food
     *  @param myFood food to be added
     */
    public void addFood(int myFood)
    {
        food += myFood;
    }
    
    /**
     *  <b>Summary</b> Method addHealth() - adds player health
     *  @param myHealth health to be added
     */
    public void addHealth(int myHealth)
    {
        //checks if player health is already 100
        if(health > 98)
        {
            throw new IllegalArgumentException("If you eat 10 more food or drink 10 more water, you'll have over 100 health. Save the food and water for when you need it!");
        }
        health += myHealth; 
    }
    
    /**
     *  <b>Summary</b> Method subtractHealth() - subtracts player health
     *  @param myHealth health to be subtracted
     */
    public void subtractHealth(int myHealth)
    {
        health -= myHealth; 
    }
    
    /**
     *  <b>Summary</b> Method subtractMetal() - subtracts player metal
     *  @param myMetal metal to be subtracted
     */
    public void subtractMetal(int myMetal)
    {
        metal -= myMetal;
    }
    
    /**
     *  <b>Summary</b> Method subtractWood() - subtracts player wood
     *  @param myWood wood to be subtracted
     */
    public void subtractWood(int myWood)
    {
        wood -= myWood;
    }
    
    /**
     *  <b>Summary</b> Method subtractWater() - subtracts player water
     *  @param myWater water to be subtracted
     */
    public void subtractWater(int myWater)
    {
        //checks if there is enough wood 
        if(water - myWater < 0 || getHealth() >99)
            throw new IllegalArgumentException("You don't have enough water");
        water -= myWater;
    }
    
    /**
     *  <b>Summary</b> Method subtractFood() - subtracts player food
     *  @param myFood food to be subtracted
     */
    public void subtractFood(int myFood)
    {
        //checks if there is enough food
        if(food - myFood < 0 || getHealth() >98)
            throw new IllegalArgumentException("You don't have enough food");
        food -= myFood;
    }
    
    /**
     *  <b>Summary</b> Method Method subtractBowAndArrow() - subtracts player bow and arrows
     *  @param amount amount bow and arrows to be subtracted
     */
    public void subtractBowAndArrow(int amount)
    {
        bowAndArrow -= amount;
    }
    
    /**
     *  <b>Summary</b> Method subtractSpear() - subtracts player spears
     *  @param amount amount spears to be subtracted
     */
    public void subtractSpear(int amount)
    {
        spear -= amount;
    }
    
    /**
     *  <b>Summary</b> Method subtractArmor() - subtracts player armor
     *  @param amount amount armor to be subtracted
     */
    public void subtractArmor (int amount)
    {
        armor -= amount;
    }
    
    /**
     *  <b>Summary</b> Method subtractPickAxe() - subtracts player pickaxes
     *  @param amount amount pickaxes to be subtracted
     */
    public void subtractPickaxe (int amount)
    {
        pickaxe -= amount;
    }
    
    /**
     *  <b>Summary</b> Method subtractFireProofShield() - subtracts player fire proof shields
     *  @param amount amount fire proof shields to be subtracted
     */
    public void subtractFireProofShield (int amount)
    {
        fireProofShield -= amount;
    }
    
    /**
     *  <b>Summary</b> Method subtractRope() - subtracts player rope
     *  @param amount amount rope to be subtracted
     */
    public void subtractRope (int amount)
    {
        rope -= amount;
    }
}

