package com.smoothstack.utopia.engine.tests;


import org.junit.Test;
import com.smoothstack.utopia.engine.EmployeeEngine;

public class EmployeeEngineTests {

	EmployeeEngine engine = new EmployeeEngine();
	
	@Test
	public void login() {
		engine.run();
	}
}
