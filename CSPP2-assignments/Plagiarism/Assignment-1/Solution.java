import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
class Stringmatching {
	private File file1;
	private File file2;
	private String[] p;
	private String[] q;
	private int l1;
	private int l2;
	public Stringmatching(File filee1, File filee2) {
		this.file1 = filee1;
		this.file2 = filee2;
		p = null;
		q = null;
		l1 = 0;
		l2 = 0;
		try {

		Scanner sc1 = new Scanner(file1);
		Scanner sc2 = new Scanner(file2);
		String s = "";
		while(sc1.hasNext()) {
			s += sc1.nextLine();
		}
		l1 = s.length();
		p = s.toLowerCase().replaceAll("[^a-z0-9 ]", "").split(" ");
		// System.out.println(Arrays.toString(p));
		String x = "";
		while(sc2.hasNext()) {
			x += sc2.nextLine();
		}
		l2 = x.length();
		q = x.toLowerCase().replaceAll("[^a-z0-9 ]", "").split(" ");
		// System.out.println(Arrays.toString(q));
		} catch (Exception ex) {
			System.out.println("file not found");
		}
	}
	public int perMatch() {
		int count = 1;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < q.length; j++) {
				if (p[i].equals(q[j])) {
					count = count * p[i].length();
				}					
			}
		}
		return count;
	}
	public int calculate(int count) {
		float res;
		int res1 = l1 + l2;
		res = ((float)count / (float)res1) * 100;
		return (int) res;

	}

}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		File folder = new File(line);
		File[] listoffiles = folder.listFiles();
		for (int i = 0; i < listoffiles.length - 1; i++) {
			Stringmatching match = new Stringmatching(listoffiles[i], listoffiles[i + 1]);
			System.out.println(match.calculate(match.perMatch()));
		}
	}
}