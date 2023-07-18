package com.lec.ex2_ReaderWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//1. 파일을 연다 > 2. 데이터를 읽는다(read()) > 3. 파일을 닫는다
public class Ex01_FileReader {

	public static void main(String[] args) {

		Reader reader = null;
		try {
			reader = new FileReader("txtFile/intest.txt");

			while (true) {

				int i = reader.read(); // 2byte 단위 출력
				if (i == -1)
					break;
				System.out.print((char) i);

			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) { // FileReader()

			System.out.println(e.getMessage() + "파일 못찾음");
		} catch (IOException e) { // reader.read()

			System.out.println(e.getMessage());
		} finally {

			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) { // reader.close

				System.out.println(e.getMessage());
			}
		}

	}

}
