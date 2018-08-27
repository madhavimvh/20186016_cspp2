public final class Swap{
	private Swap(){

	}
	public static void main(String[] args) {
		int x = 10;
		int y = 5;
		int temp = x;
		x = y;
		y = temp;
		System.out.println(x + " " + y);
	}
}