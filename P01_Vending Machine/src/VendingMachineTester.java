// File Header comes here

import java.util.Arrays;

// Javadoc style class header comes here
public class VendingMachineTester {

  // TODO complete the implementation of the following tester methods and add their javadoc style
  // method headers

  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of containsItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
    // search returning false.

    //1.successful search returning true
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, null};
      int itemsCount = 5;

      // check the correctness of the output
      if (!VendingMachine.containsItem("Soda", items, itemsCount)) {
        System.out.println(
            "testContainsItem-scenario 1. Problem detected: Your containsItem did not return "
                + "the expected output true");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testContainsItem-scenario 1. Problem detected: Your containsItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    //2.Unsuccessful search returning false.
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, null};
      int itemsCount = 5;

      // check the correctness of the output
      if (VendingMachine.containsItem("Juice", items, itemsCount)) {
        System.out.println(
            "testContainsItem-scenario 2. Problem detected: Your containsItem did not return "
                + "the expected output false");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testContainsItem-scenario 2. Problem detected: Your containsItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
                  // Feel free to change it.
  }

  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetItemAtIndex() {
    // Define at least two test scenarios: (1) the provided index is out of the range
    // 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.

    //1.The provided index is out of the range 0..itemsCount-1
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, null, null, null};
      int itemsCount = 6;

      // check the correctness of the output
      if (!VendingMachine.getItemAtIndex(8, items, itemsCount).equals("ERROR INVALID INDEX")) {
        System.out.println(
            "getItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did not return "
                + "the expected output \"ERROR INVALID INDEX\"");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "getItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    //2.The provided index is at 2.
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, null, null, null};
      int itemsCount = 6;

      // check the correctness of the output
      if (!VendingMachine.getItemAtIndex(2, items, itemsCount).equals("Cookies 10")) {
        System.out.println(
            "getItemAtIndex-scenario 2. Problem detected: Your getItemAtIndex did not return "
                + "the expected output \"Cookies 10\"");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "getItemAtIndex-scenario 2. Problem detected: Your getItemAtIndex did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    // (2) the items array contains multiple occurrences of the provided item description.

    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.

    //1.No match found so that the method returns zero
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getItemOccurrences("Juice", items, itemsCount)!=0) {
        System.out.println(
            "getItemOccurrences-scenario 1. Problem detected: Your getItemOccurrences did not return "
                + "the expected output 0");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "getItemOccurrences-scenario 1. Problem detected: Your getItemOccurrences did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    //2.The items array contains multiple occurrences of the provided item description.
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getItemOccurrences("Soda", items, itemsCount)!=3) {
        System.out.println(
            "getItemOccurrences-scenario 2. Problem detected: Your getItemOccurrences did not return "
                + "the expected output 3");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "getItemOccurrences-scenario 2. Problem detected: Your getItemOccurrences did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of addItem defined in the VendingMachine class.
  public static boolean testAddItem() {
    // Define at least three test scenarios: (1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0), (2) adding a new item to a non-empty non-full
    // vending machine, and (3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    //1.Adding a new item to an empty vending machine whose size is zero (provided itemsCount == 0)
    {
      String[][] items = new String[][] {null,null};
      int itemsCount = 0;

      // check the correctness of the output
      if (VendingMachine.addItem("Soda","30",items, itemsCount)!=1) {
        System.out.println(
            "addItem-scenario 1. Problem detected: Your addItem did not return "
                + "the expected output 1");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] nowItems =
          new String[][] {{"Soda", "30"}, null};
      if (!Arrays.deepEquals(items, nowItems)) {
        System.out.println(
            "addItem-scenario 1. Problem detected: Your addItem did not make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    //2.Adding a new item to a non-empty non-full vending machine
    {
      String[][] items = new String[][] {{"Soda","30"},null,null};
      int itemsCount = 1;

      // check the correctness of the output
      if (VendingMachine.addItem("Water","60",items, itemsCount)!=2) {
        System.out.println(
            "addItem-scenario 2. Problem detected: Your addItem did not return "
                + "the expected output 2");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] nowItems =
          new String[][] {{"Soda", "30"},{"Water","60"}, null};
      if (!Arrays.deepEquals(items, nowItems)) {
        System.out.println(
            "addItem-scenario 2. Problem detected: Your addItem did not make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    //3.Adding a new item to a full vending machine where the provided itemsCount equals the length
    // of the provided items array.
    {
      String[][] items = new String[][] {{"Soda","30"}};
      int itemsCount = 1;

      // check the correctness of the output
      if (VendingMachine.addItem("Water","60",items, itemsCount)!=1) {
        System.out.println(
            "addItem-scenario 3. Problem detected: Your addItem did not return "
                + "the expected output 1");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] nowItems =
          new String[][] {{"Soda", "30"}};
      if (!Arrays.deepEquals(items, nowItems)) {
        System.out.println(
            "addItem-scenario 3. Problem detected: Your addItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.
  public static boolean testRemoveNextItem() {
    // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), (2) the next item to be removed matching
    // the provided description is at index 0 of the array, (3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
    // is at a middle index of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    //1.Trying to remove a non-existing item from a vending machine
    {
      String[][] items = new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.removeNextItem("Juice",items, itemsCount)!=7) {
        System.out.println(
            "removeNextItem-scenario 1. Problem detected: Your removeNextItem did not return "
                + "the expected output 7");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] nowItems =
          new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, nowItems)) {
        System.out.println(
            "removeNextItem-scenario 1. Problem detected: Your removeNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    //2.The next item to be removed matching the provided description is at index 0 of the array
    {
      String[][] items = new String[][]{{"Water", "1"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.removeNextItem("Water", items, itemsCount) != 6)
      {
        System.out.println(
            "removeNextItem-scenario 2. Problem detected: Your removeNextItem did not return "
                + "the expected output 6");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] nowItems =
          new String[][] {{"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null,null};
      if (!Arrays.deepEquals(items, nowItems))
      {
        System.out.println(
            "removeNextItem-scenario 2. Problem detected: Your removeNextItem did not match " +
            "the result {{\"Soda\", \"60\"}, {\"Cookies\", \"10\"}, {\"Water\", \"20\"},"+
            "{\"Soda\", \"100\"}, {\"Water\", \"30\"}, {\"Soda\", \"20\"}, null, null, null}");
        return false;
      }
    }
    //3.The next item to be removed is at index itemsCount of the array
    {
      String[][] items = new String[][]{{"Water", "30"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.removeNextItem("Soda", items, itemsCount) != 6)
      {
        System.out.println(
            "removeNextItem-scenario 3. Problem detected: Your removeNextItem did not return "
                + "the expected output 6");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] nowItems =
          new String[][] {{"Water", "30"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, null, null, null, null};
      if (!Arrays.deepEquals(items, nowItems))
      {
        System.out.println(
            "removeNextItem-scenario 3. Problem detected: Your removeNextItem did not match " +
                "the result {{\"Water\", \"30\"},{\"Soda\", \"60\"}, {\"Cookies\", \"10\"}, {\"Water\", \"20\"},"+
                "{\"Soda\", \"100\"}, {\"Water\", \"30\"}, null, null, null, null}");
        return false;
      }
    }
    //4.The next item to be removed is at a middle index of the provided items array
    {
      String[][] items = new String[][]{{"Water", "30"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.removeNextItem("Cookies", items, itemsCount) != 6)
      {
        System.out.println(
            "removeNextItem-scenario 4. Problem detected: Your removeNextItem did not return "
                + "the expected output 6");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] nowItems =
          new String[][] {{"Water", "30"}, {"Soda", "60"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"},null, null, null, null};
      if (!Arrays.deepEquals(items, nowItems))
      {
        System.out.println(
            "removeNextItem-scenario 4. Problem detected: Your removeNextItem did not match " +
                "the result {{\"Water\", \"30\"},{\"Soda\", \"60\"}, {\"Water\", \"20\"},"+
                "{\"Soda\", \"100\"}, {\"Water\", \"30\"},{\"Soda\", \"20\"}, null, null, null, null}");
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemsSummary defined in the VendingMachine class.
  public static boolean testGetItemsSummary() {
    // Define at least three scenarios: (1) the vending machine is empty, (2) the vending machine
    // contains non duplicate items (no multiple items with the same description), (3) the vending
    // machine contains multiple items with the same description at various index locations.

    //1.the vending machine is empty
    {
      String[][] items = new String[][]{null};
      int itemsCount = 0;

      // check the correctness of the output
      String res="";
      if (!VendingMachine.getItemsSummary( items, itemsCount).equals(res))
      {
        System.out.println(
            "getItemsSummary-scenario 1. Problem detected: Your getItemsSummary did not return "
                + "the expected output \"\"");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {null};
      if (!Arrays.deepEquals(items, originalItems))
      {
        System.out.println(
            "getItemsSummary-scenario 1. Problem detected: Your getItemsSummary did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    //2.the vending machine contains non duplicate items
    {
      String[][] items = new String[][]{{"Water", "30"}, {"Soda", "60"},null};
      int itemsCount = 2;

      // check the correctness of the output
      String res="Water (1)\nSoda (1)\n";
      if (!VendingMachine.getItemsSummary(items, itemsCount).equals(res))
      {
        System.out.println(
            "getItemsSummary-scenario 2. Problem detected: Your getItemsSummary did not return "
                + "the expected output :\nWater (1)\nSoda (1)\n");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "30"}, {"Soda", "60"},null};
      if (!Arrays.deepEquals(items, originalItems))
      {
        System.out.println(
            "getItemsSummary-scenario 2. Problem detected: Your getItemsSummary did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    //3.the vending machine contains multiple items with the same description at various index locations.
    {
      String[][] items = new String[][]{{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
          {"Soda", "100"}, {"Water", "30"}, null, null, null};
      int itemsCount = 6;

      // check the correctness of the output
      String res="Water (3)\nCookies (1)\nSoda (2)\n";
      if (!VendingMachine.getItemsSummary(items, itemsCount).equals(res))
      {
        System.out.println(
            "getItemsSummary-scenario 3. Problem detected: Your getItemsSummary did not return "
                + "the expected output :\nWater (3)\nCookies (1)\nSoda (2)\n");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
              {"Soda", "100"}, {"Water", "30"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems))
      {
        System.out.println(
            "getItemsSummary-scenario 3. Problem detected: Your getItemsSummary did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    boolean testGetIndexNextItem=testGetIndexNextItem();
    boolean testContainsItem=testContainsItem();
    boolean testGetItemAtIndex=testGetItemAtIndex();
    boolean testGetItemsOccurrences=testGetItemsOccurrences();
    boolean testAddItem=testAddItem();
    boolean testRemoveNextItem=testRemoveNextItem();
    boolean testGetItemsSummary=testGetItemsSummary();

    return (testGetIndexNextItem&&testContainsItem&&testGetItemAtIndex&&testGetItemsOccurrences&&
        testAddItem&&testRemoveNextItem&&testGetItemsSummary); // default return statement to let this incomplete code compiles with no errors.
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
    System.out.println("testContainsItem(): " + testContainsItem());
    System.out.println("testGetItemAtIndex(): " + testGetItemAtIndex());
    System.out.println("testGetItemsOccurrences(): " + testGetItemsOccurrences());
    System.out.println("testAddItem(): " + testAddItem());
    System.out.println("testRemoveNextItem(): " + testRemoveNextItem());
    System.out.println("testGetItemsSummary(): " + testGetItemsSummary());
    System.out.println("runAllTests(): " + runAllTests());
  }

}

	
