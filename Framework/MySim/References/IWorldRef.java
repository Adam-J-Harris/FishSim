package MySim.References;

import MySim.Displayable.*;

import env3d.Env;
import jff5.*;
/**
 * Interface IWorldRef.
 * The container of WorldRef
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public interface IWorldRef
{
    /** Method : CreateWorld
     * This method creates the world
     */
    void CreateWorld();
    
    /** Method : DistroyWorld
     * This method distorys the world
     */
    void DistroyWorld();
    
    /** Method : UpdateWorld
     * This method updates the world
     */
    void UpdateWorld();
    
    /** Method : GetWorld
     * This method gets the world instance
     * 
     * @return world - Env - return the instance of the world
     */
    Env GetWorld();
}
