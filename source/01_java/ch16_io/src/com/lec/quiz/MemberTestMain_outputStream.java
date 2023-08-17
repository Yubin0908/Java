package com.lec.quiz;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {

	public static void main(String[] args) {

		ArrayList<Member> members = new ArrayList<Member>();

		Scanner sc = new Scanner(System.in);

		String input, name, tel, birthStr, address;
		Date dateBirth;

		while (true) {

			System.out.print("회원정보를 입력하시겠습니까( y / n) ?");
			input = sc.nextLine();

			if (input.equalsIgnoreCase("n"))
				break;

			System.out.print("이름을 입력하세요 : ");
			name = sc.nextLine();

			System.out.print("전화번호를 입력하세요 : ");
			tel = sc.nextLine();

			System.out.print("생일을 입력하세요('yyyy-MM-dd') : ");
			birthStr = sc.next();

			// dateBirth = toDate(birthStr);
			dateBirth = toDateTodayIsBirthDayChk(birthStr);

			sc.nextLine();
			System.out.print("주소를 입력하세요 : ");
			address = sc.nextLine();

			members.add(new Member(name, tel, dateBirth, address));

		}
		if (members.size() == 0) {

			System.out.println("가입한 회원이 없어요.");

		}

		// file Write
		OutputStream os = null;

		try {
			os = new FileOutputStream("D:\\Project\\source\\01_java\\ch16_io\\src\\com\\lec\\quiz\\member.txt", true);

			for (Member member : members) {
				System.out.println(member);

				String msg = member.toString();

				byte[] bs = msg.getBytes();

				os.write(bs);
			}
			String msg = "이하 " + "\t\t\t. . ." + members.size() + " 명 가입";
			System.out.println(msg);
			byte[] bs = msg.getBytes();

			os.write(bs);
		} catch (IOException e) {

			System.out.println(e.getMessage());

		} finally {

			try {
				if (os != null)
					os.close();

			} catch (IOException e) {

				System.out.println(e.getMessage());
			}
		}
	}

//	private static Date toDate(String birthStr) { // 매개변수로 들어온 1995-01-01을 Date형으로 변환하여 리턴
//
//		Date result = null;
//
//		StringTokenizer tokenizer = new StringTokenizer(birthStr, "-");
//		if (tokenizer.countTokens() == 3) {
//
//			int year = Integer.parseInt(tokenizer.nextToken());
//			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
//			int day = Integer.parseInt(tokenizer.nextToken());
//
//			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
//		} else {
//
//			System.out.println("생년월일 정보가 올바르지 않아 입력되지 않았습니다.");
//		}
//
//		return result;
//	}

	private static Date toDateTodayIsBirthDayChk(String birthStr) { // 매개변수로 들어온 1995-01-01을 Date형으로 변환하여 오늘이 생일이지 확인후
																	// 리턴

		Date result1 = null;

		StringTokenizer tokenizer1 = new StringTokenizer(birthStr, "-");
		if (tokenizer1.countTokens() == 3) {

			int year = Integer.parseInt(tokenizer1.nextToken());
			int month = Integer.parseInt(tokenizer1.nextToken()) - 1;
			int day = Integer.parseInt(tokenizer1.nextToken());

			result1 = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());

			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			Date now = new Date(new GregorianCalendar().getTimeInMillis());

			String result1Str = sdf.format(result1);
			String nowStr = sdf.format(now);

			if (result1Str.equals(nowStr)) {

				System.out.println("☆ 생일을 진심으로 축하합니다. ☆");

			}
		} else {

			System.out.println("생년월일 정보가 올바르지 않아 입력되지 않았습니다.");
		}
		return result1;

	}
}
