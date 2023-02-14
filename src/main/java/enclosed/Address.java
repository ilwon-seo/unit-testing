package enclosed;

import java.io.Serializable;

import com.google.common.collect.ComparisonChain;

import lombok.Data;

public @Data class Address implements Serializable, Comparable<Address> {

	private static final long serialVersionUID = 1L;
	private final String address1;
	private final String city;
	private final String state;
	private final String zip;

	private Address(Builder builder) {
		this.address1 = builder.address1;
		this.city = builder.city;
		this.state = builder.state;
		this.zip = builder.zip;
	}

	@Override
	public int compareTo(Address that) {
		return ComparisonChain.start().compare(this.zip, that.zip).compare(this.state, that.state)
				.compare(this.city, that.city).compare(this.address1, that.address1).result();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final Address that = (Address) obj;

		return com.google.common.base.Objects.equal(this.address1, that.address1)
				&& com.google.common.base.Objects.equal(this.city, that.city)
				&& com.google.common.base.Objects.equal(this.state, that.state)
				&& com.google.common.base.Objects.equal(this.zip, that.zip);
	}

	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(getAddress1(), getCity(), getCity(), getState(), getZip());
	}

	public static class Builder {

		private String address1;
		private String city;
		private String state;
		private String zip;

		public Builder address1(String address1) {
			this.address1 = address1;
			return this;
		}

		public Address build() {
			return new Address(this);
		}

		public Builder city(String city) {
			this.city = city;
			return this;
		}

		public Builder state(String state) {
			this.state = state;
			return this;
		}

		public Builder zip(String zip) {
			this.zip = zip;
			return this;
		}
	}
}