package zxwtry.qUbuntu;

import javax.swing.text.GapContent;

import zxwtry.qUbuntu.PublishWebServiceStub.GetPublishedWebService;

public class ConsumerTest {
	public static void main(String[] args) throws Exception{
		PublishWebServiceStub stu = new PublishWebServiceStub();
		GetPublishedWebService getPublishedWebService0 = new GetPublishedWebService();
		getPublishedWebService0.setArg("This zxwtry for qUbuntu");
		String s = stu.getPublishedWebService(getPublishedWebService0).get_return();
		System.out.println(s);
	}
}
