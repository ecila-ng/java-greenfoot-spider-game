import greenfoot.*;  // (World, Actor,  GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World for CSC14400 Project#1 (Spring 2018)
 * 
 * @author Stephen Blythe, Tran Nguyen
 * @version 1/2018
 */
public class MyWorld extends World
{ 
    private Scoreboard scoreboard; //the scoreboard
    private Person person; //the person
    private Spider spider; //the spider

    /**
     * Constructor for objects of class MyWorld.
     * 
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        //Create a scoreboard centered at the top of the screen
        Scoreboard scoreboard = new Scoreboard();
        addObject(scoreboard, 400, 10);

        //Create a person and put him at the bottom left of the World
        Person person = new Person();
        addObject(person, 15, 575);

        //Create the first spider at the top of the World, slighly below the
        //scoreboard. Its X location is set randomly from 2 to 798 to avoid the 
        //spider getting stuck between the scoreboard border and the edge of the
        //World.
        Spider spider = new Spider();
        addObject(spider, Greenfoot.getRandomNumber(796) + 2, 55);

        //Prepare the World 
        prepare(); 
    }

    /**
     * returns the scoreboard that was added by the constructor.
     *
     * @return the scoreboard.
     */ 
    public Scoreboard getScoreboard()
    {
        return scoreboard; //return the scoreboard added.
    }

    /**
     * returns the number of spiders found in the World.
     * 
     * @return number of spiders found. 
     */
    public int getSpiderCount()
    {
        // get list of all spiders and return count found
        //   inside of that list.
        return getObjects(Spider.class).size();
    }

    /** 
     * removes all Spider objects from the world. 
     */
    public void removeAllSpiders()
    {
        // get list of all spiders and remove each
        //   spider inside of that list
        removeObjects(getObjects(Spider.class));
    }

    /** 
     * removes all Trap objects from the world. 
     */
    public void removeAllTraps()
    {
        // get list of all spiders and remove each
        //   spider inside of that list
        removeObjects(getObjects(Trap.class));
    }

    /**
     * yes! a World can have an act() method, too. 
     * It might just check to see if a key has been
     * pressed, etc...
     */

    public void act()
    {
        if(Greenfoot.isKeyDown("n") && (scoreboard.getHealth() == 0))
        { 
            removeAllSpiders(); //remove all of the spiders in the World.
            removeAllTraps(); // remove all of the traps in the World.

            scoreboard.setScore(0); //reset the scoreboard's score to 0.
            scoreboard.setHealth(100); //reset the scoreboard's health to 100.
            scoreboard.setTrapsLeft(3); //reset the scoreboard's number of traps left to 3.

            Person person = new Person(); //add a new person to the bottom left of the World.
            addObject(person, 15, 575);

            //add the first spider at the top of the World, slighly below the
            //scoreboard. Again, its X location is set randomly from 2 to 798
            //to avoid getting stuck.
            Spider spider = new Spider();
            addObject(spider, Greenfoot.getRandomNumber(796) + 2, 55);

            showText(" ", 400, 300); //overwrite the "Game over" message with blank spaces.
        } 
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    private void prepare()
    {
        scoreboard = new Scoreboard(); //the scoreboard is initialy added at the centered top.
        addObject(scoreboard, 400, 10);

    }  
}