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
	/*public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}*/
		
		//����ö �޼ҵ� 
		
		
		public void showInfo() {
			System.out.println(studentName + "���� ���� ���� "+money+"�Դϴ�. ");
		}
		
}
