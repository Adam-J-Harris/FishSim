package MySim.Behaviour;

import MySim.Displayable.*;

import com.jme3.math.Vector3f;

import java.util.ArrayList;
import java.util.List;
/**
 * JavaFishBehave extends Behave which implements IBehave.
 * JavaFishBehave contains the code to simulated a JavaFish behaviour
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class JavaFishBehave extends Behave
{
    // Instance variables

    // Vector3f to hold the varibles needed to move the fish around
    private Vector3f posVectorJava;
    private Vector3f oriVectorJava; 

    // Feild to hold the ID of the behaviour
    private String ID;

    // Temp var for speed to check it works
    private double Accelerate;

    /**
     * Constructor for objects of class JavaFishBehave
     */
    public JavaFishBehave()
    {
        // Initialise instance variables
    }

    /** METHOD : SetValues
     * This method sets the values needed for the java fish behaviour class
     */
    public void SetValues()
    {
        // Call the overrided method first
        super.SetValues();

        // Set position through accessor
        // Set rotation through accessor
        // Set speed through accessor
        posVectorJava = position();
        oriVectorJava = orientation();      
        Accelerate = accelerate();

    }

    /** METHOD : SetID
     * This  sets the value ID needed for the behaviour class,
     * The ID value is a string to repesent the behaviour for identification
     */    
    public String SetID()
    {
        super.SetID();
        // Set the java fish ID value
        ID = "javafish";
        return ID;
    }

    /** Method : Move
     * This method simulates the java fish's movement
     */
    public void Move()
    {
        // Set the orange fish off in a direction
        posVectorJava.x = posVectorJava.x - (float)Accelerate;

        // code to make the java fish move back and forth in the aqaruiam
        if(posVectorJava.x < 1)
        {
            Accelerate = Accelerate * -1;
            oriVectorJava.y = oriVectorJava.y * -1;
        }
        else if (posVectorJava.x > 9)
        {
            Accelerate = Accelerate * -1;
            oriVectorJava.y = oriVectorJava.y * -1;
        }
    }

    /** METHOD : Update
     * This method acts as the update for the java fish behaviour,
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
