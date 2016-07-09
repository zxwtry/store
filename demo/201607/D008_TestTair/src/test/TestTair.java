package test;

import java.util.ArrayList;
import java.util.List;

import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.ResultCode;
import com.taobao.tair.impl.DefaultTairManager;

public class TestTair {
	final static String server0="192.168.160.150:5198";
	public static void main(String[] args) {
		List<String> confServers = new ArrayList<String>();
		confServers.add(server0);
		
		DefaultTairManager tairManager = new DefaultTairManager();
		tairManager.setConfigServerList(confServers);
		
		tairManager.setGroupName("group_1");
		tairManager.init();
		
		for (int i = 0; i < 10; i ++) {
			ResultCode result = tairManager.put(0, "k"+i, "v"+i, 0, 10);
			System.out.println("put k"+i+":"+result.isSuccess());
			if (!result.isSuccess()) {
				System.out.println("Not Success");
				break;
			}
		}
		
		Result<DataEntry> result = tairManager.get(0, "k3");
		System.out.println("get:"+result.isSuccess());
		if (result.isSuccess()) {
			DataEntry entry = result.getValue();
			if (entry != null) {
				System.out.println("value is "+entry.getValue().toString());
			} else {
				System.out.println("This key does not exist!");
			}
		} else {
			System.out.println(result.getRc().getMessage());
		}
	}
}
