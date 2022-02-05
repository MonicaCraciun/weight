package Test1.Testare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class SimpleWeightTest {
	
	
	@Test
	void testCapacityShouldReturnCorrectValue()  {
		SimpleWeight s1 = new SimpleWeight(3);
		int result = s1.capacity();
		assertEquals(3,result);
		assertThat(2, is(result));
	}
	
	
	@Test
	void testSimpleWeightInvalidMaximumCapacityShouldFail() {
		IllegalArgumentException thrown =assertThrows(IllegalArgumentException.class, () -> {
			SimpleWeight s1 = new SimpleWeight(-5);
		});
		assertEquals("The capacity cannot be lower than 1",thrown.getMessage());
		assertThat("The capacity cannot be lower than 1", is(thrown.getMessage()));
	}

}
