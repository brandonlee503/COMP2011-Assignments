////////////////////////////////////////////////////////////////
class Link{
	public int iData;
	public double dData;                // data item
	public Link next;                 // next link in list
	public Node linkNode;
//-------------------------------------------------------------
	public Link(Node newNode)               // constructor
		{ linkNode = newNode; }
//-------------------------------------------------------------
	public void displayLink()         // display this link
		{ System.out.print(linkNode.dData + " "); }
//-------------------------------------------------------------
}  // end class Link
////////////////////////////////////////////////////////////////
class FirstLastList{
   private Link first;               // ref to first item
   private Link last;                // ref to last item
// -------------------------------------------------------------
   public FirstLastList(){            // constructor
      first = null;                  // no items on list yet
      last = null;
   }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertLast(Node newNode){ // insert at end of list
	   Link newLink = new Link(newNode);   // make new link
       if( isEmpty() )                // if empty list,
    	   first = newLink;            // first --> newLink
       else
    	   last.next = newLink;        // old last --> newLink
       last = newLink;                // newLink <-- last
   }
// -------------------------------------------------------------
   public Link deleteFirst(){         // delete first link (assumes non-empty list)
	      Link temp = first;
	      if(first.next == null)         // if only one item
	         last = null;                // null <-- last
	      first = first.next;            // first --> old next
	      return temp;
	   }
// -------------------------------------------------------------
   public void displayList(){
      Link current = first;          // start at beginning
      while(current != null){         // until end of list,
         current.displayLink();      // print data
         current = current.next;     // move to next link
      }
      System.out.println("");
   }
// -------------------------------------------------------------   
}
////////////////////////////////////////////////////////////////
class LinkQueue{
   private FirstLastList theList;
//--------------------------------------------------------------
   public LinkQueue()                // constructor
      { theList = new FirstLastList(); }  // make a 2-ended list
//--------------------------------------------------------------
   public boolean isEmpty()          // true if queue is empty
      { return theList.isEmpty(); }
//--------------------------------------------------------------
   public void insert(Node newNode)        // insert, rear of queue
      { theList.insertLast(newNode); }
//--------------------------------------------------------------
   public Link remove()              // remove, front of queue
      {  return theList.deleteFirst();  }
//--------------------------------------------------------------
   public void displayQueue(){
      System.out.print("Queue (front-->rear): ");
      theList.displayList();
   }
//--------------------------------------------------------------
}
////////////////////////////////////////////////////////////////
class LinkQueueTreeNodeApp{
	public static void main(String[] args){
		LinkQueue theQueue = new LinkQueue();
		for(int i=0; i<20; i++){
			Node newNode = new Node();
			newNode.iData=i+1;
			newNode.dData=i+1.0;
			theQueue.insert(newNode);
		}
		theQueue.displayQueue(); // display queue
		theQueue.remove(); // remove items
		theQueue.remove();
		theQueue.displayQueue(); // display queue
	}// end main()
}//end class LinkQueueApp
