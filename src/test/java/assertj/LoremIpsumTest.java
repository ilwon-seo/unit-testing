package assertj;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LoremIpsumTest {

	@Test
	public void getLorem() {
		LoremIpsum li = new LoremIpsum();
		Assertions.assertThat(li.getLorem()).startsWith("Lorem").contains("sed").doesNotContain("XXX");
	}
}