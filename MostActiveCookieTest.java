import java.util.*;


public class MostActiveCookieTest {	
	
	public static void main(String[] args) {

		testcases();

	}
	
	//returns true if the output matches the answer key
	public static boolean testHelper(Set<String> answers, List<String> list_of_cookies, int testNumber, String date) {
		List<String> output = MostActiveCookie.outputCookies(list_of_cookies, date);
		for(int i = 0; i < output.size(); i++) {
			if(!answers.remove(output.get(i))) {
				// if we find a cookie not in the answer key, return false
				System.out.println("test case " + testNumber + " failed");
				return false;
			}
		}
		if(answers.size() != 0) {
			// if we have any cookies in the answer key not in our results, return false;
			System.out.println("test case " + testNumber + " failed");
			return false;
		}
		return true;
	}
	
	//list of all test cases that call the testhelper function
	public static boolean testcases() {
		
		Set<String> answers = new HashSet<String>();
		List<String> list_of_cookies = new ArrayList<String>();
		String date = "2018-12-09";
		//test case 0 - null test case
		if(!testHelper(answers, list_of_cookies, 0, date)) return false;
		
		
		//test case 1 - sample test case in exercise
		list_of_cookies.add("AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00");
		list_of_cookies.add("SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00");
		list_of_cookies.add("5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00");
		list_of_cookies.add("AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00");
		list_of_cookies.add("SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00");
		list_of_cookies.add("4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00");
		list_of_cookies.add("fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00");
		list_of_cookies.add("4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00");
				
		date = "2018-12-09";
		answers.add("AtY0laUfhglK3lC7");
		if(!testHelper(answers, list_of_cookies, 1, date)) return false;
		
		
		
		// test case 2
		date = "2018-12-09"; // date is unchanged, but including it here again for code readability
		list_of_cookies.add(1, "SAZuXPGUrfbcn5UA,2018-12-09T11:13:00+00:00");
		//dont need to clear set of answers since we would have returned by now if test 1 failed, so it is already empty
		
		answers.add("AtY0laUfhglK3lC7");
		answers.add("SAZuXPGUrfbcn5UA");
		if(!testHelper(answers, list_of_cookies, 2, date)) return false;
		
		
		//test case 3 return all 3 values that appear only once for the given date
		answers.add("4sMM2LxV07bPJzwf");
		answers.add("SAZuXPGUrfbcn5UA");
		answers.add("fbcn5UAVanZf6UtG");
		date = "2018-12-08";
		if(!testHelper(answers, list_of_cookies, 3, date)) return false;
		
		//test case 4 should return just the single value in the list
		list_of_cookies.clear();
		date = "2018-12-09";
		list_of_cookies.add("AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00");
		answers.add("AtY0laUfhglK3lC7");
		if(!testHelper(answers, list_of_cookies, 4, date)) return false;
		
		//test case 5 should return nothing since the dates dont match
		date = "2018-12-08";
		if(!testHelper(answers, list_of_cookies, 5, date)) return false;
		
		//test case 6 should return nothing since the dates dont match
		date = "2019-12-09";
		list_of_cookies.add("SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00");
		list_of_cookies.add("5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00");
		list_of_cookies.add("AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00");
		list_of_cookies.add("SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00");
		list_of_cookies.add("4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00");
		list_of_cookies.add("fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00");
		list_of_cookies.add("4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00");
		if(!testHelper(answers, list_of_cookies, 6, date)) return false;
		
		
		
		// if we get to the end without failing any test cases, we print a message stating that
		// we passed the test cases and return true
		System.out.println("all test cases passed!");
		return true;
	}

	
}
