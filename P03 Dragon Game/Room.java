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

public class Room {

    private RoomType type; //one of the four types a room could be
    private String roomDescription; //a brief description of the room
    private ArrayList<Room> adjRooms; //arraylist that holds the rooms adjacent
    private final int ID; //unique ID for each room to identify it
    private static int teleportLocationID; //place where all portal rooms will go to
    private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";

    /**
     * 
     * @param id
     * @param roomDescription
     */
    public Room(int id, String roomDescription){
        ID = id;
        this.roomDescription = roomDescription;
        this.type = RoomType.NORMAL;
        this.adjRooms = new ArrayList<>();
    }

    /**
     * Getter for the type instance field
     * @return this object's RoomType
     */
    public RoomType getType() {
        return type;
    }

    /**
     * Getter for the id instance field
     * @return this object's id
     */
    public int getID(){
        return ID;
    }

    /**
     * Getter for the adjRooms instance field
     * @return this object's list of rooms adjacent to it
     */
    public ArrayList<Room> getAdjacentRooms(){
        return adjRooms;
    }

    /**
     * Takes the given room and adds it to this object's list of adjacent rooms
     * @param toAdd  room to be added to the adjacent rooms list
     */
    public void addToAdjacentRooms(Room toAdd){
        if (adjRooms == null){
            adjRooms = new ArrayList<>();
        }
        adjRooms.add(toAdd);
    }

    /**
     * Getter for the description instance field
     * @return this object's description
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * Changes this objects type to the roomtype given
     * @param type The new roomtype of this Room object.
     */
    public void setRoomType(RoomType type) {
        this.type = type;
    }

    /**
     * Sets the class field teleportLocation to the int given.
     * @param teleportID  the id of the room where all portals should teleport to
     */
    public static void assignTeleportLocation(int teleportID){
        Room.teleportLocationID = teleportID;
    }

    /**
     * Returns the string that is the room class's portal warning, 
     * indicating that there is one nearby.
     * @return The portal warning message string
     */
    public static String getPortalWarning(){
        return PORTAL_WARNING;
    }

    /**
     * Returns the string that is the room class's treasure warning, 
     * indicating that the treasure room nearby.
     * @return The treasure warning message string
     */
    public static String getTreasureWarning(){
        return TREASURE_WARNING;
    }

    /**
     * Returns the id of the room where all portals will teleport to.
     * @return the id of the teleportLocation room
     */
    public static int getTeleportationRoom(){
        return teleportLocationID;
    }
    
    /**
     * Checks whether this given room is adjacent to this one or not.
     * @param r The room that you are seeing if it is adjacent to this.
     * @return true if they are adjacent, false otherwise
     */
    public boolean isAdjacent(Room r){
        return this.adjRooms.contains(r);
    }


    
    @Override
    public boolean equals(Object other) {
        if (other instanceof Room){
            Room otherRoom = (Room) other;
            return this.ID == otherRoom.ID;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String s = this.ID +": " + this.roomDescription+ " (" + type +")\n Adjacent Rooms: ";
        for(int i = 0; i<adjRooms.size(); i++){
            s+= adjRooms.get(i).ID +" ";
        }
        return s;
    }
}
