package com.lec.ex4_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

// printWriter : OutputStream을 기본스트림으로 하는 보조스트림
//	Writer를 기본스트림으로 하는 보조스트림
// printWriter 혼자 기본스트림처럼 사용.
public class Ex01 {

	public static void main(String[] args) {
		
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		
//		try { // PrintWriter : OutputStream 보조
//			os = new FileOutputStream("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(os);
			
//		try { // PrintWriter : Writer 보조
//			writer = new FileWriter("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(writer);
		
		try { //PrintWriter : 기본스트림 사용
			printWriter = new PrintWriter("txtFile/outTest.txt"); //append 불가능
			
			// console PrintWriter 공통
			System.out.println("안녕하세요.\n 반갑습니다.");
			printWriter.println("안녕하세요.\n 반갑습니다.");
			System.out.print("print는 자동개행이 안되요. 그래서 개행추가 필요\n");
			printWriter.print("print는 자동개행이 안되요. 그래서 개행추가 필요\n");
			System.out.printf("%s %3d %3d %5.1f\n", "홍길동", 100, 100, 100.0);
			printWriter.printf("%s %3d %3d %5.1f\n", "홍길동", 100, 100, 100.0);
			System.out.printf("%s %3d %3d %5.1f\n", "신길동", 90, 90, 95.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "신길동", 90, 90, 95.5);
			System.out.printf("%s %3d %3d %5.1f\n", "신길순", 85, 85, 85.1);
			printWriter.printf("%s %3d %3d %5.1f\n", "신길순", 85, 85, 85.1);
			
		} catch (IOException e) { // FileOutputStream(), FileWriter()

			System.out.println(e.getMessage());
		} finally {
			try {
				if(printWriter != null) 
					printWriter.close();
//				if(os != null) 
//					os.close();
				if(writer != null) 
					writer.close();
				
			} catch(IOException e) {
				
				System.out.println(e.getMessage());
			}
			
			
		}
		
	}
}
