
package com.sun.mdm.index.webservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0.redhat-610379
 * 2015-12-14T14:08:57.509-05:00
 * Generated source version: 2.7.0.redhat-610379
 */

@WebFault(name = "CodeLookupException", targetNamespace = "http://webservice.index.mdm.sun.com/")
public class CodeLookupException_Exception extends Exception {
    
    private com.sun.mdm.index.webservice.CodeLookupException codeLookupException;

    public CodeLookupException_Exception() {
        super();
    }
    
    public CodeLookupException_Exception(String message) {
        super(message);
    }
    
    public CodeLookupException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeLookupException_Exception(String message, com.sun.mdm.index.webservice.CodeLookupException codeLookupException) {
        super(message);
        this.codeLookupException = codeLookupException;
    }

    public CodeLookupException_Exception(String message, com.sun.mdm.index.webservice.CodeLookupException codeLookupException, Throwable cause) {
        super(message, cause);
        this.codeLookupException = codeLookupException;
    }

    public com.sun.mdm.index.webservice.CodeLookupException getFaultInfo() {
        return this.codeLookupException;
    }
}
