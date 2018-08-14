import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Trap class should remove the first five spiders that
 * touch it, and then remove itself from the World.
 * 
 * @author Tran Nguyen
 * @version 1.80305
 */
public class Trap extends Actor
{
    private int cankill; //this indicates the number of spiders this trap can still kill
    private MyWorld w; //a reference to World
    /**
     * Constructor for objects of class Trap.
     *
     */
    public Trap ()
    {
        cankill = 5; //the number of spiders that this trap can kill is initially set to 5.
    }

     /**
     * Act - do whatever the Trap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //get a reference to World
        MyWorld w = (MyWorld) getWorld();
        
        //Unless there is only one spider in the world 
        if (w.getSpiderCount() != 1 )
        {
            if (isTouching(Spider.class)) 
            {
                removeTouching(Spider.class); //kill the spider
                cankill --; //trap can kill one less spider now
            }
        }
        //but if there is only one spider left
        else if (w.getSpiderCount() == 1 )
        {
            removeTouching(Trap.class); //then ignore the spider, don't kill it
        }

        //If the trap can no longer kill spiders
        if (cankill == 0)
        {
            w.removeObject(this); //remove it from World, because it's useless now
        }
    }
}