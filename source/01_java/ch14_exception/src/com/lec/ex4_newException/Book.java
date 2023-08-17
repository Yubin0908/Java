package com.lec.ex4_newException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new Book("890-��01", "Java", "������");
public class Book implements ILendable {
	private String bookNo;    // û����ȣ
	private String bookTitle; // å�̸�
	private String writer;    // ����
	private String borrower;  // ������
	private Date checkOutDate; // ������(07-08)
	private byte   state; // ���Ⱑ��(0), ������(1)
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null;
//		state = 0;
	}
	@Override
	public void checkOut(String borrower) { // ����
		if(state == STATE_BORROWED) { // �������� �����̸� �޼��� �Ѹ��� �޼ҵ� ��
			System.out.println(bookTitle + " ������ �������Դϴ�");
			return;
		}
		// state�� 0(STATE_NORMAL)�� ���� ����
		this.borrower = borrower;
		this.checkOutDate = new Date(); // �������� ����� ����
		state = STATE_BORROWED; // ������ ���·� ��ȯ
		System.out.println(bookTitle + " ������ ����Ǿ����ϴ�");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		System.out.println("������ : " + borrower + "\t������ : " + sdf.format(checkOutDate));
	}
	@Override
	public void checkIn() throws Exception {//�ݳ�
		if(state == STATE_NORMAL) {//���Ⱑ���� å�̸� �޼��� �Ѹ��� �޼ҵ� ��
			//������ ���� �߻�
			throw new Exception(bookTitle + "������ �ݳ��� �Ϸ�� å�Դϴ�. Ȯ���ϼ��� @@���� �޼���@@");
		}
		//���� ��¥�� �ý������κ��� �����ͼ� ������(checkOutDate)�� ������ ��¥���̸� ��� => 14�� �������� ��ü
		//checkOutDate ~ now������ ��¥ ���		
		Date now = new Date();
		
		long checkOutDateMillis = checkOutDate.getTime(); // 1970. 1 1 ~ ������ ������ �и�����
		long nowMillis = now.getTime(); //1970.1.1 ~ now������ �и�����
		long diff = nowMillis - checkOutDateMillis; //������ ~ now������ �и�����
		
		int day = (int)(diff / (1000 * 60 * 60 * 24));
		
		if(day > 14) { // day�� 14���� ũ�� ��ü
			
			day -= 14; // ��ü��
			System.out.println(day + "�ϸ�ŭ ��ü�Ǿ� " + (day * 100) + "���� ��ü�� �ΰ��մϴ�. ��ü�Ḧ �����̳���[ y / n ] ? >> ");
			Scanner sc = new Scanner(System.in);
			
			if(!sc.next().trim().equalsIgnoreCase("y")) {
				
				System.out.println("��ü�Ḧ �̳��Ͻø� �ݳ�ó���� �ȵ˴ϴ�.");
				return;
			}
		}
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;		// state�� ������(1)�̶� �ݳ�ó��
		System.out.println(bookTitle + " ������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}
//	@Override
//	public void printState() { // "890-��1 Java (��������) ���Ⱑ��"
////		if(state == STATE_BORROWED) {
////			System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"��) - ������");
////		}else if(state==STATE_NORMAL) {
////			System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"��) - ���Ⱑ��");
////		}
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + "��)";
//		msg += state==STATE_BORROWED ? "������(������:" + checkOutDate + ")":"���Ⱑ��";
//		System.out.println(msg);
//	}
	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "��)";
		msg += state==STATE_BORROWED ? "������(������:" + sdf.format(checkOutDate) + ")":"���Ⱑ��";
		return msg;
	}
	// getter
	public String getBookNo() {
		return bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public String getBorrower() {
		return borrower;
	}

	public byte getState() {
		return state;
	}
	//setter : ������ ������ ���� setter
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}












