// doublyLinked.java
// demonstrates doubly-linked list
// to run this program: C>java DoublyLinkedApp
////////////////////////////////////////////////////////////////
class Link
   {
   public long dData;                 // data item
   public Link next;                  // next link in list
   public Link previous;              // previous link in list
// -------------------------------------------------------------
   public Link(long d)                // constructor
      { dData = d; }
// -------------------------------------------------------------
   public void displayLink()          // display this link
      { System.out.print(dData + " "); }
// -------------------------------------------------------------
   }  // end class Link
////////////////////////////////////////////////////////////////
class DoublyLinkedList
   {
   private Link first;               // ref to first item
   private Link last;                // ref to last item
// -------------------------------------------------------------
   public DoublyLinkedList()         // constructor
      {
      first = null;                  // no items on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertFirst(long dd){  // insert at front of list
   
      Link newLink = new Link(dd);    // make new link

      if( isEmpty() ){                 // if empty list..
    	  first = newLink;	           // first and last since only 1 link
     	  last = newLink;	
    	  newLink.next = newLink;	   // newLink.next --> itself
    	  newLink.previous = newLink;  // newLink.prev --> itself
      }else{
    	  newLink.previous = last;     // newLink point to last link
    	  last.next = newLink;         // last link point to newLink
    	  newLink.next = first;	       // newLink point forward to first
    	  first.previous = newLink;	   // first point back to newLink
    	  first = newLink;	           // newLink = first
      }
   }
// -------------------------------------------------------------
   public void insertLast(long dd){   // insert at end of list
	   
      Link newLink = new Link(dd);    // make new link
      
      if( isEmpty() ){                // if empty list..
    	  first = newLink;            // first and last since only 1 link 
    	  last = newLink;
    	  newLink.next = newLink;     // only one link in list points to itself
    	  newLink.previous = newLink;
      }else{
    	  newLink.next = first;       // newLink point forward to first
    	  first.previous = newLink;   // first point back to newLink
    	  last.next = newLink;        // last points forward to newLink
    	  newLink.previous = last;    // newLink points back to last
    	  last = newLink;             // newLink = last
      }
   }
// -------------------------------------------------------------
   public Link deleteFirst(){          // delete first link, (assumes non-empty list)
	   Link temp = first;
	   if(first == first.next){        // if only one link..
		   first = null;               // set list to empty
		   last = null;
	   }else{
		   first.next.previous = last; // point new first to last
		   last.next = first.next;     // point last to new first 
		   first = first.next;         // increment first
	   }
	   return temp;
   }
// -------------------------------------------------------------
   public Link deleteLast(){              // delete last link, (assumes non-empty list)
      Link temp = last;
      if(last == last.next){              // if only one link..
    	  first = null;                   // set list to empty
    	  last = null;
      }else{ 
    	  last.previous.next = first;     // point new last to first
    	  first.previous = last.previous; // point first to new last
    	  last = last.previous;           // increment last
      }
      return temp;
   }
// -------------------------------------------------------------
   public boolean insertAfter(long key, long dd){    // insert dd just after key, assumes non-empty list
	   Link current = first;                         // start at beginning
	   while(current.dData != key){                  // while not found..
		   current = current.next;                   // increment to next link
		   if(current == last && last.dData != key)  // if not in list..
			   return false;                         // not found and not completed
	   }
	   if(current == last)                           // if last link.. 
		   insertLast(dd);
	   else{
		   Link newLink = new Link(dd);              // create link
		   newLink.next = current.next;              // point new link forward next link
		   newLink.previous = current;               // point new link backwards to previous link
		   current.next = newLink;                   // point current link to new link
	   }
	   return true;                                  // found and completed
   }
// -------------------------------------------------------------
   public Link deleteKey(long key){
	   Link current = first;                           // start at beginning
	   while(current.dData != key){                    // while not found..
		   current = current.next;                     // increment
		   if(current == last && current.dData != key) // if finished and still not in list..
			   return null;                            // didn't find
	   }
	   if(current == first)                            // if found at first item..
		   current = deleteFirst();                    // delete first
	   if(current == last)                             // if found at last item..
		   current = deleteLast();                     // delete last
	   if(current != first && current != last){        // if inbetween..
		   current.previous.next = current.next;       // point new current to new next
		   current.next.previous = current.previous;   // point new current to new previous
	   }
	   return current;
   }
// -------------------------------------------------------------
   public void displayForward(){
	   System.out.print("List (first-->last): ");
	   Link current = first;                           // start at beginning
	   Link originalFirst = current;                   // set first as an ending point
	   if( !isEmpty() ){                               // if the list has links..
		   if(current == current.next)                 // if there's only one link..
			   current.displayLink();                  
		   else{                                       // since there are multiple links..
			   while(current.next != originalFirst){   // while not all links have been displayed
				   current.displayLink();
				   current = current.next;             // move down list
			   }
		       current.displayLink();                  // display the final link
		   }
	   }
	   System.out.println("");
   }
// -------------------------------------------------------------
   public void displayBackward(){
      System.out.print("List (last-->first): ");
      Link current = last;                             // start at end
      Link originalLast = current;                     // set last as an ending point
      if( !isEmpty() ){								   // if list has links..
    	  if(current == current.previous)              // if there's only one link..
    		  current.displayLink();
    	  else{                                        // since there are multiple links
    		  while(current.previous != originalLast){ // while not all links have been displayed 
    			  current.displayLink();
    			  current = current.previous;          // move up the list
    		  }
    		  current.displayLink();                   // display the final link
    	  }
      }
      System.out.println("");
   }
// -------------------------------------------------------------
}  // end class DoublyLinkedList
////////////////////////////////////////////////////////////////
class DoublyLinkedApp
   {
   public static void main(String[] args)
      {                             // make a new list
      DoublyLinkedList theList = new DoublyLinkedList();
      
      theList.displayForward();     // display list forward
      theList.displayBackward();    // display list backward
      
      theList.insertFirst(22);      // insert at front
      theList.insertFirst(44);
      theList.insertFirst(66);
      
     
      theList.displayForward();     // display list forward
      theList.displayBackward();    // display list backward
      
      theList.insertLast(11); 
      theList.insertLast(33);
      theList.insertLast(55);
      
 
      theList.displayForward();     // display list forward
      theList.displayBackward();    // display list backward
      
      theList.deleteFirst();
      theList.deleteFirst();
      
     
      theList.displayForward();     // display list forward
      theList.displayBackward();    // display list backward
      
      theList.deleteLast();
      theList.deleteLast();
      
      
      theList.displayForward();     // display list forward
      theList.displayBackward();    // display list backward
      
      theList.deleteKey(11); 
      theList.deleteKey(22);
      

      theList.displayForward();     // display list forward
      theList.displayBackward();    // display list backward
      
      theList.insertFirst(22);      // insert at front
      theList.insertFirst(44);
      theList.insertFirst(66);
      
      theList.insertAfter(22, 77);
      theList.insertAfter(33, 88);  // insert 88 after 33
      theList.insertAfter(88, 11);
      

      theList.displayForward();     // display list forward
      theList.displayBackward();    // display list backward

      theList.deleteKey(11); 
      theList.deleteKey(44);

      theList.displayForward();     // display list forward
      theList.displayBackward();    // display list backward
      
      }  // end main()
   }  // end class DoublyLinkedApp
////////////////////////////////////////////////////////////////
