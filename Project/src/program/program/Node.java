package program.program;

public class Node {

    public int ticketID;
    public int paxID;
    public int journeyDate; // format : DDMMYYYY
    public int srcModule;
    public int destModule;
    public String paxName;
    public Node next;

    public Node() { // Default constructor

        ticketID = 0;
        paxID = 0;
        journeyDate = 0;
        srcModule = 0;
        destModule = 0;
        paxName = "";
        next = null;
    }


    public Node(int t, int p, int j, int s, int d, String N) { // Overridden constructor

        if(((s < 1 || s > 255) || (d < 1 || d > 255))) // Check if src and dest modules are between 1 and 255
            return;

        ticketID = t;
        paxID = p;
        journeyDate = j;
        srcModule = s;
        destModule = d;
        paxName = N;
        next = null;
    }

    @Override
    public String toString() { // The toString method is called from the 4 print methods. Printing the list in the desired format

        //------------------//

        /** Simple formatting to make sure the journeyDate is printed correctly, with leading zeros if needed */

        String tmpStr = ("00000000" + journeyDate);
        String journeyDate = tmpStr.substring(tmpStr.length() - 8); // This is the final formatted journey date

        //------------------//

        // Finally, return the formatted string

        return ticketID + " " + paxID + " " + journeyDate + " " + srcModule + " " + destModule + " " + paxName;
    }
}