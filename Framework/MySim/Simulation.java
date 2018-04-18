package MySim;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////

// Importing required framework
import env3d.Env;
import jff5.*;

// Importing packages to the simulation
import MySim.Displayable.*;
import MySim.Behaviour.*;
import MySim.References.*;
import MySim.Factories.*;
import MySim.MouseInput.*;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * By running the 'main' method the simulation will begin. 
 * 
 * @author (Adam) & Marc Price
 * @version 0.6
 */
public class Simulation
{        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    
    /**
     * Constructor for objects of class Simulation
     */
    private Simulation()
    {
        // Create the world through singleton instance
        WorldRef.getInstance().CreateWorld();    
    }
    
    /**
     * METHOD: Static Main method used for creating standalone apps
     *
     */
    public static void main(String[] args) throws Exception
    {
        // Create the simulation class constructor.
        Simulation sim = new Simulation();
        
        // Call the AddDisplayable.
        sim.AddDisplayable();
        
        // Call the Run method.
        sim.Run();
    }
    
    //Implements the factory and input methods
    /**
     * METHOD: Add displayables to the scene with displayables
     *
     */
    private void AddDisplayable() throws Exception
    { 
        // Call the method of the factory manager that creates the displayables.
        FactoryManager.getInstance().Populate();
        
        // Call the method of the factory manager that gets the list of displayables that are on the screen.
        FactoryManager.getInstance().DMGetList();
    } 

    /**
     * METHOD: Run the simulation loop.  
     * User presses escape to exit.
     *
     */
    private void Run() throws Exception
    {      
        // The simulation loop method
        // While the simulation is running 
        // Check to see if the user wants to end the simulation
        while (!endSim)
        {
            // UPDATE STAGE:
            // This could be put into the mouse input class
            // IF: user has requested simulation loop exit (ie escape pressed):
            if (WorldRef.getInstance().GetWorld().getKey() == 1)
            {
                // SET: render loop exit condition
                endSim = true;
            }
          
            // Call the mouse input funcation check
            // Which checks if a mouse click has accured
            MouseInput.getInstance().Check(WorldRef.getInstance().GetWorld());
            
            // UPDATE Objects in 3D world:
            // Update through behave by subtype polymorphism 
            // By calling the factory managers update funcation
            FactoryManager.getInstance().Update();
            
            // RENDER STAGE
            // UPDATE: the environment
            WorldRef.getInstance().UpdateWorld();
        }
        
        // EXIT: cleanly by closing-down the environment:
        WorldRef.getInstance().DistroyWorld();
    }
}
