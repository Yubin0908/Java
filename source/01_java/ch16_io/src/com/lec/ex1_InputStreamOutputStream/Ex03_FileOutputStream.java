package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//1. 파일을 연다 > 2. 쓴다 > 3. 파일을 닫는다.
public class Ex03_FileOutputStream {

	public static void main(String[] args) {

		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); // Default(false) : (파일이 없으면 생성, 파일이 있으면 덮어씀)
//			byte[] bs = { 'H', 'e', 'l', 'l', 'o', '\n' };					         // true : append
			String msg = "Hi, Java\n01234567\n안녕\n"; 
			byte[] bs = msg.getBytes(); //String을 byte 배열로 바꾸는 함수
//			for (byte b : bs) {
//
//				os.write(b);
//			}
			os.write(bs);
			System.out.println("파일 출력 완료");

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage() + " 폴더를 못찾음"); // FileOutputStream()
		} catch (IOException e) {

			System.out.println(e.getMessage()); //os.write()
		} finally {

			try {
				if (os != null) os.close();
			} catch (IOException e) {
				
				System.out.println(e.getMessage()); //os.close()
			}

		}

	}

}
