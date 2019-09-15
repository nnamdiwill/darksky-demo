package stepdefinition;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumZero {

    public int [] sumZero(int [] arr){
        for(int i = 0; i <= arr.length; i++){
            for(int j = i +1; j<= arr.length; j++){

                if(arr[i] + arr[j] == 0){
                    System.out.println(i +" + " + j + " equal zero");
                    break;

                }
                if (arr[i] + arr[j] != 0) {
                    return null;
                }
            }
        }
        return arr;
    }

    @Test
    public void testPairOfThree(){
        int []arr = {-3,-2,-1,0,1,2,3};
       int [] pair = sumZero(arr);
       if (pair != null){
           int result = pair[0] + pair[1];
           Assert.assertEquals(result,0);
       }


    }

    @Test
    public void testNull(){
        int []arr = {1,2,3};
        Assert.assertNull(sumZero(arr));
    }
}
