package Java_GUI01;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

class FlowLayoutMainClass extends Frame{
	
	public FlowLayoutMainClass() { //생성자
		this.setLayout(new FlowLayout()); //this 자기자신을 참조하는 객체, FlowLayoutMainClass를 참조
		//가로 중앙정렬, 상하좌우 5픽셀간격
		//즉, 좌에서 우로 배치, 다시 다음줄 좌에서 우로 배치
		//같은 줄에서는 가운데 정렬
		//실행한 윈도우를 크기를 줄이거나 늘렸을때 자동적용 
		
		//setLayout(null)은 개발자 임의대로 
		this.add(new Button("눌러봐")); //Button 내장 클래스 , 새로운 Button 객체를 만들고, add로 화면에 붙인다. 
		this.add(new Button("골라봐"));
		this.add(new Button("웬열?드립실드치지마"));
		this.add(new Button("뭥미?"));
		this.add(new Button("뭘 눌러?"));
		this.add(new Button("아무거나"));
		
	}

	public static void main(String[] args) {
		//FlowLayoutMainClass.java
		FlowLayoutMainClass flc1=new FlowLayoutMainClass(); //one class방식
		//객체 생성 후 제일먼저 가동 >> 생성자 
		//생성자를 잘 사용하는 것이 중요
		//원래 디폴트생성자는 자동으로 만들어져 있다.
		//디폴드 생성자는 처리할 내용이 없으므로 여기서는  개발자가 직접 만듦
	}

}
