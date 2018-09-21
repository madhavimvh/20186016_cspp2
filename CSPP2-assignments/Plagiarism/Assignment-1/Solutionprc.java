import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
class Filereader {
	String[] word;
	Filereader() {
	}
	Filereader(String f) {
		word = Fileinput(f);
	}
	public String[] Fileinput(String f) {
		System.out.println("f" + f);
		String file = "";
		String[] s = null;
	try {
		Scanner scan = new Scanner(new File(f));
		while(scan.hasNext()) {
			file += scan.nextLine().toLowerCase().replaceAll("[^a-z0-9_ ]", "");
		}
		s = file.split(" ");
	} catch (Exception ex) {
		System.out.println("-----file not found");
		ex.printStackTrace();
	}
	System.out.println("jk" + Arrays.toString(s));
	return s;
	}

	public String[] getWord() {
		return this.word;
	}
}

class Plagiarism {
	HashMap<String, Integer> map;
	// ArrayList<String> words;
	String[] words;
	public Plagiarism(){
	}
	public Plagiarism(String[] words) {
		map = new HashMap<String, Integer>();
		this.words = words;
	}
	public HashMap<String, Integer> freq(){
		// for (String s:words) {
		// 	map.putIfAbsent(s, 0);
		// 	map.put(s, map.get(s) + 1);
		// }
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])){
				map.put(words[i], map.get(words[i]) + 1);
			} else {
				map.put(words[i], 1);
			}
		}
		System.out.println(map);
		return map;
		}
}
class Calculate {
	HashMap<String, Integer> map1;
	HashMap<String, Integer> map2;
	HashMap<String, Integer> map;
	Calculate(HashMap<String, Integer> map0, HashMap<String, Integer> map01) {
		map1 = map0;
		map2 = map01;
		map = new HashMap<String, Integer>();
	}
	public double dotProduct() {
		double x = 0;
		for (String s : map1.keySet()) {
			if (map2.containsKey(s)) {
				x += map1.get(s) * map2.get(s);
			} else {
				x += 0;
			}
		}
		return x;
	}
	public double euclidean(HashMap<String, Integer>map1) {
		double x = 0;
		double a = 0;
		for (String s : map1.keySet()) {
			x += Math.pow(map1.get(s), 2);
		}
		a = Math.sqrt(x);
		return a;
	}
	public double distance(double x, double b, double c) {
		double cos = 0;
		cos = (x / (b*c)) * 100.0;
		return Math.round(cos * 100.0) / 100.0;
	}
}


public class Solutionprc {
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> inputnames = new ArrayList<String>();
		Scanner sc = new  Scanner(System.in);
		File folder = new File(sc.nextLine());
		File[] listoffiles = folder.listFiles();
		String s = "";
		try {
			for (File file1 : listoffiles) {
				inputnames.add(file1.getName());
/*				Scanner sc1 = new Scanner(file1);
				while(sc1.hasNext()) {
					s += sc1.nextLine() + " ";
				}
				input.add(s);*/
			}
			System.out.print("\t\t");
			for (int i = 0; i < listoffiles.length - 1; i++) {
				System.out.print(inputnames.get(i) + "\t");
			}
			System.out.print(inputnames.get(listoffiles.length - 1));


			System.out.println();
			for (int i = 0; i < listoffiles.length; i++) {
				System.out.println(inputnames.get(i) + "\t");
				
				//Plagiarism plag1 = new Plagiarism(new Filereader(inputnames.get(i) + "").getWord());
				for (int j = 0; j < inputnames.size(); j++) {
					Plagiarism plag2 = new Plagiarism(new Filereader(inputnames.get(i) + "").getWord());	
				}
			}

		} catch (Exception ex) {
			System.out.println("file not found");
		}
		// HashMap<String, Integer> map1 = plag1.freq();
		// HashMap<String, Integer> map2 = plag2.freq();
		// Calculate c = new Calculate(map1, map2);
		// System.out.println(c.distance(c.dotProduct(), c.euclidean(map1), c.euclidean(map2)));	

	}
}