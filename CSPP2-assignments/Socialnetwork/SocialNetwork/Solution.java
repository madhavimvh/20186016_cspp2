import java.util.Scanner;
import java.util.Arrays;
class User {
	private String username;
	private String[] friends;
	User(String username, String[] friends) {
		this.username = username;
		this.friends = friends;
	}
	public String getUsername() {
		return username;
	}
	public String[] getFriends() {
		return friends;
	}
	public String[] setFriends(String[] friendslist) {
		return friends = friendslist;
	}
	public String toString() {
		String s = "";
		s += username + ": " + "[" + getFriends() + "]";
		return s;
	}
}
class Socialnetwork {
	private List<User> userlist;
	Socialnetwork() {
		userlist = new List<User>();
	}
	public void connections(User user) {
		userlist.add(user);
	}
	public void addConnection(String user, String name) {
		for (int i = 0; i < userlist.size(); i++) {
			if (userlist.get(i).getUsername().equals(user)) {
				String[] friends = userlist.get(i).getFriends();
				friends = Arrays.copyOf(friends, friends.length + 1);
				friends[friends.length - 1] = name;
				userlist.get(i).setFriends(friends); 	
			}
		}
	}
	public String[] getConnections(String user) {
		String[] s = new String[10];
		for (int i = 0; i < userlist.size(); i++) {
			if (userlist.get(i).getUsername().equals(user)) {
				s = userlist.get(i).getFriends();
				s = Arrays.copyOf(s, s.length);
			}
		}
		return s;
	}
	public String getCommonConnections(String user1, String user2) {
	// 	String[] friends1 = new String[10];
	// 	String[] friends2 = new String[10];
	// 	for (int i = 0; i < userlist.size(); i++) {
	// 		if (userlist.get(i).getUsername().equals(user1)) {
	// 			friends1 = userlist.get(i).getFriends();
	// 			friends1 = Arrays.copyOf(friends1, friends1.length);
	// 		}
	// 	}
	// 	for (int i = 0; i < userlist.size(); i++) {
	// 		if (userlist.get(i).getUsername().equals(user2)) {
	// 			friends2 = userlist.get(i).getFriends();
	// 			friends2 = Arrays.copyOf(friends2, friends2.length);
	// 		}
	// 	}
		String common = "[";
		String[] friends1 = getConnections(user1);
		// System.out.println(Arrays.toString(friends1));
		String[] friends2 = getConnections(user2);
		// System.out.println(Arrays.toString(friends2));
		for (int i = 0; i < friends1.length; i++) {
			for (int j = 0; j < friends2.length; j++) {
				// System.out.println("maddy");
				// System.out.println("frst" + friends1[i]);
				// System.out.println("scnd" + friends2[j]);
				if (friends1[i].equals(friends2[j])) {
					common += friends1[i] + ", "; 
				}
			}
		}

		if (common.length() == 1) {
			return "[]";
		}
		// System.out.println(Arrays.toString(common));
		return common.substring(0, common.length() - 2) + "]";
	}
	public String toString() {
		String[] keys = new String[userlist.size()];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = userlist.get(i).getUsername();
		}
		Arrays.sort(keys);
		String s = "";
		int i = 0;
		for (i = 0; i < keys.length - 1; i++) {
			s += keys[i] + ": " + Arrays.toString(getConnections(keys[i])) + ", ";
		}
		s += keys[i] + ": " + Arrays.toString(getConnections(keys[i]));
		return s;

	}
}
public class Solution {
	public static void main(String[] args) {
		Socialnetwork ntwrk = new Socialnetwork(); 
		Scanner s = new Scanner(System.in);
		String[] x = s.nextLine().split(" ");
		int j = 0;
		while (j < Integer.parseInt(x[1])) {
			String[] tokens = s.nextLine().replace(".", "").split(" is connected to ");
			// System.out.println(Arrays.toString(tokens));
			// System.out.println(tokens.length);
				String[] friends = tokens[1].split(", ");
				// System.out.println(Arrays.toString(friends));
				ntwrk.connections(new User(tokens[0], friends));
			j++;
		}
		while(s.hasNext()) {
		String[] input = s.nextLine().split(" ");
		switch(input[0]) {
			case "Network":
			System.out.println(ntwrk);
			break;
			case "addConnections":
			ntwrk.addConnection(input[1], input[2]);
			break;
			case "getConnections":
			String[] q = ntwrk.getConnections(input[1]);
			if (q[0] == null) {
				System.out.println("Not a user in Network");
			} else {
				System.out.println(Arrays.toString(ntwrk.getConnections(input[1])));
			}
			break;
			case "CommonConnections":
			System.out.println(ntwrk.getCommonConnections(input[1], input[2]));
			break;
		}			
		}
	}
}