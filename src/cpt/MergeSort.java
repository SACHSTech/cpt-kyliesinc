package cpt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    
    private static List<ShowVid19Record> merge(List<ShowVid19Record> left, List<ShowVid19Record> right, Comparator<ShowVid19Record> comparator){
        // initialize variables
        List<ShowVid19Record> result = new ArrayList<>();
        int intLeftIndex = 0;
        int intRightIndex  = 0;

        // while indexes are both smaller than the list size 
        while (intLeftIndex < left.size() && intRightIndex < right.size()) {
            // if left index is smaller than right index
            if (comparator.compare(left.get(intLeftIndex), right.get(intRightIndex)) < 0) {
                // add element from the left side first and increase left index by 1
                result.add(left.get(intLeftIndex));
                intLeftIndex++;
            }
            // left index is larger than right index or they are same size
            else{
                // add element from the right and increase right index by 1
                result.add(right.get(intRightIndex));
                intRightIndex++;
            }
        }

        // add the remaining elements from the left list 
        while(intLeftIndex < left.size()){
            result.add(left.get(intLeftIndex));
            intLeftIndex++;
        }

        // add the remaining elements from right list
        while (intRightIndex < right.size()){
            result.add(right.get(intRightIndex));
            intRightIndex++;
        }

        return result;
    }

    public static List<ShowVid19Record> mergeSort(List<ShowVid19Record> records, Comparator<ShowVid19Record> comparator) {
        // define variables
        int intRecordsSize = records.size();

        if (intRecordsSize <= 1){
            return records;
        }

        // separate the list into left and right to use merge 
        List<ShowVid19Record> left = records.subList(0, intRecordsSize/2);
        List<ShowVid19Record> right = records.subList(intRecordsSize / 2, intRecordsSize);
        left = mergeSort(left, comparator);
        right = mergeSort(right, comparator);
        // user merge to sort the showvid19 records
        records = merge(left, right, comparator);
        return records;

    }
}
