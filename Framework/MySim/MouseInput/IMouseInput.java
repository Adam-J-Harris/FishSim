package MySim.MouseInput;

import env3d.Env;

import com.jme3.math.Vector3f;

/**
 * Interface IMouseInput implemented by MouseInput.
 * IMouseInput is the contianer for MouseInput
 * 
 * @author (Adam Harris) 
 * @version (0.1)
 */
public interface IMouseInput
{
    /** Method : Check
     * This method checks if the mosue had been clicked 
     * 
     * @param env - Env - Holds the reference to the world
     */
    void Check(Env env) throws Exception;
}
