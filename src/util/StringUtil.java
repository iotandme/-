package util;
/**
 * �ַ���������
 * @author iot
 *
 */
public class StringUtil {
	/**
	 * �ж��Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())){
			return true;
		}else {
			return false;
		}
	}
	/**
	 * �ж��Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public static boolean isNoEmpty(String str) {
		if(str!=null&&!"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
