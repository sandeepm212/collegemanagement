package com.management.college.model;

public class Book extends BaseObject {

	private String bookId = null;
	private String title = null;
	private String firstName = null;
	private String surname = null;
	private float price = 0.0F;
	private int year = 0;
	private String description = null;
	private int inventory = 0;
	
	

	public int getEntityType() {
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object inputO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
