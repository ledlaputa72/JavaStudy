package lottomain;

import org.springframework.context.support.GenericXmlApplicationContext;

import lottopkg.Lotto1;

public class LottoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ac1 = new GenericXmlApplicationContext("applicationContext2.xml"); 
		
		Lotto1 b1 = (Lotto1) ac1.getBean("lotBean1");
		b1.kajaLotto("로또 너 나와");
		
	}

}
