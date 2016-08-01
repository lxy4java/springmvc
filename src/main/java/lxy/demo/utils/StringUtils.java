package lxy.demo.utils;

public class StringUtils {
	/**
	 * 首字母大写
	 */
	public static String firstUppercase(String name) {
		char[] cs = name.toCharArray();
		// ascii 码 移动 32位
		cs[0] -= 32;
		return String.valueOf(cs);
	}

	/**
	 * 去下划线，然后首字母转大写
	 * 
	 */
	public static String toClassName(String name) {
		String[] strs = name.toLowerCase().split("_");
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = strs.length; i < len; i++) {
			sb.append(firstUppercase(strs[i]));
		}
		return sb.toString();

	}

	/**
	 * 专为 驼峰，先大些转小写，在去下划线转驼峰
	 */
	public static String humpCapital(String name) {
		String[] strs = name.toLowerCase().split("_");
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = strs.length; i < len; i++) {
			if (i == 0) {
				sb.append(strs[i]);
			} else {
				sb.append(firstUppercase(strs[i]));
			}
		}
		return sb.toString();
	}

	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}
	public static void main(String[] args) {
		String name="xx_oo_yy";
		System.out.println(toClassName(name));
		System.out.println(firstUppercase(name));
		System.out.println(humpCapital(name));
	}
}
