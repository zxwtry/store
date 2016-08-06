import java.util.HashSet;
import java.util.Vector;
public class J019_structO1 {
	public static void main(String[] args) {
		MyStruct my = new MyStruct();
		my.insert(1);
		my.insert(2);
		my.insert(3);
		System.out.println(my.getRandom());
		System.out.println(my.getRandom());
		System.out.println(my.getRandom());
		System.out.println(my.getRandom());
		System.out.println(my.getRandom());
		my.delete(3);
		my.delete(2);
		System.out.println(my.getRandom());
		System.out.println(my.getRandom());
		System.out.println(my.getRandom());
	}

	static class MyStruct {
		Vector<Integer> vec = new Vector<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		public MyStruct() {
		}
		public boolean insert(int val) {
			if (set.contains(val)) {
				return false;
			} else {
				set.add(val);
				vec.add(val);
				return true;
			}
		}

		public void delete(int val) {
			if (set.contains(val)) {
				set.remove(val);
				vec.removeElement(val);
			}
		}

		public int getRandom() {
			int ind = (int)(Math.random()*vec.size());
			return vec.get(ind);
		}
	}
}
