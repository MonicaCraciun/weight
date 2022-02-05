package Test1.Testare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DoubleWeightTest {
	
	@Test
	void testCapacityShouldReturnCorrectValue() {
		DoubleWeight d1 = new DoubleWeight(7,14);
		int result = d1.capacity();
		assertEquals(21, result);
		assertThat(21, is(result));
	}
	
	
	//Invalid first capacity 
	@Test
	void testDoubleWeigthInvalidMaximumCapacityShouldFail1() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			DoubleWeight d1 = new DoubleWeight(-5,4);
		});
		assertEquals("The capacity cannot be lower than 1", thrown.getMessage());
		assertThat("The capacity cannot be lower than 1", is(thrown.getMessage()));
	}
	
	@Test
	void testDoubleWeigthInvalidMaximumCapacityShouldFail2() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			DoubleWeight d2 = new DoubleWeight(3,-8);
		});
		assertEquals("The capacity cannot be lower than 1", thrown.getMessage());
		assertThat("The capacity cannot be lower than 1", equalTo(thrown.getMessage()));
	}
	
	
	
	

}
