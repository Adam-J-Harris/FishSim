package MySim.References;

import env3d.Env;
import jff5.*;

import MySim.Displayable.*;

/**
 * WorldRef implements IWorldRef
 * WorldRef will contian funcation to manage the world
 * 
 * Singleton
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class WorldRef implements IWorldRef
{
    // Instance variables - replace the example below with your own
    private static WorldRef WRInstance = null;
    
    // Declaring core and the world
    private Core core;
    private Env world;
    
    /**
     * Constructor for objects of class WorldRef
     */
    private WorldRef()
    {
        // Initialise instance variables
    }
    
    /** METHOD : getInstance
     * This funcation is the singleton pattern
     * 
     * Returns a single instance of the factory manager
     */
    public static WorldRef getInstance() 
    {
        if(WRInstance == null) 
        {
            WRInstance = new WorldRef();
        }
        return WRInstance;
    }
    
    /** Method : CreateWorld
     * This method creates the world
     */
    public void CreateWorld()
    {
        // Set the core
        // The Set world to equal a new world
        core = new Core();
        world = core.createWorld();
    }
    
    /** Method : DistroyWorld
     * This method distorys the world
     */
    public void DistroyWorld()
    {   
        // code to distory the world
        core.destroyWorld();
    }
     
    /** Method : UpdateWorld
     * This method updates the world
     */
    public void UpdateWorld()
    {
        // code to update teh world
        core.updateWorld();
    }
    
    /** Method : GetWorld
     * This method gets the world instance
     * 
     * @return world - Env - return the instance of the world
     */
    public Env GetWorld()
    {
        // code to return the world instance
        return world;
    }
}
