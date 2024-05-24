package strings;

// few test cases are not getting passed
class AtoI {

	public static void main(String[] args) {
		String s = "    -42";
		System.out.println(myAtoi(s));
//		System.out.println(Integer.MIN_VALUE);
	}

	public static int myAtoi(String s) {
		int sign = 1;
		long res = 0;
		int i = 0;
		s = s.trim();
		if (s.length() == 0)
			return 0;
		if (s.charAt(0) == '-') {
			sign = sign * (-1);
			i = 1;
		}
		if (s.charAt(0) == '+') {
			sign = 1;
			i = 1;
		}
		for (; i < s.length(); i++) {
            if(s.charAt(i)=='.')break;
			if (!Character.isDigit(s.charAt(i))) {
				if(res == 0)
					return 0;
				else
					return (int) (sign*res);
			}
			if (Character.isDigit(s.charAt(i))) {
				res = res * 10 + (s.charAt(i) - '0');
			}

		}
		res = res * sign;
		if (res < Integer.MIN_VALUE)
			res = Integer.MIN_VALUE;
		if (res > Integer.MAX_VALUE)
			res = Integer.MAX_VALUE;
		return (int) res;
	}
}