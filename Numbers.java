import java.lang.Math.*;

public class Numbers{
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
	while(Math.pow(endbase, i) < num){
	    i ++;
	}
	return i;
    }

    private static int convertFromBase10(){
	return 1;
    }

    public static int convertBase(int startBase, int endBase, int num){
	return 1;
    }

    public static void main(String[]args){
	System.out.println(convertToBase10(2, 10000));
	System.out.println(highestPower(2, 16));
    }
	
}
