package com.jack.design.pattern.filter;

import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName: Filter
 * @author:  Jack Zeng 
 * @CreateDate: [2016年9月6日 下午3:20:12]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年9月6日 下午3:20:12]   
 * @UpdateRemark: [TODO()]
 * @Description:  [利用lambda表达式，可以完成多个刷选条件的扩展情况]
 * @version: [V1.0]
 */
public class Filter {
	
	public static <T> List<T> filter(final List<T> list,Condition<T> condition){
		List<T> retList = new ArrayList<T>();
		
		for(T e : list){
			if(condition.test(e)){
				retList.add(e);
			}
		}
		
		return retList;
	}
}
