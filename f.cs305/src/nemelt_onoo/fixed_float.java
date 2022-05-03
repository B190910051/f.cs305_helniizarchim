package nemelt_onoo;

public class fixed_float {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2, b = 1 , c = 21;
		
		double result = a + b;
		System.out.println("a+b = " + result);
		
		result = result + c;
		double result1 = b + c;
		System.out.println("b+c = "+result1);
		result1 = result1 + a;
		System.out.println("(a + b) + c = "+result);
		System.out.println("a + (b + c) = "+result1);
	}

}
