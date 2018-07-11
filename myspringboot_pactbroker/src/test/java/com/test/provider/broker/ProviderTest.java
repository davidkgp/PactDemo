package com.test.provider.broker;

import java.util.Arrays;

import org.apache.http.HttpRequest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.pact.myapi.SpringbootrestApplication;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.TargetRequestFilter;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@PactBroker(host = "pact_broker_host_dns_ip", port = "pact_broker_port", protocol = "pact_broker_protocol_http_https", authentication = @PactBrokerAuth(username = "pact_broker_username", password = "pact_broker_password"))
@Provider("studentservice")
@VerificationReports({ "console", "markdown", "json" })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE

)

public class ProviderTest {

	private int PORT = 8095;

	@TestTarget
	public final Target target = new HttpTarget("http", "localhost", PORT);

	@BeforeClass
	public static void start() {
		//System.setProperty("pact.verifier.publishResults", "true");
		// System.out.println(todoServiceMock);
		SpringApplication.run(SpringbootrestApplication.class);

	}

	@TargetRequestFilter
	public void printTheRequestHeaders(HttpRequest request) {
		Arrays.asList(request.getAllHeaders())
				.forEach(header -> System.out.println(header.getName() + "->" + header.getValue()));
	}

}
