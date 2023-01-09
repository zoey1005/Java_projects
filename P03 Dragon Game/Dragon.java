//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Dragon Treasure Adventure
// Course:   CS 300 Fall 2022
//
// Author:   Zhuoyu Jiang
// Email:    zjiang299@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    None
// Partner Email:  None
// Partner Lecturer's Name: None
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X__ Write-up states that pair programming is allowed for this assignment.
//   _X__ We have both read and understand the course Pair Programming Policy.
//   _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:        None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * This class models the moving dragon and handles control flow and game logic
 */
import java.util.Random;

public class Dragon {

    private Room currentRoom; //current location of the dragon
    private Random randGen; //random num generator used for moving
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";

    public Dragon(Room currentRoom){
        this.currentRoom = currentRoom;
        this.randGen = new Random();
    }
    public Dragon(Room currentRoom , Random randGen){
      this.currentRoom = currentRoom;
      this.randGen = randGen;
    }
    /**
     * getter of the current room
     * @return the current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    /**
     * check if the dragon could move to the pointed room 
     * 
     */
    public void changeRooms(){
        randGen = new Random();
        int randNum = randGen.nextInt(13);
        Room currentRoom = getCurrentRoom();
        ArrayList<Room> adjacentRooms = currentRoom.getAdjacentRooms();
        for (Room room : adjacentRooms){
            if (room.getID() == randNum && room.getType() != RoomType.START
                && room.getType() != RoomType.PORTAL){
                this.currentRoom = room;
            } else {
              this.currentRoom = adjacentRooms.get(randGen.nextInt(adjacentRooms.size()));
          }
        }
    }
    /**
     * get the warning message
     * @return warning message
     */
    public static String getDragonWarning(){
        return DRAGON_WARNING;
    }
}
