package com.lec.ex3_bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//1. 스트림 생성(FileReader -> bufferedReader) > 2. 데이터를 읽는다(bufferedReader를 통해 한줄씩) > 3. 스트림 클로즈(burrferedReader -> FileReader)
public class Ex01 {

	public static void main(String[] args) {

		Reader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader("txtFile/intest.txt"); // 기본스트림 생성
			br = new BufferedReader(reader); // 보조스트림은 기본스트림을 통해 생성

			while (true) { // Data Read (br.readLine())

				String linedata = br.readLine();

				if (linedata == null)
					break;

				System.out.println(linedata);
			}

			System.out.println("파일 입력 끝");

		} catch (IOException e) { // FileReader(), BufferedReader(), br.readLIne()

			System.out.println(e.getMessage());

		} finally {
			try {
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();

			} catch (IOException e) { // close()

				System.out.println(e.getMessage());
			}

		}

	}
}
