
/**
 * Write a description of class Rainforest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rainforest extends Biomes
{
    /**
     * Constructor Rainforest() constructs a rainforest object
     */
    public Rainforest()
    {
        biome = new Materials[150][125]; //size of rainforest biome
    }
    /**
     *  <b>Summary</b> Method isAtSupply() - determines whether there's a supply at given location
     *  @param x x coordinate of location
     *  @param y y coordinate of location
     *  @return boolean that tells whether there's a supply at the location
     */
    public boolean isAtSupply(int x, int y)
    {
        //instanceof operator tells whether object is instance of a certain class
        return biome[y][x] instanceof Supplies; 
    }
    /**
     * <b>Summary</b> Method buildObstacles() - builds obstacles in rainforest biome
     */
    public void buildObstacles()
    {
        //first 1/5 of rainforest level 3 obstacles Drought and Sandstorm
        for (int row = 0; row < biome.length * 0.2; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (Math.random() < (1.0/20.0)) //randomly, every 8 spaces
                {
                    if (Math.random() < 0.5) //decides between the two level 3 obstacles
                        //row and col must switch spots to make an (x, y) Point
                        biome[row][col] = new Fire(col, row);
                    else
                        biome[row][col] = new Famine(col, row);
                }
            }
        }
        //2/5 of the board with Level 2 Obstacle Animal
        for (int row = 24; row < biome.length * 0.4 + 24; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (Math.random() < (1.0/20.0)) //occur every 8 spaces randomly
                    biome[row][col] = new Animal(col, row); //col and row switch spots to create an (x, y) point
            }
        }
        //2/5 of the board with Level 1 Obstacle Mudslide
        for (int row = 72; row < biome.length * 0.4 + 72; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (Math.random() < (1.0/20.0)) //occur every 8 spaces
                    biome[row][col] = new Mudslide(col, row); //col and row switch spots
            }
        }
    }
    /**
     * <b>Summary</b> Method buildSupplies() - build supplies in rainforest biome
     */
    public void buildSupplies()
    {   
        double randPos;
        //builds wood, food, and water supplies
        for (int row = 0; row < biome.length; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                //if there's no obstacle already there
                if (biome[row][col] == null)
                {
                    //randomly generates every 10 spaces
                    if (Math.random() < (1.0/12.0))
                    {
                        randPos = Math.random();
                        //randomly chooses one of the supplies
                        if (randPos < (1.0/3.0))
                        {
                            //chooses whether to add 20 or 40 wood
                            if (Math.random() < 0.5)
                                biome[row][col] = new Wood(20, col, row);
                            else
                                biome[row][col] = new Wood(40, col, row);
                        }
                        else
                            if (randPos < (2.0/3.0))
                            {
                                //chooses whether to add 20 or 40 food
                                if (Math.random() < 0.5)
                                    biome[row][col] = new Food(20, col, row);
                                else
                                    biome[row][col] = new Food(40, col, row);
                            }
                            else
                            {
                                //chooses whether to add 20 or 40 water
                                if (Math.random() < 0.5)
                                    biome[row][col] = new Water(20, col, row);
                                else
                                    biome[row][col] = new Water(40, col, row);
                            }
                    }
                }      
            }
        }
    }
    
    /**
     * <b>Summary</b> Method toString() - returns String of biome
     * @return all CAPS form of biome String
     */
    public String toString()
    {
        return "RAINFOREST";
    }
}
