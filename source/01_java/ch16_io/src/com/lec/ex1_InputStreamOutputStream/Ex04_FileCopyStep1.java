package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//D:\Project\lecNote\01_Java/bts_7.mp4
public class Ex04_FileCopyStep1 {

	public static void main(String[] args) {

		long start = System.currentTimeMillis(); // 1970.1.1 부터 시작시점까지의 밀리세컨
		// file copy 로직
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("D:\\Project\\lecNote\\01_Java/bts_7.mp4");
			os = new FileOutputStream("D:\\Project\\lecNote\\01_Java/bts_Copy.mp4");

			int cnt = 0;

			while (true) {

				int i = is.read(); // read
				if (i == -1)
					break;
				os.write(i); // write
				cnt++;
				if (cnt % 1000000 == 0) {

					System.out.println(cnt + "/7,460,545 : " + (int) (cnt / 7460545.0 * 100) + "% 진행");

				}
			}
			System.out.println(cnt + "번 while문 실행하여 복사 성공");
		} catch (IOException e) {

			System.out.println(e.getMessage()); // FileInputStream(), FileOutputStream(), is.read()
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();

			} catch (IOException e) {

				System.out.println(e.getMessage());
			}

		}

		long end = System.currentTimeMillis(); // 1970.1.1 부터 종료시점까지의 밀리세컨

		System.out.println((end - start) / 1000.0 + "초 걸림");

	}

}
