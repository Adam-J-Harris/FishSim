package MySim.Behaviour;
import MySim.Displayable.*;

import com.jme3.math.Vector3f;
import MySim.MouseInput.*;

import java.util.ArrayList;
import java.util.List;
/**
 * BubbleBehave class extends Behave whihc implements IBehave.
 * BubbleBehave contians the code to simulated a Bubble behaviour.
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class BubbleBehave extends Behaviour
{
    // Instance variables

    // Instance to the fish of tpye IBehave
    private IBehave Display;

    // Vector3f to hold the varibles needed to move the bubble around
    private Vector3f posVectorBubble;
    private Vector3f oriVectorBubble;

    // Temp var for speed to check it works
    private double Accelerate;

    // feilds to make the bubble reset after 4 units
    private double MaxDistance = 4;
    private float LastP;

    // Feild to hold the ID of the behaviour
    private String ID;

    /**
     * Constructor for objects of class BubbleBehave
     */
    public BubbleBehave()
    {
        // initialise instance variables
    }

    /** METHOD : SetValues
     * This method sets the values needed for the bubble behaviour class
     */
    public void SetValues()
    {
        // Call the overrided method first
        super.SetValues();

        // Set position through accessor
        // Set rotation through accessor
        // Set speed through accessor
        posVectorBubble = position();
        oriVectorBubble = orientation();      
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
        ID = "bubble";
        return ID;
    }

    /** METHOD : GetFish
     * This method get a single behaviour of type IBehave
     * 
     * @param behave - IBehave - Holds the instance of a behaviour
     */
    public void GetFish(IBehave behave)
    {
        super.GetFish(behave);
        // Make the local instance of the fish equal the one passed through
        Display = behave;

        // Set the bubbles position vector equal the one of fish
        posVectorBubble.x = Display.position().getX();
        posVectorBubble.y = Display.position().getY();
        posVectorBubble.z = Display.position().getZ();

        // Set the last position varible of teh bubble
        LastP = Display.position().getY();
    }

    /** Method : Move
     * This method simulates the bubbles movement
     */
    public void Move()
    {
        // Set the bubble to move up
        posVectorBubble.y = posVectorBubble.y + (float)Accelerate;
        // code to make the ubble return to the fish
        if (posVectorBubble.y >= LastP + (float)MaxDistance)
        {
            // Set the bubbles position vector to equal the position of the fish
            posVectorBubble.y = Display.position().getY();
            posVectorBubble.x = Display.position().getX();
        }
    }

    /** METHOD : Update
     * This method acts as the update for the bubble behaviour,
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
