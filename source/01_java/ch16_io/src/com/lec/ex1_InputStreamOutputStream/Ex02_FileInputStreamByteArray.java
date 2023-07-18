package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1. 파일은 연다 > 2. 데이터를 읽는다(read(byte[]) > 3. 파일을 닫는다.
public class Ex02_FileInputStreamByteArray {
	
	public static void main(String[] args) {
		
		InputStream is = null;
		
		try { // 1. 파일을 연다.
			is = new FileInputStream("D:\\Project\\source\\01_java\\ch16_io\\txtFile\\intest.txt");	//상대경로, 절대경로 모두 가능
			byte[] bs = new byte[10]; //byte 객체생성
			
			while(true) {
				
				int readByteCount = is.read(bs); //bs 배열만큼 일고 읽은 byte 갯수를 return. 파일의 끝은 -1
				
				if(readByteCount == -1) 	break;
				
				for(int i = 0; i < readByteCount; i++) {
					
		//			System.out.printf("%3d/", bs[i]);
					System.out.print((char)bs[i]);
				}
		//		System.out.println();
			}
			//2. 파일을 읽는다.
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage() + "파일 못찾음");//FileInputStream()
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage() + "파일 못읽음");//is.read()
		} finally {
			
			try {
				
				if(is != null) is.close();
				
			}catch (IOException e) {
				
				System.out.println(e.getMessage());
			}
			
		}
		
		
	}

}
