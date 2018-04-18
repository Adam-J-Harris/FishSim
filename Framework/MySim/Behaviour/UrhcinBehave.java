package MySim.Behaviour;
import MySim.Displayable.*;

import com.jme3.math.Vector3f;

/**
 * UrhcinBehave class extends Behave whihc implements IBehave.
 * UrhcinBehave contians the code to simulated a Urhcin behaviour.
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class UrhcinBehave extends Behave
{
    // Instance variables

    // Vector3f to hold the varibles needed to move the fish around
    private Vector3f posVectorUrhcin;
    private Vector3f oriVectorUrhcin;

    // Temp var for speed to check it works
    private double Accelerate;

    // Feild to hold the ID of the behaviour
    private String ID;

    /**
     * Constructor for objects of class UrhcinBehave
     */
    public UrhcinBehave()
    {
        // initialise instance variables

        //System.out.println("Urchin");
    }

    /** METHOD : SetValues
     * This method sets the values needed for the urchin behaviour class
     */
    public void SetValues() 
    {
        // Call the overrided method first
        super.SetValues();

        // Set position through accessor
        // Set rotation through accessor
        // Set speed through accessor
        posVectorUrhcin = position();
        oriVectorUrhcin = orientation();      
        Accelerate = accelerate();

        // Set Urchin to bottom of the aqaruiam 
        posVectorUrhcin.y = (float)1.0;
    }

    /** METHOD : SetID
     * This  sets the value ID needed for the behaviour class,
     * The ID value is a string to repesent the behaviour for identification
     */
    public String SetID()
    {
        super.SetID();
        // Set the urchin ID value
        ID = "urchin";
        return ID;
    }

    /** Method : Move
     * This method simulates the urchins movement
     */
    public void Move()
    {
        // Add onto the x of the urchin
        posVectorUrhcin.x = posVectorUrhcin.x + (float)Accelerate;
        // Add onto the rotate x of the urchin
        oriVectorUrhcin.x = oriVectorUrhcin.x + ((float)Accelerate*40);

        // code to make the urchin move back and forth on the bottom of the aqaruiam
        if(posVectorUrhcin.x < 1)
        {
            Accelerate = Accelerate * -1;
            oriVectorUrhcin.x = oriVectorUrhcin.x * -1;
        }
        else if (posVectorUrhcin.x > 9)
        {
            oriVectorUrhcin.x = oriVectorUrhcin.x * -1;
            Accelerate = Accelerate * -1;
        }
    }

    /** METHOD : Update
     * This method acts as the update for the urchin behaviour,
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
