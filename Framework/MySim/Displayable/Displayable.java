package MySim.Displayable;

// importing the vector3f
import com.jme3.math.Vector3f;
/**
 * Class Displayable implements IDisplayable.
 * A Displayable contains all of the features needed for it to be visable
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class Displayable implements IDisplayable
{
    // Instance variables
    // All required vars for a displayable to be visable
    
    /*
     * Model
     * Texture
     * Scale
     * Tranprantce
     * Position between x 1 - 9 and y 1 - 7;
     * Rotation will be different for some of the fish
     */
    
    // private vector3f 
    // This will require the import com.jme3.math.vectorf3
    // This will replace the env3d double vaules
    
    // Testing ref
    
    //Accessors and getters for behave
    //Position and rotation
    
    // reference to the 3D model:
    private String model = "models/billboard/billboard.obj";
    
    // scale factor to be applied to model:
    private double scale = 0.25;
    
    // reference to the image to be used as the texture-map (initialise to something sensible):
    private String texture = "textures/javaFish/JavaFish.png";
    
    // transparency flag - set to true:
    private boolean transparent = true;
    
    // position in to be placed at in 3D world (x,y,z coordinates):
    private double x = 1.0, y = 1.0, z = 1.0;
    
    // orientation to be placed at in 3D world (about x,y,z):
    private double rotateX = 0, rotateY = 90, rotateZ = 0;
    

    /**
     * Constructor for objects of class Displayable
     */
    public Displayable()
    {
        // initialise instance variables                
    }
    
    /** METHOD : Initlalise
     * This funcation initlalises the texture and model
     * 
     * @param DMmodel - String - Holds the model string value
     * @param DMtext - String - Holds the texture string value
     */
    public void Initlalise(String DMmodel, String DMtext)throws BondaryException
    {
        // make the parameters equal the local varibles
        if((DMmodel == "models/billboard/billboard.obj") || 
            (DMmodel == "sphere") &&
            (DMtext == "textures/javaFish/JavaFish.png") ||
            (DMtext == "textures/javaFish/Urchin.png") ||
            (DMtext == "textures/javaFish/OrangeFish.png") ||
            (DMtext == "textures/javaFish/Bubble.png") ||
            (DMtext == "textures/javaFish/seahorse.png") ||
            (DMtext == "textures/javaFish/Piranha.png") ||
            (DMtext == "textures/javaFish/FishFood.png"))
            {
                 model = DMmodel;
                 texture = DMtext;
            }
            else 
            {
                throw new BondaryException("The scale or texture is invaild");
            }
       
    }
    
    /** Method : Update
     * 
     * Updates the entity inside of the world
     * 
     * @param MposVector - Vector3f - Holds the x,y,z position value of the behaviour
     * @param MoriVector - Vector3f - Holds the X,Y,Z orientation vaule of the behaviour
     * @param Mscale - double - Holds the scale vaule of the behaviour
     */
    public void Update(Vector3f MposVector, Vector3f MoriVector, double Mscale)
    {
        // Make the parameters equal the local varibles 
        x = (double)MposVector.x;
        y = (double)MposVector.y;
        z = (double)MposVector.z;
        
        rotateX = (double)MoriVector.x;
        rotateY = (double)MoriVector.y;
        rotateZ = (double)MoriVector.z;
        
        scale = Mscale;
    }
}
