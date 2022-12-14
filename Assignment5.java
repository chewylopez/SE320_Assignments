import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Assignment5 {

	public static void main(String[] args) {

		//question 1
		System.out.println("i've been alive for: " + daysAlive(new Day(2001, 10, 15), new Day(2022, 12, 14)) + " days");
		
		//question 2
		List<String> sample = new ArrayList();
		sample.add("1");
		sample.add("fd");
		sample.add("123");
		sample.add("468");
		sample.add("er");
		sample.add("23");
		sample.add("23");
		sample.add("76");
		sample.add("468");
		
		removeDuplicates(sample);

	}
	//question 1
	private static int daysAlive(Day born, Day today) {
		return today.daysFrom(born);
	}
	
	
	/*
	 * question 2:
	 * The list must be sorted so I implemented a generic sorting algorithm into the method after the empty check, this guarantees the method works
	 * every time regardless of the initial list state
	 */
	public static void removeDuplicates(List lst) {
		if (lst == null || lst.size() == 0) {
			return;
		}
		
		List sorted = selectionSort(lst);
		
		List copy = new ArrayList(sorted);
		Iterator elements = copy.iterator();
		Object pre = elements.next();
		while (elements.hasNext()) {
			Object nex = elements.next();
			if (pre.equals(nex)) {
				lst.remove(nex);
			} else {
				pre = nex;
			}
		}
		//check if working
		printList(lst);
	}
	
	//stealing this from another class's assignment
	private static <T extends Comparable> List<T> selectionSort(List l) {
		
		List<T> sortedArray = l;
		
 		//iterate for whole array
		for(int i = 0; i < sortedArray.size(); i++) {
			
			T currentLowest = sortedArray.get(0);
			int currentLowestIndex = 0;
			
			//search for lowest from i -> end (elements before i are sorted)
			for(int j = i; j < sortedArray.size(); j++) {
				if(currentLowest.compareTo(sortedArray.get(j)) < 0) {
					currentLowest = sortedArray.get(j);
					currentLowestIndex = j;
				}
			}
			//remove lowest
			sortedArray.remove(currentLowestIndex);
			
			//re-add it at position i
			sortedArray.add(i, currentLowest);
			
			//print iteration
			printList(sortedArray);
			
		}
		return sortedArray;
	}
	
	//for visual aid
	private static <T> void printList(List<T> arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i)+ ", ");
		}
		System.out.println("");
	}
	
	//question 3
	private class Person {
		private String firstName;
		private String lastName;
		
		public boolean equals(Object obj) {
			if(!(obj instanceof Person)) return false;
			Person that = (Person) obj;
			return this.lastName.toUpperCase().equals(that.lastName.toUpperCase());
		}
		//assuming that the goal is to always compare with uppercase letters, this returns the hash of the uppercase lastname
		public int hashCode() {
			return this.lastName.toUpperCase().hashCode();
		}
	}

}
