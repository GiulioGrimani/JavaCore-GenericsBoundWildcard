package com.nttdata.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nttdata.model.Person;
import com.nttdata.model.Student;

public class Main1Generics {

	public static void main(String[] args) {

		/*
		 * I Generics sono stati introdotti dalla versione 5 di Java. Forniscono un
		 * ulteriore livello di astrazione sui tipi.
		 * 
		 * Cosa si intende con "astrazione sui tipi"?
		 * 
		 * Supponiamo di avere questo codice:
		 */

		List<Integer> notTypedList = new ArrayList();
		Integer uno = 1;
		notTypedList.add(uno);
		Integer one = notTypedList.get(0);

		/*
		 * Il compilatore non e' in grado inferire il tipo Integer: dovremmo usare un
		 * cast esplicito. Tipizzare la List con il Generic Integer risolve il problema,
		 * rendendo il codice piu' chiaro e meno verboso.
		 * 
		 * Usare i Generics nella dichiarazione di un metodo ci da' flessibilta' in
		 * quanto con una singola dichiarazione scriviamo un metodo che potra' essere
		 * usato con piu' tipi.
		 * 
		 * Ad esempio: il metodo convertArrayToList converte un array di un qualsiasi
		 * tipo nella List del tipo corrispondente. Nella dichiarazione del metodo
		 * compare un generico tipo 'T' (che sta per Type) e, dal momento che viene
		 * usato quello, dovra' esser messo (tra parentesi angolate) prima
		 * dell'indicazione sul tipo di dato restituito (<T>). La scelta di usare la
		 * lettera T e' soltanto una convenzione: si puo' usare qualsiasi lettera
		 * (convenzioni: T per Type, K per Key, V per Value).
		 * 
		 * Senza l'utilizzo del Generics avremmo dovuto creare, per ogni tipo di array
		 * che si vuol convertire in una List, un metodo specificatamente tipizzato.
		 */

		Person[] personArray = new Person[3];
		personArray[0] = new Person();
		personArray[1] = new Person();
		personArray[2] = new Person();

		Student[] studentArray = new Student[3];
		studentArray[0] = new Student();
		studentArray[1] = new Student();
		studentArray[2] = new Student();

		List<Person> personList = convertArrayToList(personArray);
		for (Person p : personList) {
			p.speak();
		}

		List<Student> studentList = convertArrayToList(studentArray);
		for (Student s : studentList) {
			s.study();
		}

	}

	public static <T> List<T> convertArrayToList(T[] array) {
		return Arrays.asList(array);
	}

}
