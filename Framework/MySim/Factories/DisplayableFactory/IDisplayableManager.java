package MySim.Factories.DisplayableFactory;

import MySim.Factories.IFactoryManager;
import MySim.Factories.FactoryManager;

import MySim.Displayable.*;

import java.util.ArrayList;
import java.util.List;

import MySim.References.*;
/**
 * Interface IDisplayableManager implemented by Displayable manager.
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public interface IDisplayableManager
{
    /** Method : createDisplayable
     * This method return a Displayable object
     * 
     * @param model - String - The model which you wish to use for the displayable
     * @param text - String - The texture which you wish to use for the displayable 
     * 
     * @return Displayable - IDisplayable - returns a displayable object of type IDisplayable
     */
    public IDisplayable createDisplayable(String model, String text) throws BondaryException;
    
    /** Method : sentList
     * This method returns a lsit of IDisplayables
     * 
     * @return List<IDisplayable> The list contianing all of the displayable fishes
     */
    public List sentList();    
}
