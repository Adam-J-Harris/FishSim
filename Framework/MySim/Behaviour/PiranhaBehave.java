package MySim.Behaviour;

import MySim.Displayable.*;

import com.jme3.math.Vector3f;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;
/**
 * PiranhaBehave class extends Behave whihc implements IBehave.
 * PiranhaBehave contians the code to simulated a Piranha behaviour.
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class PiranhaBehave extends Behave
{
    // Instance variables

    // Vector3f to hold the varibles needed to move the piranha around
    private Vector3f posVectorPiranha;
    private Vector3f oriVectorPiranha;

    // Temp var for speed to check it works
    private double Accelerate;

    // Feild to hold the ID of the behaviour
    private String ID;

    // Local boolean to set if there has been a collision
    private boolean hit = false;

    // Local boolean to set if the piranha should move or sink
    private boolean stopMove = false;

    // Declaring a double to set a boundary box around the piranha
    private double boundary = 0.25;

    // Local douvle vaule of scale to change
    private double piranhaScale;

    // Local list to hold the java fish passed into the class
    private List<IBehave> fishList = new ArrayList<IBehave>();
    
    // Declaring Min and Max doubles for randomising position x, y
    private double MinposX = 1.0;
    private double MaxposX = 9.0;
    private double MinposY = 1.0;
    private double MaxposY = 7.0;

    // Declaring random number reference name
    Random _rnP;

    /**
     * Constructor for objects of class PiranhaBehave
     */
    public PiranhaBehave()
    {
        // initialise instance variables
    }

    /** METHOD : SetValues
     * This method sets the values needed for the piranha behaviour class
     */
    public void SetValues() 
    {
        // Call the overrided method first
        super.SetValues();

        posVectorPiranha = position();
        oriVectorPiranha = orientation();      
        Accelerate = accelerate();
        // Set position through accessor
        // Set rotation through accessor
        // Set speed through accessor

        // Set the rotation of the prianaha to face the right way
        oriVectorPiranha.x = oriVectorPiranha.x - (float)180;
        // Set scale through accessor
        piranhaScale = scale();
        
        // Set the random number
        _rnP = new Random();
    }

    /** METHOD : GetFishList
     * This method gets a list of behaviours of type IBehave
     * 
     * @param behavelist - IBehave - Holds the instance of the behaviours in a list 
     */
    public void GetFishList(List<IBehave> behavelist)
    {
        super.GetFishList(behavelist);
        // Make the local instance of the list equal the one passed through
        fishList = behavelist;
    }

    public String SetID()
    {
        super.SetID();
        // Set the piranha ID value
        ID = "piranha";
        return ID;
    }

    public void Move()
    {
        // Set the piranha to move in a direction
        posVectorPiranha.x = posVectorPiranha.x + (float)Accelerate;

        // code to make the piranha to move back forth around the aqauriam
        if(posVectorPiranha.x < 1)
        {
            Accelerate = Accelerate * -1;
            oriVectorPiranha.y = oriVectorPiranha.y * -1;
        }
        else if (posVectorPiranha.x > 9)
        {
            Accelerate = Accelerate * -1;
            oriVectorPiranha.y = oriVectorPiranha.y * -1;
        }
    }
    
    /** Method SetRandomPosition
     * This method set a random x and y value between 1 - 9 and 1 - 7
     * 
     */
    public void SetPosition()
    {
        
 
    }

    /** Method : CheckCollision
     * This method checks for a collision between the piranha and a list of fishs
     */
    public void CheckCollision()
    {
        // Loop through the list of fishes then
        // Check to see if the x position of those fish equal a prianhas x
        // IF the condition is true then increase the scale of prianha
        // Check to see if the prianha scale is big enough to make it sink
        // IF the condition is true then stop move equals true
        for(IBehave fishbehave: fishList)
        {
            if (((fishbehave.position().getX() <= posVectorPiranha.x + (float)boundary)&&
                (fishbehave.position().getX() >= posVectorPiranha.x - (float)boundary))&&
                ((fishbehave.position().getY() <= posVectorPiranha.y + (float)boundary)&&
                (fishbehave.position().getY() >= posVectorPiranha.y - (float)boundary)))
            {
                fishbehave.position().setX((float)MinposX + ((float)MaxposX - (float)MinposX) * (float)_rnP.nextDouble());
                fishbehave.position().setY((float)MinposY + ((float)MaxposY - (float)MinposY) * (float)_rnP.nextDouble());
                hit = true;
                if (hit == true)
                {
                    piranhaScale = piranhaScale + 0.15;

                    if(piranhaScale >= 0.60)
                    {
                        stopMove = true;
                    }

                }

            }
        }
    }
    
    /** Method : SwitchBehaviour
     * This methods decides what action the prianaha performs
     * Move, CheckCollision, Sink
     */
    public void SwitchBehaviour()
    {
        // IF: the local boolean stop move is false then
        // Call Move and check for collision
        // Set hit is equal to false
        // ELSE: the local boolean stop move is true then 
        // Call Sink
        if (!stopMove)
        {
            hit = false;
            Move();
            CheckCollision();
        }else
        {
            Sink();
        }
    }
    
    /** Method : Sink
     * This method will make the piranha sink
     */
    public void Sink()
    {
        posVectorPiranha.y = posVectorPiranha.y - (float)0.025;
        //piranhaScale = 0.25;  
        if (posVectorPiranha.y <= 0.70)
        {
            SetRandomPosition();
            SetScale(0.30);
            piranhaScale = scale();
            SetRandomSpeed();
            stopMove = false;
        }
    }

    /** METHOD : Update
     * This method acts as the update for the piranha behaviour,
     * By calling the update of super.instance it passing the values to the Displayable instance
     * Position x,y,z Oreintation x,y,z Scale 
     */
    public void Update()
    {  
        // Call the SwitchBehaviour method
        // Call the behaviours update
        // To pass the values back
       SetScale(piranhaScale);
       SwitchBehaviour();
       super.Update();
    }
}
