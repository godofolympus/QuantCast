import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MostActiveCookie {

	public static void main(String[] args) {
		
		// we only perform pre-processing on the input data in the main method and then call our outputCookies
		// helper method which performs the actual logic and returns(prints) the answer
		String filename;
		String date;
		try {
			filename = args[0];
			date = args[2];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("please check your input format!");
			e.printStackTrace();
			return;
		}
		
		List<String> list_of_cookies = new ArrayList<String>(); // arraylist that contains each line in csv file
		String current_line;
		
		// read the lines in the csv one line at a time inside a try-catch to catch exceptions for when 
		// file is not found or data is empty
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			current_line = reader.readLine(); // ignore the first line of the csv file that contains headers. 
			while((current_line = reader.readLine()) != null) {
				list_of_cookies.add(current_line);
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No file with that name was found. Please try again!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error trying to read the file!");
			e.printStackTrace();
		}
		
		//call our helper method that performs the actual logic.
		List<String> most_frequent_cookies = outputCookies(list_of_cookies, date);
		
		//print each string in the list
		for(int i = 0; i < most_frequent_cookies.size(); i++) {
			System.out.println(most_frequent_cookies.get(i));
		}
		
		// if the list is empty, we dont print anything. We could send a message to the console stating there are no cookies
	//	if(most_frequent_cookies.size() == 0)
	//		System.out.println("There are no cookies found for this date");
	}
	
	public static List<String> outputCookies(List<String> list_of_cookies, String date) {
		//hashmap to store each cookie and its count (only when dates match)
		Map<String, Integer> map = new HashMap<String, Integer>();
		// variable that stores the count of the most frequent cookies so we can easily return later
		int most_frequent_count = 0; 
		
		for(String cookie: list_of_cookies) {
			String[] split = cookie.split("\\s*,\\s*"); // split the string by commas and remove excess spaces
			String cookiename = split[0]; // first value is the string that contains cookie's name
			
			// 4 digit year, '-', 2 digit month, '-', 2 digit date for 10 characters total
			String cookiedate = split[1].substring(0, 10); 
			
			//if the date on the cookie matches the date we are searching for, add it to the map
			if(cookiedate.equals(date)) {
				int count = map.getOrDefault(cookiename, 0) + 1;
				// update count of the cookies in map with the same name as the current cookie
				map.put(cookiename, count);
				//update most_frequent_count if needed
				most_frequent_count = Math.max(count, most_frequent_count);
			}	
		}// by the end of the for loop, most_frequent_count will hold the count of the most repeated cookie(s)
		
		List<String> most_frequent_cookies = new ArrayList<String>();
		for(String key: map.keySet()) {
			if(map.get(key) == most_frequent_count)
				most_frequent_cookies.add(key);
				//System.out.println(key);
		}
		return most_frequent_cookies;		
	}
		
}

