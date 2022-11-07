import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

public class Assignment4 {

	private static LinkedHashSet set1 = new LinkedHashSet();
	private static LinkedHashSet set2 = new LinkedHashSet();
	
	public static void main(String[] args) {
		
	//question 1 	
	System.out.println("\nQuestion 1");
		
	set1.add("George");
	set1.add("Jim");
	set1.add("John");
	set1.add("Blake");
	set1.add("Kevin");
	set1.add("Michael");
	
	set2.add("George");
	set2.add("Katie");
	set2.add("Kevin");
	set2.add("Michelle");
	set2.add("Ryan");
	
	System.out.println("Union of set1 and set2:" + findUnion(set1, set2));
	
	System.out.println("Difference of set1 and set2:" + findDifference(set1, set2));
	
	System.out.println("Intersection of set1 and set2:" + findIntersection(set1, set2));
	
	
	//Question 2
	System.out.println("\nQuestion 2");
	try {
		String URL = "C:\\Users\\pablo\\Desktop\\randomWords.txt";
		File file = new File(URL);
		sortAndReadFile(file);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	//Question 3
	System.out.println("\nQuestion 3");
	
	System.out.println("Number in UK format: " + formatForUK(12345.678));
	
	System.out.println("Currency in the US format: " + formatForUS(12345.678));
	
	System.out.println("number from string: " + parseIntWithCommas("12,345.678"));
	
	
		
	}
	
	private static LinkedHashSet findUnion(LinkedHashSet s1, LinkedHashSet s2) {
		
		LinkedHashSet UnionSet = new LinkedHashSet();
			
		UnionSet = (LinkedHashSet) s1.clone(); 
		UnionSet.addAll(s2);
		
		return UnionSet;
	}
	
	private static LinkedHashSet findDifference(LinkedHashSet s1, LinkedHashSet s2) {
		
		LinkedHashSet DifferenceSet = new LinkedHashSet();
		
		DifferenceSet = (LinkedHashSet) s1.clone();  
		DifferenceSet.removeAll(s2);
		
		return DifferenceSet;
	}

	private static LinkedHashSet findIntersection(LinkedHashSet s1, LinkedHashSet s2) {
		
		LinkedHashSet IntersectionSet = new LinkedHashSet();
		
		IntersectionSet = (LinkedHashSet) s1.clone();  
		IntersectionSet.retainAll(s2);
		
		return IntersectionSet;
		
	}
	
	private static void sortAndReadFile(File f) {
		
		TreeSet sortedWords = new TreeSet();
		
		try {
			FileReader fileReader = new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String word;
			
			while((word = bufferedReader.readLine()) != null){
				bufferedReader.readLine();
				sortedWords.add(word);
			}
			
			System.out.println("Sorted list of words: " + sortedWords);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String formatForUK(double d) {
		Locale l = new Locale("en", "UK");
		NumberFormat nf = NumberFormat.getInstance(l);
		return nf.format(d); 
	}
	
	private static String formatForUS(double d) {
		Locale l = new Locale("en", "US");
		NumberFormat nf = NumberFormat.getCurrencyInstance(l);
		return nf.format(d); 
	}

	private static double parseIntWithCommas(String s) {
		Locale l = new Locale("en", "US");
		NumberFormat nf = NumberFormat.getInstance(l);
		try {
			return nf.parse(s).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
}
