package MySim.Displayable;


/**
 * class BondaryException.
 * Used to flag when a parameter is outside the defined range of values.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BondaryException extends Exception
{
    /**
     * Constructor for objects of class BondaryException
     */
    public BondaryException(String message)
    {
        // initialise instance variables
        super(message);
    }
}
