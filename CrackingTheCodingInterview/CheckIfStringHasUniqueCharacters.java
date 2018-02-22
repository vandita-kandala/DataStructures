package CrackingTheCodingInterview;

public class CheckIfStringHasUniqueCharacters {
//first charset[0-256] are set to false. so in the code if a value from 0-256 is present we are setting to true
//but if a value is true and is encountered again then it means it is present in the string twice
//meaning the string has repeated char and does not have all unique chars
	public static boolean isUnique1(String s) {
		boolean[] char_set = new boolean[256];
		for(int i=0;i<s.length();i++) {
			int val = s.charAt(i);
			if(char_set[val]==true)
				return false;
			char_set[val] = true;
		}
		
		return true;
	}
	
	//2^0 = 1 = 0000 0001
	//2^1 = 2 = 0000 0010
	//2^2 = 4 = 0000 0100
	//2^3 = 8 = 0000 1000
	//.. so on
	//here for every power of 2, 1 is shifting left.
	// 1<<val is 1*(2^val). Values of that multiplication results in powers of 2
	
	
	// checker |= (1<<val) is checker = checker | (1<<val). results in bitwise OR of checker and (1<<val)
	//Or puts a 1 if 1 is present in either
	//So when OR is performed between 1 | 2 it places 1 in last two bits
	// = 0000 0011
	//When OR is performed between 1 | 2 | 8
	//= 0000 1011
	//that means still 2^2 = 4 is not encountered yet.
	//if next is 1 | 2 | 4 | 8
	// = 0000 1111
	
	//now in the next step if either or 1,2,4,8 is encountered then
	//checker & (1<<val) gives something other than 0 (Bitwise AND gives 1 if both have 1)
	//its 0 only if the number isn't encountered before. coz that bit place will be still 0.
	
	//so the resultant 0000 1111 will be > 0 if the next numbers are either of 1,2,4,8
	//i.e.., 0(2^0 = 1) or 1 (2^1=2) or 2 (2^2=4) or 3 (2^3=8).
	
	//so the code below starts by checker =0. next it checks multiplies 1 with 2^ s.chart(i) value.
	//this value is always & with checker to see if the value is encountered before.
	//if it is, then the result is false.
	//if it is not, it is OR to the existing checker to make that bit 1.
	
	
	public static boolean isUnique2(String s) {
		
		int checker=0;
		for(int i=0;i<s.length();i++) {
			int val = s.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;
			checker = checker | (1 << val);

		}
		
		return true;
	}
	
	
	public static void main(String args[]) {
		//System.out.println(isUnique1("hello"));
		System.out.println(isUnique2("hello"));

	}
}
