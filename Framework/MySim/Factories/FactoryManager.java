package MySim.Factories;

import MySim.Factories.DisplayableFactory.*;
import MySim.Factories.BehaveFactory.*;

import MySim.Displayable.*;
import MySim.Behaviour.*;

import MySim.References.*;

import java.util.ArrayList;
import java.util.List;

import com.jme3.math.Vector3f;
/**
 * FactoryManager implements IFactoryManager.
 * FactoryManager is the higher level access of the factories provided.
 * 
 * Facade Pattern
 * Singleton
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public class FactoryManager implements IFactoryManager
{
    // Singleton instance of the factory manager
    private static FactoryManager FMInstance = null;
    
    // Declaring FB, BB, JF of type IBehave
    // FB for fish behaviour 
    // BB for bubble behaviour
    // JF for javafish behaviour
    private IBehave FB;
    private IBehave BB;
    private IBehave JF;
    
    // Declaring local instance of diaplay & behave factories
    private IDisplayableManager DMInstance;
    private IBehaveManager BMInstance;
    
    // Declaring and initialising a list for all displayable behaviours
    private List<IBehave> DisplayableList = new ArrayList<IBehave>();

    // Declaring and initialising a list for only javafish displayable behaviours
    private List<IBehave> JavaList = new ArrayList<IBehave>();

    /**
     * Constructor for objects of class FactoryManager
     */
    private FactoryManager()
    {
        // initialise instance variables
        
        // Initialising the local instance of display & behave manager
        DMInstance = DisplayableManager.getInstance();
        BMInstance = BehaveManager.getInstance();
    }

    /** METHOD : getInstance
     * This funcation is the singleton pattern
     * 
     * Returns a single instance of the factory manager
     */
    public static FactoryManager getInstance() 
    {
        // IF: the instance of factory manager is equal to null
        if(FMInstance == null) 
        {
            // Create the instnace of the factory manager.
            FMInstance = new FactoryManager();
        }
        // ELSE: the instance is returned
        return FMInstance;
    }

    /** METHOD : Populate
     * This method calls the two factory methods using the local instances,
     * Which creates the displayables and behaviours for the simulation
     */
    public void Populate() throws Exception
    {
        // Loop through the factory methods to create a single displayable and assign it a behaviour,
        // This is could be considered bad design as you might only need one behaviour to be created,
        // This loop creates 10 java fish displayables and 10 java fish behaviours.
        for (int i = 0; i < 10; i++)
        {
            // Create a displayable through the factory and pass the correct string for model and texture for a javafish
            IDisplayable displayableJava = DMInstance.createDisplayable("models/billboard/billboard.obj","textures/javaFish/JavaFish.png");
            // Create a behaviour through the factory and pass the correct displayable object
            JF = BMInstance.CreateBehave(JavaFishBehave.class, displayableJava);
            
            // Add the nealy created javafish behaviour to the javafish list and the displayable list
            JavaList.add(JF);
            DisplayableList.add(JF);
            
            // Create a displayable through the factory and pass the correct string for model and texture for a bubble
            IDisplayable displayableBubble = DMInstance.createDisplayable("sphere","textures/javaFish/Bubble.png");
            // Create a behaviour through the factory and pass the correct displayable object
            BB = BMInstance.CreateBehave(BubbleBehave.class, displayableBubble);
            
            // Add the nealy created javafish behaviour to the bubble behaviour
            BB.GetFish(JF);
        }

         // This loop creates 3 seahorse displayables and 3 seahorse behaviours.
        for(int i = 10; i < 13; i++)
        {
            IDisplayable displayableSeahorse = DMInstance.createDisplayable("models/billboard/billboard.obj","textures/javaFish/SeaHorse.png");
            FB = BMInstance.CreateBehave(SeahorseBehave.class, displayableSeahorse);
            
            DisplayableList.add(FB);
            
            IDisplayable displayableBubble = DMInstance.createDisplayable("sphere","textures/javaFish/Bubble.png");
            BB = BMInstance.CreateBehave(BubbleBehave.class, displayableBubble);
            
            BB.GetFish(FB);
        }

         // This loop creates 2 prianha displayables and 2 prianha behaviours.
        for (int i = 13; i < 15; i++)
        {
            IDisplayable displayablePiranha = DMInstance.createDisplayable("models/billboard/billboard.obj","textures/javaFish/Piranha1.png");
            FB = BMInstance.CreateBehave(PiranhaBehave.class, displayablePiranha);
            
            DisplayableList.add(FB);
            
            IDisplayable displayableBubble = DMInstance.createDisplayable("sphere","textures/javaFish/Bubble.png");
            BB = BMInstance.CreateBehave(BubbleBehave.class, displayableBubble);
            
            BB.GetFish(FB);
            
            // Add teh nealy created java fish behaviours to the piranha
            FB.GetFishList(JavaList);
        }

         // This loop creates 3 orange fish displayables and 3 orange fish behaviours.
        for (int i = 15; i < 18; i++)
        {
            IDisplayable displayableOrange = DMInstance.createDisplayable("models/billboard/billboard.obj","textures/javaFish/OrangeFish.png");
            FB = BMInstance.CreateBehave(OrangeFishBehave.class, displayableOrange);
            
            DisplayableList.add(FB);
            
            IDisplayable displayableBubble = DMInstance.createDisplayable("sphere","textures/javaFish/Bubble.png");
            BB = BMInstance.CreateBehave(BubbleBehave.class, displayableBubble);
            
            BB.GetFish(FB);
        }

         // This loop creates 2 urchin displayables and 2 urchin behaviours.
        for(int i = 18; i < 20; i++)
        {
            IDisplayable displayableUrchin = DMInstance.createDisplayable("models/billboard/billboard.obj","textures/javaFish/Urchin.png");
            FB = BMInstance.CreateBehave(UrhcinBehave.class, displayableUrchin);
            
            DisplayableList.add(FB);
        }
        
        // Overall 20 fish are created in this aquriuam
    }

    /** METHOD : Populate 2
     * This method calls the two factory methods using the local instances,
     * Which creates the displayables and behaviours for the simulation,
     */
    public void Populate2() throws Exception
    {
        // Once the funcation is called by the simulation, call the factory methods to create a single displayable and assign it a behaviour,
        // This is could be considered bad design as you might only need one behaviour to be created,
        // This call creates 1 fish food displayables and 1 fish food behaviours.
        IDisplayable displayableFishFood = DMInstance.createDisplayable("sphere","textures/javaFish/FishFood.png");
        FB = BMInstance.CreateBehave(FishFoodBehave.class, displayableFishFood);
        
        // Add the behaviours of every fish to the fish food behaviour.
        FB.GetFishList(DisplayableList);
    }

    /** METHOD : DMGetList
     * This method makes a call to the displayable factory, 
     * Which revices the list of displayables
     * 
     */
    public void DMGetList()
    { 
        // Recive the list of displayables
        DMInstance.sentList();
        //System.out.println(DMInstance.sentList());
    }

    /** METHOD : Update
     * This method makes a call to the update of behaviour manager
     * That update then loops through the list of behaviours and calls there update
     * 
     */
    public void Update()
    {
        // Call the behaviour factory update funcation
        BMInstance.Update();
    }
}
