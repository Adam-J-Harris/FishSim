package MySim.Factories.BehaveFactory;

import MySim.Factories.IFactoryManager;
import MySim.Factories.FactoryManager;

import MySim.Displayable.*;

import MySim.Behaviour.*;

/**
 * Interface IBehaveManager implemented by IBehaveManager.
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public interface IBehaveManager
{
    /** Method : createBehave
     * This is a generic method that returns any behaviour of type IBehave
     * 
     * @param classRef - Class<T> - Specify the class you wish to make
     * @param Displayable - IDisplayable -  Pass the Displayable you wish to make a behaviour of
     * 
     * @return <T> - IBehave - returns T which is any behaviour class that implements IBehave
     */
    public <T extends IBehave> IBehave CreateBehave(Class<T> classRef, IDisplayable Displayable) throws Exception;
    
    /** Method : Update
     * This method updates all of the behaviours that have been created,
     * By running through a loop whihc contains the list of behaviours
     */
    public void Update();
}
