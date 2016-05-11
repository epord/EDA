package Hashing;

import Hashing.OpenHashing;

import java.util.Collection;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		System.out.println("----- MULTIMAP -----");

		Multimap<String, Integer> multi = new MultimapImpl<>();

		multi.put("A", 2);
		multi.put("A", 6);
		multi.put("A", 12);
		multi.put("A", 4);

		multi.put("B", 3);
		multi.put("B", 7);
		multi.put("B", 5);

		multi.put("C", 13);
		multi.put("C", 19);


		multi.remove("C");
		multi.remove("B", 7);
		multi.remove("B", 3);
		multi.remove("B", 5);

		multi.print();


		System.out.println("----- BAG -----");

		Bag<String> bag = new BagImpl<>();

		bag.add("A");
		bag.add("B");
		bag.add("C");
		bag.add("B");
		bag.add("A");
		bag.add("D");
		bag.add("A");
		bag.add("D");

		bag.remove("A");
		bag.remove("C");

		bag.print();

		System.out.println(bag.occurencesOf("B"));


		System.out.println("----- HASHMAP -----");

		OpenHashing<String, String> oh = new OpenHashing<>();

		oh.put("Nombre", "Apellido");
		oh.put("Prénom", "Nom");
		oh.put("Name", "Surname");
		oh.put("Federico", "Fernandez");
		oh.put("Hernán", "Hernandez");
		oh.put("Rodrigo", "Rodriguez");
		oh.put("Pedro", "Perez");
		oh.put("Jimena", "Gimenez");
		oh.put("AAA", "aaa");
		oh.put("BBB", "bbb");
		oh.put("CCC", "ccc");
		oh.put("DDD", "ddd");
		oh.put("EEE", "eee");
		oh.put("FFF", "fff");
		oh.put("GGG", "ggg");
		oh.put("HHH", "hhh");

		oh.print();

		oh.remove("Pedro");
		oh.remove("AAA");

		oh.print();

		Set<String> keySet = oh.keySet();
		System.out.println("Keys: " + keySet);

		Collection<String> values = oh.values();
		System.out.println("Values: " + values);

	}
}
