package com.wbl.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class RestExecutor<client, HttpClient> {

	private HttpClient client;
	private String url;

	public RestExecutor(String url) {
		Object HttpClientBuilder;
		client = ((Object) HttpClientBuilder).create().build();
		this.url = url;
	}

	public RestValidator get(String path) {
		return get(path, null);
	}

	
	public RestValidator get(String path, HashMap<String, String> headers) {
		HttpClient request = new HttpGet(url + path);
		HttpResponse response;
		
		RestResponse resResponse = new RestResponse();
		StringBuffer responseString = new StringBuffer();
		try {
			
			if (headers != null) {
				Set<String> keys = headers.keySet();
				for (String key : keys) {
					request.addHeader(key, headers.get(key));
				}
			}
			
			response = client.execute(request);
			
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			
			resResponse.setResponseBody(responseString.toString());
			resResponse.setResponseCode(response.getStatusLine().getStatusCode());
			resResponse.setResponseMessage(response.getStatusLine().getReasonPhrase());
			Header[] rheaders = response.getAllHeaders();
			for (Header header : rheaders) {
				resResponse.setHeader(header.getName(), header.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new RestValidator(resResponse);
	}

	public RestValidator post(String path, String xmlContent, String contentType) {
		return post(path, null, xmlContent, contentType);
	}

	
	public RestValidator post(String path, HashMap<String, String> headers, String xmlContent, String contentType) {
		HttpPost post = new HttpPost(url + path);
		RestResponse resResponse = new RestResponse();
		StringBuffer responseString = new StringBuffer();
		try {
			if (headers != null)
				post.setEntity(getEntities(headers));

			StringEntity input = new StringEntity(xmlContent);
			input.setContentType(contentType);
			post.setEntity(input);

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			resResponse.setResponseBody(responseString.toString());
			resResponse.setResponseCode(response.getStatusLine().getStatusCode());
			resResponse.setResponseMessage(response.getStatusLine().getReasonPhrase());
			Header[] rheaders = response.getAllHeaders();
			for (Header header : rheaders) {
				resResponse.setHeader(header.getName(), header.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new RestValidator(resResponse);
	}

	public RestValidator delete(String path) {
		return delete(path, null);
	}

	
	public RestValidator delete(String path, HashMap<String, String> headers) {
		HttpDelete delete = new HttpDelete(url + path);
		RestResponse resResponse = new RestResponse();
		StringBuffer responseString = new StringBuffer();
		try {
			if (headers != null) {
				Set<String> keys = headers.keySet();
				for (String key : keys) {
					delete.addHeader(key, headers.get(key));
				}
			}
			HttpResponse response = client.execute(delete);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			resResponse.setResponseBody(responseString.toString());
			resResponse.setResponseCode(response.getStatusLine().getStatusCode());
			resResponse.setResponseMessage(response.getStatusLine().getReasonPhrase());
			Header[] rheaders = response.getAllHeaders();
			for (Header header : rheaders) {
				resResponse.setHeader(header.getName(), header.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RestValidator(resResponse);
	}
	
	public RestValidator put(String path, String xmlContent, String contentType) {
		return put(path,null,xmlContent,contentType);
	}

	
	public RestValidator put(String path, HashMap<String, String> headers, String xmlContent, String contentType) {
		HttpPut post = new HttpPut(url + path);
		RestResponse resResponse = new RestResponse();
		StringBuffer responseString = new StringBuffer();
		try {
			if (headers != null)
				post.setEntity(getEntities(headers));

			StringEntity input = new StringEntity(xmlContent);
			input.setContentType(contentType);
			post.setEntity(input);

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			resResponse.setResponseBody(responseString.toString());
			resResponse.setResponseCode(response.getStatusLine().getStatusCode());
			resResponse.setResponseMessage(response.getStatusLine().getReasonPhrase());
			Header[] rheaders = response.getAllHeaders();
			for (Header header : rheaders) {
				resResponse.setHeader(header.getName(), header.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new RestValidator(resResponse);
	}
	
	public RestValidator patch(String path, String xmlContent, String contentType) {
		return patch(path,null,xmlContent,contentType);
	}

	
	public RestValidator patch(String path, HashMap<String, String> headers, String xmlContent, String contentType) {
		HttpPatch post = new HttpPatch(url + path);
		RestResponse resResponse = new RestResponse();
		StringBuffer responseString = new StringBuffer();
		try {
			if (headers != null)
				post.setEntity(getEntities(headers));

			StringEntity input = new StringEntity(xmlContent);
			input.setContentType(contentType);
			post.setEntity(input);

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			resResponse.setResponseBody(responseString.toString());
			resResponse.setResponseCode(response.getStatusLine().getStatusCode());
			resResponse.setResponseMessage(response.getStatusLine().getReasonPhrase());
			Header[] rheaders = response.getAllHeaders();
			for (Header header : rheaders) {
				resResponse.setHeader(header.getName(), header.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new RestValidator(resResponse);
	}

	
	private HttpEntity getEntities(HashMap<String, String> inputEntities) {
		List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>(inputEntities.size());
		Set<String> keys = inputEntities.keySet();
		for (String key : keys) {
			nameValuePairs.add(new BasicNameValuePair(key, inputEntities.get(key)));
		}
		try {
			return new UrlEncodedFormEntity(nameValuePairs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}