package enclosed;

import java.io.Serializable;

import com.google.common.collect.ComparisonChain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address implements Serializable, Comparable<Address> {

	private static final long serialVersionUID = 1L;
	private final String address1;
	private final String city;
	private final String state;
	private final String zip;

	@Override
	public int compareTo(Address that) {
		return ComparisonChain.start().compare(this.zip, that.zip).compare(this.state, that.state)
				.compare(this.city, that.city).compare(this.address1, that.address1).result();
	}
}