package sjsu.magal.cs146.project2;

/*
   Class: CS146-01 
   Semester: Spring 2017
   Project: #2 - Quicksort
   Sample JUnit tests for qs1, qs2 i.e., with pivot as last element and median, their running time,
   and count of comparisons.
 */

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * The main JUnit Test class to test each method in Quicksort
 * 
 *
 */
public class MyQuicksortTest
{

   private Quicksort QS;

   @Before
   public void setUp() throws Exception
   {
      QS = new Quicksort();
      QS.reset();
   } // setUp()



   /* Method to test the Sorting of an empty List
    */
   @Test
   public void testEmpty() {
             int[] array1 = new int[0];
             int[]  array2= new int[0]; //correct sorted array
             
             array1 = QS.qs1(array1, 0, array1.length - 1);
             assertArrayEquals(array1,array2);
             array1 = QS.qs2(array1, 0, array1.length - 1);
             assertArrayEquals(array1,array2);
   }   

  
   /* Method to test the Sorting of an already sorted list:
    */
   @Test
   public void testSorted() {
        int[] array1 = new int[20];
        int[] array2 = new int[20];
 	    int[] array3 = new int[20];
              
	 for (int i = 0; i < 10; i++) {
             array1[i] = i*2;
             array2[i] = i*2;
	         array3[i] = i*2;

        }
	// sort using Java's inbuilt sorting method
        Arrays.sort(array3);
         
       // run QS1()
        array1 = QS.qs1(array1, 0, array1.length - 1);
        assertArrayEquals(array1,array3);
        
        // run QS2()
        array1 = QS.qs2(array2, 0, array2.length - 1);
        assertArrayEquals(array1,array3);
        
   }
 
  
   /* Method to test the Sorting of a reverse sorted list:
    */
   @Test
   public void testReverseSorted() {
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        
        int[] array3 = new int[10];
        
        for (int i = 0; i < 10; i++) {
             array1[i] = (100-i);
             array2[i] = (100-i);
             array3[i] = (100-i);
        }
        //sort array3 
        Arrays.sort(array3); 
   
        // run QS1()
        array1 = QS.qs1(array1, 0, array1.length - 1);
        assertArrayEquals(array1,array3);
        
        // run QS2()
        array1 = QS.qs2(array2, 0, array2.length - 1);
        assertArrayEquals(array1,array3);
        
   }
   
   /*
    * Method to test the select method 
    */
    @Test
    public void testSelect() {
      int[] array1 = new int[100];
       
      for (int i = 0; i < 100; i++) {
            array1[i] = i;
      }
      // median is 49
      int median=QS.select(array1,0, array1.length-1, array1.length/2);
      System.out.println("median:"+ QS.select(array1,0, array1.length-1, array1.length/2));
      assertEquals(array1[median], 49);   
      
     
      //median is 4
      int[] a = {1, 9, 4, 48, 3};
      int median3=QS.select(a,0, a.length-1, (a.length+1)/2);
      System.out.println("median:"+ QS.select(a,0, a.length-1, ((a.length+1)/2))); 
      assertEquals(a[median3], 4);
        
    	//median is 3
        int[] at = {3, 9, 2};
        int med = QS.select(at,0, at.length-1, (at.length+1)/2);
        System.out.println("median:"+ QS.select(at,0, at.length-1, ((at.length+1)/2))); 
        assertEquals(at[med], 3);
      
      //median is 4
      int[] ab = {4, 93, -1, 5};
      int m = QS.select(ab,0, ab.length-1, ab.length/2);
      System.out.println("median:"+ QS.select(ab,0, ab.length-1, ((ab.length)/2))); 
      assertEquals(ab[m], 4);
      
      //
      int[] ac = {2, 7, 5, 1834, -6, 3, 421, 12};
      int ma = QS.select(ac,0, ac.length-1, ac.length/2);
      System.out.println("median:"+ QS.select(ac,0, ac.length-1, ((ac.length)/2))); 
      assertEquals(ac[ma], 5);
    }
   
 
    /*
     * Method to test the select2 method 
     */
     @Test
     public void testSelect2() {
       int[] array1 = new int[100];
        
       for (int i = 0; i < 100; i++) {
             array1[i] = i;
       }
       // median is 49
       int median=QS.select2(array1,0, array1.length-1, array1.length/2);
       System.out.println("median:"+ QS.select(array1,0, array1.length-1, array1.length/2));
       assertEquals(array1[median], 49);   
       
      
       //median is 4
       int[] a = {1, 9, 4, 48, 3};
       int median3=QS.select2(a,0, a.length-1, (a.length+1)/2);
       System.out.println("median:"+ QS.select(a,0, a.length-1, ((a.length+1)/2))); 
       assertEquals(a[median3], 4);
         
     	//median is 3
         int[] at = {3, 9, 2};
         int med = QS.select2(at,0, at.length-1, (at.length+1)/2);
         System.out.println("median:"+ QS.select(at,0, at.length-1, ((at.length+1)/2))); 
         assertEquals(at[med], 3);
       
       //median is 4
       int[] ab = {4, 93, -1, 5};
       int m = QS.select2(ab,0, ab.length-1, ab.length/2);
       System.out.println("median:"+ QS.select(ab,0, ab.length-1, ((ab.length)/2))); 
       assertEquals(ab[m], 4);
       
       //median is 5
       int[] ac = {2, 7, 5, 1834, -6, 3, 421, 12};
       int ma = QS.select2(ac,0, ac.length-1, ac.length/2);
       System.out.println("median:"+ QS.select(ac,0, ac.length-1, ((ac.length)/2))); 
       assertEquals(ac[ma], 5);
     }
    
     
   /*
    * Method to test the randomness to the tests:
    */
    @Test
     public void testRandom() {
       int[] array1 = new int[10];
       
       for (int i = 0; i < 10; i++) {
            array1[i] = (int) Math.random()*10;
       } 
 
       //copy arrays
       int[] array2 = Arrays.copyOf(array1, array1.length);  
       int[] array3 = Arrays.copyOf(array1, array1.length); // correct sorted array 
       Arrays.sort(array3);
 
       // run QS1()
       array1 = QS.qs1(array1, 0, array1.length - 1);
       assertArrayEquals(array1,array3);
       
       // run QS2()
       array1 = QS.qs2(array2, 0, array2.length - 1);
       assertArrayEquals(array1,array3);
       
     }

   /* Method to test the timing of QS1
    *
    */
   @Test
   public void testQS1Timing()
   {
      // create an array and a sorted backup
	  int[] array1 = QS.populate(10000);
      int[] array2 = QS.populate(1000000);
      int[] array3 = QS.populate(10000000);
      int[] array4 = QS.populate(100000);
      int[] array5 = QS.populate(100000000);
      
      
      long start = System.currentTimeMillis();
      array1 = QS.qs1(array1, 0, array1.length - 1);
      long end = System.currentTimeMillis();
      long elapsed = end - start;
      System.out.println("QS1 time to sort 10000 elements in ms:"+ elapsed);
      System.out.println("QS1 comparisons 10000:" + QS.getPartCount());
      QS.reset();
      
      start = System.currentTimeMillis();
      array2 = QS.qs1(array2, 0, array2.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS1 time to sort 1000000 elements in ms:"+ elapsed);
      System.out.println("QS1 comparisons 1000000:" + QS.getPartCount());
      QS.reset();
      
      start = System.currentTimeMillis();
      array3 = QS.qs1(array3, 0, array3.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS1 time to sort 10000000 elements in ms:"+ elapsed);
      System.out.println("QS1 comparisons 10000000:" + QS.getPartCount());
      QS.reset();
      
      start = System.currentTimeMillis();
      array4 = QS.qs1(array4, 0, array4.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS1 time to sort 100000 elements in ms:"+ elapsed);
      System.out.println("QS1 comparisons 100000:" + QS.getPartCount());
      QS.reset();
      
      start = System.currentTimeMillis();
      array5 = QS.qs1(array5, 0, array5.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS1 time to sort 100000000 elements in ms:"+ elapsed);
      System.out.println("QS1 comparisons 100000000:" + QS.getPartCount());
      QS.reset();
      
   }
   /*
    * Method to test that qs1 works
    */
   @Test
   public void testQS1(){
	   int[] arg = {3, 9, 2, 8, 1};
	   arg = QS.qs1(arg, 0, 4);
	   int[] expected = {1, 2, 3, 8, 9};
	   assertArrayEquals(arg,expected);
	   int[] arg1 = {283, 11, 0, 739, 3, 8};
	   arg1 = QS.qs1(arg1, 0, 5);
	   int[] exp = {0, 3, 8, 11, 283, 739};
	   assertArrayEquals(arg1, exp);
   }
   
   /*
    * Method to test that qs2 works 
    */
   @Test
   public void testQS2(){
	   int[] arg = {3, 9, 2, 8, 1};		
	   arg = QS.qs2(arg, 0, 4);
	   int[] expected = {1, 2, 3, 8, 9};	 
	   assertArrayEquals(arg,expected);
	   
	   int[] arg1 = {3, 9, 2};		
	   arg1 = QS.qs2(arg1, 0, 2);
	   int[] expected1 = {2, 3, 9};		
	   assertArrayEquals(arg1,expected1);
	   
	   
	   int[] arg4 = {1, 9, 4, 48, 3};		
	   arg4 = QS.qs2(arg4, 0, 4);
	   int[] expected4 = {1, 3, 4, 9, 48};
	   assertArrayEquals(arg4,expected4);
	   
	   int[] arg2 = {283, 11, 0, 739, -10, 3, 8}; 	
	   arg2 = QS.qs1(arg2, 0, 6);
	   int[] exp = {-10, 0, 3, 8, 11, 283, 739};
	   assertArrayEquals(arg2, exp);
	   
	   int[] arg3 = {13, 5, 9, 4};		
	   QS.qs2(arg3, 0, 3);
	   int[] ex = {4, 5, 9, 13};		
	   assertArrayEquals(arg3, ex);
   }
   
   /* Method to test the timing of QS2
    *
    */
   @Test
   public void testQS2Timing()
   {
      // create an array and a sorted backup
      int[] array1 = QS.populate(10000); 
      int[] array2 = QS.populate(1000000);	
      int[] array3 = QS.populate(10000000);
      int[] array4 = QS.populate(100000);
      int[] array5 = QS.populate(100000000);
      
      long start = System.currentTimeMillis();
      array1 = QS.qs2(array1, 0, array1.length - 1);
      long end = System.currentTimeMillis();
      long elapsed = end - start;
      System.out.println("QS2 time to sort 10000 elements in ms:"+ elapsed);
      System.out.println("QS2 comparisons 10000:" + QS.getPartCount());
      QS.reset();

      start = System.currentTimeMillis();
      array2 = QS.qs2(array2, 0, array2.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS2 time to sort 1000000 elements in ms:"+ elapsed);
      System.out.println("QS2 comparisons 1000000:" + QS.getPartCount());
      QS.reset();
      
      start = System.currentTimeMillis();
      array3 = QS.qs2(array3, 0, array3.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS2 time to sort 10000000 elements in ms:"+ elapsed);
      System.out.println("QS2 comparisons 10000000:" + QS.getPartCount());
      QS.reset();
      
      start = System.currentTimeMillis();
      array4 = QS.qs2(array4, 0, array4.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS2 time to sort 100000 elements in ms:"+ elapsed);
      System.out.println("QS2 comparisons 100000:" + QS.getPartCount());
      QS.reset();
      
      
      start = System.currentTimeMillis();
      array5 = QS.qs2(array5, 0, array5.length - 1);
      end = System.currentTimeMillis();
      elapsed = end - start;
      System.out.println("QS2 time to sort 100000000 elements in ms:"+ elapsed);
      System.out.println("QS2 comparisons 100000000:" + QS.getPartCount());
      QS.reset();
   } 
   
   /*
    * Method to test that qs3 works
    */
   @Test
   public void testQS3(){
	   int[] arg = {3, 9, 2, 8, 1};
	   arg = QS.qs3(arg, 0, 4);
	   int[] expected = {1, 2, 3, 8, 9};
	   assertArrayEquals(arg,expected);
	   int[] arg1 = {283, 11, 0, 739, 3, 8};
	   arg1 = QS.qs3(arg1, 0, 5);
	   int[] exp = {0, 3, 8, 11, 283, 739};
	   assertArrayEquals(arg1, exp);
	   
	   int[] ar = {3, 9, 2};		
	   ar = QS.qs3(ar, 0, 2);
	   int[] expected1 = {2, 3, 9};		
	   assertArrayEquals(ar,expected1);
	   
	   
	   int[] arg4 = {1, 9, 4, 48, 3};		
	   arg4 = QS.qs3(arg4, 0, 4);
	   int[] expected4 = {1, 3, 4, 9, 48};
	   assertArrayEquals(arg4,expected4);
	   
	   int[] arg2 = {283, 11, 0, 739, -10, 3, 8}; 	
	   arg2 = QS.qs3(arg2, 0, 6);
	   int[] ex = {-10, 0, 3, 8, 11, 283, 739};
	   assertArrayEquals(arg2, ex);
   }
   
   /*
    * Method to test the number of comparisons in sorting an already sorted array of 10 numbers.
    * Number of comparisons should be 45
    */
   @Test
   public void testgetPartCount()
   {
      int[] array1 = new int[10];
      
    //  int[] result1 = new int[10];
      
      for (int i = 0; i < 10; i++) {
           array1[i] = i*20;
      }
      
      array1 = QS.qs1(array1, 0, array1.length - 1);
      System.out.println("comparisons in already sorted:"+ QS.getPartCount());
      long compare=QS.getPartCount();
      assertEquals(compare, 45);
   }

   
   /*
    * Method to test the number of comparisons in reverse sorted array of 10 numbers.
    * Number of comparisons should be 45.
    */	
   @Test
   public void testgetPartCountA()
   {
      int[] array1 = new int[10];
      
      for (int i = 0; i < 10; i++) {
           array1[i] = (100-i);
      }
      
      array1 = QS.qs1(array1, 0, array1.length - 1);
      System.out.println("comparisons in reverse sorted:"+ QS.getPartCount());
      long compare=QS.getPartCount();
      System.out.println("compare:" + compare);
      assertEquals(compare, 45);
         
   } // getPartCount()

   
   /*
    * Method that tests if insertionSort1 works
    * a after method call should be expected 
    */
   @Test
   public void testInsertionSort1(){
	   int[] a = {3, 6, 1, 0, 9, -4};
	   int[] expected = {-4, 0, 1, 3, 6, 9};
	   QS.insertionSort1(a, 0, 5);
	   assertArrayEquals(a, expected);
	   
	   int[] b = {4, 193, -139, 2, 91};
	   int[] exp = {-139, 2, 4, 91, 193};
	   QS.insertionSort1(b, 0, 4);
	   assertArrayEquals(b, exp);
	   
	   int[] c = {1, 2, 3, 4, 5};
	   int[] e = {1, 2, 3, 4, 5};
	   QS.insertionSort1(c, 0, 4);
	   assertArrayEquals(c,e);
   } //insertionSort1()
   
   
} // class QuicksortTest
