package dsa;

public class ModuloAddition {
	
	public static long sumUnderModulo(long a, long b){
		// code here
		int m =(int) Math.pow(10,9)+7;
		return ((a%m)+(b%m))%m;
	}   
	
	static long multiplicationUnderModulo(long a, long b)
    {
        // add your code here
        int m =(int) Math.pow(10,9)+7;
        
        return ((a%m)*(b%m))%m;
    }
	
	public int modMultiplicativeInverse(int a, int m)
    {
      //Your code here
      for(int i=1;i<m;i++){
          if((a*i)%m==1)
          return i;
      }
      
      return -1;
    }


public static void main(String[] args) {
	System.out.println(sumUnderModulo(6, 8));
}
}

