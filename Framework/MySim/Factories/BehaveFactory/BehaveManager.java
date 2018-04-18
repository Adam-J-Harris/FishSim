package MySim.Factories.BehaveFactory;

import MySim.Factories.IFactoryManager;
import MySim.Factories.FactoryManager;

import MySim.Displayable.*;

import MySim.Behaviour.*;

import java.util.ArrayList;
import java.util.List;

/**
 * BehaveManager implements IBehaveManager.
 * BehaveManager creates the behaviours for the displayable objects
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class BehaveManager implements IBehaveManager
{
    // Instance variables
    
    // Declaring the singleton instance of teh behavour manager
    private static BehaveManager BMInstance = null;
    
    // Declaring the local list instance of type IBehave
    private List<IBehave> _behave;
    
    
    /**
     * Constructor for objects of class BehaveManager
     */
    public BehaveManager()
    {
        // initialise instance variables
        // Initialise the local list of behaviours
        _behave = new ArrayList<IBehave>();
    }
    
    
    /** METHOD : getInstance
     * This funcation is the singleton pattern
     * 
     * Returns a single instance of the factory manager
     */
    public static BehaveManager getInstance() 
    {
        if(BMInstance == null) 
        {
            BMInstance = new BehaveManager();
        }
        return BMInstance;
    }
    
    /** Method : createBehave
     * This is a generic method that returns any behaviour of type IBehave
     * 
     * @param classRef - Class<T> - Specify the class you wish to make
     * @param Displayable - IDisplayable -  Pass the Displayable you wish to make a behaviour of
     * 
     * @return <T> - IBehave - returns T which is any behaviour class that implements IBehave
     */
    public <T extends IBehave> IBehave CreateBehave(Class<T> classRef, IDisplayable Displayable) throws Exception
    { 
        // Create a new behaviour of type IBehave
        // Make that behaviour equal the specified class type
        IBehave newBehave = classRef.newInstance();
        
        // Call the inilalise method and pass the displayable
        newBehave.Initlalise(Displayable);
        // Call the set values method
        newBehave.SetValues();
        // Call the set ID method
        newBehave.SetID();
        
        // Add behaviour to list of IBehaves
        _behave.add(newBehave);
           
        // code to return the behaviour
        return newBehave;
    }
    
    /** Method : Update
     * This method updates all of the behaviours that have been created,
     * By running through a loop whihc contains the list of behaviours
     */
    public void Update()
    {
        // Loop through all behaviours in the lsit and call there update method
        for (IBehave behave : _behave)
        {
             behave.Update();
        }             
    }
}
