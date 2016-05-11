package Hashing;

import Hashing.SimpleMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class OpenHashing<K,V> implements SimpleMap<K,V> {
	private static int cantBuckets = 3;
	private Node<K,V>[] buckets = new Node[cantBuckets];
	private int size;
	private float maxLoad = 3f;		// elems per bucket
	private float RehashFactor = 1.5f;
	
	private class Node<K,V> {
		private K key;
		private V value;
		private Node<K,V> next;
		public Node(K key, V value, Node<K,V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	@Override
	public void put(K key, V value) {
		int bucket = Math.abs(key.hashCode() % cantBuckets);
		Node<K,V> n = buckets[bucket];
		
		while (n != null) {
			if (n.key.equals(key)) {
				n.value = value;
				return;
			}
			n = n.next;
		}
		buckets[bucket] = new Node<K,V>(key, value, buckets[bucket]);
		size++;
		
		if (size / (float)cantBuckets > maxLoad) {
			rehash((int)(cantBuckets * RehashFactor));
		}
	}
	
	private void rehash(int size) {
		cantBuckets = size;
		Node<K,V>[] prevBuckets = buckets;
		buckets = new Node[cantBuckets];
		
		for(Node<K,V> n: prevBuckets) {
			while (n != null) {
				put(n.key, n.value);
				n = n.next;
			}
		}
	}

	@Override
	public V get(K key) {
		int bucket = Math.abs(key.hashCode() % cantBuckets);
		Node<K,V> n = buckets[bucket];
		while (n != null) {
			if (n.key.equals(key)) {
				return n.value;
			}
			n = n.next;
		}
		return null;
	}

	@Override
	public void remove(K key) {
		int bucket = Math.abs(key.hashCode() % cantBuckets);
		Node<K,V> n = buckets[bucket];
		buckets[bucket] = removeRec(n, key);
	}
	
	private Node<K,V> removeRec(Node<K,V> n, K key) {
		if (n == null) {
			return null;
		}
		if (n.key.equals(key)) {
			return n.next;
		}
		n.next = removeRec(n.next, key);
		return n;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new TreeSet<>();
		for(Node<K,V> n: buckets) {
			while (n != null) {
				set.add(n.key);
				n = n.next;
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Collection<V> arr = new ArrayList<>();
		for(Node<K,V> n: buckets) {
			while (n != null) {
				arr.add(n.value);
				n = n.next;
			}
		}
		return arr;
	}

	@Override
	public int size() {
		return size;
	}
	
	public void print() {
		int currentBucket = 0;
		for(Node<K,V> n: buckets) {
			System.out.println("Bucket " + currentBucket++ + ":");
			Node<K,V> auxN = n;
			while (auxN != null) {
				System.out.println("    key: " + auxN.key + " value: " + auxN.value);
				auxN = auxN.next;
			}
		}
	}

}
