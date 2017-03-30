/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

/**
 *
 * @author Devin Walter
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class SelectionSort {
    
    //implements the selection sort and returns sorted array
    static double[] selectionSort(double[] array){
        for(int i = 0; i < array.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            double small = array[min];
            array[min] = array[i];
            array[i] = small;
        }
        
        return array;
    }
    

    //prints an array to a file
    public static void printArrayToFile(double[] array, String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".txt"));
        for(int i = 0; i < array.length; i++){
            writer.write(array[i] + ", ");
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }
    
    //prints an array to the console
    static void printArrayToConsole(double[] array){
        for(double d : array){
            System.out.print(d + ", ");
        }
    }
    
    //populates the array from a file, the file format should read the first number as int for how many numbers in the array
    //each double should be separated by a new line
    static double[] populateArray(){
        Scanner scan = null;
        try{
            //Commented out code takes user file path to retrieve data, uncommented code means the file path must be changed to right path
            /*Scanner sc = new Scanner(System.in);
            System.out.println("Enter path for data file: ");
            filename = sc.nextLine();
            scan = new Scanner(new File(filename));*/
            scan = new Scanner(new File("C:\\Users\\Administrator\\Downloads\\SomeDataToImport\\temp.dat"));
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        //populates the array
        //takes the first number in file as how many items in array
        int n = scan.nextInt();
        double[] unsortedArray = new double[n];
        for(int i = 0; i < unsortedArray.length; i++){
            unsortedArray[i] = scan.nextDouble();
        }
        scan.close();
        return unsortedArray;
    }

    
    public static void main(String[] args) {
        //creates and prints unsorted array to console
        double[] unsortedArray = populateArray();
        System.out.print("UNSORTED LIST: ");
        printArrayToConsole(unsortedArray);
        System.out.println();
        
        //creates and prints sorted array to console
        double[] sortedArray = selectionSort(unsortedArray);
        System.out.print("SORTED LIST: ");
        printArrayToConsole(sortedArray);
        System.out.println();
        
        //saves array to file
        Scanner scanMain = new Scanner(System.in);
        System.out.print("Enter filename you would like to save to: ");
        String filename = scanMain.nextLine();
        try{
            printArrayToFile(sortedArray, filename);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    
    
}
