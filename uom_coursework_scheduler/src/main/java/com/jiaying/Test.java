package com.jiaying;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.*;

import com.jiaying.loader.PythonLoader;

public class Test {
	public static void main(String args[]) {
		String date = "28-Oct-17:52";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-HH:mm");
		try {
			Date date1 = formatter.parse(date);
			System.out.println(date1.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
