import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * A Spider simply moves up and down in the world.
 * 
 * After being placed into the world, the spider should
 * not move for a random anount of time between 25 and
 * 375 calls to it's act method. 
 * 
 * When this spider comes back to top of the world, add a 
 * new spider
 * 
 * @author Tran Nguyen 
 * @version 1.80503
 */

public class Spider extends Actor
{   
    private int timeToWait; //this variable represents the time the spider has to wait before it can start moving.
    /**
     * Constructor for objects of class Spider.
     * 
     * 
     */
    public Spider()
    {
        turn(90); //to make sure the spider always starts facing down
        
        //to make sure the spider waits a random delay from 25 to 375 calls before it starts moving.
        Random rand = new Random(); 
        timeToWait = rand.nextInt(350) + 25;
    }

    /**
     * Act - do whatever the Spider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        //This is to make sure that the spider won't move and will wait until its
        //timeToWait drops to 0.
        if (timeToWait > 0)
        {
            timeToWait = timeToWait - 1;
            return;
        }
        else if (timeToWait == 0)
        {
            move(1); //when timeToWait is 0, it moves
        }

        //When the spider touches the bottom of the World, it turns around.
        if (this.isAtEdge())
        {
            turn(180); //turn
            move(1); //and continue moving
        }

        //When the spider goes slightly below the scoreboard, it turns around again and 
        //there spawns a new spider. 
        if (this.isTouching(Scoreboard.class))
        {
            turn(180); //turn
            
            Spider spider = new Spider(); //add a new spider
            getWorld().addObject(spider, Greenfoot.getRandomNumber(796) + 2, 55);
            
            move(1); //then move
        }    
    }
}
