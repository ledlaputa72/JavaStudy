package study01;

public class CardPoker {

	public static void main(String[] args) {

		//카드 생성 1~13(S) 14~26(C) 27~39(D) 40~53(H)
		int[] cards=new int[53];
		
		for (int i = 0; i < cards.length; i++) {
			cards[i]=i+1; // created cards 
			//System.out.print(cards[i]+","); //print created cards 
		}
		
		//shuffle cards 
		for (int i = 0; i < 100; i++) {
			int n =(int)(Math.random()*53);
			int tmp = cards[0];
			cards[0]=cards[n];
			cards[n]=tmp;
		}
		
		//print shuffled cards list 
		for (int i = 0; i < cards.length; i++) {
			//System.out.print(cards[i]+",");
		}

		//player get cards 
		System.out.println("플레이어에게 카드를 4장 줍니다.");
		System.out.println("########################");
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			//int m =(int)(Math.random()*53);
			System.out.println("플레이어에게"+cards[i]+"번 카드가 지급됩습니다.");
		}
		
		
		
	}

}
