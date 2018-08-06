package com.springboot.provider;

import java.util.Arrays;

import org.apache.http.HttpRequest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.provider.dto.Address;
import com.springboot.provider.dto.Student;
import com.springboot.provider.repo.StudentRepo;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

public class ProviderApplicationTests {
	
	
	private static StudentRepo repo;

	private int PORT = 8979;

	@TestTarget
	public final Target target = new HttpTarget("http", "localhost", PORT);

	@BeforeClass
	public static void start() {
		System.setProperty("pact.provider.version", "94");
		ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class);
		repo = context.getBean(StudentRepo.class);

	}

	@TargetRequestFilter
	public void printTheRequestHeaders(HttpRequest request) {

		Arrays.asList(request.getAllHeaders())
				.forEach(header -> System.out.println(header.getName() + "->" + header.getValue()));
	}
	
	@State(value="scrooge is created")
	public void createDataRequested() {
		
		repo.addData("93", new Student("Scrooge", "Duck", new Address("Metropolis", "Scrooge Tower")));
		
	}

}
