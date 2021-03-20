/*
 * FileName: FlightPlanner.java
 * @author David Amateau
 *
 * In this program we will read from a file a list of cities and
 * the possible destinations from each city. We will store all the
 * information in a HashMap that has a city name as it's key and
 * an ArrayList of it's possible destinations as its value.
 * We will use another ArrayList to store a flight path created by
 * a user from the possible destinations that can be reached from
 * the current city they have selected until we return them to their
 * original starting city at which point we will print out their flight
 * path.
 */


package week5;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FlightPlanner extends ConsoleProgram {

	/*		Instance Variables, Data Structures & Objects		*/
	BufferedReader flightReader;
	HashMap<String, ArrayList<String>> cityFlightPaths = new HashMap<String, ArrayList<String>>();
	ArrayList<String> flightRoute = new ArrayList<String>();
	ArrayList<String> destinationCities;
	String flightsFile = "/Users/davida/flights.txt";

	// This is our main method that capitalizes on Encapsulation and contains only methods
	public void run() {
		readInFlights();
		introduction();
		planATrip();
		printFlightPath();
	}

	// Between the readInFlights Method and readInFlightPath, I am not instantiating the
	// ArrayList properly so that a new ArrayList is created storing a particular fromCity's
	// list of destinationCities and then accessed when a new city needs to be added to that
	// particular arrayList. Currently this program just adds every destinationCity to a single
	// ArrayList and all HashMap keys have the same ArrayList as a value.

	public void readInFlights() {

		try {
			Scanner scanner = new Scanner(new File(flightsFile));
			destinationCities = new ArrayList<String>();			// This can't be right

			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				if (currentLine.equals("")) continue;
				readInFlightPath(currentLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readInFlightPath(String flightPath) {
		// This splits the string into the departing city and destination city

		String[] temp = flightPath.split(" -> ");
		String fromCity = temp[0];
		String toCity = temp[1];
		destinationCities.add(toCity);		// This may need to be moved


		if (cityFlightPaths.containsKey(fromCity)) {
			cityFlightPaths.put(toCity, destinationCities);

		} else {
			// This doesn't seem quite right currently
			cityFlightPaths.put(fromCity, new ArrayList<String>());
			cityFlightPaths.put(fromCity, destinationCities);
		}
	}


	public void introduction() {
		println("Welcome to Flight Planner!");
		println("Here's a list of all the cities in our database: ");
		for (String key : cityFlightPaths.keySet()) {
			println(key);
		}
	}

	public void planATrip() {
		println("Let's plan a round-trip route!");
		String currentCity = "";
		String startingCity = readLine("Enter the starting city: ");
		currentCity = startingCity;

		while (true) {
			if (cityFlightPaths.containsKey(currentCity)) {
				println("From " + currentCity + " you can fly directly to: ");
				println(cityFlightPaths.get(startingCity));
				currentCity = readLine("Where do you want to go from " + currentCity + ": ");
				if(currentCity.equals(startingCity)) break;
			} else {
				println("You can't get to that city by a direct flight.");
				continue;
			}
		}
	}

	// This method prints out the flight path the user has chosen
	public void printFlightPath() {
		print("The route you have chosen is ");
		for (int i = 0; i < flightRoute.size(); i++) {
			print(flightRoute.get(i) + " -> ");
		}
		print(flightRoute.get(0));
		flightRoute.clear();
	}
}
