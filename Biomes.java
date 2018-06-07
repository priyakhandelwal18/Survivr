import java.awt.Point;
/**
 * Abstract class Biomes - Superclass of all the biomes which contains some common methods
 *
 * @author (Satvik Nagpal)
 * @version (06/06/2018)
 */
public abstract class Biomes
{
    protected Materials[][] biome; //grid of materials
    public abstract void buildObstacles();
    
    /**
     *  <b>Summary</b> Method isObstacle() - determines whether there is an obstacle at the given location
     *  @param x x coordinate of location
     *  @param y y coordinate of location
     *  @return boolean that tells if there is an obstacle at a location
     */
    public boolean isObstacle (int x, int y)
    {
        return biome[y][x] instanceof Obstacles;
    }
    
    /**
     *  <b>Summary</b> Method getMaterial() - returns material at a certain location
     *  @param x x coordinate of location
     *  @param y y coordinate of location
     *  @return Material that is at the location
     */
    public Materials getMaterial(int x, int y)
    {
        return biome[y][x];
    }
    
    /**
     * <b>Summary</b> Method clearObstacles() - clears obstacles in the given biome
     */
    public void clearObstacles()
    {
        for (int row = 0; row < biome.length; row++)
        {
            for (int col = 0; col < biome[row].length; col++)
            {
                if (isObstacle(col, row))
                    biome[row][col] = null;
            }
        }
    }
    
    /**
     * <b>Summary</b> Method clearMaterial() - clears material at a certain spot
     * @param pos point at which material should be cleared
     */
    public void clearMaterial(Point pos)
    {
        biome[(int)pos.getY()][(int)pos.getX()] = null;
    }
}
    

