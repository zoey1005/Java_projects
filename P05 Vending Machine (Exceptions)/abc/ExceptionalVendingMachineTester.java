//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P04 Exceptional Vending Machine
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


// TODO import relevant exceptions here

import java.io.File;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

/**
 * This class implements testers to check the correctness of the methods implemented in p04
 * Exceptional Vending Machine
 *
 */
public class ExceptionalVendingMachineTester {
  // TODO complete the implementation of all the public static tester methods defined below

  // It is recommended but NOT required to add additional tester methods to check the correctness
  // of loadItems and saveVendingMachineSumary defined in the ExceptionalVendingMachine class.

  /**
   * Checks the correctness of the constructor of the class Item when passed invalid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorNotValidInput() {
    try{
      ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(0);
    }catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the constructor of the class Item, Item.getDescription(),
   * Item.getExpirationDate(), Item.setDescription(), and Item.toString() when passed valid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorGettersSetters() {
    try {
      Item item = new Item("coke",5);
      System.out.println(item.getDescription());
      System.out.println(item.getExpirationDate());
      System.out.println(item.toString());
      item.setDescription("");
    }catch (IllegalArgumentException e){
      return false;
    }
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the Item.equals() method. You should consider at least the following
   * four scenarios. (1) Create an item with valid description and expiration date, comparing it to
   * itself should return true. (2) Two items having the same description but different expiration
   * dates should be equal. (3) Passing a null reference to the Item.equals() method should return
   * false. (4) An item MUST NOT be equal to an object NOT instance of the class Item, for instance
   * a string object.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemEquals() {
    Item item1 = new Item("coke",4);
    Item item2 = new Item("coke",3);
    if (!item1.equals(item1)){
      return false;
    }
    if (!item1.equals(item2)){
      return false;
    }
    if (item1.equals("")){
      return false;
    }
    if (item1.equals("123")){
      return false;
    }
    return true; // default return statement added to resolve compiler errors
  }


  /**
   * Checks the correctness of the constructor of the ExceptionalVendingMachine when passed invalid
   * input
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineConstructor() {
    try {
      ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(0);
    }catch (IllegalArgumentException e){
      return false;
    }
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the following methods defined in the ExceptionalVendingMachine class
   * when an exception is expected to be thrown:
   * 
   * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(), getItemOccurrences(),
   * getItemOccurrencesByExpirationDate(), removeNextItem().
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {
    ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(5);
    try {
      exceptionalVendingMachine.addItem("coke",4);
      exceptionalVendingMachine.addItem("fish",4);
      exceptionalVendingMachine.addItem("coke",1);
      exceptionalVendingMachine.addItem("hamburger",4);
      exceptionalVendingMachine.addItem("cookie",4);
      System.out.println("contains fish: " + exceptionalVendingMachine.containsItem("fish"));
      System.out.println("get coke next index: " + exceptionalVendingMachine.getIndexNextItem("coke"));
      System.out.println("get item at index 1: " + exceptionalVendingMachine.getItemAtIndex(1));
      System.out.println("get Item Occurrences: " + exceptionalVendingMachine.getItemOccurrences("hamburger"));
      System.out.println("getItemOccurrencesByExpirationDate: " + exceptionalVendingMachine.getItemOccurrencesByExpirationDate("coke",4));
      System.out.println("remove next item: " + exceptionalVendingMachine.removeNextItem("coke"));
    }catch (IllegalArgumentException | IllegalStateException  | IndexOutOfBoundsException | NoSuchElementException e){
      return false;
    }
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of isEmpty(), size(), and isFull() methods defined in the
   * ExceptionalVendingMachine class
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testEmptySizeFullExceptionalVendingMachine() {
    try {
      ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(5);
      exceptionalVendingMachine.addItem("coke",4);
      exceptionalVendingMachine.addItem("fish",4);
      exceptionalVendingMachine.addItem("coke",1);
      exceptionalVendingMachine.addItem("hamburger",4);
      exceptionalVendingMachine.addItem("cookie",4);
      if (!exceptionalVendingMachine.isFull()){
        return false;
      }
      if (exceptionalVendingMachine.isEmpty()){
        return false;
      }
      if (exceptionalVendingMachine.size() != 5){
        return false;
      }
    }catch (IllegalStateException | IllegalArgumentException e){
      return false;
    }

    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of loadOneItem method with respect to its specification. Consider at
   * least the four following scenarios. (1) Successful scenario for loading one item with a valid
   * string representation to a non-full vending machine. (2) Unsuccessful scenario for passing null
   * or a blank string (for instance one space or empty string) to the loadOneItem() method call, an
   * IllegalArgumentEXception is expected to be thrown. (3) Unsuccessful scenario for passing a
   * badly formatted string to the loadOneItem method. A DataFormatException is expected to be
   * thrown. (4) Unsuccessful scenario for trying to load an item with a valid representation to a
   * full vending machine. An IllegalStateException is expected to be thrown.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testLoadOneItem() throws DataFormatException {
    boolean ans = true;
    ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(5);
    exceptionalVendingMachine.addItem("coke",4);
    exceptionalVendingMachine.addItem("coke",4);
    exceptionalVendingMachine.loadOneItem("coke:3");
    try {
      exceptionalVendingMachine.loadOneItem("");
    }catch (IllegalArgumentException e){
      ans = false;
    }
    try {
      exceptionalVendingMachine.loadOneItem("44444");
    }catch (DataFormatException e){
      ans = false;
    }
    try {
      exceptionalVendingMachine.loadOneItem("cookie:3");
    }catch (IllegalStateException e){
      ans = true;
    }
    return ans; // default return statement added to resolve compiler errors
  }

  /**
   * Invokes all the public tester methods implemented in this class
   * 
   * @return true if all testers pass with no errors, and false if any of the tester fails.
   */
  public static boolean runAllTests() throws DataFormatException {
    System.out.println("testItemConstructorNotValidInput: " + testItemConstructorNotValidInput());
    System.out.println("testItemConstructorGettersSetters: " + testItemConstructorGettersSetters());
    System.out.println("testItemEquals: " + testItemEquals());
    System.out.println("testExceptionalVendingMachineConstructor: " + testExceptionalVendingMachineConstructor());
    System.out.println("testExceptionalVendingMachineAddContainsRemoveGetters: " + testExceptionalVendingMachineAddContainsRemoveGetters());
    System.out.println("testEmptySizeFullExceptionalVendingMachine: " + testEmptySizeFullExceptionalVendingMachine());
    System.out.println("testLoadOneItem: " + testLoadOneItem());
    return !testLoadOneItem(); // default return statement added to resolve compiler errors
  }

  /**
   * Main method for the tester class
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    try {
      runAllTests();
    } catch (DataFormatException e) {
      e.printStackTrace();
    }
  }

}
