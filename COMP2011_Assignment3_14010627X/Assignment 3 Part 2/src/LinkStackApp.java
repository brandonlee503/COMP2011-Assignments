////////////////////////////////////////////////////////////////
class Node{
	public int iData; // data item (key)
	public double dData; // data item
	public Node leftChild; // this node's left child
	public Node rightChild; // this node's right child
    public boolean wasVisited;
  //-------------------------------------------------------------   
    public Node(){
    	wasVisited = false;
    }
//-------------------------------------------------------------
	public void displayNode(){ // display ourself
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
 } // end class Node
////////////////////////////////////////////////////////////////
class Link{
   public long dData;             // data item
   public Link next;              // next link in list
   public Node linkNode;
// -------------------------------------------------------------
   public Link(Node newNode)           // constructor
      { linkNode = newNode; }
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      { System.out.print(linkNode.dData + " "); }
}  // end class Link
////////////////////////////////////////////////////////////////
class LinkList{
   private Link first;            // ref to first item on list
// -------------------------------------------------------------
   public LinkList()              // constructor
      { first = null; }           // no items on list yet
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      { return (first==null); }
// -------------------------------------------------------------
   public void insertFirst(Node newNode){// insert at start of list
      Link newLink = new Link(newNode);  // make new link
      newLink.next = first;       		 // newLink --> old first
      first = newLink;           		 // first --> newLink
   }
// -------------------------------------------------------------
   public Link deleteFirst(){     // delete first item (assumes list not empty)
      Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp;		          // return deleted link
   }
// -------------------------------------------------------------
   public void displayList()
      {
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class LinkList
////////////////////////////////////////////////////////////////
class LinkStack{
   private LinkList theList;
//--------------------------------------------------------------
   public LinkStack()             // constructor
      { theList = new LinkList(); }
//--------------------------------------------------------------
   public void push(Node newNode)     // put item on top of stack
      { theList.insertFirst(newNode); }
//--------------------------------------------------------------
   public Link pop()            // take item from top of stack
      { return theList.deleteFirst(); }
//--------------------------------------------------------------
   public boolean isEmpty()       // true if stack is empty
      { return ( theList.isEmpty() ); }
//--------------------------------------------------------------
   public void displayStack(){
      System.out.print("Stack (top-->bottom): ");
      theList.displayList();
   }
//--------------------------------------------------------------
   }  // end class LinkStack
////////////////////////////////////////////////////////////////
class LinkStackApp{ 
	public static void main(String[] args){ 
	    LinkStack theStack = new LinkStack(); // make stack  
	    for(int i=0; i<20; i++){
	    	Node newNode = new Node();
		    newNode.iData=i+1; 
		    newNode.dData=i+1.0; 
		    theStack.push(newNode); 
		    theStack.displayStack();              // display stack 
	    } 
	    theStack.pop();                       // pop items 
	    theStack.pop(); 
	    theStack.displayStack();              // display stack 
	}  // end main() 
}// end class LinkStackApp
////////////////////////////////////////////////////////////////
