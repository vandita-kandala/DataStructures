package CrackingTheCodingInterview;
 
//limited set from 0-256 if string contains only ASCII
public class RemoveDuplicateCharactersInString {
	public static void removeDuplicates2(char[] s) {
		boolean[] char_set = new boolean[256];
		for(int i=0;i<s.length;i++) {
			int val = s[i];
			if(char_set[val]==true)
				s[i] = 0;
			char_set[val] = true;
		}
		 System.out.println(s);
	}
	
	//unlimited set. If string contains more.
	public static void removeDuplicates1(char[] str) {
		 if (str == null) return;
		 int len = str.length;
		 if (len < 2) return;
		 for(int i=1;i<len;i++) {
			 int j;
			 for (j = 0; j < i; ++j) {
				 if (str[i] == str[j]) 
					 str[i] = 0; 
				 }
		 }
		 System.out.println(str);
		
	}
	
	public static void main(String args[]) {
		char str[] = {'h','e','l','l','l','h','e','y'};
		removeDuplicates1(str);
		removeDuplicates2(str);

	}
}
