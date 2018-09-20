import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
class Filereader {
	String[] word;
	Filereader(String f) {
		word = Fileinput(f);
	}
	public String[] Fileinput(String f) {
		String[] file = null;
		String[] s = null;
		try {
		Scanner scan = new Scanner(new File(f));
		while(scan.hasNext()) {
			
			file = scan.nextLine().toLowerCase().replaceAll("[^a-z0-9_ ]", "").split(" ");
			
			System.out.println(Arrays.toString(file));
				
		}
	} catch (Exception ex) {
		System.out.println("file not found");
	}
	System.out.println("jk" +Arrays.toString(file));
	return file;
	}
	public String[] getwords() {
		return word;
	}
}
public class Solution {
	public static void main(String[] args) {
		Filereader input1 = new Filereader("file1.txt");
		Filereader input2 = new Filereader("file2.txt");
		System.out.println(input1);
		System.out.println(input2);
	}
}
class Plagiarism {
	HashMap<String, Integer> map;
	// ArrayList<String> words;
	List<String> words;
	private Plagiarism(List<String> words) {
		map = new HashMap<String, Integer>();
		this.words = words;
	}
	public void freq(List<String> words){
		// for (String s:words) {
		// 	map.putIfAbsent(s, 0);
		// 	map.put(s, map.get(s) + 1);
		// }
		for (int i = 0; i < words.size(); i++) {
			if (map.containsKey(words.get(i))){
				map.put(words.get(i), map.get(words.get(i)) + 1);
			} else {
				map.put(words.get(i), 1);
			}
		}
		System.out.println(map);
		}
}
class Calculate {
	HashMap<String, Integer> map1;
	HashMap<String, Integer> map2;
	HashMap<String, Integer> map;
	double x = 0;
	double a = 0;
	Calculate(HashMap<String, Integer> map0, HashMap<String, Integer> map01, HashMap<String, Integer> map001) {
		map1 = map0;
		map2 = map01;
		this.x = x;
		this.a = a;
	}
	public double dotProduct(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
		for (String s : map1.keySet()) {
			if (map2.containsKey(s)) {
				x += map1.get(s) * map2.get(s);
			} else {
				x += 0;
			}
		}
		return x;
	}
	public double euclidean(HashMap<String, Integer> map) {
		for (String s : map1.keySet()) {
			x += Math.pow(map.get(s), 2);
		}
		a = Math.sqrt(x);
		return a;
	}
	public double distance(double x, double b, double c) {
		double cos = 0;
		cos = x / (b*c);
		return cos;
	}
}

