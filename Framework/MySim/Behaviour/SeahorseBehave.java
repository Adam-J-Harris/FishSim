package MySim.Behaviour;

import MySim.Displayable.*;

import com.jme3.math.Vector3f;

/**
 * SeahorseBehave class extends Behave whihc implements IBehave.
 * SeahorseBehave contians the code to simulated a seahorse behaviour.
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class SeahorseBehave extends Behave
{
    // Instance variables

    // Vector3f to hold the varibles needed to move the fish around
    private Vector3f posVectorSeahorse;
    private Vector3f oriVectorSeahorse;

    // Temp var for speed to check it works
    private double AccelerateX;
    private double AccelerateY;

    // Feild to hold the ID of the behaviour
    private String ID;

    /**
     * Constructor for objects of class SeahorseBehave
     */
    public SeahorseBehave()
    {
        // initialise instance variable      
        //System.out.println("Seahorse");
    }

    /** METHOD : SetValues
     * This method sets the values needed for the seahorse behaviour class
     */
    public void SetValues() 
    {
        // Call the overrided method first
        super.SetValues();

        // Set position through accessor
        // Set rotation through accessor
        // Set xspeed through accessor
        // Set yspeed through accessor

        posVectorSeahorse = position();
        oriVectorSeahorse = orientation();      
        AccelerateX = accelerate();
        AccelerateY = accelerate();

        // flip the saehorse the right way around
        oriVectorSeahorse.x = oriVectorSeahorse.x - 180;
    }

    /** METHOD : SetID
     * This  sets the value ID needed for the behaviour class,
     * The ID value is a string to repesent the behaviour for identification
     */
    public String SetID()
    {
        super.SetID();
        // Set the saehorse ID value
        ID = "seahorse";
        return ID;
    }

    /** Method : Move
     * This method simulates the seahorses movement
     */
    public void Move()
    {
        //System.out.println("Seahorse move");

        // Add onto the x and y of seahorse
        posVectorSeahorse.x = posVectorSeahorse.x + (float)AccelerateX;
        posVectorSeahorse.y = posVectorSeahorse.y + (float)AccelerateY;

        // code to make the seahorse move aorund the aqaruiam diagonally
        if(posVectorSeahorse.x < 1 )
        {
            AccelerateX = AccelerateX * -1;
            oriVectorSeahorse.y = oriVectorSeahorse.y * -1;
        }
        else if (posVectorSeahorse.x > 9)
        {
            AccelerateX = AccelerateX * -1;
            oriVectorSeahorse.y = oriVectorSeahorse.y * -1;
        }

        if(posVectorSeahorse.y < 1)
        {
            AccelerateY = AccelerateY * -1;
        }
        else if (posVectorSeahorse.y > 7)
        {
            AccelerateY = AccelerateY * -1;
        }
    }

    /** METHOD : Update
     * This method acts as the update for the seahorse behaviour,
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
