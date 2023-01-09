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

public class Player {

    private Room currentRoom; 
    /**
     * Constructor for a player object. Assigns values to all non-static fields.
     * Current location of the player
     * @param currentRoom the current location of the player
     */
    public Player(Room currentRoom){
        this.currentRoom = currentRoom;
    }
    /**
     * Getter for the current room in Class Player.
     * @return The current location of the player
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    /**
     * Setter for the current room in Class Player.
     * @param newRoom the location that the player is moving to
     */
    public void changeRoom(Room newRoom){
        this.currentRoom = newRoom;
    }
    /**
     * Determines whether or not the player can move to the given destination room. 
     * A valid player move is ONLY to adjacent rooms.
     * @param destination room player wants to move to
     * @return true if it is a valid movement; otherwise return false
     */
    
    public boolean canMoveTo(Room destination){
        ArrayList<Room> adjacentRooms = this.currentRoom.getAdjacentRooms();
        if (adjacentRooms.contains(destination)){
            changeRoom(destination);
            return true;
        }
        return false;
    }
    /**
     * Determines whether or not the player needs to teleport. 
     * Players teleport when their current room is of type PORTAL
     * @return true if they should teleport; otherwise return false
     */
    public boolean shouldTeleport(){
        Room currentRoom = this.currentRoom;
        if (currentRoom.getType() == RoomType.PORTAL){
            return true;
        }
        return false;
    }
    /**
     * Gets the list of rooms adjacent to where the player is currently at.
     * @return list of rooms adjacent to the current room
     */
    public ArrayList<Room> getAdjacentRoomsToPlayer(){
        ArrayList<Room> adjacentRooms = this.getCurrentRoom().getAdjacentRooms();
        return adjacentRooms;
    }

    /**
     * Determines whether or not the given dragon is in a nearby room.
     * @param d  the dragon to check if nearby
     * @return true if the dragon is nearby, false otherwise
     */
    public boolean isDragonNearby(Dragon d){
        return d.getCurrentRoom().equals(this.currentRoom);
    }

    /**
     * Determines whether or not a portal room is in a nearby room.
     * @return true if a portal room is nearby, false otherwise
     */
    public boolean isPortalNearby(){
        ArrayList<Room> adjacentRoomsToPlayer = getAdjacentRoomsToPlayer();
        for (Room room : adjacentRoomsToPlayer){
            if (room.getType() == RoomType.PORTAL){
                return true;
            }
        }
        return false;
    }

    /**
     * Determines whether or not the treasure room is in a nearby room.
     * @return true if the treasure room is nearby, false otherwise
     */
    public boolean isTreasureNearby(){
        ArrayList<Room> adjacentRoomsToPlayer = getAdjacentRoomsToPlayer();
        for (Room room : adjacentRoomsToPlayer){
            if (room.getType() == RoomType.TREASURE){
                return true;
            }
        }
        return false;
    }
}
