package Test1.Testare;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeightCollectionTest {
	
	@Test
	@DisplayName("Average Should return the correct value")
	void testAverageShouldReturnCorrectValue() {
		SimpleWeight s5 = new SimpleWeight(2);
		DoubleWeight d5 = new DoubleWeight(18,9);
		List<Weight> l5 = Arrays.asList(s5,d5);
		MultipleWeight m5 = new MultipleWeight(l5);
		SimpleWeight s6 = new SimpleWeight(22);
		DoubleWeight d6 = new DoubleWeight(15,33);
		WeightCollection w1 = new WeightCollection(3);
		w1.add(d6);
		w1.add(s6);
		w1.add(m5);
		assertEquals(99/3, w1.average());
		assertThat(99/3, is(w1.average()));
		
	}
	
	@Test
	@DisplayName("Average should throw IllegalArgumentException")
	void testAverageShoulFail() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {WeightCollection w = new WeightCollection(-5);});
		assertEquals("The Maximum Capacity is not greater than 0", exception.getMessage());
		assertThat("The Maximum Capacity is not greater than 0", is( exception.getMessage()));
	}
	
	@Test
	@DisplayName("Add should be ok")
	void testAddShouldBeOk() {
		WeightCollection w = new WeightCollection(3);
		SimpleWeight s5 = new SimpleWeight(2);
		DoubleWeight d5 = new DoubleWeight(18,9);
		DoubleWeight d6 = new DoubleWeight(15,33);
		w.add(d5);
		w.add(d6);
		w.add(s5);
		assertTrue(w.getSize() == 3);
		assertThat(w.getSize(), is(3));
	}
	
	@Test 
	@DisplayName("Add should throw RuntimeException")
	void testAddShouldFail() {
		WeightCollection w = new WeightCollection(3);
		SimpleWeight s5 = new SimpleWeight(2);
		DoubleWeight d5 = new DoubleWeight(18,9);
		DoubleWeight d6 = new DoubleWeight(15,33);
		SimpleWeight s6 = new SimpleWeight(22);
		w.add(d5);
		w.add(d6);
		w.add(s5);
		RuntimeException exception = assertThrows(RuntimeException.class, ()-> w.add(s6));
		assertEquals("The maximum capacity has been reached", exception.getMessage());
		assertThat("The maximum capacity has been reached", is( exception.getMessage()));
	}
	
	@Test
	@DisplayName("Add should throw IllegalArgumentException")
	void testAddNullWeightShouldFailWhenWeightIsNull() {
		WeightCollection w = new WeightCollection(3);
		DoubleWeight d5 = new DoubleWeight(18,9);
		DoubleWeight d6 = new DoubleWeight(15,33);
		w.add(d5);
		w.add(d6);
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> w.add(null));
		assertEquals("The weight received as a parameter shouldn't be null", exception.getMessage());
		assertThat("The weight received as a parameter shouldn't be null", is( exception.getMessage()));
		
	}
	
	
	
	
	

}
