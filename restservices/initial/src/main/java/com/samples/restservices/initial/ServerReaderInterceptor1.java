package com.samples.restservices.initial;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
@PreMatching
public class ServerReaderInterceptor1 implements ReaderInterceptor {

	public Object aroundReadFrom(ReaderInterceptorContext interceptorContext) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub

		System.out.println("ServerReaderInterceptor2 invoked.");
		InputStream inputStream = interceptorContext.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String data = "";
		
		while((data = reader.readLine()) != null) {
			System.out.println("Data:: "+data);
			interceptorContext.setInputStream(new ByteArrayInputStream(
					data.getBytes()));
		}
		
		return interceptorContext.proceed();
	}

}