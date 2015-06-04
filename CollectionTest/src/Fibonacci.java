import java.util.ArrayList;
import java.util.List;


public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printFiboNacci(10);
		printFiboNacciRecursive(10);
	}

	public static void printFiboNacci(int n) {

		List<Integer> fibo = new ArrayList<Integer>();
		fibo.add(0);
		fibo.add(1);
		int i = 2;
		while (i < n) {
			fibo.add(fibo.get(i - 2) + fibo.get(i - 1));
			i++;
		}
		System.out.println("fibo series " + fibo);

	}

	public static void printFiboNacciRecursive(int n) {

		List<Integer> fibo = new ArrayList<Integer>();
		int i = 0;
		while (i < n){
			fibo.add(findFibo(i));
			i++;
		}
		System.out.println("fibo series " + fibo);
	}

	private static Integer findFibo(int n) {
		return (n == 0 || n == 1) ? n : findFibo(n-1) + findFibo(n-2);
	}

}