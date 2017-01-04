import java.lang.Math.*;
import java.util.ArrayList;

public class Numbers{
    //converting the base stuff:
    private static int convertToBase10(int startbase, int num){
	int baseTen = 0;
	int i = 0;
	while(num > 0){
	    baseTen += (num % 10) * (Math.pow(startbase, i));
	    num = num / 10;
	    i ++;
	}
	return baseTen;
    }

    private static int highestPower(int endbase, int num){
	int i = 0;
	while(Math.pow(endbase, i) <= num){
	    i ++;
	}
	return i - 1;
    }

    private static int convertFromBase10(int endbase, int num){
	int finalNum = 0;
	for (int i = highestPower(endbase, num); i >= 0; i --){
	    int digit = 0;
	    while (highestPower(endbase, num) == i){
		if (num - Math.pow(endbase, i) >= 0){
		    num -= Math.pow(endbase, i);
		    digit ++;
		}
	    }
	    finalNum += digit * (Math.pow(10, i));
	}
	return finalNum;
    }

    public static int convertBase(String startbase, String endbase, String n){
	int startBase = Integer.parseInt(startbase);
	int endBase = Integer.parseInt(endbase);
	int num = Integer.parseInt(n);
	int baseTen = convertToBase10(startBase, num);
	return convertFromBase10(endBase, baseTen);
    }

    //prime factorization stuff:
    private static int largestFactor(int num){
	for (int i = num - 1; i >= Math.sqrt(num); i --){
	    if (num % i == 0){
		return i;
	    }
	}
	return 1;
    }
    
    public static String primeFactorize(String n){
	int num = Integer.parseInt(n);
	String factor = "";
	int largest = largestFactor(num);
	int smallest = num / largest;
	ArrayList<String> primes = new ArrayList<String>();
	if (largest == 1){
	    primes.add("" + num);
	}
	while (largest != 1){
	    primes.add("" + smallest);
	    smallest = largest / largestFactor(largest);
	    if (largestFactor(largest) ==  1){
		primes.add("" + largest);
	    }
	    largest = largestFactor(largest);
	}
	for (int i = 0; i < primes.size(); i ++){
	    String prime = primes.get(i);
	    int pow = 0;
	    while (i < primes.size() && (primes.get(i)).equals(prime)){
		pow ++;
		i ++;
	    }
	    factor = factor + prime + "^" + pow + " * ";
	    i --;
	}
	factor = factor.substring(0, factor.length() - 3);
	return factor;
    }
    
    
    //tests:
    public static void main(String[]args){
	//tests for converting base
	System.out.println(highestPower(10, 16));
	System.out.println(convertFromBase10(10, 16));
	System.out.println(convertBase("2", "10", "10000"));
	System.out.println(convertBase("10", "4", "16"));
	System.out.println(convertBase("2", "4", "10000"));

	//tests for prime factorizing
	System.out.println(largestFactor(10));
	System.out.println(primeFactorize("10"));
	System.out.println(primeFactorize("96"));
	System.out.println(primeFactorize("97"));
    }
	
}
