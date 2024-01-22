import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.BiFunction;

public class ArrayOperations {


    private Map<String, Function<double[], double[]>> sortArrayMap;
    private Map<String, BiFunction<double[], Double, Double>> searchArrayMap;


    public ArrayOperations() {
        sortArrayMap = new HashMap<>();
        searchArrayMap = new HashMap<>();
        initializeMap();
    }


    // Initiliaizes the Maps so they are able to be called upon
    private void initializeMap() {

        sortArrayMap.put("Sort Array", this::mergeSort);
        searchArrayMap.put("Search Sorted Array", this::searchElement);
    }

    // Used to tell if it a Sort Operation
    public boolean isSortOperation(String operationName) {

        if (sortArrayMap.containsKey(operationName)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Used to tell if it a Search Operation
    public boolean isSearchOperation(String operationName) {

        if (searchArrayMap.containsKey(operationName)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Performs the Sort Operations
    public double[] performSortOperation(String operationName, double[] arr) {

        double[] result = sortArrayMap.get(operationName).apply(arr);
        return result; // Return the first element of the sorted array

    }

    // Performs the Search Array Operations
    public double performSearchArray(String operationName, double[] arr, double searchItem) {

        double result = searchArrayMap.get(operationName).apply(arr, searchItem);
        
        return result;
    }
    



    /////////////////////////////////////////////////
    ////              SORT ARRAY OPERATIONS
    /////////////////////////////////////////////////

    // Main entry point for merge sort with DOUBLES
    private double[] mergeSort(double[] array) {

        if (array.length >= 2) {
            // Calculate mid index
            int mid = array.length / 2;

            // Create left and right subarrays
            double[] left = Arrays.copyOfRange(array, 0, mid);
            double[] right = Arrays.copyOfRange(array, mid, array.length);

            // Recursively sort the left and right subarrays
            double[] sortedLeft = mergeSort(left);
            double[] sortedRight = mergeSort(right);

            // Merge the sorted left and right subarrays
            return merge(sortedLeft, sortedRight);
        } else {
            // If the array has one or zero elements, return it as is
            return array;
        }
    }

    // Merge two sorted arrays into a single sorted array
    private double[] merge(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Compare elements from left and right arrays and merge
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy any remaining elements from the left array
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Copy any remaining elements from the right array
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
    


    
    /////////////////////////////////////////////////
    ////          SEARCH ARRAY OPERATIONS
    /////////////////////////////////////////////////

    // Binary Search: Searches for an element in the given array
    private double searchElement(double[] arr, double searchItem) {

        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == searchItem) {
                return (double) mid; // Change int --> double[] can also do int --> double with "(double) mid"
            } else if (searchItem > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1; // If element wasn't found return -1
    } 
}

