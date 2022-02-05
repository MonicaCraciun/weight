package Test1.Testare;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainWeight {
	public static void main(String[] args) {
		SimpleWeight s1 = new SimpleWeight(3);
		SimpleWeight s2 = new SimpleWeight(7);
		DoubleWeight d1 = new DoubleWeight(4, 13);
		DoubleWeight d2 = new DoubleWeight(11, 8);
		List<Weight> weightList1 = Arrays.asList(s1, d1);

		MultipleWeight m1 = new MultipleWeight(weightList1);
		List<Weight> weightList2 = Arrays.asList(m1, s2, d1);
		MultipleWeight m2 = new MultipleWeight(weightList2);

		System.out.println("Simple Weight capacity " + s1.capacity());
		System.out.println("Double weight capacity " + d1.capacity());
		System.out.println("Multiple weight capacity " + m1.capacity());

		WeightCollection w1 = new WeightCollection(5);
		w1.add(m2);
		w1.add(s1);
		w1.add(d1);
		w1.add(s2);
		w1.add(m1);
		//w1.add(d2);
		System.out.println("Average is " + w1.average());
		
	}

}
