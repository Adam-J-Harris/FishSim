package MySim.Factories.DisplayableFactory;

import MySim.Factories.IFactoryManager;
import MySim.Factories.FactoryManager;

import MySim.Displayable.*;

import java.util.ArrayList;
import java.util.List;

import MySim.References.*;
/**
 * DisplayableManager implements IDisplayableManager
 * DisplayableManager creates the displayable objects
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class DisplayableManager implements IDisplayableManager
{
    // Instance variables

    // Declaring the singleton instance of the displayable manager 
    private static DisplayableManager DMInstance = null;

    // Declaring a local list instance of type IDisplayable
    private List<IDisplayable> _displayable;

    /**
     * Constructor for objects of class DisplayableManager
     */
    public DisplayableManager()
    {
        // Initialise instance variables
        // Initialise the local list
        _displayable = new ArrayList<IDisplayable>();
    }

    /** METHOD : getInstance
     * This funcation is the singleton pattern
     * 
     * Returns a single instance of the factory manager
     */
    public static DisplayableManager getInstance() 
    {
        if(DMInstance == null) 
        {
            DMInstance = new DisplayableManager();
        }
        return DMInstance;
    }

    // Factory method
    /** Method : createDisplayable
     * This method return a Displayable object
     * 
     * @param model - String - The model which you wish to use for the displayable
     * @param text - String - The texture which you wish to use for the displayable 
     * 
     * @return Displayable - IDisplayable - returns a displayable object of type IDisplayable
     */
    public IDisplayable createDisplayable(String model, String text) throws BondaryException
    {
        // Create a displayable obejct of type IDisplayable
        IDisplayable newDisplayable = new Displayable();

        // Call the objects initlalise funcation and pass the paramters
        newDisplayable.Initlalise(model, text);

        // Add object to the list
        _displayable.add(newDisplayable);

        // Add the object to the world
        WorldRef.getInstance().GetWorld().addObject(newDisplayable);

        // code to return the object
        return newDisplayable;
    }

    /** Method : sentList
     * This method returns a lsit of IDisplayables
     * 
     * @return List<IDisplayable> The list contianing all of the displayable fishes
     */
    public List sentList()
    {
        // code to return the list of displayables
        return _displayable;
    }
}
