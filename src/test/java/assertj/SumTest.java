package assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Percentage;
import org.junit.Test;

public class SumTest {

	@Test
	public void getSum() {
		Sum sum = new Sum();
		int ret = sum.getSum(5, 5);
		assertThat(ret).isEqualTo(10);
		assertThat(ret).isNotEqualTo(11);
		assertThat(ret).isCloseTo(11, Percentage.withPercentage(10));
		assertThat(ret).isNotCloseTo(9, Percentage.withPercentage(10));
		assertThat(ret).isGreaterThan(9).isLessThan(11).isNotEqualTo(0);
	}
}