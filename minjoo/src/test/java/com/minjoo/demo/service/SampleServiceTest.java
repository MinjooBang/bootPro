package com.minjoo.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.minjoo.demo.config.RootConfig;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@ContextConfiguration(classes = {RootConfig.class})
public class SampleServiceTest {
	
	@Setter(onMethod_ = {@Autowired} )
	private SampleService service;
	@Test
	public void testClass() {
		
		log.info("testClass : "+service);
		log.info("estClass : "+service.getClass().getName());
		
	}
	@Test
	public void testAdd() throws Exception {
		log.info("testAdd : "+service.doAdd("123", "456"));
		
	}
	
	@Test
	public void testAddError() throws Exception {
		log.info("testAddError :: "+service.doAdd("123", "ABC"));
		
	}
	

}//SampleServiceTest

