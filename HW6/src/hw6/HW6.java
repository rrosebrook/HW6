/*
Rachel Rosebrook
CS2
*/
package hw6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;





public class HW6 {
    static int SIZE;
    static int BIG;
    static int[] array;
    static float[] arrayfloat;
    static String[] arraystring;
    //static int[] copy;
//    static String regex = "^[0-9]*$";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        userInput();
        calculateCPUSorts();
        calculateCPUFloatSorts();
        getRandoString();
        //sort();
        //sort();
    }
    
public static void Mergesort(int[] a, int low, int high) 
    {
        int N = high - low;         
        if (N <= 1) 
            return; 
        int mid = low + N/2; 
        // recursively sort 
        Mergesort(a, low, mid); 
        Mergesort(a, mid, high); 
        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) 
        {
            if (i == mid)  
                temp[k] = a[j++];
            else if (j == high) 
                temp[k] = a[i++];
            else if (a[j]<a[i]) 
                temp[k] = a[j++];
            else 
                temp[k] = a[i++];
        }    
        /*for (int k = 0; k < N; k++) 
            a[low + k] = temp[k];*/         
    }

public static void Mergesort(float[] a, int low, int high) 
    {
        int N = high - low;         
        if (N <= 1) 
            return; 
        int mid = low + N/2; 
        // recursively sort 
        Mergesort(a, low, mid); 
        Mergesort(a, mid, high); 
        // merge two sorted subarrays
        float[] temp = new float[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) 
        {
            if (i == mid)  
                temp[k] = a[j++];
            else if (j == high) 
                temp[k] = a[i++];
            else if (a[j]<a[i]) 
                temp[k] = a[j++];
            else 
                temp[k] = a[i++];
        }    
        /*for (int k = 0; k < N; k++) 
            a[low + k] = temp[k];*/         
    }


public static void Mergesort(String[] names)  {  
        if (names.length >= 2)  
        {  
            String[] left = new String[names.length/2];  
            String[] right = new String[names.length-names.length/2];  
               
            for (int i = 0; i < left.length; i++)  
            {  
                left[i] = names[i];  
            }  
            for (int i = 0; i < right.length; i++)  
            {     
                right[i] = names[i + names.length/2];  
            }  
   
            Mergesort(left);  
            Mergesort(right);  
            merge(names, left, right);  
        } 
    }

public static void merge(String[] names, String[] left, String[] right)
    {
        int i1 = 0;
        int i2 = 0;
         
        for (int i = 0; i < names.length; i++)
        {
            if (i2 >= right.length || (i1 < left.length && left[i1].compareToIgnoreCase(right[i1])<0))
            {
                names[i] = left[i1];
                i1++;
            } else
            {
                names[i] = right[i2];
                i2++;               
            }
        }
    } 

private static void sort(){
    array = new int[SIZE];
    Random rand = new Random();
    for (int i = 0; i < array.length; i++)
        array[i] = rand.nextInt(BIG) + 1;
        //System.out.println(Arrays.toString(array));
            Mergesort(array, 0, SIZE);
        //Arrays.sort(array);
    //System.out.println(Arrays.toString(array));
}    

public static String getRandoString() {
    String randoCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    StringBuilder rando = new StringBuilder();
    Random r = new Random();
    //for(int i=0; i<SIZE; i++) {
        while (rando.length() < 6) { // length of the random string.
            int index = (int) (r.nextFloat() * randoCHARS.length());
            rando.append(randoCHARS.charAt(index));
            }
    String randoStr = rando.toString();
            //return randoStr;
    System.out.println(randoStr);
      
        
            return randoStr;
    //}
    //return arraystring[];
}

/*public static void getRandoStringArray(String getRandoString){
    for(int i=0; i<SIZE; i++) {
        List<String> randolist = new getRandoString();
            //arraystring[i] = new getRandoString();
    }  
}*/


private static void sortFloat(){
    Float floatSIZE = (float)SIZE;
    Float floatBIG = (float)BIG;
    arrayfloat = new float[SIZE];
    Random rand = new Random();
    for (int i = 0; i <arrayfloat.length; i++)
        arrayfloat[i] = rand.nextFloat() * BIG + 1;
            Mergesort(arrayfloat, 0, SIZE);
        
}

public static void calculateCPUSorts() {
    //int[] copy = (int[])array.clone();
    //int[] copy = new int[array.length];
    //System.arraycopy(array, 0, copy, 0, array.length); 
    long startTime = System.nanoTime();
    sort();
    long stopTime = System.nanoTime();
    long duration = (stopTime - startTime);
    System.out.println("Merge Sort: " + duration + " nanoseconds.");
    
    long startTimeSort = System.nanoTime();
    Arrays.sort(array);
    long stopTimeSort = System.nanoTime();
    long durationSort = (stopTime - startTime);
    System.out.println("Internal Sort: " + durationSort + " nanoseconds");
}

public static void calculateCPUFloatSorts() {
    long startTime = System.nanoTime();
    sortFloat();
    long stopTime = System.nanoTime();
    long duration = (stopTime - startTime);
    System.out.println("Merge Sort on floats: " + duration + " nanoseconds.");
    
    long startTimeSort = System.nanoTime();
    Arrays.sort(array);
    long stopTimeSort = System.nanoTime();
    long durationSort = (stopTime - startTime);
    System.out.println("Internal Sort on floats: " + durationSort + " nanoseconds");
}

private static void findArraySize() {
    System.out.println("What is the size of this array?");
    Scanner userSIZE = new Scanner(System.in);
    String SIZEline = userSIZE.nextLine(); 
        while (true) {
            if(SIZEline.length() >= 0) {
                try {
                    SIZE = Integer.parseInt(SIZEline);
                    break;
                }
                catch (NumberFormatException e) {
                   //do nothing
                }
            }
            System.out.println("Please enter a number");
            SIZEline = userSIZE.nextLine();
        }
}

private static void userInput() {
    findArraySize();
    System.out.println("What is the largest value you wish in this array?");
    Scanner userBIG = new Scanner(System.in);
    String BIGline = userBIG.nextLine();
        while (true) {
            if(BIGline.length() >= 0) {
                try {
                    BIG = Integer.parseInt(BIGline);
                    break;
                }
                catch (NumberFormatException e) {
                   //do nothing
                }
            }
            System.out.println("Please enter a number");
            BIGline = userBIG.nextLine();
        while (true) {
            if(BIG<SIZE) {
                System.out.println("You need to enter a number larger than " + SIZE);
                BIGline = userBIG.nextLine();
            }
        }
    
    }
    
}
}
