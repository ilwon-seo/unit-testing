import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalTest {

	@Test
	public void getSum() {
		Cal cal = new Cal();
		int ret = cal.getSum(20,500);
		assertEquals(520, ret);
	}
}