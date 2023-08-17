package com.lec.ex2_ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_FileWriter {

	public static void main(String[] args) {
		
		Writer writer = null;
		
		try {
			writer = new FileWriter("txtFile/outwriter.txt"); 
			
			String msg = "안녕! Hi\n장마철 건강조심 하세요.\n";
			writer.write(msg);
			msg = "다음주까지 비온데요. 모두 모두 뽀송뽀송\n";
			writer.write(msg);
			System.out.println("파일 출력 완료");
		
		} catch (IOException e) { //FileWriter
			 
			System.out.println(e.getMessage());
		} finally {
			try {
				
				if(writer != null)
					writer.close();
				
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
				
			}
		}
		
		
	}
	
}
