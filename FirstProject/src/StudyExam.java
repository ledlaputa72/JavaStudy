import java.util.Scanner;
class Parent2{
     public void car() { //car1
           System.out.println("���� �θ�-����̺갡��.");
     }
}
class Child2 extends Parent2{
     public void car() { //car2, car1�� ��ӹ޾� ������ �� car()
           System.out.println("���� �ڳ�-���డ��.");
     }
}
public class StudyExam {
     public static void main(String[] args) {
           Parent2 p1=new Parent2();
           Child2 c1=new Child2();
           
           Scanner sc=new Scanner(System.in);
           
           int num;
           do {
           System.out.println("��ȣ�� �����ϼ���");
           num=sc.nextInt();
           }while(num!=0 && num!=1); //0�� 1�� �����ϰ� �ϴ� ����
           
           switch (num) {
           case 0: // �θ� ����
                p1.car();
                break;
           case 1: // �ڳ� ����
                c1.car();
                break;
           default:
                break;
           }
     } //main end
} // class end
