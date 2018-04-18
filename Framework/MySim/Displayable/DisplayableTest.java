package MySim.Displayable;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DisplayableTest.
 *
 * @author  (Adam Harris)
 * @version (01)
 */
public class DisplayableTest
{
    private Displayable Disp;
    /**
     * Default constructor for test class DisplayableTest
     */
    public DisplayableTest()
    {
        Disp = new Displayable();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * METHOD: Test condition 1:
     * position(): throws an exception when invaild string or texture.
     *
     */
    @Test
    public void testCondition1() throws BondaryException
    {
        String text = "textures/javaFish/Shark.png";
        String model = "models/billboard/billboard.obj";
        boolean pass = false;
        
        // TEST if an ArgumentOutOfBoundsException is thrown when a value < 0.0:
        try
        {
            Disp.Initlalise(model, text);
        }
        catch(BondaryException e)
        {
            pass = true;
        }
        
        // TEST if an ArgumentOutOfBoundsException is thrown when a value > 1.0:
        if (!pass)
        {
            pass = false;
            text = "textures/javaFish/JavaFish.png";
            try
            {
                Disp.Initlalise(model, text);
            }
            catch(BondaryException e)
            {
                pass = true;
            }
        }
        
        if (pass)
            fail("BoundsException was not thrown");
    }
}
