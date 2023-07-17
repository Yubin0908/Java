package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1) Stream 생성(파일을 연다) - (2) 데이터를 읽는다(read메소드 사용) - (3) 파일을 닫는다.(close메소드 사용)
public class Ex01_inputStream {

	public static void main(String[] args) {
		
		InputStream is = null;
		
		try {
			is = new FileInputStream("txtFile/intest.txt"); //1. Stream 생성
			//2. 데이터를 읽는다.(파일 끝까지 읽는다)
			while(true) {
				
				int i = is.read(); //1byte 씩 read
				if(i == -1) {
					
					break; //파일이 끝나면 break;
					
				}
				System.out.print((char)i);
			}

			
		} catch (FileNotFoundException e) {
		
			System.out.println("예외 메시지(파일을 못찾음) : " + e.getMessage());
		} catch (IOException e) {
			
			System.out.println("예외 메시지(파일을 못읽음) " + e.getMessage());
		} finally {
			try {
				if(is!=null) is.close(); //3. 파일을 닫는다.
			} catch (IOException e) {
				
			}
			System.out.println("\n = = = DONE = = =");

		}
	}
	
}
