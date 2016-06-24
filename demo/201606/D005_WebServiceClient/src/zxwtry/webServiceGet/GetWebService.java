package zxwtry.webServiceGet;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import zxwtry.webServiceTest.PublishWebServiceStub;
import zxwtry.webServiceTest.PublishWebServiceStub.GetPublishedWebService;
import zxwtry.webServiceTest.PublishWebServiceStub.GetPublishedWebServiceResponse;

public class GetWebService {
	public static void main(String[] args) throws RemoteException {
		PublishWebServiceStub stub = new PublishWebServiceStub();
		GetPublishedWebService getPublishedWebService0 = new GetPublishedWebService();
		getPublishedWebService0.setArg("zxwtry");
		GetPublishedWebServiceResponse publishedWebservice = stub.getPublishedWebService(getPublishedWebService0);
		String s = publishedWebservice.get_return();
		System.out.println(s);
		System.out.println(stub.getPublishedWebService(getPublishedWebService0).get_return());
	}
}