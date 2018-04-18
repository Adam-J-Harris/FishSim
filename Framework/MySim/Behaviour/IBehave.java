package MySim.Behaviour;

import MySim.Displayable.*;

import com.jme3.math.Vector3f;

import java.util.ArrayList;
import java.util.List;
/**
 * Interface Ibehave implemented by behaviour and behave
 * This interface will act a container for all IBehave implementations
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public interface IBehave
{
    /** METHOD : position
     * This method acts as an accessor for the position values in behaviour
     * 
     * @return rtnVal - Vector3f - public instance of the position values
     */
    Vector3f position();
    
    /** METHOD : orientation
     * This method acts as an accessor for the orientation values in behaviour
     * 
     * @return rtnVal - Vector3f - public instance of the orientation values
     */
    Vector3f orientation();
    
    /** METHOD : accelerate
     * This method acts as an accessor for the accelerate value in behaviour
     * 
     * @return rtnVal - double - public instance of the accelerate value
     */
    double accelerate();
    
    /** METHOD : scale
     * This method acts as an accessor for the scale value in behaviour
     * 
     * @return rtnVal - double - public instance of the scale value
     */
    double scale();
    
    /** METHOD : Update
     * This method acts as the update for behaviour,
     * By calling the update of diplayable instance and passing in the values
     * Position x,y,z Oreintation x,y,z Scale 
     */
    void Update();
    
    /** METHOD : Initlalise
     * This method sets the displayable instance in behaviour
     * 
     * @param Displayable - IDisplayable - Holds the displayable instance
     */
    void Initlalise(IDisplayable Displayable);
    
    /** METHOD : SetValues
     * This method sets the values needed for the behaviour class
     */
    void SetValues();
    
    /** METHOD : SetMouse
     * This method sets the values by the mouses position
     * 
     * @param pos - Vector3f - Holds the Vector3f of the mosue position
     */
    void SetMouse(Vector3f pos);
    
    /** METHOD : SetID
     * This method sets the value ID needed for the behaviour class,
     * The ID value is a string to repesent the behaviour for identification
     */
    String SetID();
    
    /** METHOD : GetFish
     * This method get a single behaviour of type IBehave
     * 
     * @param behave - IBehave - Holds the instance of a behaviour
     */
    void GetFish(IBehave behave);
    
    /** METHOD : GetFishList
     * This method gets a list of behaviours of type IBehave
     * 
     * @param behavelist - IBehave - Holds the instance of the behaviours in a list 
     */
    void GetFishList(List<IBehave> behavelist);
}
