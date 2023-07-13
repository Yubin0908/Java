package com.lec.ex4_object;

import java.util.Random;

public class Ex3_CardMain {

	public static void main(String[] args) {
		
//		Card c1 = new Card("♥", 3);
//		Card c2 = new Card("♥", 3);
//		
//		System.out.println(c1);
//		System.out.println(c2);
//		
//		System.out.println("c1과 c2가 같은 주소인가 >> " + (c1 == c2)); 
//		
//		System.out.println("c1과 c2가 같은 카드인가 >> " + c1.equals(c2));	
		
		Card[] cards = { new Card("♥", 3), new Card("♥", 7), new Card("♥", 10),
							     	new Card("♠", 2), new Card("♠", 6), new Card("♠", 1), 
							     	new Card("◆", 4), new Card("◆", 7), new Card("◆", 11), 
							     	new Card("♣", 2), new Card("♣", 6), new Card("♣", 13)
		};
		//임의의 뽑힌 가드와 배열안의 카드를 비교해서 일치하는 카드가 나오면 출력(해당 카드를 출력.), 일치하는 카드가 없으면, 땡 출력.
		Random random = new Random();
		
		String[]	kinds = { "♥" , "♠" , "◆" , "♣"};
		
		int idx = random.nextInt(4); // 0 ~ 3 사이의 정수 난수
		
		Card randomCard = new Card(kinds[idx], random.nextInt(13) + 1);
		
		
		System.out.println("컴퓨터의 선택은 >> " + randomCard);
		
		int i;
		
		for(i = 0; i < cards.length; i++) {
			
			if(randomCard.equals(cards[i])) {
				
				System.out.println("축하합니다. " + i +"번째 카드와 일치합니다. " + cards[i]);
				
				break;
			}
			if(i == cards.length) {
				
				System.out.println("아쉽습니다. 배열에 없는 카드를 선택하셧습니다.");
				
			}		
		}	
	}
}
