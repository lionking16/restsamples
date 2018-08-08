/**
 * 
 */
package com.samples.restservices.initial;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

/**
 * @author pavan
 *
 */
@Provider
@PreMatching
public class ServerFilter implements ContainerRequestFilter {

	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
	 */
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Here");
		if (requestContext.getMethod().equals("POST")) {
            System.out.println("POST Method");
        }
		if (requestContext.getMethod().equals("PUT")) {
            System.out.println("PUT Method");
        }
	}

}
