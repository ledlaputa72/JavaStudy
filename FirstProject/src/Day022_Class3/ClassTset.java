package Day022_Class3;

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
public class ClassTset {
     public static void main(String[] args) {
           Parent2 p1=new Parent2();
           Child2 c1=new Child2();
           
           Scanner sc=new Scanner(System.in);
           
           int num;
           do {
           System.out.println("��ȣ�� �����ϼ���(1�� �θ�, 2�� �ڳ�)");
           num=sc.nextInt();
           }while(num!=1 && num!=2); //0�� 1�� �����ϰ� �ϴ� ����
           
           switch (num) {
           case 1: // �θ� ����
                p1.car();
                break;
           case 2: // �ڳ� ����
                c1.car();
                break;
           default:
                break;
           }
     } //main end
} // class end
