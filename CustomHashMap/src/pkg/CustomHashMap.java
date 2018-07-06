package pkg;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomHashMap<K,V> {

	private Entry<K,V>[] myMap;
	private int hashMapSize = 3;
	
	class Entry<K, V> {
		K key;
		V value;
		Entry<K,V> next;
		
		public Entry(K kp, V vp, Entry<K,V> np) {
			this.key = kp;
			this.value = vp;
			this.next = np;
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		myMap = new Entry[hashMapSize];
	}
		
		//Get value based on key
		public V get(K key) {
			int hashCode = hash(key);
			if(myMap[hashCode] == null) {
				return null;
			} else {
				Entry<K,V> toGet = myMap[hashCode];
				while(toGet != null) {
					if(toGet.key.equals(key)) {
						return toGet.value;
					}
					toGet = toGet.next;
				}
			return null;
			}
		}
		
		//Add new entry to hashMap
		public void put(K key, V data) {
			if (key == null) {
				return;
			}
			int hashCode = hash(key);
			Entry<K,V> newestEntry = new Entry<K,V>(key, data, null);
			if(myMap[hashCode] == null) {
				myMap[hashCode] = newestEntry;
			} else {
				Entry<K,V> previous = null;
				Entry<K,V> current = myMap[hashCode];
				while(current != null) {
					if(current.key.equals(key)) {
						if(previous == null) {
							newestEntry.next = current.next;
							myMap[hashCode] = newestEntry;
							return;
						} else {
							newestEntry.next = current.next;
							previous.next = newestEntry;
							return;
						}
					}
					previous = current;
					current = current.next;
				}
				previous.next = newestEntry;
			}
		}	
		
		//Remove values from hashMap based on key
		public boolean remove(K key) {
			int hashCode = hash(key);
			if(myMap[hashCode] == null) {
				return false;
			} else {
				Entry<K,V> previous = null;
				Entry<K,V> current = myMap[hashCode];
				while(current != null) {
					if(current.key.equals(key)) {
						if(previous == null) {
							myMap[hashCode] = myMap[hashCode].next;
							return true;
						} else {
							previous.next = current.next;
							return true;
						}
					}
					previous = current;
					current = current.next;
				}
				return false;
			}
		}
		
		private int hash(K key) {
			return Math.abs(key.hashCode()) % hashMapSize;
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomHashMap<Integer, Integer> hashMap = new CustomHashMap<Integer, Integer>();
		
		hashMap.put(1, 100);
		hashMap.put(2, 200);
		hashMap.put(3, 300);
		
		System.out.println("The value for key 1 is: " + hashMap.get(1));
		System.out.println("The value for key 2 is: " + hashMap.get(2));
		System.out.println("The value for key 3 is: " + hashMap.get(3));
	}

}
