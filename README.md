# java-spider-game

Programming project #1 for Computer Science I 


<b> Objectives: </b>

• writing a Greenfoot application on my own

• working in an object-oriented environment

• designing and coding your own methods

• utilizing selective execution


<b> Problem Statement: </b>

Five Greenfoot (sub)classes (MyWorld, Spider, Trap and Person and Scoreboard). Together, these classes will enable player to play a game where a person avoids spiders and places traps to kill spiders.

<b> Summary: </b>

Each game starts with one spider spawns facing down randomly and is set up to wait a random delay of between 25 to 375 calls to act before it starts moving. When this spider has moved to the bottom of the world, it will turn around. When this spider has moved back up to just barely underneath the World’s scoreboard, another spider will spawn.

A trap can kill spiders and can be placed by pressing "space". Any one trap can only kill 5 spiders. Traps do not move and cannot kill the last spider left in the world.

A person is the ”player” in the game that the user controls. It can move left or right, place traps, score points, and have its health depleted. When a person’s health becomes 0, the game is over, a “Game over” message will appear in the middle of the World. If the current score is more than the high score in the scoreboard, the high score in the scoreboard will be updated. 
