package MySim.Behaviour;

import MySim.Displayable.*;

import com.jme3.math.Vector3f;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;
/**
 * Abstract class Behaviour implements IBehave.
 * Behaviour contains the code which updates displayableMove,
 * The behaviour class is for objects that dont take a random position.
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public abstract class Behaviour implements IBehave
{
    // Instance variables 
    // Will have to pass the varibles for position and rotation to displayable

    IDisplayable _Displayable;

    // Declaring Vector3f for position and orientation
    private Vector3f posVector;
    private Vector3f oriVector;

    // Declaring Min and Max doubles for randomising position x, y
    private double MinposX = 1.0;
    private double MaxposX = 9.0;
    private double MinposY = 1.0;
    private double MaxposY = 7.0;

    // Declaring Min and Max doubles for randomising speed
    private double Minspeed = 0.005;
    private double Maxspeed = 0.025;

    // Declaring position for behaviour to change (x,y,z coordinates):
    // To help encapsulation
    private double x = 1.0, y = 1.0, z = 1.0;

    // Declaring orientation for behaviour to change (x,y,z rotation):
    // To help encapsulation
    private double rotateX = 0, rotateY = 90, rotateZ = 0;
    
    // Declaring Scale for behaviour to change scale
    // To help encapsulation
    private double Scale;

    // The private doubles above were added to behaviour
    // as vaules it can chnage rather than getting information from visual

    // Declaring a deafult String to replace later
    private String Defualt = "Defualt";

    // Declaring random number reference name
    Random _rn;

    // Declaring Accelerate value of type double
    private double Accelerate;
    
    /**
     * Constructor for objects of class Behave
     */
    public Behaviour()
    {
        
    }
    
    /** METHOD : position
     * This method acts as an accessor for the position values in behaviour
     * 
     * @return rtnVal - Vector3f - public instance of the position values
     */
    public Vector3f position()
    {
        Vector3f rtnVal = posVector;
        return rtnVal;
    }

    /** METHOD : orientation
     * This method acts as an accessor for the orientation values in behaviour
     * 
     * @return rtnVal - Vector3f - public instance of the orientation values
     */
    public Vector3f orientation()
    {
        Vector3f rtnVal = oriVector;
        return rtnVal;
    }

    /** METHOD : accelerate
     * This method acts as an accessor for the accelerate value in behaviour
     * 
     * @return rtnVal - double - public instance of the accelerate value
     */
    public double accelerate()
    {
        double rtnVal = Accelerate;
        return rtnVal;
    }

    /** METHOD : scale
     * This method acts as an accessor for the scale value in behaviour
     * 
     * @return rtnVal - double - public instance of the scale value
     */
    public double scale()
    {
        double rtnVal = Scale;
        return rtnVal;
    }

    /** METHOD : Initlalise
     * This method sets the displayable instance in behaviour
     * 
     * @param Displayable - IDisplayable - Holds the displayable instance
     */
    public void Initlalise(IDisplayable Displayable)
    {
        // Set the local instance to equal the one passed through parameter
        _Displayable = Displayable;
        
        // Set the pos and ori vector
        posVector = new Vector3f((float)x, (float)y, (float)z);
        oriVector = new Vector3f((float)rotateX, (float)rotateY, (float)rotateZ);
        
        // Set the random number
        _rn = new Random();
    }

    /** METHOD : SetValues
     * This method sets the values needed for the behaviour class
     */
    public void SetValues()
    { 
        // Set scale
        Scale = 0.10;
        
        // Call the random speed methods
        SetRandomSpeed();
    }
 
    /** METHOD : GetFish
     * This method get a single behaviour of type IBehave
     * 
     * @param behave - IBehave - Holds the instance of a behaviour
     */
    public void GetFish(IBehave behave)
    {
        // This method is used to call the one from the child
    }
    
    public IDisplayable SetFishDisplayable()
    {
        return _Displayable;
    }

    /** METHOD : GetFishList
     * This method gets a list of behaviours of type IBehave
     * 
     * @param behavelist - IBehave - Holds the instance of the behaviours in a list 
     */
    public void GetFishList(List<IBehave> behavelist)
    {
        // This method is used to call the one from the child
    }

    /** METHOD : SetID
     * This method sets the value ID needed for the behaviour class,
     * The ID value is a string to repesent the behaviour for identification
     */
    public String SetID()
    {
        // code to return the ID
        return Defualt;
    }

    /** Method SetRandomSpeed
     * This method set a random speed value between 0.05 and 0.005
     */
    public void SetRandomSpeed()
    {
        //Randomising speed between 0.05 and 0.005
        Accelerate = Minspeed + (Maxspeed - Minspeed) * _rn.nextDouble();
        //System.out.println("Speed " + Accelerate);
    }

    /** METHOD : SetMouse
     * This method sets the values by the mouses position
     * 
     * @param pos - Vector3f - Holds the Vector3f of the mosue position
     */
    public void SetMouse(Vector3f pos)
    {
        // This method is used to call the one from the child
    }

    /** METHOD : Update
     * This method acts as the update for behaviour,
     * By calling the update of diplayable instance and passing in the values
     * Position x,y,z Oreintation x,y,z Scale 
     */
    public void Update()
    {
        // Updating the displayable throught the instance
        // Updating is done through a method of subtype polymorphism
        _Displayable.Update(posVector, oriVector, Scale);
    }
}
