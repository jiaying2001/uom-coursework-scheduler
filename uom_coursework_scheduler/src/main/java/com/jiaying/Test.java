package com.jiaying;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.*;

import com.jiaying.loader.PythonLoader;

public class Test extends TestFather{
	public Collection doSomething(HashMap map){ 
		System.out.println("子类被执行..."); 
		return map.values(); 
	}
	
	public static void main(String args[]) {
		Test f =new Test(); 
		HashMap map = new HashMap(); 
		f.doSomething(map);
	}
}
