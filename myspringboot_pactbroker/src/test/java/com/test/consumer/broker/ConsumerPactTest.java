package com.test.consumer.broker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.pact.myapi.consumer.ConsumerSpringBoot;
import com.pact.myapi.dto.Address;
import com.pact.myapi.dto.Student;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ConsumerPactTest {

	private int PORT = 8098;

	@Rule
	public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("studentservice", "localhost", PORT, this);

	@Pact(consumer = "anybody", provider = "studentservice")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		Map<String, String> headers = new HashMap<String, String>();
		return builder.uponReceiving("a student request")
				.path("/myapi/student/15")
				.method("GET")
				.willRespondWith()
				.status(200)
				.body("{\"firstName\":\"Mickey\",\"lastName\":\"Mouse\",\"address\":{\"addressLine1\":\"1026YV\",\"addressLine2\":\"Arjenstraat\"},\"parentDetails\":{\"fatherName\":\"Dave Roger\",\"motherName\":\"Teri Wig\"},\"labParterDetails\":{\"labPartner1\":{\"firstName\":\"Deb\",\"lastName\":\"Laxman\",\"address\":{\"addressLine1\":\"Amta\",\"addressLine2\":\"West Bengal\"}},\"labPartner2\":{\"firstName\":\"Sanan\",\"lastName\":\"Prakash\",\"address\":{\"addressLine1\":\"Hoogly\",\"addressLine2\":\"West Bengal\"}}}}")
				.toPact();
	}

	@Test
	@PactVerification("studentservice")
	public void runTest() throws IOException, InterruptedException {


		Student actual = ConsumerSpringBoot.getStudent(PORT, 15);
		Student expected = new Student("Mickey", "Mouse", new Address("1026YV", "Arjenstraat"));
		Assert.assertEquals(expected, actual);


	}

}
