package program.program;

import java.util.*;

public class Solution {

    public static void main(String[] args) {


        List list = new List(); // Create a new list
        Scanner s = new Scanner(System.in); // Create a Scanner to read input


        try {
            while (s.hasNextLine()) { // Will read as long as there is a next Line

                String input = s.nextLine(); // Reading the input

                if (input.equalsIgnoreCase("")) // To handle errors
                    break;

                String[] param = input.split(" "); // Split the line at spaces and store in String array

                //////////////////////////////////////////////////////////////////////////////////////////////
                ///Using a switch statement to decide operations, 1 for input, 2 for remove, 3 for cost etc.//
                //////////////////////////////////////////////////////////////////////////////////////////////

                switch (Integer.parseInt(param[0])) { // param[0] will include one of the 7 cases

                    case 1:

                        // Insert, no output is required //

                        Node N = new Node(Integer.parseInt(param[1]), Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4]), Integer.parseInt(param[5]), param[6] + " " + param[7]); // Calling the full constructor
                        list.insert(N); // Insert the prepared node into the list
                        break;
                    case 2:

                        // Remove, no output is required //

                        list.remove(Integer.parseInt(param[1]));
                        break;
                    case 3:

                        // Calculate cost, then print //

                        System.out.println(list.cost(Integer.parseInt(param[1])));
                        break;
                    case 4:

                        // Print all matching Nodes with paxID //

                        list.printPaxId(Integer.parseInt(param[1]));
                        break;
                    case 5:

                        // Print all matching Nodes with journeyDate //

                        list.printJourneyDate(Integer.parseInt(param[1]));
                        break;
                    case 6:

                        // Print all matching Nodes with srcModule //

                        list.printSrcModule(Integer.parseInt(param[1]));
                        break;
                    case 7:

                        // Print all matching Nodes with destModule //

                        list.printDestModule(Integer.parseInt(param[1]));
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input, please see the README file for instructions.");
        }
    }
}

