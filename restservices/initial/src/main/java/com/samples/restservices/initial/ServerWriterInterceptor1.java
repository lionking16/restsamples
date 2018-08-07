/**
 * 
 */
package com.samples.restservices.initial;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 * @author pavan
 *
 */
@Provider
public class ServerWriterInterceptor1 implements WriterInterceptor {
 
    public void aroundWriteTo(WriterInterceptorContext interceptorContext)
            throws IOException, WebApplicationException {
        System.out.println("ServerWriterInterceptor1 invoked");
        OutputStream outputStream = interceptorContext.getOutputStream();
        String responseContent = "\nResponse changed in ServerWriterInterceptor1.";
        outputStream.write(responseContent.getBytes());
        interceptorContext.setOutputStream(outputStream);
 
        interceptorContext.proceed();
    }
}
