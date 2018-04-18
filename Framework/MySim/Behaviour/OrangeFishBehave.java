package MySim.Behaviour;

import MySim.Displayable.*;

import com.jme3.math.Vector3f;

/**
 * OrangeFishBehave class extends Behave whihc implements IBehave.
 * OrangeFishBehave contians the code to simulated a OrangeFish behaviour.
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class OrangeFishBehave extends Behave
{
    // Instance variables

    // Vector3f to hold the varibles needed to move the fish around
    private Vector3f posVectorOrange;
    private Vector3f oriVectorOrange;

    // Temp var for speed to check it works
    private double Accelerate;

    // Feild to hold the ID of the behaviour
    private String ID;

    /**
     * Constructor for objects of class OrangeFishBehave
     */
    public OrangeFishBehave()
    {
        // initialise instance variables
    }

    /** METHOD : SetValues
     * This method sets the values needed for the orange fish behaviour class
     */
    public void SetValues() 
    {
        // Call the overrided method first
        super.SetValues();

        // Set position through accessor
        // Set rotation through accessor
        // Set speed through accessor
        posVectorOrange = position();
        oriVectorOrange = orientation();      
        Accelerate = accelerate();
    }

    /** METHOD : SetID
     * This  sets the value ID needed for the behaviour class,
     * The ID value is a string to repesent the behaviour for identification
     */
    public String SetID()
    {
        super.SetID();
        ID = "orangefish";
        // Set the orange fish ID value
        return ID;
    }

    /** Method : Move
     * This method simulates the orange fish's movement
     */
    public void Move()
    {
        // Set the orange fish off in a direction
        posVectorOrange.x = posVectorOrange.x - (float)Accelerate;

        // code to make the orange fish move back and forth in the aqaruiam
        if(posVectorOrange.x < 1)
        {
            Accelerate = Accelerate * -1;
            oriVectorOrange.y = oriVectorOrange.y * -1;
        }
        else if (posVectorOrange.x > 9)
        {
            Accelerate = Accelerate * -1;
            oriVectorOrange.y = oriVectorOrange.y * -1;
        }
    }

    /** METHOD : Update
     * This method acts as the update for the orange fish behaviour,
     * By calling the update of super.instance it passing the values to the Displayable instance
     * Position x,y,z Oreintation x,y,z Scale 
     */
    public void Update()
    {  
        // Call the move method
        // Call the behaviours update
        // To pass the values back
        Move();
        super.Update();
    }
}
