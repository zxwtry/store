/**
 * PublishWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package zxwtry.webServiceTest;


/**
 *  PublishWebServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class PublishWebServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public PublishWebServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public PublishWebServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getPublishedWebService method
     * override this method for handling normal response from getPublishedWebService operation
     */
    public void receiveResultgetPublishedWebService(
        zxwtry.webServiceTest.PublishWebServiceStub.GetPublishedWebServiceResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getPublishedWebService operation
     */
    public void receiveErrorgetPublishedWebService(java.lang.Exception e) {
    }
}
