package com.lec.ex3_bufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

// 사용자로부터 파일이름을 입력받음 -> 해당파일이 존재하는지 확인 -> 해당파일을 console에 출력
public class Ex02_filenameConsolePrint {

	public static void main(String[] args) {

		Reader reader = null;
		BufferedReader br = null;

		Scanner sc = new Scanner(System.in);

		System.out.print("읽어올 파일 이름을 입력하세요 : "); // abc.txt => txtFile/abc.txt

		String filename = sc.next();

		File file = new File("txtFile/" + filename);

		if (file.exists()) { // 파일 유효성검사

			try {

				reader = new FileReader(file); // 기본 스트림 생성
				br = new BufferedReader(reader); // 보조 스트림 생성

				while (true) { // 보조스트림을 통해 한줄씩 출력

					String linedata = br.readLine();

					if (linedata == null)
						break;
					System.out.println(linedata);
				}

			} catch (IOException e) { // FileReader(), br.readLine()

				System.out.println(e.getMessage());
			} finally {
				try {
					if (br != null)
						br.close();
					if (reader != null)
						reader.close();

				} catch (IOException e) {

					System.out.println(e.getMessage());

				}

			}

		} else {

			System.out.println("입력하신 파일은 존재하지 않습니다.");

		}
	}

}
