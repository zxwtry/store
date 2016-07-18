package util;

import java.math.BigDecimal;

/**
 * <p>用来获取JVM的内存使用情况</p>
 * <ul>
 * 	<li>Java Doc</li>
 * </ul>
 * @author zxwtry
 * 
 */
public class MemoryUtil {
	/**
	 * 获取JVM内存
	 */
	/**
	 * 内部参数：
	 * rt: 		当前的Runtime.getRuntime()
	 * max:		获取最大内存大小		单位：MB
	 * total:	总共内存大小			单位：MB
	 * free:	空闲内存大小			单位：MB
	 * avail:	可用内存大小			单位：MB
	 */
	public static String getJVMMemory() {
		Runtime rt = Runtime.getRuntime();	
		double max = rt.maxMemory() >> 20;	
		double total = rt.totalMemory() >> 20;
		double free = rt.freeMemory() >> 20;
		double avail = max - total + free;
		
		BigDecimal bigAvail = new BigDecimal(avail);
		bigAvail = bigAvail.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		BigDecimal bigTotal = new BigDecimal(total);
		bigTotal = bigTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		StringBuffer st = new StringBuffer();
		st.append("{\"total\":");
		st.append(bigTotal.toString());
		st.append(",\"avail\":");
		st.append(bigAvail.toString());
		st.append("}");
		
		return st.toString();
	}
}