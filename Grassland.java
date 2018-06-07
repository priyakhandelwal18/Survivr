
/**
 * Write a description of class Grassland here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grassland extends Biomes
{
    /**
     * Contructor Grasslad() - constructs a new grassland object
     */
    public Grassland()
    {
        biome = new Materials[150][110]; //size of grassland biome
    }
    /**
     * <b>Summary</b> Method isAtSupply() - determines whether location contains a supply
     * @param x x coordinate of location
     * @param y y coordinate of location
     * @return boolean that tells whether there's a supply at location
     */
    public boolean isAtSupply(int x, int y)
    {
        return biome[y][x] instanceof Supplies;
    }
    /**
     * <b>Summary</b> Method buildObstacles() - builds obstacles in grassland
     */
    public void buildObstacles()
    {
        //1/5 of the board contains Level 3 Obstacles Drought and Sandstorm
        for (int row = 0; row < biome.length * 0.2; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (Math.random() < (1.0/20.0)) //randomly spaces obstacles every 8 spaces
                {
                    //decides between the two level 3 obstacles
                    if (Math.random() < 0.5)
                        biome[row][col] = new Fire(col, row);
                    else
                        biome[row][col] = new Famine(col, row);
                }
            }
        }
        //2/5 of the board contains Level 2 Obstacle Animal
        for (int row = 24; row < biome.length * 0.4 + 24; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                //randomly spaces out obstacles every 8 spaces.
                if (Math.random() < (1.0/20.0))
                    biome[row][col] = new Animal(col, row);
            }
        }
        //2/5 of the board contains Level 1 Obstacle
        for (int row = 72; row < biome.length * 0.4 + 72; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (Math.random() < (1.0/20.0))
                    biome[row][col] = new Mudslide(col, row);
            }
        }
    }
    public void buildSupplies()
    {
        double randPos;
        for (int row = 0; row < biome.length; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if ((biome[row][col] == null))
                {
                    if (Math.random() < (1.0/12.0))
                    {
                        randPos = Math.random();
                        if (randPos < (1.0/3.0))
                        {
                            if (Math.random() < 0.5)
                                biome[row][col] = new Metal(20, col, row);
                            else
                                biome[row][col] = new Metal(40, col, row);
                        }
                        else
                            if (randPos < (2.0/3.0))
                            {
                                if (Math.random() < 0.5)
                                    biome[row][col] = new Food(20, col, row);
                                else
                                    biome[row][col] = new Food(40, col, row);
                            }
                            else
                            {
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
     * <b>Summary</b> Method toString() - returns String biome
     *
     * @return the string that represents the biome
     */
    public String toString() 
    {
        return "GRASSLAND";
    }
}
