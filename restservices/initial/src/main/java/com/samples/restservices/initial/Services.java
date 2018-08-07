/**
 * 
 */
package com.samples.restservices.initial;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author pavan
 *
 */
@Path("/json/metallica")
public class Services {
	private static long COUNT;
	
	@GET
	@Path("/get")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;
	}

	@POST
	@Path("/post")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createTrackInJSON(Track track, @Context HttpHeaders header) {
		COUNT++;
		System.out.println("Header Info:: "+COUNT+header.getMediaType());
		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}
	
	@PUT
	@Path("/put")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response putData(Track track) {
		System.out.println("In Put method");
		String result = "Track Created: " + track;
		return Response.status(201).entity(result).build();
	}
	
	@DELETE
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteData (Track track) {
		String result = "Track Deleted" + track;
		return Response.status(202).entity(result).build();
	}
	
}