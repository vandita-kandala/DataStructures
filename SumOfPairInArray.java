import java.util.HashMap;

public class SumOfPairInArray {

	public static int[] findPair(int z, int[] arr){
		
		int l = arr.length;
		
		HashMap<Integer, Integer> hm = new HashMap();
		
		for(int i=0; i<l; i++) {
			
			int comp = z - arr[i];
			
			if(hm.containsKey(comp)) {
				return new int[] {hm.get(comp), i};	
			}
			hm.put(arr[i], i);
		}
		
		return null;
	}
	
	public static void main(String args[]) {
		
		int[] arr = new int[] {1,2, 3, 4, 5, 6, 7, 8, 9};
		int z = 10;
		int[] resss = findPair(z, arr);
		System.out.println(resss[0]+","+resss[1]);
	}
}
