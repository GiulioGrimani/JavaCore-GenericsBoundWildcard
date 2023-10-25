package com.nttdata.main;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.model.Person;
import com.nttdata.model.Student;

public class Main3Wildcards {

	/*
	 * Il carattere jolly (wildcard) in Java e' rappresentato dal carattere del
	 * punto interrogativo e si usa per indicare un tipo di dato che non si conosce.
	 * 
	 * E' spesso usato con un bound per risolvere il problema del voler operare su
	 * una lista di elementi eterogenea, cosi' come il bound sul Generics visto in
	 * precedenza.
	 * 
	 * Esempio: il metodo typedPrint, nonostante accetti in input una List<Person>,
	 * non funziona se gli viene passata una List<Student>, sottoclasse di Person.
	 * Per agirare il problema possiamo usare la wildcard cosi' come la vediamo nel
	 * metodo wildcardPrintWithBound: in tale metodo saremo in grado di svolgere
	 * operazioni su una List di elementi che potra' essere sia di Person che di
	 * Student, e contenere al suo interno oggetti sia di tipo Person che di tipo
	 * Student. Cosi' come d'altronde siamo in grado di fare nel metodo
	 * genericsPrintWithBound, gia' visto nella spiegazione sui bounds. La
	 * differenza tra questi ultimi due metodi e' praticamente inesistente: nel caso
	 * del genericsPrintWithBound il compilatore e' in grado di inferire
	 * staticamente il tipo alla List e per questo lo si preferisce usare per fare
	 * operazioni definite esclusivamente nella classe che viene estesa (in questo
	 * caso, Person) sebbene anche qui sia possibile usare il cast per fare
	 * operazioni proprie delle sottoclassi.
	 * 
	 * La wildcard invece dichiara esplicitamente di non conoscere quale tipo ci
	 * puo' capitare, per questo ha piu' senso usarla nel momento in cui bisogna
	 * fare operazioni definite sia nella classe estesa (Person) che in una
	 * qualsiasi sottoclasse X che estende Person e che il programmatore si
	 * prendera' la briga di gestire
	 */

	public static void main(String[] args) {

		List<Person> personList = new ArrayList<>();
		personList.add(new Person());
		personList.add(new Person());
		personList.add(new Person());

		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student());
		studentList.add(new Student());
		studentList.add(new Student());

		typedPrint(personList);
//		typedPrint(studentList); // Errore

//		wildcardPrintWithBound(personList); // fallisce senza l'instanceof
		wildcardPrintWithBound(studentList);

	}

	public static void typedPrint(List<Person> myList) {
		for (Person p : myList) {
			p.speak();
		}
	}

	public static void wildcardPrintWithBound(List<? extends Person> myList) {
		myList.forEach(item -> item.speak());
		myList.forEach(item -> ((Student) item).study());

//		 Per star ancora piu' sicuri, un controllino con l'instanceof non guasta
//		myList.forEach(item -> {
//			if (item instanceof Student) {
//				((Student) item).study();
//			}
//		});
	}

	public static <T extends Person> void genericsPrintWithBound(List<T> myList) {
		for (T item : myList) {
			item.speak();
		}

		// questo e' possibile, ma e' preferibile farlo con la wildcard
//		for (T item : myList) {
//			((Student)item).study();
//		}
	}

}
