
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x1 < 0 && x2 > 0){ // x1 is negative x2 is positive
			int i = 0;
			while ( i < x2){
				x1++;
				i++;
			}
			return x1;
		}
		if (x2 == 0){
			return x1;
		}
		int i = 0;
		while (i < x2) {
		x1++;
		i++;
		}
		if ( x1 < 0 && x2 < 0){
			while (x2 <0){
				x1--;
				x2++;
			}
			return x1;
		}
		if (x1 < 0){ // x1 negative
			while (x1 < 0){
				x1++;
				x2--;
			}
			return x2;
		}
		if (x2 < 0){ // x2 negative
			while (x2 < 0){
				x2++;
				x1--;
			}
			return x1;
		}	
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (0 <= x2){
			for (int i = 0 ; i < x2 ; i++){
				x1--;
			}
			return x1;
		}
		else {
			if ( x1 < 0 && x2 > 0){
				for ( int i = 0 ; i>x2 ; i--){
					x1++;
				}
				return x1;
			}
			for (int i = 0 ; i > x2 ; i--){
				x1++;
			}
			return x1;
		}
	}


	// Returns x1 * x2
	public static int times(int x1, int x2) {
		{
			int j = 0;
			int result = 0;
			if ( x1 < 0 && x2 < 0){ // both are negative!
				for (int i = 0 ; i > x2 ; i--){
					result = minus(result, x1);
				}
				return result;
			}
			if (x1 <0){ // x1 is negative!
				for (int i=0; i<x2;i++){
					result = plus(result, x1);
				}
				return result;
			}
			if (x2 < 0){ // x2 is negative!
				for (int i=0; i<x1;i++){
					result = plus(result, x2);
				}
				return result;
			}
			while (j < x2) { // none negative!
				result = plus(result, x1);
				j++;
			}
			return result;
		}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if ( n == 0){
			return 1;
		}	
		int i = 1;
		int result = 0;
		result = x;
			while (i < n){
			result = times(result,x);
			i++;
			}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0;
		if ( x1 < 0 && x2 < 0){ // both negative!
			while (x1 < 0){ 
				x1 = minus(x1,x2);
				result++;
			}
			return result;
			}
		if ( x1 < 0) {	// x1 is negative
			System.out.println("x1 is" +x1); 
			while (x1 <0){
				x1 = plus(x1,x2);
				System.out.println(x1);
				result--;
			}
			System.out.println(result);
			return result;
		}
		while ( x1 > 0){
			x1 = minus(x1,x2);
			if ( x1 < x2){
				x1 = 0;
			} 
			result++;
		}
		return result;
}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (  x1 == 0){
			return x1;
		}
		if ( x2 == 0 ){
			return x1;
		}
		int result = 0;
		int x3=x2;
		while ( x1 > 0){
			x1 = minus(x1,x2);
			if ( x1 < x2){
				x3=x1;
				x1 = 0;
			} 
			result++;
		}
		return x3;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int p1 = 1;
		int counter = 1;
		while ( x >= p1){
			p1 = times(counter, counter);
			counter++;
			if (  p1 == x){
				return minus(counter,1);
			}
			if ( p1 > x){
				return minus(counter,2);
			}
		}
		return 0;
	}
	
	
}