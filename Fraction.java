package fractionsv2;
//import java.math.*;

public class Fraction {

	private int numerator;
	private int denominator;

	// constructor #1 (no arg constructor)
	public Fraction() {
		this(1, 1); // makes numerator AND denominator 1
	}

	// constructor #2:
	public Fraction(int numerator, int denominator) {

		boolean isNegative = false;
		if (numerator < 0 ^ denominator < 0) // exclusive or
			isNegative = true;

		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);

		// eliminates possibility for denominator == 0
		if (denominator == 0) {
			this.numerator = numerator;
			this.denominator = 1; // changes denominator to 1 if given 0
			System.out.println("Changed " + numerator + "/" + denominator
					+ " to " + numerator + "/" + this.denominator); // prints change
			return;
		}

		// simplifying fraction
		int gcf = numerator; // gcf: Greatest Common Factor
		for (int i = gcf; i > 0; i--) {
			if (numerator % gcf == 0 && denominator % gcf == 0) {
				break;
			}
			gcf--;
		}
		numerator /= gcf;
		denominator /= gcf;

		if (isNegative) {
			numerator *= -1; // if negative, only the numerator will be negative
		}

		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * equals
	 * ------
	 * This method tests if the current fraction is equal to another
	 * PRE: other is not null
	 * POST: return true if equal, returns false if not
	 * 
	 */
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Fraction))
			return false;
		Fraction that = (Fraction) other;
		if (this.denominator == that.denominator && this.numerator == that.numerator)
			return true;
		else
			return false;
	}

	/**
	 * getNumerator
	 * ------------
	 * This method returns this's numerator
	 * PRE: this is not null
	 * POST: returns numerator for current instance
	 */
	public int getNumerator() {
		return this.numerator;
	}

	/**
	 * getDenominator
	 * ------------
	 * This method returns this's denominator
	 * PRE: this is not null
	 * POST: returns denominator for current instance
	 */
	public int getDenominator() {
		return this.denominator;
	}

	/**
	 * setNumerator
	 * ------------
	 * This method sets the current instance's numerator
	 * PRE: newNumerator is not null
	 * POST: sets the current instance numerator to newNumerator
	 */
	public void setNumerator(int newNumerator) {
		this.numerator = newNumerator;
	}

	/**
	 * setDenominator
	 * ------------
	 * This method sets the current instance's denominator
	 * PRE: newDenominator is not null
	 * POST: sets the current instance numerator to newDenominator
	 */
	public void setDenominator(int newDenominator) {
		this.denominator = newDenominator;
	}

	/**
	 * toString
	 * --------
	 * This method overrides original toString method to return fraction string
	 * PRE: this.numerator & this.denominator are not null
	 * POST: returns string of fraction ex.("1/2")
	 */
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
}
