package program.program;

public class List {

    Node head; // The head of the list
    int size; // Keeping track of the size of the List

    public List() {

        head = null; // Initialize head to be null since list is empty
        size = 0;

    }

    public void insert(Node N) {

        size++; // Size is incremented in all cases

        if (head == null) {  // if List is empty we insert in the beginning
            head = N;
            return;
        }

        /////////////
        //Not Empty//
        /////////////

        Node tmp = head;
        Node prev = head;


        // Case 1 : A duplicate of the date exits, so we insert before the first match

        while (tmp != null) {
            if (compareDates(N.journeyDate, tmp.journeyDate) == 0) { // We found a duplicate of the date
                if (tmp == head) {
                    N.next = head;
                    head = N;
                    return;
                } else {
                    N.next = tmp;
                    prev.next = N;
                    return;
                }
            } else if (compareDates(N.journeyDate, tmp.journeyDate) == 1) { // We found a date greater than current date
                if (tmp == head) { // If the current Node belongs in the beginning

                    N.next = head;
                    head = N;
                    return;

                } else { // Current node belongs somewhere in the middle

                    N.next = tmp;
                    prev.next = N;
                    return;

                }
            } else if (tmp.next == null) {  // There is no date greater than current date, so Node belongs in the end

                tmp.next = N; // We insert at the end
                return;
            }
            prev = tmp;
            tmp = tmp.next;
        }
    }


    public void remove(int n) {

        if (head == null) // If list is empty, nothing to remove
            return;


        if (head.paxID == n) { // Removing if head contains the paxID
            head = head.next;
            size--;
            return;
        }

        // If we reach here, we will need prev & temp

        Node prev = head; // We can also do prev = head,
        Node tmp = head; // tmp = head.next
        

        while (tmp != null) { // Removing in the middle, or the end, works for both
            if (tmp.paxID == n) {
                prev.next = tmp.next;
                size--;
                return;
            }
            prev = tmp;
            tmp = tmp.next;
        }
    }

    public int cost(int n) {

        //--------------------------------------------------------//
        //Calculating the cost of all journeys with matching paxID//
        //--------------------------------------------------------//

        if (head == null) // List is empty, nothing to calculate
            return 0;

        int cost = 0; // Initial cost set at 0
        Node tmp = head; // tmp will be used to iterate the list

        while (tmp != null) {
            if (tmp.paxID == n) { // We check for matching paxID (Passenger ID)
                cost += Math.abs(tmp.srcModule - tmp.destModule) * 5; // Given formula, add it to cost
            }
            tmp = tmp.next;
        }
        return cost; // Finally, we return cost
    }


    public void printPaxId(int n) {

        // Print all Nodes with matching paxID (Passenger ID)

        if (head == null) // Check if empty
            return;

        Node tmp = head;

        while (tmp != null) {
            if (tmp.paxID == n) { // Iterate through the list, looking for paxID
                System.out.println(tmp.toString()); // Print if found
            }
            tmp = tmp.next; // Iterate tmp
        }
    }

    public void printJourneyDate(int n) {

        // Print all Nodes with matching journeyDate

        if (head == null) // Check if empty
            return;

        Node tmp = head;

        while (tmp != null) {
            if (tmp.journeyDate == n) { // Iterate through the list, looking for journeyDate
                System.out.println(tmp.toString()); // Print if found
            }
            tmp = tmp.next; // Iterate tmp
        }
    }

    public void printSrcModule(int n) {

        // Print all Nodes with matching srcModule (Source Module)

        if (head == null) // Check if empty
            return;

        Node tmp = head;

        while (tmp != null) {
            if (tmp.srcModule == n) { // Iterate through the list, looking for srcModule
                System.out.println(tmp.toString()); // Print if found
            }
            tmp = tmp.next; // Iterate tmp
        }

    }

    public void printDestModule(int n) {

        // Print all Nodes with matching destModule (Destination Module)

        if (head == null) // Check if empty
            return;

        Node tmp = head;

        while (tmp != null) {
            if (tmp.destModule == n) { // Iterate through the list, looking for destModule
                System.out.println(tmp); // Print if found
            }
            tmp = tmp.next; // Iterate tmp
        }
    }


    public int compareDates(int date1, int date2) {  // Method used to compare the two dates, passed as integers as per the project's instructions

        /**  We return:
         0 : if dates are equal
         1 : if date1 is before date2
         -1 : if date2 is before date1 */

        // First we make sure the dates are formatted correctly with leading zeros as needed
        // ex. 03031986 is 3 March 1986. Normally the first 0 would be omitted. We add it back if that is the case

        String str = ("00000000" + date1);
        String date1Str = str.substring(str.length() - 8);

        str = ("00000000" + date2);
        String date2Str = str.substring(str.length() - 8);

        // Now both date1 and date2 are formatted properly, we can split them into substrings and compare.


        if (date1Str.equals(date2Str)) // if dates are equal,we return 0
            return 0;


        // We conclude that dates are not equal, so we must compare

        // We split the two dates (Strings) into years, months and days

        // For date 1 :

        int day1int = Integer.parseInt(date1Str.substring(0, 2));
        int month1int = Integer.parseInt(date1Str.substring(2, 4));
        int year1int = Integer.parseInt(date1Str.substring(4));

        // For date 2 :

        int day2int = Integer.parseInt(date2Str.substring(0, 2));
        int month2int = Integer.parseInt(date2Str.substring(2, 4));
        int year2int = Integer.parseInt(date2Str.substring(4));

        // We now have 6 substrings. 3 for each date

        if (year1int < year2int) { // Year1 is less than Year2
            return 1;
        }
        if (year2int < year1int) { // Year2 is less than Year1
            return -1;
        }

        // If we reach here, the two dates have the same year

        if (month1int < month2int) { // Month1 is less than Month2
            return 1;
        }
        if (month2int < month1int) { // Month2 is less than Month1
            return -1;
        }

        // If we reach here, we conclude the two dates have the same month

        else if (day1int < day2int) {
            return 1;
        } else if (day2int < day1int) {
            return -1;
        }

        return -1; // Ideally, we never reach here
    }
}



