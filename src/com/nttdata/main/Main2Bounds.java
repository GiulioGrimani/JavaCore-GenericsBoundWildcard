package com.nttdata.main;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.model.Person;
import com.nttdata.model.Student;

public class Main2Bounds {

	public static void main(String[] args) {

		/*
		 * E' possibile specificare un bound, ovvero una restrizione, sul tipo generico
		 * usato da un metodo. Questo puo' essere utile qualora volessimo fare delle
		 * operazioni specifiche di una determinata classe su oggetti di quella classe o
		 * di un suo sottotipo
		 */

		List<Person> personList = new ArrayList<>();
		personList.add(new Person());
		personList.add(new Person());
		personList.add(new Student());
		personList.add(new Student());

		print(personList);
	}

	public static <T extends Person> void print(List<T> list) {
		for (T item : list) {
			item.speak();
		}
	}

}
