package javaTest01;

public class Student {

		public String studentName;
		public int grade;
		public int money;
		public Student(String studentName, int money) {
			super();
			this.studentName = studentName;
			this.money = money;
		}
		
		//���� �޼ҵ�
	public void takeBus(Bus bus) {
		bus.takeBus(1000);
		this.money -= 1000;
	}
		
		//����ö �޼ҵ� 
	public void takeSubesy(Subway subway) {
		subway.takeSubway(1000);
		this.money -= 1000;
	}	
		
		public void showInfo() {
			System.out.println(studentName + "���� ���� ���� "+money+"�Դϴ�. ");
		}
		
}
