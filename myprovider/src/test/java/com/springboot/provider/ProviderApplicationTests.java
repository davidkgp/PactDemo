package com.springboot.provider;

import java.util.Arrays;

import org.apache.http.HttpRequest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.TargetRequestFilter;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;

@RunWith(SpringRestPactRunner.class)
@PactFolder("../acceptedPacts")
@Provider("mystudentservice" )
@VerificationReports({ "console", "markdown", "json" })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE

)

public class ProviderApplicationTests {

	private int PORT = 8979;

	@TestTarget
	public final Target target = new HttpTarget("http", "localhost", PORT);

	@BeforeClass
	public static void start() {
		System.setProperty("pact.provider.version", "94");
		SpringApplication.run(ProviderApplication.class);

	}

	@TargetRequestFilter
	public void printTheRequestHeaders(HttpRequest request) {

		Arrays.asList(request.getAllHeaders())
				.forEach(header -> System.out.println(header.getName() + "->" + header.getValue()));
	}

}
