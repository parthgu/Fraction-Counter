public class FractionCounter {

	private Fraction theFraction;
	private int count;
	
	// contructor #1
	public FractionCounter(Fraction theFraction) {
		this.theFraction = theFraction;
		count = 1;
	}
	
	/**
	 * compareAndIncrement
	 * -------------------
	 * This method will return true/false depending on 
	 * if newFraction equals this.fraction
	 * PRE: this.fraction and newFraction are not null
	 * POST:returns a boolean value depending on if fractions are equal.
	 * 		if true, count will increase by 1
	 */
	public boolean compareAndIncrement(Fraction newFraction) {
		if(this.theFraction.equals(newFraction)) {
			count++;
			return true;
		}
		return false;
	}
	
	/**
	 * toString
	 * --------
	 * This method returns a string of the fraction and the count
	 * PRE: this.theFraction is not null
	 * POST: returns string and count in form of
	 * 		ex.("1/2 has a count of 2")
	 */
	public String toString() {
		return this.theFraction.toString() + " has a count of " + count;
	}
	
}
