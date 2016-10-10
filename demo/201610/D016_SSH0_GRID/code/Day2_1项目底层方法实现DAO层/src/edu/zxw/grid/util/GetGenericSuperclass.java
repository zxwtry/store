package edu.zxw.grid.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import edu.zxw.grid.dao.impl.CommonDaoImpl;

public class GetGenericSuperclass {

	@SuppressWarnings("rawtypes")
	public static <T> Type[] getClassesByThis(Class<? extends CommonDaoImpl> thisClass) {
		ParameterizedType pt = (ParameterizedType) thisClass.getGenericSuperclass();
		return pt.getActualTypeArguments();
	}
	
}
 