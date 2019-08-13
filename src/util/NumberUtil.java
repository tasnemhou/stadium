package util;

import org.apache.commons.lang.StringUtils;

public class NumberUtil {

	public static Double parseDouble(String str) {
//		Boolean strResult = str.matches("-?[0-9]+.?[0-9]*");  
		Boolean strResult = str.matches("[0-9]+.?[0-9]*");  
        
		if(strResult == true) {  
            return Double.valueOf(str);
        } else {  
            return (double) 0;
        }  
	}
	
	//"".matches("[0-9]*") 会返回true   ?????????
	public static Integer parseInteger(String str) {
		if(StringUtils.isNotBlank(str)) {
			Boolean strResult = str.matches("[0-9]*");  
			if(strResult == true) {  
				return Integer.valueOf(str);
			} else {  
				return 0;
			}  
		}else {
			return 0;
		}
	}
}
