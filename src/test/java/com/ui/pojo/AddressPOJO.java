package com.ui.pojo;

public class AddressPOJO {
	private String company;
	private String address1;
	private String address2;
	private String city;
	private String postcode;
	private String phone;
	private String mobilePhone;
	private String otherInfo;
	private String addressAlias;
	private String state;
	public AddressPOJO(String company, String address1, String address2, String city, String postcode, String phone,
			String mobilePhone, String otherInfo, String addressAlias, String state) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postcode = postcode;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.otherInfo = otherInfo;
		this.addressAlias = addressAlias;
		this.state = state;
	}
	public String getCompany() {
		return company;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getCity() {
		return city;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getPhone() {
		return phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public String getAddressAlias() {
		return addressAlias;
	}
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", postcode=" + postcode + ", phone=" + phone + ", mobilePhone=" + mobilePhone + ", otherInfo="
				+ otherInfo + ", addressAlias=" + addressAlias + ", state=" + state + "]";
	}

	
	
}
