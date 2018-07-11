package com.test.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pact.myapi.consumer.dto.Student;

public class MyConsumer {
	
	public static String readAll(InputStream stream) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		try {
			StringBuilder result = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				result.append(inputLine);
			return result.toString();
		} finally {
			in.close();
		}
	}
	
	
	public static Student getStudent(int port, int id) {
		
		Student emp = null;

		try {
			URLConnection url = new URL("http://localhost:" + port + "/myapi/student/" + id).openConnection();
			InputStream stream = url.getInputStream();
			String result = readAll(stream);

			byte[] jsonData = result.getBytes();

			// create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();

			// convert json string to object
			emp = objectMapper.readValue(jsonData, Student.class);

			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	public static void main(String[] args) {
		

	}

}
