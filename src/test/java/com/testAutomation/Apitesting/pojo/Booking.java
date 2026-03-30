package com.testAutomation.Apitesting.pojo;

import java.util.Objects;

public class Booking {
	
	

	@Override
	public int hashCode() {
		return Objects.hash(additionalneeds, booking, bookingdates, depositpaid, firstname, lastname, totalprice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(additionalneeds, other.additionalneeds) && Objects.equals(booking, other.booking)
				&& Objects.equals(bookingdates, other.bookingdates) && depositpaid == other.depositpaid
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& totalprice == other.totalprice;
	}

	private String firstname;
	private String lastname;
	private String additionalneeds;
	private int totalprice;
	private boolean depositpaid;
	private Booking bookingdates;
	private Booking booking;
	
	public Booking() {
		
	}
	
	public Booking(String fname,String lname,String aneeds,
			int tprice,boolean dpaid,Booking bdates) {
		
		setFirstname(fname);
		setLastname(lname);
		setAdditionalneeds(aneeds);
		setTotalprice(tprice);
		setDepositpaid(dpaid);
		setBookingdates(bdates);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public Booking getBookingdates() {
		return booking;
	}

	public void setBookingdates(Booking bookingdates) {
		this.booking = bookingdates;
	}

}



