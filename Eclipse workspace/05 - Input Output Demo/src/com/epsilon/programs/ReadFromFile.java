package com.epsilon.programs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class ReadFromFile {

	static final String filename = "src/com/epsilon/programs/ReadFromKeyboard.java";

	public static void main1(String[] args) {

		try (FileReader file = new FileReader(filename);) {
			int ch;
			int pass = 0;
			while ((ch = file.read()) != -1) {
				System.out.print((char) ch);
				pass++;
			}
			System.out.println("passes = " + pass);
		} catch (Exception e) {
			System.out.println("There was an error ");
			System.out.println(e);
		}
	}

	public static void main2(String[] args) throws Exception {

		try (FileReader file = new FileReader(filename); BufferedReader in = new BufferedReader(file);) {
			String line;
			int pass = 0;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				pass++;
			}
			System.out.println("passes = " + pass);
		}

	}

	public static void main(String[] args) throws Exception {
		
		try(
			FileInputStream file = new FileInputStream(filename);
		) {
			int size = file.available();
			int pass = 0;
			while(size>0) {
				byte[] bytes = new byte[size];
				file.read(bytes);
				String s = new String(bytes);
				System.out.println(s);
				size = file.available();
				pass++;
			}
			System.out.println("passes = " + pass);
		}
		
	}

}











