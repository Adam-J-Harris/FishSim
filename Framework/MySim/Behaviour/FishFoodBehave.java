package MySim.Behaviour;

import MySim.Displayable.*;

import com.jme3.math.Vector3f;

import MySim.References.*;

import MySim.MouseInput.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class FishFoodBehave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FishFoodBehave extends Behaviour
{
    // Instance variables
    // Instance to the fish of type IBehave

    // Vector3f to hold the varibles needed to move the fish food around
    private Vector3f posVectorFishFood;
    private Vector3f oriVectorFishFood;

    // Temp var for speed to check it works
    private double Accelerate;

    // Declaring a double to set a boundary box around the fish food
    private double boundary = 0.30;

    // Feild to hold the ID of the behaviour
    private String ID;

    // Local list to hold the fish's passed into the class
    private List<IBehave> fishListF = new ArrayList<IBehave>();

    /**
     * Constructor for objects of class FishFoodBehave
     */
    public FishFoodBehave()
    {
        // initialise instance variables
        //System.out.println("FishFood");
    }

    /** METHOD : SetValues
     * This method sets the values needed for the fish food behaviour class
     */
    public void SetValues()
    {
        // Call the overrided method first
        super.SetValues();

        // Set position through accessor
        // Set rotation through accessor
        // Set speed through accessor
        posVectorFishFood = position();
        oriVectorFishFood = orientation();      
        Accelerate = accelerate();

        //System.out.println(posVectorFishFood);
        // Set the new vectors to equal the mosue click position
        posVectorFishFood.x = WorldRef.getInstance().GetWorld().getMouseX() / 80;
        posVectorFishFood.y = WorldRef.getInstance().GetWorld().getMouseY() / 80;
    } 

    /** METHOD : GetFishList
     * This method gets a list of behaviours of type IBehave
     * 
     * @param behavelist - IBehave - Holds the instance of the behaviours in a list 
     */
    public void GetFishList(List<IBehave> behavelist)
    {
        super.GetFishList(behavelist);
        // Make the local instance of the list equal the one passed through
        fishListF = behavelist;
    }

    /** METHOD : SetValues
     * This method sets the values needed for the fish food behaviour class
     */
    public String SetID()
    {
        super.SetID();
        // Set the fish food ID value
        ID = "fishfood";
        return ID;
    }

    /** METHOD : CheckCollision
     * This method checks for collision between all fish food and the fishes
     */
    public void CheckCollision()
    {
        // Loop through the list and heck to see if the fish food x is the same as the fish's x
        for(IBehave fishbehave: fishListF)
        {
            if (((fishbehave.position().getX() <= posVectorFishFood.x + (float)boundary)&&
                (fishbehave.position().getX() >= posVectorFishFood.x - (float)boundary))&&
            ((fishbehave.position().getY() <= posVectorFishFood.y + (float)boundary)&&
                (fishbehave.position().getY() >= posVectorFishFood.y - (float)boundary)))
            {
                // delete the fish food   
                WorldRef.getInstance().GetWorld().removeObject(super.SetFishDisplayable());
                WorldRef.getInstance().GetWorld().removeObject(this);
            }
        }
    }

    /** Method : Move
     * This method simulates the fish food movement
     */
    public void Move()
    {
        // Set the fish food to sink
        posVectorFishFood.y = posVectorFishFood.y - (float)Accelerate;
        // Chek to see if there has been a collision
        CheckCollision();
        // When it reaches the bottom stop sinking
        if (posVectorFishFood.y <= 0.70)
        {
            // Set speed to 0
            Accelerate = 0.0;
            // Delete the object
            WorldRef.getInstance().GetWorld().removeObject(super.SetFishDisplayable());
            WorldRef.getInstance().GetWorld().removeObject(this);
        }
    }

    /** METHOD : Update
     * This method acts as the update for the fish food behaviour,
     * By calling the update of super.instance it passing the values to the Displayable instance
     * Position x,y,z Oreintation x,y,z Scale 
     */
    public void Update()
    {  
        // Call the move method
        // Call the behaviours update
        // To pass the values back
        Move();
        super.Update();
    }
}
