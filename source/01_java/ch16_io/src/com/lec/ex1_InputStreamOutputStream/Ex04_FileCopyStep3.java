package com.lec.ex1_InputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//D:\Project\lecNote\01_Java/bts_7.mp4
public class Ex04_FileCopyStep3 {

	public static void main(String[] args) {

		long start = System.currentTimeMillis(); // 1970.1.1 부터 시작시점까지의 밀리세컨
		// file copy 로직
		InputStream is = null;
		OutputStream os = null;
		File file = new File("D:\\Project\\lecNote\\01_Java/bts_7.mp4");

		try {
			is = new FileInputStream(file);
			os = new FileOutputStream("D:\\Project\\lecNote\\01_Java/bts_Copy.mp4");

			int cnt = 0;
			byte[] bs = new byte[(int)file.length()];

			while (true) {

				int readByteCount = is.read(bs); // read
				if (readByteCount == -1)
					break;
				os.write(bs, 0, readByteCount); // write
				cnt++;

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
