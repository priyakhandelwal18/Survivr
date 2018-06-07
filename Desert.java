
/**
 * Class Desert represents one biome in the game which only has obstacles.
 *
 * @author (Satvik Nagpal)
 * @version (06/06/2018)
 */
public class Desert extends Biomes
{
    public Desert()
    {
        biome = new Materials[80][235]; //size of desert biome
    }

    public void buildObstacles() //sandstorm, fire, drought, famine
    {
        for (int col = 0; col < biome[2].length; col++)
        {
            biome[2][col] = new FinalObstacle(col, 2); //final obstacle row
        }
        //half the board with lvl 4 obstacles (sandstorm and drought)
        for (int row = 3; row < biome.length/2; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                //randomly generates every 15 spaces
                if (Math.random() < (1.0/15.0))
                {
                    if (Math.random() < .5)
                        biome[row][col] = new Drought(col, row);
                    else
                        biome[row][col] = new Sandstorm(col, row);
                }
            }
        }
        //half the board with lvl 3 obstacels (fire and famine)
        for (int i = biome.length/2; i < biome.length; i++)
        {
            for (int j = 0; j < biome[i].length; j++)
            {
                //randomly generates every 15 spaces
                if (Math.random() < (1.0/15.0))
                {
                    if (Math.random() < .5)
                        biome[i][j] = new Fire(j, i);
                    else
                        biome[i][j] = new Famine(j, i);
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
        return "DESERT";
    }
}