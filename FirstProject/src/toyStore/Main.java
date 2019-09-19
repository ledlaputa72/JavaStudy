package toyStore;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("�ʵ��"+"\t"+"|�峭���̸�"+"\t\t"+"|�峭������"+"\t"+"|�뿩�ݾ� ");
		System.out.println("===========================================");
		
		//�ڵ��� ������ �Է�
		ArrayList<Car> carArr=new ArrayList<Car>();
		inputCar(carArr);
		
		 //�κ� ������ �Է�
		 ArrayList<Robot> robotArr=new ArrayList<Robot>();
		 inputRobot(robotArr);
		 
		 //���� ������ �Է�
		 ArrayList<Doll> dollArr=new ArrayList<Doll>(); 
		 inputDoll(dollArr);
		 
		 //���� ������ �Է�
		 ArrayList<VideoGame> gameArr=new ArrayList<VideoGame>(); 
		 inputGame(gameArr);
		 
		 //���� ������ �Է�
		 ArrayList<Puzzle> puzzleArr=new ArrayList<Puzzle>(); 
		 inputPuzzle(puzzleArr);
		 
		 System.out.println("---------------------------------------");
		 
		 //������ �뿩����
		 int sumCar=0;
		 int imsi1=0;
		 for (int i = 0; i < carArr.size(); i++) {
			 imsi1=carArr.get(i).getpPrice();
			 sumCar=sumCar+imsi1;
		}
		 System.out.println("�ڵ��� �뿩�� �հ� : "+sumCar+"��");
		 
		 //������ �뿩����
		 int sumRobot=0;
		 int imsi2=0;
		 for (int i = 0; i < robotArr.size(); i++) {
			 imsi2=robotArr.get(i).getpPrice();
			 sumRobot=sumRobot+imsi2;
		}
		 System.out.println("�κ� �뿩�� �հ� : "+sumRobot+"��");
		 
		 //������ �뿩����
		 int sumDoll=0;
		 int imsi3=0;
		 for (int i = 0; i < dollArr.size(); i++) {
			 imsi3=dollArr.get(i).getpPrice();
			 sumDoll=sumDoll+imsi3;
		}
		 System.out.println("���� �뿩�� �հ� : "+sumDoll+"��");
		 
		 //������ �뿩����
		 int sumGame=0;
		 int imsi4=0;
		 for (int i = 0; i < gameArr.size(); i++) {
			 imsi4=gameArr.get(i).getpPrice();
			 sumGame=sumGame+imsi4;
		}
		 System.out.println("���� �뿩�� �հ� : "+sumGame+"��");
		 
		 //������ �뿩����
		 int sumPuzzle=0;
		 int imsi5=0;
		 for (int i = 0; i < puzzleArr.size(); i++) {
			 imsi5=puzzleArr.get(i).getpPrice();
			 sumPuzzle=sumPuzzle+imsi5;
		}
		 System.out.println("���� �뿩�� �հ� : "+sumPuzzle+"��");
		 //�� �뿩����
		 
		 System.out.println("---------------------------------------");
		 
		 int sum=sumCar+sumRobot+sumDoll+sumGame+sumPuzzle;
		 System.out.println("�� �հ�� : "+sum+"���Դϴ�.");
		 
	}

	private static void inputPuzzle(ArrayList<Puzzle> puzzleArr) {
		puzzleArr.add(new Puzzle("tp01","����","����1",5000));
		 puzzleArr.add(new Puzzle("tp02","����","����2",5000));
		 puzzleArr.add(new Puzzle("tp03","����","����3",5000));
		 for (int i = 0; i < puzzleArr.size(); i++) {
            System.out.println(puzzleArr.get(i));
       }
	}

	private static void inputGame(ArrayList<VideoGame> gameArr) {
		gameArr.add(new VideoGame("tg01","����","����1",4000));
		 gameArr.add(new VideoGame("tg02","����","����2",4000));
		 gameArr.add(new VideoGame("tg03","����","����3",4000));
		 for (int i = 0; i < gameArr.size(); i++) {
            System.out.println(gameArr.get(i));
       }
		 System.out.println("---------------------------------------");
	}

	private static void inputDoll(ArrayList<Doll> dollArr) {
		dollArr.add(new Doll("td01","����","����1",3000));
		 dollArr.add(new Doll("td02","����","����2",3000));
		 dollArr.add(new Doll("td03","����","����3",3000));
		 for (int i = 0; i < dollArr.size(); i++) {
            System.out.println(dollArr.get(i));
       }
		 System.out.println("---------------------------------------");
	}

	private static void inputRobot(ArrayList<Robot> robotArr) {
		 robotArr.add(new Robot("tr01","�κ�","�κ�1",2000));
		 robotArr.add(new Robot("tr02","�κ�","�κ�2",2000));
		 robotArr.add(new Robot("tr03","�κ�","�κ�3",2000));
		 for (int i = 0; i < robotArr.size(); i++) {
             System.out.println(robotArr.get(i));
        }
		 System.out.println("---------------------------------------");
	}
	private static void inputCar(ArrayList<Car> carArr) {
		 carArr.add(new Car("tc01","�ڵ���","����1",1000));
		 carArr.add(new Car("tc02","�ڵ���","����2",1000));
		 carArr.add(new Car("tc03","�ڵ���","����3",1000));
		 for (int i = 0; i < carArr.size(); i++) {
            System.out.println(carArr.get(i));
       }
		 System.out.println("---------------------------------------");
	}

}
