package fractionsv2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class FractionDriver {
	/**
	 * main
	 * ----
	 * This method is the main method of the fractionsv2 class
	 * PRE:
	 * POST: prints the unique fractions in "fractions.txt" and their count
	 */
	public static void main(String[] args) {

		ArrayList<FractionCounter> filledList = fillList("fractions.txt");

		printList(filledList);

	}

	/**
	 * getNextFraction
	 * ---------------
	 * This method convert the next line of the file into a fraction
	 * and return it.
	 * PRE: reader is not null.
	 * Each line of txt file must be a fraction ("int / int")
	 * POST: return Fraction object containing numerator and denominator
	 */
	private static Fraction getNextFraction(Scanner reader) {
		String[] curFraction = reader.nextLine().split("/");
		int numerator = Integer.parseInt(curFraction[0]);
		int denominator = Integer.parseInt(curFraction[1]);

		return new Fraction(numerator, denominator);
	}

	/**
	 * printList
	 * ---------
	 * This method will print out toString form of each FractionCounter in
	 * the ArrayList
	 * PRE: counterList does not contain null values
	 * POST: prints each fraction and their count
	 */
	private static void printList(ArrayList<FractionCounter> counterList) {
		for (int i = 0; i < counterList.size(); i++)
			System.out.println(counterList.get(i).toString());
	}

	/**
	 * fillList
	 * --------
	 * This method fills a FractionCounter ArrayList from a file
	 * PRE: fileName is a txt file with a fraction in each line
	 * POST: returns ArrayList of FractionCounters for fileName
	 */
	private static ArrayList<FractionCounter> fillList(String fileName) {
		Scanner reader;
		try {
			reader = new Scanner(new File(fileName));
		} catch (Exception e) {
			System.out.println("FILE NOT FOUND!!!");
			return null;
		}

		ArrayList<FractionCounter> counterList = new ArrayList<>();

		// adding first fraction in the ArrayList
		counterList.add(new FractionCounter(getNextFraction(reader)));

		while (reader.hasNextLine()) {
			Fraction curFraction = getNextFraction(reader);
			for (int i = 0; i < counterList.size(); i++) {

				// if curFraction is already counted, break. (count is increased)
				if (counterList.get(i).compareAndIncrement(curFraction)) {
					break;
				}
				// if reached to the end of list, add new counter to list
				else if (i == counterList.size() - 1) {
					counterList.add(new FractionCounter(curFraction));
					break;
				}
			}
		}
		return counterList;
	}
}
