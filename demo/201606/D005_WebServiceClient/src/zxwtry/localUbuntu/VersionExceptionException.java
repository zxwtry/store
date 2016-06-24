/**
 * VersionExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package zxwtry.localUbuntu;

public class VersionExceptionException extends java.lang.Exception {
    private static final long serialVersionUID = 1460875247439L;
    private zxwtry.localUbuntu.VersionStub.VersionException faultMessage;

    public VersionExceptionException() {
        super("VersionExceptionException");
    }

    public VersionExceptionException(java.lang.String s) {
        super(s);
    }

    public VersionExceptionException(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public VersionExceptionException(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        zxwtry.localUbuntu.VersionStub.VersionException msg) {
        faultMessage = msg;
    }

    public zxwtry.localUbuntu.VersionStub.VersionException getFaultMessage() {
        return faultMessage;
    }
}
