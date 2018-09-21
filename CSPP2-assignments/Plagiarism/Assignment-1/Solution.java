import java.util.Scanner;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<>();
		ArrayList<String> inputnames = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		File folder = new File(line);
		File[] listoffiles = folder.listFiles();
		for (File file1 : listoffiles) {
			try{
			inputnames.add(file1.getName());
			Scanner sc1 = new Scanner(file1);
			String s = "";
			while(sc1.hasNext()) {
				s += 				
			}
				
			}
	}	
	}
}