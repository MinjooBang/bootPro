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
public class SampleTxServiceTests {
	
	@Setter(onMethod_ = {@Autowired} )
	private SampleTxService service;
	
	@Test
	public void testLog() {
		String str = "Starry/r/n"+"Starry night/r/n"+"point your palette blue and grey /r/n"+"Look out on a summer's day";
		log.info("testLog ::"+str.getBytes().length);
		service.addData(str);
	}
	
	

}//SampleTxServiceTests
