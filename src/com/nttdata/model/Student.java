package com.nttdata.model;

public class Student extends Person {

	public void study() {
		System.out.println("I'm studying!");
	}

	@Override
	public void speak() {
		System.out.println("Hey I'm a Student");
	}

}
