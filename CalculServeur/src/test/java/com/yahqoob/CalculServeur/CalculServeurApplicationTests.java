package com.yahqoob.CalculServeur;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculServeurApplicationTests {

	@Autowired
	fibService service;


	@Test
	public void fibOk()  {
		BigInteger result = service.fibonacci(10);

		assertEquals(new BigInteger("55"),result);
	}

}
