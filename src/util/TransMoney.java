package util;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jdt.internal.compiler.util.HashtableOfIntValues;

public class TransMoney {

	public String convert(String money) {
		String[] numberCNN = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		String[] subMonetCN = {"","拾","佰","仟"};
		
		String formatCN = "";
		int point = money.indexOf(".");
		if(point!=-1) {
			String money1 = money.substring(0, point);		//小数点前的整数部分
			String money1_1 = (new StringBuffer(money1).reverse()).toString(); //反转
			String money2 = money.substring(point+1);		//小数点后的小数部分
			
			//判断小数点前后是不是数字
			if(!StringUtils.isNumeric(money1)||!StringUtils.isNumeric(money2)) {
				formatCN = "输入内容必须是数字，请重新输入";
				System.out.println(formatCN);
				return formatCN;
			}
			
			if(money2.length()<2) {
				if(money2.length() == 0) {
					money2 = "00";
				}else {
					money2 = money2  + "0";
				}
			}else {
				//如果小数点后面的位数大于两位，则只取前两位
				money2 = money.substring(point+1, point+3);
			}
			
			int len = money1_1.length();   //字符串反转之后，小数点之前的位数
			int pos = len - 1;
			String single = "";
			boolean allHaveNum = false;
			boolean haveNum = false;
			boolean mark = false;
			
			//输入的数字不能超过15位
			if(len>=16) {
				formatCN = "您输入的位数过大(整数部分不能超过15位)，请重新输入";
				return formatCN;
			}
			
			while(pos>=0) {
				single = money1_1.substring(pos,pos+1);
//				if(pos>=8&&pos<12) {
					if(pos>=8) {
						if(!"0".equals(single)) {
							if(!mark) {
								formatCN = formatCN + numberCNN[Integer.parseInt(single)] + subMonetCN[pos%4];
							}else {
								if(allHaveNum) {
									formatCN = formatCN + "零";
								}
								formatCN = formatCN + numberCNN[Integer.parseInt(single)] + subMonetCN[pos%4];
								mark = false;
							}
							haveNum = true;
							allHaveNum = true;
						}else {
							mark = true;
						}
						
						if(pos%4==0&&pos!=8&&haveNum) {
							formatCN = formatCN + "万";
						}
						
						if(pos==8&&haveNum) {
							formatCN = formatCN + "亿";
							haveNum = false;
						}
					}
				
					if(pos>=4&&pos<8) {
						if(!"0".equals(single)) {
							if(!mark) {
								formatCN = formatCN + numberCNN[Integer.parseInt(single)] + subMonetCN[pos%4];
							}else {
								if(allHaveNum) {
									formatCN = formatCN + "零";
								}
								formatCN = formatCN + numberCNN[Integer.parseInt(single)] + subMonetCN[pos%4];	
								mark = false;
							}
							haveNum = true;
							allHaveNum = true;
						}else {
							mark = true;
						}
						if(pos%4==0&&haveNum) {
							formatCN = formatCN + "万";
							haveNum = false;
						}
					}
					
					if(pos>=0&&pos<4) {
						if(!"0".equals(single)) {
							if(!mark) {
								formatCN = formatCN + numberCNN[Integer.parseInt(single)] + subMonetCN[pos%4];	
							}else {
								if(allHaveNum) {
									formatCN = formatCN + "零";
								}
								formatCN = formatCN + numberCNN[Integer.parseInt(single)] + subMonetCN[pos%4];	
								mark = false;
							}
							haveNum = true;
							allHaveNum = true;
						}else {
							mark = true;
						}
					}
					pos--;
				}
				if(allHaveNum) {
					formatCN = formatCN + "元";
				}else {
					formatCN = formatCN + "零元";
				}
				
				if("00".equals(money2)) {
					formatCN = formatCN + "整";
				}else {
					if(money2.startsWith("0")||(allHaveNum&&money1.startsWith("0"))) {
						formatCN = formatCN + "零";
					}
					if(!money2.startsWith("0")) {
						formatCN = formatCN + numberCNN[Integer.parseInt(money2.substring(0,1))] + "角";
					}
					formatCN = formatCN + numberCNN[Integer.parseInt(money2.substring(1))] + "分";
				}
			
		}else {
			formatCN = "您输入的格式不正确，格式为：888.00";
		}
		return formatCN;
	}
	
	public static void main(String[] args) {
		TransMoney t = new TransMoney();
		String s = t.convert("968767984700000.7");
		System.out.println(s);
	}
}
