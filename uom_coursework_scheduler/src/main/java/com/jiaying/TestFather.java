package com.jiaying;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestFather {
	public Collection doSomething(Map map){ 
		System.out.println("父类被执行..."); 
		return map.values(); 
	}
}
