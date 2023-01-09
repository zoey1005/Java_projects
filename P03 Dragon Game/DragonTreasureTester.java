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
public class DragonTreasureTester {

    public static void main(String[] args) {
        boolean flag1 = testRoomInstanceMethods();
        boolean flag2 = testRoomStaticMethods();
        boolean flag3 = testPlayerCanMoveTo();
        boolean flag4 = testPlayerShouldTeleport();
        boolean flag5 = testPlayerDetectNearbyRooms();
        boolean flag6 = testDragonChangeRooms();
        System.out.print(flag1 + " " + flag2 + " " + flag3 + " " + flag4 + " " + flag5 + " "+ flag6);
    }
    /**
     * test the all the static methods of Class Room
     * @return while passing all the static methods, return true; otherwise, return false
     */
    public static boolean testRoomStaticMethods(){
        Room.assignTeleportLocation(2);
        int teleportationRoom = Room.getTeleportationRoom();
        if (teleportationRoom != 2){
            return false;
        }
        if (Room.getTreasureWarning().equals("")){
            return false;
        }
        if (Room.getPortalWarning().equals("")){
            return false;
        }
        return true;
    }
    /**
     * test all the instance methods of Class Room
     * @return while passing all the instance methods, return true; otherwise, return false
     */
    public static boolean testRoomInstanceMethods(){
      try {
          Room room = new Room(1,"START");
          room.setRoomType(RoomType.START);
          RoomType type = room.getType();
          if (type == null){
              System.out.println("method getType wrong");
          }
          if (room.getID() == 0){
              System.out.println("method getID wrong");
          }
          Room room2 = new Room(2,"NORMAL");
          room.addToAdjacentRooms(room2);
          if (room.getAdjacentRooms().size() == 0){
              System.out.println("method getAdjacentRooms wrong");
          }
          String roomDescription = room.getRoomDescription();
          if (roomDescription.equals("")){
              System.out.println("method getRoomDescription wrong");
          }
          if (!room.isAdjacent(room2)){
              System.out.println("method isAdjacent wrong");
          }
      }catch (Exception e){
          e.printStackTrace();
          return false;
      }
      return true;
  }
    /**
     * Test the CanMoveTo methods of Class Player
     * @return while passing CanMoveTo methods, return true; otherwise, return false
     */
    public static boolean testPlayerCanMoveTo(){
        Room room1 = new Room(1,"START");
        Room room2 = new Room(2,"NORMAL");
        room1.addToAdjacentRooms(room2);
        Player player = new Player(room1);
        return player.canMoveTo(room2);
    }
    /**
     * Test the PlayerShouldTeleport method of Class Player
     * @return while passing PlayerShouldTeleport methods, return true; otherwise, return false
     */
    public static boolean testPlayerShouldTeleport(){
        Room room1 = new Room(1,"START");
        Room room2 = new Room(2,"PORTAL");
        room1.addToAdjacentRooms(room2);
        room2.setRoomType(RoomType.PORTAL);
        Player player = new Player(room1);
        player.canMoveTo(room2);
        return player.shouldTeleport();
    }
    /**
     * Test the DetectNearbyRooms method of Class Player
     * @return while passing DetectNearbyRooms methods, return true; otherwise, return false
     */
    public static boolean testPlayerDetectNearbyRooms(){
        Room room1 = new Room(1,"START");
        Room room2 = new Room(2,"PORTAL");
        Room room3 = new Room(3,"TREASURE");
        room2.setRoomType(RoomType.PORTAL);
        room3.setRoomType(RoomType.TREASURE);
        room1.addToAdjacentRooms(room2);
        room1.addToAdjacentRooms(room3);
        Player player = new Player(room1);
        boolean portalNearby = player.isPortalNearby();
        boolean treasureNearby = player.isTreasureNearby();
        return portalNearby || treasureNearby;
    }
    /**
     *  Test the ChangeRooms method of Class Dragon
     * @return while successfully changing the room, return true; otherwise, return false
     */
    public static boolean testDragonChangeRooms(){
        Room room = new Room(1, "TREASURE");
        Dragon dragon = new Dragon(room);
        Room room1 = new Room(2, "NORMAL");
        Room room2 = new Room(3, "NORMAL");
        Room room3 = new Room(4, "NORMAL");
        room.addToAdjacentRooms(room1);
        room.addToAdjacentRooms(room2);
        room.addToAdjacentRooms(room3);
        dragon.changeRooms();
        if (!dragon.getCurrentRoom().equals(room)){
            return true;
        }
        return false;
    }
}
