package arrays;

import java.util.Arrays;
import java.util.Collections;

// spell[i]*{any(potion[i])>= success}
public class SuccessfulSpellsAndPotions
{
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
       Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++) {
            int l = 0, r = potions.length;
            
            while(l < r) {
                int m = l + (r - l) / 2;
                
                if((long)spells[i]*potions[m]  >= success)
                    r = m;
                else
                    l = m + 1;
            }
            
            spells[i] = potions.length - l;
        }
        
        return spells;
    }
}