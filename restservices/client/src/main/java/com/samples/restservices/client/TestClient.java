/**
 * 
 */
package com.samples.restservices.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author pavan
 *
 */
public class TestClient {
	
	private static Client client = Client.create();
	
	private static WebResource webResource_get = client.resource("http://localhost:8080/initial/rest/json/metallica/get");
	private static WebResource webResource = client.resource("http://localhost:8080/initial/rest/hello");
	private static WebResource webResource_post = client.resource("http://localhost:8080/initial/rest/json/metallica/post");
	private static WebResource webResource_put = client.resource("http://localhost:8080/initial/rest/json/metallica/put");
	private static WebResource webResource_delete = client.resource("http://localhost:8080/initial/rest/json/metallica/delete");
	
	public void getJSONExample() {
		
		ClientResponse response_json_get = webResource_get.accept("application/json")
				.get(ClientResponse.class);
		
		if (response_json_get.getStatus() != 200) {
			throw new RuntimeException("Failed JSON GET: HTTP error code : "
					+ response_json_get.getStatus());
		}
		
		String output_json_get = response_json_get.getEntity(String.class);
		System.out.println("JSON GET output from server");
		System.out.println(output_json_get);
	}
	
	public void getXMLExample() {
		ClientResponse response_xml_get = webResource_get.accept("application/xml")
				.get(ClientResponse.class);
		
		if (response_xml_get.getStatus() != 200) {
			throw new RuntimeException("Failed XML GET: HTTP error code : "
					+ response_xml_get.getStatus());
		}
		String output_xml_get = response_xml_get.getEntity(String.class);
		System.out.println("XML GET output from server ");
		System.out.println(output_xml_get);
	}
	
	public void postJSONExample () {
		ClientResponse response_json_post = webResource_post.type("application/json")
				.post(ClientResponse.class, "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}");
		
		if (response_json_post.getStatus() != 201) {
			throw new RuntimeException("Failed JSON POST: HTTP error code : "
					+ response_json_post.getStatus());
		}
		String output_json_post = response_json_post.getEntity(String.class);
		System.out.println("JSON POST output from server");
		System.out.println(output_json_post);
	}
	
	public void postXMLExample() {
		ClientResponse response_xml_post = webResource_post.type("application/xml")
				.post(ClientResponse.class, "<track><singer>Metallica</singer><title>Fade To Black</title></track>");
		
		if (response_xml_post.getStatus() != 201) {
			throw new RuntimeException("Failed xml POST: HTTP error code : "
					+ response_xml_post.getStatus());
		}
		String output_xml_post = response_xml_post.getEntity(String.class);
		System.out.println("XML POST output from server ");
		System.out.println(output_xml_post);
	}
	
	public void putJSONExample () {
		ClientResponse response_json_put = webResource_put.type("application/json")
				.put(ClientResponse.class, "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}");
		
		if (response_json_put.getStatus() != 201) {
			throw new RuntimeException("Failed JSON PUT: HTTP error code : "
					+ response_json_put.getStatus());
		}
		
		String output_json_post = response_json_put.getEntity(String.class);
		System.out.println("JSON PUT output from server");
		System.out.println(output_json_post);
	}
	
	public void putXMLExample() {
		ClientResponse response_xml_put = webResource_put.type("application/xml")
				.put(ClientResponse.class, "<track><singer>Metallica</singer><title>Fade To Black</title></track>");
		
		if (response_xml_put.getStatus() != 201) {
			throw new RuntimeException("Failed xml PUT: HTTP error code : "
					+ response_xml_put.getStatus());
		}
		String output_xml_put = response_xml_put.getEntity(String.class);
		System.out.println("XML PUT output from server ");
		System.out.println(output_xml_put);
	}
	
	public void deleteJSONExample() {
		ClientResponse response_json_del = webResource_delete.type("application/json")
				.delete(ClientResponse.class, "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}");
		
		if (response_json_del.getStatus() != 202) {
			throw new RuntimeException("Failed xml PUT: HTTP error code : "
					+ response_json_del.getStatus());
		}
		String output_xml_delete = response_json_del.getEntity(String.class);
		System.out.println("XML PUT output from server ");
		System.out.println(output_xml_delete);
	}
	
	public void deleteXMLExample() {
		ClientResponse response_xml_del = webResource_delete.type("application/xml")
				.delete(ClientResponse.class, "<track><singer>Metallica</singer><title>Fade To Black</title></track>");
		
		if (response_xml_del.getStatus() != 202) {
			throw new RuntimeException("Failed xml PUT: HTTP error code : "
					+ response_xml_del.getStatus());
		}
		String output_xml_put = response_xml_del.getEntity(String.class);
		System.out.println("XML PUT output from server ");
		System.out.println(output_xml_put);
	}
	
	public void getPlainExample() {
		ClientResponse response = webResource.accept("text/plain")
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... ");
		System.out.println(output);
	}
	
	public static void main(String[] args) {
		TestClient client = new TestClient();
		
		try {
			client.getPlainExample();
			
			client.getJSONExample();
			client.getXMLExample();
			
			client.postJSONExample();
			client.postXMLExample();
			
			client.putJSONExample();
			client.putXMLExample();
			
			client.deleteJSONExample();
			client.deleteXMLExample();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
