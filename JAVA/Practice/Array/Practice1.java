
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayPractice {
	
	public static Scanner sc = new Scanner(System.in);
	public static Random r = new Random();
	
	public static void main(String[] args) {
		ArrayPractice ap = new ArrayPractice();
//		ap.practice1();
//		ap.practice2();
//		ap.practice3();
//		ap.practice4();
//		ap.practice5();
//		ap.practice6();
//		ap.practice7();
//		ap.practice8();
//		ap.practice9();
		  ap.practice10();
	}
	
	public void practice1() {
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 순서대로 배열 인덱스에 넣은 후 그 값을 출력하세요.
    // 1 2 3 4 5 6 7 8 9 10
		int array[] = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
			System.out.print(array[i] + " "); // 1.
		}
    System.out.println(Arrays.toString(array)); //2. 둘다 가능
	}
