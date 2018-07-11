package com.test.pact.test.provider;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.pact.myapi.consumer.dto.Student;
import com.test.consumer.MyConsumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ProviderTest {
	
private int PORT = 8098;
	
	@Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("mystudentservice", "localhost", PORT, this);
	
	@Pact(consumer = "consumer1",provider="mystudentservice")
    public RequestResponsePact  createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<String, String>();
        return builder
                .uponReceiving("a student request")
                .path("/myapi/student/15")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("{\"firstName\":\"Mickey\",\"lastName\":\"Mouse\"}")
                .toPact();
    }
	
	@Test
	@PactVerification(value="mystudentservice")
	public void testData() {
		
		Student student = MyConsumer.getStudent(PORT, 15);
		Assert.assertTrue(student.getFirstName().equals("Mickey")&& student.getLastName().equals("Mouse"));
		
		
	}

}
