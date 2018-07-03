package pkg;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomHashMap<K,V> {

	private Entry<K,V>[] myMap;
	
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
		
		//Get value based on key
		public V get(K key) {
			Entry<K,V> toGet = myMap[(int) (key)];
			
			return toGet.value;
		}
		
		//Add new entry to hashMap
		public void put(K key, V data) {
			if (key == null) {
				return;
			}
			
			Entry<K,V> newestEntry = new Entry<K,V>(key, data, null);
		}
		
		//Remove values from hashMap based on key
		public void remove(K key) {
			Entry<K,V> previous = null;
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomHashMap<Integer, Integer> hashMap = new CustomHashMap<Integer, Integer>();
		
		hashMap.put(1, 100);
		hashMap.put(2, 200);
		hashMap.put(3, 300);
		
		System.out.println(hashMap.get(1));
	}

}
