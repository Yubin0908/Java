package com.lec.ex2_ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

//파일이름과 파일내용을 사용자에게 입력받아 해당파일에 입력받은 내용을 파일로 출력(파일출력, 콘솔출력)
public class Ex03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Writer writer = null;
		
		System.out.print("파일의 이름을 입력해주세요 : ");
		String fileName = sc.next(); // abc => txtFile/abc.txt
		sc.nextLine();

		try {
			writer = new FileWriter("txtFile/" + fileName + ".txt");
			while (true) {

				System.out.println("파일에 출력할 내용을 입력해주세요(종료: 'x') : ");
				String msg = sc.nextLine();
				if (msg.equalsIgnoreCase("x"))
					break;

				writer.write(msg + "\n");

				System.out.println(msg);
			}
			System.out.println("txtFile/" + fileName + ".txt 파일로 출력 저장 완료.");
		} catch (IOException e) {

			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();

			} catch (IOException e) {

				System.out.println(e.getMessage());
			}
		}

	}

}
