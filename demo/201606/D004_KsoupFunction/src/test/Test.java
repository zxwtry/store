package test;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Test {
	public static void main(String[] args) throws Exception{
//		getWeather();
		getFromMiddlewareWebService();
	}
	static void getWeather() throws Exception{
	 	final String url = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
		final String namespace = "http://WebXml.com.cn";
		final String action = "getRegionProvince";
		HttpTransportSE trans = new HttpTransportSE(url);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		SoapObject body = new SoapObject(namespace,action);
		envelope.setOutputSoapObject(body);
		envelope.dotNet = true;
		trans.call(namespace+"/"+action, envelope);
		SoapObject soapObject = (SoapObject)envelope.getResponse();
		for (int i = 0; i < soapObject.getPropertyCount(); i ++) {
			System.out.println(soapObject.getProperty(i));
		}
	}
	
	private static void getFromMiddlewareWebService() {
		
	}
} 