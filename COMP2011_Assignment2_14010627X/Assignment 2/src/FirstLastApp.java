import java.util.*;
// firstLastList.java
// demonstrates list with first and last references
// to run this program: C>java FirstLastApp
////////////////////////////////////////////////////////////////
/*                                    // May need to uncomment to compile.  Commented out since already defined in DoublyLinkedApp.java
class Link
   {
   public long dData;                 // data item
   public Link next;                  // next link in list
// -------------------------------------------------------------
   public Link(long d)                // constructor
      { dData = d; }
// -------------------------------------------------------------
   public void displayLink()          // display this link
      { System.out.print(dData + " "); }
// -------------------------------------------------------------
   }  // end class Link
*/
////////////////////////////////////////////////////////////////
class FirstLastList
   {
   private Link first;               // ref to first link
   private Link last;                // ref to last link
// -------------------------------------------------------------
   public FirstLastList()            // constructor
      {
      first = null;                  // no links on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertFirst(long dd)  // insert at front of list
      {
      Link newLink = new Link(dd);   // make new link

      if( isEmpty() )                // if empty list,
         last = newLink;             // newLink <-- last
      newLink.next = first;          // newLink --> old first
      first = newLink;               // first --> newLink
      }
// -------------------------------------------------------------
   public void insertLast(long dd)   // insert at end of list
      {
      Link newLink = new Link(dd);   // make new link
      if( isEmpty() )                // if empty list,
         first = newLink;            // first --> newLink
      else
         last.next = newLink;        // old last --> newLink
      last = newLink;                // newLink <-- last
      }
// -------------------------------------------------------------
   public long deleteFirst()         // delete first link
      {                              // (assumes non-empty list)
      long temp = first.dData;
      if(first.next == null)         // if only one item
         last = null;                // null <-- last
      first = first.next;            // first --> old next
      return temp;
      }
// -------------------------------------------------------------
   public void displayList()
      {
      System.out.print("List (first-->last): ");
      Link current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayLink();      // print data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   /* Function Logic:
    * Iterate through list and remove all links
    * Each time link is removed, store its dData value into a set
    * Set will remove all duplicates
    * Once all links are removed, re insert into the linklist 
    */
   public void removeDupLink(){
	   Set<Long> set = new HashSet<Long>();         // Create a set of longs
	   
	   while(!isEmpty()){                           // While there are still links
		   long current = deleteFirst();            // Delete dData from list
		   set.add(current);                        // Add it to the set
	   }
	   
	   Iterator<Long> itr = set.iterator();         // Create iterator for long variables
	   while(itr.hasNext()){                        // While there are more long variables
		   insertFirst(itr.next());                 // Add back to link list
	   }
   }
// -------------------------------------------------------------
/* Old Implementation (please ignore):
 * Function Logic:
 * Start at the first link and check its value
 * Check each link after the first and remove if a duplicate
 * Once the end is reached, move starting point to next link and repeat until all links are checked
 */
   /*
    public void removeDupLink(){
    	if( !isEmpty() ){                                            // if list has links
    		Link startingPoint = first;                              // create starting point
        	OuterLoop: while(startingPoint.next != null){            // while there are more links to go
        		Link current = startingPoint;                        // create link to iterate down list
        		long keyVal = current.dData;                         // set key value
				while( current.next != null ){                       // while not reached the end yet.. 
					if(current.next.dData == keyVal){                // if current link's next has duplicate data
						if(current.next == last){                    // if it's the last link
							last = current;                          // set current link to last and end
							current.next = null;                 
							break OuterLoop;                   	     // Break completely to prevent infinite loop
						}else{                                  	 // if normal link is a duplicate
							current.next = current.next.next;    	 // delete the next link
							current = startingPoint;                 // start again from beginning
						}
					}
					current = current.next;                          // move current link up by one
				}
				startingPoint = startingPoint.next;                  // move starting point up by one
        	}
    		startingPoint = first;                                   // make one final sweep through for insurance
    		while(startingPoint.next != null)                        // as long as another link exists
    			if(startingPoint.dData == startingPoint.next.dData)  // if link still has duplicates, 
    				removeDupLink();                                 // call function recursively
    			if(first.dData == last.dData)
    				removeDupLink();
    			else
    				startingPoint = startingPoint.next;              // continue through the function
    	}
    }*/
// -------------------------------------------------------------
} // end class FirstLastList
////////////////////////////////////////////////////////////////
class FirstLastApp
   {
   public static void main(String[] args)
      {                              // make a new list
      FirstLastList theList = new FirstLastList();
      
      theList.insertFirst(22);       // insert at front
      theList.insertFirst(22);
      theList.insertFirst(33);
      theList.insertFirst(22);       // insert at front
      theList.insertFirst(22);
      theList.insertFirst(21);
      
      theList.displayList();
      theList.removeDupLink();      // the method you need to implement
      theList.displayList();
      }  // end main()
   }  // end class FirstLastApp
////////////////////////////////////////////////////////////////
