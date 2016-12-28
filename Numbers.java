public class Numbers{
    private static int ConvertToBase10(int startbase, int num){
	int baseTen = 0;
	int i = 0;
	while(num > 0){
	    baseTen += (num % 10) * (startbase ^ i);
	    num = num / 10;
	    i ++;
	}
	return baseTen;
    }

    public static int ConvertBase(int startBase, int endBase, int num){
	return 1;
    }

    public static void main(String[]args){
	System.out.println(ConvertToBase10(2, 10000));
    }
	
}
