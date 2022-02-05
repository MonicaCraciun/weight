package Test1.Testare;

/**
 * This class models DoubleWeight formed by two elements of type {@link SimpleWeight}. 
 * @author Moni
 *
 */
public class DoubleWeight implements Weight{
	private SimpleWeight s1;
	private SimpleWeight s2;
	
	/**
	 * Create a {@code DoubleWeight} instance with two capacities as parameters for the two {@link SimpleWeight} instances created.
	 * @param capacity1 is assigned to the first {@link SimpleWeight} instance.
	 * @param capacity2 is assigned to the second {@link SimpleWeight} instance.
	 * @throw IllegalArgumentException if one of the capacities is lower than 1;
	 */
	public DoubleWeight(int capacity1, int capacity2) {
		if(capacity1<=0 || capacity2<=0) throw new IllegalArgumentException("The capacity cannot be lower than 1");
		this.s1 = new SimpleWeight(capacity1);
		this.s2 = new SimpleWeight(capacity2);
	}
	
	/**
	 * Returns the sum of the capacities of the two {@link SimpleWeight} instances created.
	 */
	@Override
	public int capacity() {
		return s1.capacity() + s2.capacity();
	}

}
