package MySim.Displayable;

// importing the vector3f
import com.jme3.math.Vector3f;

/**
 * Interface IDisplayable implemented by Displayable.
 * This interface will act as a container for the displayable objects
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public interface IDisplayable
{
    /** METHOD: Update
     * 
     * Updates the entity inside of the world
     * 
     * @param MposVector - Vector3f - Holds the x,y,z position value of the behaviour
     * @param MoriVector - Vector3f - Holds the X,Y,Z orientation vaule of the behaviour
     * @param Mscale - double - Holds the scale vaule of the behaviour
     */
    void Update(Vector3f MposVector, Vector3f MoriVector, double Mscale);
    
    /** METHOD : Initlalise
     * 
     * Initlalise the displayable
     * 
     * @param DMmodel - String - Holds the model string value
     * @param DMtext - String - Holds the texture string value
     */
    public void Initlalise(String DMmodel, String DMtext)throws BondaryException;
}
