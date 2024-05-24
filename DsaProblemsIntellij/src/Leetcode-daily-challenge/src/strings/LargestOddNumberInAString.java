package strings;

import java.util.ArrayList;

class LargestOddNumberInAString {
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int i = n;i>0;i--){
            if(Integer.valueOf(num.substring(i-1,i))%2 != 0)
                return num.substring(0,i);
        }
        return "";
    }
}