package twoPointers;

import java.util.Arrays;

class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
       int l = 0;
       int r = people.length-1;
       int count = 0;
       int weight = 0;
       while(l<=r){
           weight = people[l]+people[r];
           if(weight<=limit){
               l++;
               r--;
               count++;
           }
           else{
               r--;
               count++;
           }
       }
        return count;
    }
}