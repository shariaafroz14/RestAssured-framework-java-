package com.testAutomation.Apitesting.pojo;

public class bookingDate {

	

	private String checkin;
	private String checkout;
	
	public bookingDate() {
		
	}
	
	public bookingDate(String cin,String cout) {
		setCheckin(cin);
		setCheckout(cout);
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

}


