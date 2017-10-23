package sjsu.magal.cs146.project2;

import java.util.Random;

/*
 * methods from tester:
 * .reset()
 * .qs1(array1, num, length)  - returns an array
 * .qs2(array1, num, length)  - returns an array 
 * .select(array1,num, length, length/2) --> finds median
 * .populate(n) populates an array of length n 
 * .getPartCount() gets the number of comparisons
 */
public class Quicksort {	
	long partCount; 
	Random gen;
	
	public Quicksort() {
		partCount = 0;
		gen = new Random();
	}
	
	public void reset(){		
		partCount = 0;
		gen = new Random();
	}
	
	public int[] qs1(int[] array, int start, int end){   //pivot is last element 
		int pivot; 
		if (start < end){
			pivot = partition(array, start, end);
			qs1(array, start, pivot-1);
			qs1(array, pivot+1, end);
		}
		return array;
	}
	
	//returns index of pivot
	public int partition(int[] array, int start, int end) {
		int x = array[end];
		int i = start - 1;
		for (int j = start; j <= end - 1; j++){
			if (array[j] <= x){
				
				i++;
				swap(array, i, j);
			}
			partCount++;
		}
		swap(array, i+1, end);
		return i+1;
	}
	
	public void swap(int[] array, int one, int two){
		int o = array[one];
		array[one] = array[two];
		array[two] = o;
	}
	
	public int[] qs2(int[] array, int start, int end){  //pivot is median 
		int pivot;
		int stat;
		if (start < end) { 
			//if 3 elements, 0,1,2.  2-0 = even but there is odd
			if ((end-start)%2 == 1){ //actually odd 
				stat = ((end-start)+1)/2;
			} else { //even
				stat = ((end-start)/2);
			}
			pivot = select(array, start, end, stat);
			qs2(array, start, pivot-1);
			qs2(array, pivot+1, end);
		}
		return array;
	}
	
	/**
	 * selects ith order statistic and returns the index (n/2)
	 * @param array input array
	 * @param start index start of array
	 * @param end index end of array 
	 * @param stat which order statistic you want
	 * @return the ith order statistic 
	 */
	public int select(int[] array, int start, int end, int stat){
		if(start == end){
			return start;  //array[start]
		}
		int q = partitionRandom(array, start, end);
		int k = q - start + 1;
		if (stat == k){	
			return q; 	//array[q]
		}
		else if (stat < k){
			return select(array, start, q-1, stat);
		}
		else return select(array, q+1, end, stat - k);
	}
	
	//partitions using a randomly generated number
	public int partitionRandom(int[] array, int start, int end){
		int i = gen.nextInt((end-start) + 1) + start;
		swap(array, end, i);
		return partition(array, start, end); 			
	}

	public int[] qs3(int[] array, int start, int end){  //pivot is median of medians deterministic
		if (end-start > 1) { //if(start < end) else
			int pivot;
			boolean even = true;
			if ((end-start)%2 == 0) even = false;	//if 3 elements, 0,1,2.  2-0 = even but there is odd
			if(!even){ //actually odd
				pivot = select2(array, start, end, ((end-start)+1/2));
				qs2(array, start, pivot-1);
				qs2(array, pivot+1, end);

			} else { //even
				pivot = select2(array, start, end, ((end-start)/2));
				qs2(array, start, pivot-1);
				qs2(array, pivot+1, end);
			}
		} else {
			insertionSort1(array, start, end);
		}
		return array;
	}
	
	//select method for qs3
	public int select2(int[] array, int start, int end, int stat){
		int numGroups = (int)Math.ceil((end-start)/5);
		int groupLength = (end-start)/numGroups;
		if (numGroups == 1){
			return partitionM(array, start, end, start);
		}
		for(int i = 1; i <= numGroups; i++){
			insertionSort1(array, start, groupLength); 
			insertionSort1(array, i*groupLength, i*2*groupLength); 
			insertionSort1(array, i*2*groupLength + 1, i*3*groupLength); 
			insertionSort1(array, i*3*groupLength + 1, i*4*groupLength); 
			insertionSort1(array, i*4*groupLength + 1, end);
			int one = findMedianIndex(array, start, groupLength);
			int two = findMedianIndex(array, groupLength, 2*groupLength);
			int three = findMedianIndex(array, i*2*groupLength + 1, i*3*groupLength);
			int four = findMedianIndex(array, i*3*groupLength + 1, i*4*groupLength);
			int five = findMedianIndex(array, 4*groupLength + 1, end);
			swap(array, 0, one);
			swap(array, 1, two);
			swap(array, 2, three);
			swap(array, 3, four);
			swap(array, 4, five);
		}
		return select2(array, 0, 5, 2);
	}
	
	//finds the index of the median of the array between start and end
	public int findMedianIndex(int[] array, int start, int end){
		insertionSort1(array, start, end);
		if (end - start % 2 == 1) //even
			return (((end-start)+1)/2);
		else return ((end-start)/2);
	}
	
	//partition method for qs3
	public int partitionM(int[] array, int start, int end, int median) {
		int x = array[median];
		int i = start - 1;
		for (int j = start; j <= end - 1; j++){
			if (array[j] <= x){
				partCount++;
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i+1, end);
		return i+1;
	}
	
	//sorts array from start to end indices using insertion sort
	public static void insertionSort1(int[] array, int start, int end){
		for(int i = start; i <= (end-start); i++){
			int key = array[i];
			int j = i - 1;
			while (j >= start && array[j] > key){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
	}
	
	public int[] populate(int n){
		int[] a = new int[n];
		for(int i = 0; i < n; i++){	
			a[i] = gen.nextInt(n);
		}
		return a;
	}
	
	public long getPartCount(){
		return partCount;
	}
	
	
}
