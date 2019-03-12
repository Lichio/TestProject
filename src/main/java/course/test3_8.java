package course;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * TestProject course
 *
 * @author Lichaojie
 * @version 2018/3/28 21:26
 */
public class test3_8 {
	public String findSmallest(String[] strs, int n) {
		// write code here
		List<String> list = Arrays.asList(strs);
		list.sort((o1, o2) -> {
			String s1 = o1 + o2;
			String s2 = o2 + o1;
			if (s1.compareTo(s2) > 0) {
				return 1;
			} else if (s1.compareTo(s2) < 0) {
				return -1;
			} else {
				return 0;
			}
		});
		StringBuilder stringBuilder = new StringBuilder();
		list.forEach(stringBuilder::append);
		return stringBuilder.toString();
	}

}
