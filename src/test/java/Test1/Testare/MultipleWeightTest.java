package Test1.Testare;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//import static org.hamcrest.Matchers.instanceOf;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.unruly.matchers.StreamMatchers;
public class MultipleWeightTest {
	
	
	/*
	 * Capacity test should return the correct value;
	 */
	@Test
	@DisplayName("Capacity should return the correct value")
	void testMultipleWeightCapacityShouldReturnCorrectValue() {
		SimpleWeight s = new SimpleWeight(3);
		DoubleWeight d = new DoubleWeight(5,8);
		List<Weight> l2 = Arrays.asList(s,d);
		MultipleWeight m2 = new MultipleWeight(l2);
		SimpleWeight s2 = new SimpleWeight(14);
		DoubleWeight d2 = new DoubleWeight(7,3);
		List<Weight> l1 = Arrays.asList(s2,d2,m2);
		MultipleWeight m1 = new MultipleWeight(l1);
		int result = m1.capacity();
		//assertEquals(40, result);
		assertThat(40, is(result));
	}
	
	/**
	 * Capacity Test should fail because the capacity of the {@link Weigth} should not be lower than 1;
	 */
	@Test
	@DisplayName("Capacity should throw IllegalArgumentException")
	void testMultipleWeightCapacityShouldFail() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> {MultipleWeight m3 = new MultipleWeight(Arrays.asList(new SimpleWeight(8), new DoubleWeight(-3,5)));});
		Assertions.assertEquals("The capacity cannot be lower than 1", exception.getMessage());
		String message = "The capacity cannot be lower than 1";
		assertThat(message, is(exception.getMessage()));
		
		
	}
	
	/*
	 * AddWeight should return the correct value;
	 * aici am verificat daca adauga in lista greutatile si daca returneaza bine capacitatea, mai aveam inca un test care calcula doar capacitatea dar am testat tot aici
	 */
	@Test
	@DisplayName("Add should be ok")
	void testMultipleWeightAddWeightShouldBeOk() {
		List<Weight> listaW = new ArrayList<>();
		DoubleWeight d1= new DoubleWeight(3,4);
		listaW.add(d1);
		MultipleWeight m1 = new MultipleWeight(listaW);
		DoubleWeight d2 = new DoubleWeight(8,13);
		m1.addWeight(d2);
		assertEquals("Adding two elements to the list", 2, m1.getWeightList().size());
		Assertions.assertFalse(m1.getWeightList().isEmpty());
		assertThat(m1.getWeightList().size(), is(2));
		assertThat(Stream.of(m1.getWeightList()),StreamMatchers.contains(d1,d2));
		Assertions.assertTrue(m1.getWeightList().stream().filter(c ->c.capacity()==7 || c.capacity()==21).findAny().isPresent());
		Assertions.assertEquals(28, m1.capacity());
		assertThat(28, is(m1.capacity()));
		
	}
	
	
//	/*
//	 * AddWeight should return the correct capacity
//	 */
//	@Test
//	@DisplayName("Add should return the correct capacity")
//	void testMultipleWeightAddWeightShouldReturnTheCorrectCapacity() {
//		List<Weight> listaW = new ArrayList<>();
//		MultipleWeight m1 = new MultipleWeight(listaW);
//		m1.addWeight(new DoubleWeight(3,4));
//		Assertions.assertEquals(7, m1.capacity());
//		
//	}
	
	
	/*
	 * AddWeight should throw an IllegalArgumentException
	 */
	@Test
	@DisplayName("Should Not Add A Weigth When Is Null")
	void testMultipleWeightAddWeightShouldFailWhenWeitghtIsNull() {
		SimpleWeight s=null;
		List<Weight> listW = Arrays.asList(new SimpleWeight(3), new DoubleWeight(4,8));
		MultipleWeight myM1 = new MultipleWeight(listW);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myM1.addWeight(s));
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> myM1.addWeight(s));
		Assertions.assertEquals("The weight received as a parameter shouldn't be null", thrown.getMessage());
		assertThat("The weight received as a parameter shouldn't be null", is(thrown.getMessage()));
		assertNull(s);
		
		
	}
	
	@Test
	@DisplayName("Should throw IllegalArgumentException if the WeightList is null")
	void testMultipleWeightAddWeightShouldCreateANewlist() {
		List<Weight> listW=null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {MultipleWeight m1 = new MultipleWeight(listW);});
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {MultipleWeight m1 = new MultipleWeight(listW);});
		Assertions.assertEquals("WeightList should not be null", thrown.getMessage());
		assertThat("WeightList should not be null", is(thrown.getMessage()));
	}

}
