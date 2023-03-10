package enclosed;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import enclosed.testhelpers.ComparabilityTestCase;
import enclosed.testhelpers.EqualsHashCodeTestCase;
import enclosed.testhelpers.SerializabilityTestCase;

/**
 * The Class AddressTest.
 */
@RunWith(Enclosed.class)
public class AddressTest {

	/**
	 * The Class AddressComparabilityTest.
	 */
	public static class AddressComparabilityTest extends ComparabilityTestCase<Address> {

		@Override
		protected Address createEqualInstance() throws Exception {
			return new Address.AddressBuilder().address1("2802 South Havana Street").city("Aurora").state("CO").zip("80014").build();
		}

		@Override
		protected Address createGreaterInstance() throws Exception {
			return new Address.AddressBuilder().address1("9839 Carlisle Boulevard NE").city("Albuquerque").state("NM").zip("87110").build();
		}

		@Override
		protected Address createLessInstance() throws Exception {
			return new Address.AddressBuilder().address1("14 Broad St").city("Nashua").state("NH").zip("03064").build();
		}
	}

	/**
	 * The Class AddressEqualsHashCodeTest.
	 */
	public static class AddressEqualsHashCodeTest extends EqualsHashCodeTestCase {

		@Override
		protected Address createInstance() throws Exception {
			return new Address.AddressBuilder().address1("2802 South Havana Street").city("Aurora").state("CO").zip("80014").build();
		}

		@Override
		protected Address createNotEqualInstance() throws Exception {
			return new Address.AddressBuilder().address1("9839 Carlisle Boulevard NE").city("Albuquerque").state("NM").zip("87110").build();
		}
	}

	/**
	 * The Class AddressSerializabilityTest.
	 */
	public static class AddressSerializabilityTest extends SerializabilityTestCase {

		@Override
		protected Serializable createInstance() throws Exception {
			return new Address.AddressBuilder().address1("9839 Carlisle Boulevard NE").city("Albuquerque").state("NM").zip("87110").build();
		}
	}

	public static class AddressMiscTest {

		private Address address;

		/**
		 * Setup.
		 *
		 * @throws Exception the exception
		 */
		@Before
		public void setUp() throws Exception {
			address = new Address.AddressBuilder().address1("9839 Carlisle Boulevard NE").city("Albuquerque").state("NM").zip("87110").build();
		}

		/**
		 * Test builder.
		 */
		@Test
		public void testBuilder() {
			assertThat(address.getAddress1(), is("9839 Carlisle Boulevard NE"));
			assertThat(address.getCity(), is("Albuquerque"));
			assertThat(address.getState(), is("NM"));
			assertThat(address.getZip(), is("87110"));
		}

		@Test
		public void testToString() {
			assertThat(address.toString(), is("Address(address1=9839 Carlisle Boulevard NE, city=Albuquerque, state=NM, zip=87110)"));
		}
	}
}