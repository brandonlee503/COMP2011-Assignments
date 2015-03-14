import java.util.Random;

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   
   public void size(){
	   System.out.println("size = " + nElems);
   }
//--------------------------------------------------------------
   public ArrayBub(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void bubbleSort()
      {
      int out, in;

      for(out=nElems-1; out>1; out--)   // outer loop (backward)
         for(in=0; in<out; in++)        // inner loop (forward)
            if( a[in] > a[in+1] )       // out of order?
               swap(in, in+1);          // swap them
      }  // end bubbleSort()
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
//--------------------------------------------------------------
   public int linearSearch(long key){
	   for(int i=0; i<nElems; i++){
		   if(a[i] == key){
			   return i;
		   }
	   }
	System.out.println("Not Found");   
	return nElems;
   }   
//--------------------------------------------------------------   
   public int binarySearch(long key){
	   int min = 0;
	   int max = nElems-1;
	   while(min <= max){
		   int mid = (min + max)/2;
		   if(a[mid] == key){
			   return mid;
		   }
		   else if(a[mid] < key){
			   min = mid + 1;
		   }
		   else{
			   max = mid - 1;
		   }
	   }
	   System.out.println("Not Found");
	   return nElems;
   }
}  // end class ArrayBub
////////////////////////////////////////////////////////////////
class bubbleSort
   {
   public static void main(String[] args){ 
	  //Same format as lab 3, just add/remove comment lines to whichever functions you want to run/not run  
	  executionTime(10000);
	  //executionTime(100000);
	  //executionTime(1000000);
      }  // end main()
   
   public static void executionTime(int size){
	  ArrayBub bubObj = new ArrayBub(size);
	  System.out.println("Now executing array size: " + size); 
	  
	  //Create random key
      Random rn = new Random();
      int key = rn.nextInt(10000);
      System.out.println("The randomly generated key is: " + key);
	   
       //Fill array with sorted values
	   for(int i=0; i<size; i++){
		   bubObj.insert(i);
	   }
	   
	   bubObj.display();
	   
	   //Calculate execution time
	   long lsStart = System.nanoTime();
	   int lsResult = bubObj.linearSearch(key);
	   long lsEnd = System.nanoTime();
	   
	   //Calculate execution time
	   long bsStart = System.nanoTime();
	   int bsResult = bubObj.binarySearch(key);
	   long bsEnd = System.nanoTime();
	   
	   //Print out results
	   System.out.println("Linear Search - " + "The execution time is " + (lsEnd - lsStart) + " nanoseconds!");
	   System.out.println("Binary Search - " + "The execution time is " + (bsEnd - bsStart) + " nanoseconds!");
	   System.out.println("");
	   
	   System.out.print("Linear Search - ");
	   if(lsResult != size){
		   System.out.println("Key was found in array index: " + lsResult);
	   }
	   else{
		   System.out.println("Key was not found.");
	   }
	   
	   System.out.print("Binary Search - ");
	   if(bsResult != size){
		   System.out.println("Key was found in array index: " + lsResult);
	   }
	   else{
		   System.out.println("Key was not found.");
	   }
   }  
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
