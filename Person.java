import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * The Person class. a A person can:
 * 
 *  1) move left or right based on user keypresses
 *  2) lay a trap to kill spiders
 *  3) have their own health reduced by touching a spider
 *  4) Have their own score increased by not touching a spider
 * 
 * @author Tran Nguyen
 * @version 1.80305
 */
public class Person extends Actor
{
    private Scoreboard scoreboard; //the scoreboard
    private int timeToWait; ////this variable represents the time the person has to wait before he can place the next trap.
    
    /**
     * Constructor for objects of class Person.
     * 
     * 
     */
    public Person()
    {
        timeToWait = 0; //timeToWait is initially set to 0
        
        //To make sure the person can place a trap whenever Space is pressed.
        if(Greenfoot.isKeyDown("space"))
        {
            Trap trap = new Trap();
            getWorld().addObject(trap,getX(),getY());
        } 
    }

    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld w = (MyWorld) getWorld(); //a reference to World
        Scoreboard scoreboard = w.getScoreboard(); //call the scoreboard over
        scoreboard.incScore(); //increase the score if the person is not touching the spider

        //The person moves one pixel to the left if left arrow key is pressed
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }

        //The person moves one pixel to the right if right arrow key is pressed
        if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        } 

        //If the spacebar is pressed, and there are still traps to place, and there has been at least 1000 acts since the
        //last time the person placed the other trap, then a new trap is added where the person is standing at.
        if (Greenfoot.isKeyDown("space") && (scoreboard.getTrapsLeft() != 0) && (timeToWait == 0))
        {
            Trap trap = new Trap(); //add a new trap at the person's X location and Y location
            getWorld().addObject(trap,getX(),getY());
            
            scoreboard.decTrapsLeft(); //decrease the number of traps left
            
            timeToWait = timeToWait + 1; //start counting timeToWait
        }
        
        //timeToWait adds up until it reaches 1000
        if (timeToWait > 0 && timeToWait < 1000)
        {
            timeToWait++;
            return;
        }
        else if (timeToWait == 1000) //when it reaches 1000, resets to 0, now the person can place a new trap
        {
            timeToWait = 0;
        }

        //If the person is touching a spider, his heath decreases by 1.
        if(isTouching(Spider.class))
        {
            scoreboard.decHealth();
        }

        //And when his health reaches less than or equal to 0
        if (scoreboard.getHealth() <= 0)
        {
            w.removeObject(this); //the person is removed from the World.
            w.showText("Game Over!", 400, 300); //then pops up a "Game Over!" message in the middle of World 
            
            //Start comparing current score and high score and update if needed
            if (scoreboard.getScore() > scoreboard.getHighScore())
            {
                scoreboard.setHighScore(scoreboard.getScore());
            }
        }     
    }
}