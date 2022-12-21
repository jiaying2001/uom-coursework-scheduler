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
	
	public static void main(String args[]) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
			try {
				Date test = formatter.parse("18:00");
				System.out.println(test.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
