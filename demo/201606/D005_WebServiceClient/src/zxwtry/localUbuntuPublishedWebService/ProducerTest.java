package zxwtry.localUbuntuPublishedWebService;

import java.rmi.RemoteException;

import zxwtry.localUbuntuPublishedWebService.PublishWebServiceStub.GetPublishedWebService;

public class ProducerTest {
	public static void main(String[] args) throws RemoteException {
		PublishWebServiceStub stub = new PublishWebServiceStub();
		GetPublishedWebService getPublishedWebService0 = new GetPublishedWebService();
		getPublishedWebService0.setArg("I am zxwtry in windows");
		
		String s = stub.getPublishedWebService(getPublishedWebService0).get_return();
		System.out.println(s);
	}
}
