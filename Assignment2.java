import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Assignment2 {

	public static void main(String[] args) {
		
		// question 2
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(14);
//		list.add(24);
//		list.add(14);
//		list.add(42);
//		list.add(25);
//		ArrayList<Integer> newList = removeDuplicates(list);
//		System.out.print(newList);
		
		
		
		// question 3
		Scanner s = new Scanner(System.in);
		System.out.println("input a number between 0 and 10: ");
		int input = s.nextInt();	
		
		assert(input <= 10 && input >= 0): "the entered number is out of range";
		
		}
	
		public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){ 
			
			ArrayList<E> retList = new ArrayList<E>(); 
			
			//hashsets automatically restrict duplicates
			Set<E> hash = new HashSet<E>(list);
			retList.addAll(hash);
			return retList;
		}
}
