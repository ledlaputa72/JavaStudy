package Day022_Class3;

import java.util.Scanner;
class Parent2{
     public void car() { //car1
           System.out.println("나는 부모-드라이브가자.");
     }
}
class Child2 extends Parent2{
     public void car() { //car2, car1을 상속받아 재정의 된 car()
           System.out.println("나는 자녀-여행가자.");
     }
}
public class ClassTset {
     public static void main(String[] args) {
           Parent2 p1=new Parent2();
           Child2 c1=new Child2();
           
           Scanner sc=new Scanner(System.in);
           
           int num;
           do {
           System.out.println("번호를 선택하세요(1번 부모, 2번 자녀)");
           num=sc.nextInt();
           }while(num!=1 && num!=2); //0과 1만 선택하게 하는 조건
           
           switch (num) {
           case 1: // 부모 선택
                p1.car();
                break;
           case 2: // 자녀 선택
                c1.car();
                break;
           default:
                break;
           }
     } //main end
} // class end
