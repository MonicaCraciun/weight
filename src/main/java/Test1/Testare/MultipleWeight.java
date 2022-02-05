package Test1.Testare;

import java.util.ArrayList;
import java.util.List;

/**
 * The class models MultipleWeight which represents an array of elements of type {@link Weight};
 * @author Moni
 *
 */
public class MultipleWeight implements Weight{	
	private int capacity=0;
	private List<Weight> weightList;
	
	
	/**
	 * Create a {@code MultipleWeight} instance with weightList as parameter.
	 * It assigns to weightList instance the list received as a parameter.
	 * The capacity is modified by adding the new element capacity from the list.
	 * @param weightList is a list of elements of type {@link Weight}. 
	 * @throws {@link IllegalArgumentException} if the weightList received as a parameter is null.
	 */
	public MultipleWeight(List<Weight> weightList) {
		if(null==weightList) {
			throw new IllegalArgumentException("WeightList should not be null");
		}
		this.weightList = new ArrayList<>(weightList);
		for(Weight w: weightList) {
			capacity +=w.capacity();
		}
	}
	
	
	/**
	 * Adds an element of type {@link Weight} in weightList.
	 * If a valid weightList doesn't exist, it will create a new list.
	 * The capacity is modified by adding to it the capacity of the new element added to the list.
	 * @param w is an element of type {@link Weight} and it is added to the weightList;
	 * @throws {@link IllegalArgumentException} if Weight {@link #w} received as a parameter is null;
	 */
	public void addWeight(Weight w) {
		if(null==w) {
			throw new IllegalArgumentException("The weight received as a parameter shouldn't be null");
		}
		if (null==this.weightList) {
			this.weightList=new ArrayList<>();
		}
		
		this.weightList.add(w);
		this.capacity +=w.capacity();
	}
	
	/**
	 * Returns the capacity of {@code MultipleWeight} instance;
	 */
	@Override
	public int capacity() {
		return this.capacity;
	}
	
	
	/**
	 * 
	 * @return the weigths list;
	 */
	public List<Weight> getWeightList() {
		return weightList;
	}
	

}


