package com.mule.spring;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
	public static void main(String[] args){
		StringUtilsTest t = new StringUtilsTest();
		t.getFloat();
	}
	
	public void test(){
		try{
			String  srcVaue  = "010-0000000";
			//如果为空则跳过不处理
			if(StringUtils.isBlank(srcVaue)){
				return;
			}
			
			boolean rightTel = false;
			
			//非空时，校验格式
			if(srcVaue.contains("-")){ 
				//非空有区号
				String[] telArray = srcVaue.split("-");
				if(telArray.length != 2){
					rightTel = false;
				}else{
					int zoneLen = telArray[0].length(); //区号
					int numLen  = telArray[1].length(); //号码
					if(zoneLen == 3 || zoneLen == 4){
						if(numLen == 7 || numLen == 8){
							rightTel = true;
						}
					}
				}
			}else{ 
				//非空无区号
				int numLen = srcVaue.length();
				if(numLen == 7 || numLen == 8){
					rightTel = true;
				}
			}
			
			//含有字母的非法字符
	        if( Pattern.compile(".*[a-zA-Z]+.*").matcher(srcVaue).matches() == true){
	        	rightTel = false;
	        }
			
			//无效的电话格式，置空
			if(rightTel == false){
				//srcObj.getJSONObject(node).put(key, "");
				System.out.println("电话：" + srcVaue + " 格式无效，已置空");
			}
			
			if(rightTel == true){
				System.out.println(srcVaue + " 电话合法");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void testReg(){
		String regex = "[\\d]{7,8}|[\\d]{3,4}\\-[\\d]{7,8}";
		String srcVaue = "1111-1234567";
		System.out.println(Pattern.compile(regex).matcher(srcVaue).matches());
	}
	
	public void getFloat(){
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(0.01254));
	}
}
