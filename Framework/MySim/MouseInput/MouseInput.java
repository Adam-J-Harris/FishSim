package MySim.MouseInput;

import env3d.Env;

import com.jme3.math.Vector3f;

import MySim.Factories.*;

/**
 * class MouseInput implements IMouseInput.
 * 
 * @author (Adam Harris) 
 * @version (0.1)
 */
public class MouseInput implements IMouseInput
{
    // instance variables - replace the example below with your own
    private static MouseInput MIInstance = null;
    
    // Declaring vector3f mousePosition to hold the mouse position
    private Vector3f mousePosition;
    
    /**
     * Constructor for objects of class MouseInput
     */
    public MouseInput()
    {
        // Setting the vector3f
        mousePosition = new Vector3f(0,0,0);
    }
    
    
    /** METHOD : getInstance
     * This funcation is the singleton pattern
     * 
     * Returns a single instance of the factory manager
     */
    public static MouseInput getInstance() 
    {
        if(MIInstance == null) 
        {
            MIInstance = new MouseInput();
        }
        return MIInstance;
    }
    
    /** Method : Check
     * This method checks if the mosue had been clicked 
     * 
     * @param env - Env - Holds the reference to the world
     */
    public void Check(Env env) throws Exception
    {      
        // IF: the left mouse button has been clicked
        if (env.getMouseButtonClicked() == 0)
        {
            // x and y equal the mouse x and y
            mousePosition.x = env.getMouseX();
            mousePosition.y = env.getMouseY();
            
            // divide by 80 to get the position on the screen
            mousePosition.x /= 80;
            mousePosition.y /= 80;
            
            // Make a fish food by calling the factory method through the factory manager
            FactoryManager.getInstance().Populate2();
        }
        //System.out.println("Check " + mousePosition);
    }
}
