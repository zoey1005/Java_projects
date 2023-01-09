//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Road Routine
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
import java.util.Scanner;

public class PathUtilsTester
{
    /*
     * Tests the case of countPaths() when there are no valid Paths. For example, when the start 
     * position is Intersection(1, 1) and the ending position is Intersection(0, 1), there should 
     * be no valid Paths, so countPaths() should return 0.
     * @return: true if all test cases are passed
     */
    public static boolean testCountPathsNoPath()
    {
        return PathUtils.countPaths(new Intersection(1, 1), new Intersection(0, 0)) == 0;
    }
    /*
     * Tests the case of countPaths() when there is a single valid Path. For example, when the 
     * start position is Intersection(1, 1) and the ending position is Intersection(1, 2), there 
     * should be a single Path, so countPaths() should return 1.
     * @return: true if all test cases are passed
     */
    public static boolean testCountPathsOnePath()
    {
        return PathUtils.countPaths(new Intersection(1, 1), new Intersection(1, 2)) == 1;
    }
    /*
     * Tests the case of countPaths() when there are multiple possible paths. For example, when the 
     * start position is Intersection(0, 0) and the ending position is Intersection(1, 2), there 
     * should be three possible Paths, so countPaths() should return 3.
     * @return: true if all test cases are passed
     */
    public static boolean testCountPathsRecursive()
    {
        return PathUtils.countPaths(new Intersection(0, 0), new Intersection(1, 2)) == 3;
    }
    /*
     * Tests the case of findAllPaths() when there are no valid Paths. For example, when the start 
     * position is Intersection(1, 1) and the ending position is Intersection(0, 1), there should 
     * be no valid Paths, so findAllPaths() should return an empty ArrayList.
     * @return: true if all test cases are passed
     */
    public static boolean testFindAllPathsNoPath()
    {
        return PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(0, 1)).size()==0;
    }
    /*
     * Tests the case of findAllPaths() when there is a single valid Path. For example, when 
     * the start position is Intersection(1, 1) and the ending position is Intersection(1, 2), 
     * there should be a single Path. For each of your cases, ensure that there is only a single path,
     *  and that the Path exactly matches what you expect to see.
     * @return: true if all test cases are passed
     */
    public static boolean testFindAllPathsOnePath()
    {
        ArrayList<Path> paths=PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(1, 2));
        return paths.size()==1&&paths.get(0).toString().equals("(1,1)->(1,2)");
    }
    /*
     * Tests the case of findAllPaths() when there are multiple possible paths. For example, when 
     * the start position is Intersection(0, 0) and the ending position is Intersection(1, 2), there 
     * should be three possible Paths. For each of your cases, ensure that there is both the correct 
     * number of Paths, and that the returned Paths exactly match what you expect to see.
     */
    public static boolean testFindAllPathsRecursive()
    {
        ArrayList<Path> paths=PathUtils.findAllPaths(new Intersection(0, 0), new Intersection(1, 2));
        return paths.size() == 3 && paths.get(0).toString().equals("(0,0)->(1,0)->(1,1)->(1,2)") &&
            paths.get(1).toString().equals("(0,0)->(0,1)->(1,1)->(1,2)") && paths.get(2).toString().equals("(0,0)->(0,1)->(0,2)->(1,2)");
    }

    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Test test case");
            System.out.println("testCountPathsNoPath: "+testCountPathsNoPath());
            System.out.println("testCountPathsOnePath: "+testCountPathsOnePath());
            System.out.println("testCountPathsRecursive: "+testCountPathsRecursive());
            System.out.println("testFindAllPathsNoPath: "+testFindAllPathsNoPath());
            System.out.println("testFindAllPathsOnePath: "+testFindAllPathsOnePath());
            System.out.println("testFindAllPathsRecursive: "+testFindAllPathsRecursive());

            System.out.println();

            int startX, startY, endX, endY;
            String input = "Y";
            while (input.equalsIgnoreCase("Y")) {
                System.out.print("Enter starting X coordinate: ");
                startX = keyboard.nextInt();
                System.out.print("Enter starting Y coordinate: ");
                startY = keyboard.nextInt();
                System.out.print("Enter ending X coordinate: ");
                endX = keyboard.nextInt();
                System.out.print("Enter ending Y coordinate: ");
                endY = keyboard.nextInt();
                Intersection start = new Intersection(startX, startY);
                Intersection end = new Intersection(endX, endY);
                System.out.println("Number of paths from start to end: "
                    + PathUtils.countPaths(start, end));
                System.out.println("List of possible paths:");
                for (Path p : PathUtils.findAllPaths(start, end)) {
                    System.out.println(p);
                }
                do {
                    System.out.print("Try another route? (Y/N): ");
                    input = keyboard.next();
                } while (!input.equalsIgnoreCase("Y")
                    && !input.equalsIgnoreCase("N"));
            }
        }
    }
}
