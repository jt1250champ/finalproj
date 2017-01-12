import java.util.ArrayList;
import java.util.Arrays;

public class Calculus{
    private static int[] convertPoly(String poly){
	ArrayList<String> powers = new ArrayList<String>();
	for (int i = 0; i < poly.length(); i ++){
	    if (poly.charAt(i) == '^'){
		powers.add("" + poly.charAt(i + 1));
	    }
	}
	int highestPower = 0;
	for (int i = 0; i < powers.size(); i ++){
	    if (Integer.parseInt(powers.get(i)) > highestPower){
		highestPower = Integer.parseInt(powers.get(i));
	    }
	}
	int[] coef = new int[highestPower + 1];
	for (int i = 0; i < coef.length; i ++){
	    coef[i] = 0;
	}
	for (int i = 0; i < poly.length(); i ++){
	    if (poly.charAt(i) == '^'){
		int index = Integer.parseInt("" + poly.charAt(i + 1));
		if (i - 2 >= 0 && poly.charAt(i - 2) != ' '){
		    coef[index] = Integer.parseInt("" + poly.charAt(i - 2));
		}
		else{
		    coef[index] = 1;
		}
	    }
	}
	return coef;
    }    

    public static String derivative(String f){
	return "";
    }

    private static void printAry(int[] ary){
	System.out.println(Arrays.toString(ary));
    }

    public static void main(String[]args){
	printAry(convertPoly("x^2 + x^1"));
	printAry(convertPoly("x^2 + 3x^4 - 4x^0"));
    }
}
