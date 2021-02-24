# SinglyLinkedList-Modules
A simple implementation of Singly Linked Lists based on a real life example. Completed as a course assignment.

This project is inspired by the possibility of technological advancements impacting city architectures.

In this project I used the idea of a city operating in terms of modules. These modules would be similar to small communities of a city. And of course transportation between the modules would be handled by AI. This is just a brief summary of the idea behind the concept, now, I will explain the program itself.

////////////////
///    API   //
///////////////

For this idea, I have used a simple Singly Linked List (SLL) data structure. As we know, each Node in a SLL has only one link, which is to the next Node. Here, I treat every Node as a "trip" or journey. Each Node would have several details, just as a ticket would. For example if there are 5 trips, we would create 5 Node each with their unique attributes. Each Node contains the following :

int ticketID;     // a unique ticket id;
int paxID;        // Passenger ID number;
int journeyDate;  // journey date DDMMYYYY;
int srcModule;    // takes values between 1 and 255
int destModule;   // takes values between 1 and 255
String paxName;   // Name of the passenger
Node next;        // Node next

Although storing journeyDate as an integer seems counterintuitive, this was the specification of the project XD

And for the List class, I simply had the following methods :

insert(Node N) // For inserting a Node, sorted by journeyDate.

void remove(PaxID) // Remove the first Node with matching PaxID

int cost(PaxID) //Computes the cost of ALL journeys for a passenger with PaxID. Here is how this is computed.
Journey cost = Math.abs(srcModule – destModule) * 5.
//example srcModule=3, destModule=5. Journey Cost = 10.

void printpaxID(PaxID) //Searches for PaxID in the list. Prints ALL nodes with PaxID.

void printjourneyDate(journeyDate) //Searches for journeyDate in the list. Prints ALL nodes with journeyDate.

void printsrcModule(srcModule) //Searches for srcModule in the list. Prints ALL nodes with srcModule.

void printdestModule(destModule) //Searches for destModule in the list. Prints ALL nodes with destModule.

And the toString() method is called as necessary.

////////////////
///  Usage  ///
///////////////

In my implementation, I assumed that each line would specify 1 operation. For example, a line starting with the number 1 would specify that the insert method would be called. This would imply that the user would like to insert a Node/Journey into the list, with the desired attributes. This means the first integer in each line is an argument that specifies the unique operation.

Here is the legend for the acceptable commands (first argument) :

1 - Insert details for a new node
2 - Removes node from list
3 - Computes the Cost of ALL journeys for this PaxID and displays the total. 
4 - Prints All nodes with PaxID.
5 - Prints ALL nodes with journeyDate. 
6 - Prints ALL nodes with srcModule.
7 - Prints ALL nodes with destModule.

Now I will explain a sample input to clarify the concept: 

Let's say I would like to insert a Node with the following details : 

TicketID = 1989
PaxID (Passenger ID) : 189
JourneyDate : 18111962 (This would mean 18 - November - 1962 since we assume date in DDMMYY format)
srcModule : 89 (Source Module, basically WHERE the passenger is travelling from)
destNodule : 91 (Destination Module. Where the passenger is travelling to)\
paxName : Kirk Hammett (Passenger Name, assumed to be 2 names)

Then, we would pass this parameter : 

1 1989 189 18111962 89 91 Kirk Hammett

And this would insert the Node in the list with the specified details.
Again, the first integer calls the insert method (See Line 52-58 in this file)

But what if I want to remove a Node? This is very simple to do. I would just need to pass the number 2 followed by the PaxID (Passenger ID).
Ex.

2 189

The above line would remove the first Node with the matching PaxID, if it exists in the list. No output is generated.

The parameter 3 would calculate the Cost for all Nodes matching the PaxID.

For example : 

3 101

The above line would search the entire list for Nodes with PaxID 101, and calculate the total cost based on the given formula (See line 30-32). This result would then be printed.

For arguments 4 to 7, print methods would be called. For example : 

4 101
The above line would call the printpaxID() method, printing every Node with the matching PaxID (101 in this case)

5 03081963
The above line would call the printjourneyDate() method, printing every Node with the matching JourneyDate (03081963 in this case)

6 21
The above line would call the printsrcModule() method, printing every Node with the matching JourneyDate (21 in this case)

and finally,

7 99
The above line would call the printdestModule() method, printing every Node with the matching Destination Module (99 in this case)
------------------------------------------------------------------------------------------------------------------------------------------

This is basically it. For extra clarity I will provide one more example.

Input : 

1 1225 101 10022021 3 5 Rima Grunge
1 1226 101 11022021 5 8 Rima Grunge
1 1227 101 12022021 8 3 Rima Grunge
3 101
2 101
4 101

Output :

50
1226 101 11022021 5 8 Rima Grunge
1227 101 12022021 8 3 Rima Grunge
