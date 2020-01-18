import java.util.ArrayList;
import java.util.List;

/***
 * Backend Engineer (Intern) - Java (SnapCheck, Inc.)
 * coding challenge in JD
 * @author Zhaoqi Li
 * date: 01/18/2020
 */

public class Encryption {
	
	//core function
	public static String encryption(String input) {
		//remove all the spaces in the string
		input = input.replace(" ", "");
		int length = input.length();
		//corner case
		if (length == 0) return new String("");
		
		StringBuilder res = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		int col = (int)Math.ceil(Math.sqrt(length));
		
		//the index of the first char in each row
		List<Integer> rowindex = new ArrayList<Integer>();
		
		int index = 0;
		while (index < length) {
			rowindex.add(index);
			index += col;
		}
		//get the char we need in-place to save memory
		for (int i = 0; i < col; i++) {
			tmp = new StringBuilder();
			for (int cur : rowindex) {
				if (cur + i < length) {
					tmp.append(input.charAt(cur + i));
				}
			}
			res.append(tmp + " ");
		}
		
		return res.toString().trim();
	}
	
	//test function
	public static void main(String[] arg) {
		System.out.println(encryption(new String(" "))); //none
		System.out.println(encryption(new String("if man was meant to stay on the ground god would have given us roots"))); //imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
		System.out.println(encryption(new String("haveaniceday"))); //hae and via ecy
		System.out.println(encryption(new String("feedthedog    "))); //fto ehg ee dd
		System.out.println(encryption(new String("chillout"))); //clu hlt io
	} 

}
