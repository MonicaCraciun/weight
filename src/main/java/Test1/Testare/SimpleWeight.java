package Test1.Testare;
/**
 * The class that models SimpleWeight whose capacity is set by the constructor
 * @author Moni
 *
 */

public class SimpleWeight implements Weight{
	
	private final int capacity;
	
	
	/**
	 * Create a {@code SimpleWeight} instance with capacity as a parameter.
	 * @param capacity must be greater than 0.
	 * @throws IllegalArgumentException if capacity is lower than 1.
	 */
	public SimpleWeight(int capacity) {
		if(capacity<=0) throw new IllegalArgumentException("The capacity cannot be lower than 1");
		this.capacity = capacity;
	}
	
	/**
	 * Returns the capacity of the {@code SimpleWeight} instance;
	 */
	@Override
	public int capacity() {
		return capacity;
	}
	

}



