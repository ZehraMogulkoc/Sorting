import java.io.*;
import java.util.Scanner;

public class Sorting_P5 {
	   public static void shellSort(float[] arr){
	        for (int gap = arr.length / 2; gap > 0; gap /= 2) 
	        {
	            for (int i = gap; i < arr.length; i++)
	            {
	                float newElement = arr[i];
	                int k = i;
	                while (k >= gap && arr[k - gap] > newElement) {
	                    arr[k] = arr[k - gap];
	                    k -= gap;
	                }
	                arr[k] = newElement;
	            }

	        }
	    }
	 public static void insertionSort(float [] arr){

	        for (int first = 1; first < arr.length;
	             first++) {
	            float newElement = arr[first];

	            int i;

	            for (i = first; i > 0 && arr[i - 1] > newElement; i--) {
	                arr[i] = arr[i - 1];
	            }

	            arr[i] = newElement;
	        }
	    }
	 public static int partition(float[] arr, int first, int last) {
	    	
	        //pivot is first element
	        float pivot = arr[first];
	        int i = first;
	        int j = last;

	        while (i < j) {

	       
	            while (i < j && arr[--j] >= pivot);
	            if (i < j) {
	                arr[i] = arr[j];
	            }

	            // empty loop body
	            while (i < j && arr[++i] <= pivot);
	            if (i < j) {
	                arr[j] = arr[i];
	            }

	        }

	        arr[j] = pivot;
	        return j;

	    }
	 public static void quickSort(float[] arr, int first, int last) {
	        if (last - first < 2) {
	            return;
	        }

	        int pivotIndex = partition(arr, first, last);
	        quickSort(arr, first, pivotIndex);
	        quickSort(arr, pivotIndex + 1, last);
	    }
	  public static void selectionSort(float[] arr){
	        for (int i = 0; i < arr.length - 1; i++){
	            int index = i;
	            for (int j = i + 1; j < arr.length; j++){
	                if (arr[j] < arr[index]){
	                    index = j;//searching for lowest index
	                }
	            }
	            float lowestÝndex = arr[index];
	            arr[index] = arr[i];
	           
	            arr[i] = lowestÝndex;
	        } } 
	
	    public static void merge2(float[] arr, int first, int mid, int last) {

	        if (arr[mid - 1] <= arr[mid]) {
	            return;
	        }

	        int i = first;
	        int j = mid;
	        int tempIndex = 0;

	        float[] temp = new float[last - first];
	        while (i < mid && j < last) {
	            temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
	        }

	        System.arraycopy(arr, i, arr, first + tempIndex, mid - i);
	        System.arraycopy(temp, 0, arr, first, tempIndex);


	    }
	    public static void mergeSort(float[] arr, int first, int last) {

	        if (last - first < 2) { return;  }

	        int mid = (first + last) / 2;
	        mergeSort(arr, first, mid);
	        mergeSort(arr, mid, last);
	        merge2(arr, first,  mid, last);
	    }
	public static void main(String[] args) {
		BufferedReader reader;
		int sizeOfArray=0;
		long start;
		long finish;
		long totalTime;
		 String file="src/Query.txt";
		  try {
	        	
	            reader = new BufferedReader(new FileReader(file));
	            String line = reader.readLine();
	            while (line != null) {
	            	sizeOfArray++;
	                line = reader.readLine();
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  
		  float [] data=new float[sizeOfArray];
		  
		  float num;
		  Scanner input = null;
		  try {
	             input = new Scanner(new File(file));

	            for (int i = 0; i <sizeOfArray ; i++) {
	                num= input.nextFloat();
	                data[i]=num;

	            }
	            input.close();
	        }
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }finally {
	            if(input != null){
	                input.close();
	            }
	        }
		   float insertionSort[]=data;
		  float quickSort[]=data;
		  float selectionSort[]=data;
	        float mergeSort[]=data;
	        float shellSort[]=data;
	        
	        
	        //QuickSort running time: 42 miliseconds
	        

	        start = System.currentTimeMillis();
	        quickSort(quickSort,0, quickSort.length);
	        finish   = System.currentTimeMillis();
	        totalTime = finish - start;
	        System.out.println("Quick running time: "+totalTime);

	        
	        //InsertionSort running time: 6  miliseconds
	        
	        start = System.currentTimeMillis();
	        insertionSort(insertionSort);
	        finish   = System.currentTimeMillis();
	        totalTime = finish - start;
	        System.out.println("Insertion running time: "+totalTime);
	        
	        //SelectionSort running time: 14583 miliseconds
	        
	        start = System.currentTimeMillis();
	        selectionSort(selectionSort);
	        finish   = System.currentTimeMillis();
	        totalTime = finish - start;
	        System.out.println("Selection running time:"+totalTime);
	        
	        //merge running time:5  miliseconds

	        start = System.currentTimeMillis();
	        mergeSort(mergeSort,0, mergeSort.length);
	        finish   = System.currentTimeMillis();
	        totalTime = finish - start;
	        System.out.println("Merge running time:"+totalTime);
	        
	      //shell running time:18  miliseconds

	        start = System.currentTimeMillis();
	        shellSort(shellSort);
	        finish   = System.currentTimeMillis();
	        totalTime = finish - start;
	        System.out.println("Shell running time:"+totalTime);
	       
	}

}
