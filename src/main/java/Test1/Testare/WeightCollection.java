package Test1.Testare;

/**
 * The class models WeightCollection whose {@link #maximumCapacity} is set by the constructor.
 * The class contains an array of type {@link Weight}.
 * It calculates the average weights added to the list.
 * @author Moni
 *
 */

public class WeightCollection {
	private Weight[] weights;
	private int maximumCapacity;
	private int size=0;
	private double sum;
	
	/**
	 * Create a {@code WeightCollection} instance with {@link #maximumCapacity} as a parameter.
	 * If the maximumCapacity is positive, it creates a new Array with that size.
	 * @param maximumCapacity is the size of the new Array of type Weight.
	 * @throws IllegalArgumentException if the maximumCapacity is not greater than zero.
	 */
	public WeightCollection(int maximumCapacity) {
		if(maximumCapacity>0) {
			this.maximumCapacity = maximumCapacity;
			this.weights = new Weight[maximumCapacity];
		} else {
			throw new IllegalArgumentException("The Maximum Capacity is not greater than 0");
		}
	}
	
	/**
	 * Adds an element of type {@link Weight} to the weights Array if the maximumCapacity is not reached.
	 * It counts the number of elements in the array.
	 * @param w is an element of type {@link Weight} and it is added to the weights Array.
	 * @throws RuntimeException if the maximumCapacity is reached.
	 */
	public void add(Weight w) {
		if(null==w) {
			throw new IllegalArgumentException("The weight received as a parameter shouldn't be null");
		}
		if(size<maximumCapacity) {
				weights[size] = w;
				size++;
		} else {
			throw new RuntimeException("The maximum capacity has been reached");
		}
		
	}
	
	/**
	 * It calculates the total capacity of elements in the list.
	 * @return the average weight of the collection by dividing the total capacity by the number of elements.
	 */
	public double average() {
		for(int i=0; i<size; i++) {
			sum+=weights[i].capacity();
		}
		System.out.println("Suma " + sum);
		return sum/size;
	}
	
	public int getSize() {
		return size;
	}
	
	
	

}
