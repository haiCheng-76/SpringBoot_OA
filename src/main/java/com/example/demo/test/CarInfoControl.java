package com.example.demo.test;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarInfoControl {
	private Logger log = Logger.getLogger(CarInfoControl.class);
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testGetAllCarIfo() {
		String obg = this.testRestTemplate.getForObject("/carInfoControl/getAllCarIfo",String.class );
		log.info(obg);
	}

	@Test
	public void testAddCarIfo() {
		String msg = this.testRestTemplate.getForObject("/carInfoControl/addCarIfo", String.class);
		log.info(msg);
	}

	@Test
	public void testGetCarinfoById() {
	}

	@Test
	public void testUpdateCarinfo() {
	}

	@Test
	public void testDeleteCarinfo() {
	}

}
