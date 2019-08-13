package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateUtil {
	
		/**
		 * @return
		    *       获取当前日期 "yyyyMMdd"格式
		 */
		public static String getCurrentDate() {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String currentDt = sdf.format(date);
			return currentDt;
		}
}
