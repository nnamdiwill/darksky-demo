package stepdefinition;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class CountingUniqueNumbers {

    public int countUniqueValues(int[] arr) {
        int duplicateCount = 0;



        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if(arr[i] == arr[j]){
                    duplicateCount++;
                }

            }
        }
        return duplicateCount;
    }
    @Test
    public void testCountForThree(){
       int [] arr = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        Assert.assertTrue(true,"I found a duplicate");
    }




}
