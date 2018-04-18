package MySim.Factories;

import MySim.Factories.DisplayableFactory.*;
import MySim.Factories.BehaveFactory.*;


/**
 * Interface IFactoryManager implemented by FactoryManager.
 * 
 * All funactions in this interface can be called through the singleton instance
 * 
 * @author (Adam Harris) 
 * @version (01)
 */
public interface IFactoryManager
{

    /** METHOD : Populate
     * This method creates all the start up displayables and behaviours by calling the factory methods,
     *  displayableFactory.CreateDisplayable() & behaveFactory.CreateBehave(),
     *  They are then linked together by these method.
     */
    public void Populate() throws Exception;
    
    /** METHOD : Populate2
     * This method creates a single displayable object by calling the factory methods,
     * displayableFactory.CreateDisplayable() & behaveFactory.CreateBehave(),
     * They are then linked together by these method.
     */
    public void Populate2() throws Exception;
    
    /** METHOD : Update
     * This method updates the all of the behaviours that get created,
     * The update is a call to the behaveFactory.Update() funcation,
     * This update contians a list of every behaviour that gets cerated.
     */
    public void Update();
    
    /** METHOD : DMGetList
     * This method gets the list of displayables that are being created,
     * The funcation calls a method displayableFactory.SentList(),
     * This call sends the list of diaplaybles to the factory manager.
     */
    public void DMGetList();
    
}
