class HighArray{
   //-----------------------------------------------------------
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   public long getMax(){			//Exercise 2.1 - Returns largest element in array 
	   long max = 0;
	   if(nElems == 0){				//check if array is empty or not
		   max = -1;				//return -1 if empty
	   }
	   else{
		   for(int i=0; i<nElems; i++){
			   if(a[i] > max){			//search each array element
				   max = a[i];			//replace with new max if a[i] is greater
			   }
		   }
	   }
	   System.out.println("Max key is: " + max);
	   return max;
   }
   //-----------------------------------------------------------
   public void removeMax(long max){		//Exercise 2.2 - Removes largest element in array
	   
	   int i;
	   for(i=0; i<nElems; i++){//Find which index max is in
		   if(a[i] == max){
			   break;
		   }
	   }
	   
	   for(int j=i; j<nElems; j++){//Shift all array elements up by one
		   a[j] = a[j+1];
	   }
	   nElems--; //Delete one index
   }
   //-----------------------------------------------------------
}  // end class HighArray


public class HighArrayApp {
	public static void main(String[] args){
	      int maxSize = 100;            // array size
	      HighArray arr;                // reference to array
	      arr = new HighArray(maxSize); // create the array
	      
	      arr.insert(77);               // insert 10 items
	      arr.insert(99);
	      arr.insert(44);
	      arr.insert(55);
	      arr.insert(22);
	      arr.insert(88);
	      arr.insert(11);
	      arr.insert(00);
	      arr.insert(66);
	      arr.insert(33);
	      
	      System.out.println(" - Initial Array -");
	      arr.display();                // display items
	      
	      System.out.println("-----------------------------------------------------------");
	      System.out.println(" - Exercise 2.1 -");
	      long maxValue = arr.getMax();
	      System.out.println("-----------------------------------------------------------");
	      System.out.println(" - Exercise 2.2 -");
	      arr.removeMax(maxValue);
	      arr.display();
	      
	      //HighArrayApp old stuff - still works, just remove comments to review
	      /*
	      int searchKey = 35;           // search for item
	      if( arr.find(searchKey) )
	         System.out.println("Found " + searchKey);
	      else
	         System.out.println("Can't find " + searchKey);

	      arr.delete(00);               // delete 3 items
	      arr.delete(55);
	      arr.delete(99);

	      arr.display();                // display items again
	      */

	      //Exercise 2.3
	      System.out.println("-----------------------------------------------------------");
	      System.out.println(" - Exercise 2.3 -");
	      
	      long[] arr1 = new long[10];
	      
	      arr1[0] = 90;
	      arr1[1] = 15;
	      arr1[2] = 5;
	      arr1[3] = 10;
	      arr1[4] = 25;
	      arr1[5] = 45;
	      arr1[6] = 30;
	      arr1[7] = 35;
	      arr1[8] = 65;
	      arr1[9] = 60;

	      for(int i=0; i<arr1.length; i++){
	    	  System.out.print(arr1[i] + " ");
	      }
	      
	      for(int out=0; out<arr1.length; out++){
	    	  int min = out;
	    	  for(int in=out+1; in<arr1.length; in++){
	    		  if(arr1[in] > arr1[min]){  //Sort descending, or switch to sort ascending
	    			  min = in;
	    		  }
	    	  }
	    		  long temp1 = arr1[out];
	    		  arr1[out] = arr1[min];
	    		  arr1[min] = temp1;
	      }
	      
	      System.out.println("");
	      for(int i=0; i<arr1.length; i++){
	    	  System.out.print(arr1[i] + " ");
	      }
	}
}	// end main()