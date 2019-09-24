package toyStore;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("필드명"+"\t"+"|장난감이름"+"\t\t"+"|장난감종류"+"\t"+"|대여금액 ");
		System.out.println("===========================================");
		
		//자동차 데이터 입력
		ArrayList<Car> carArr=new ArrayList<Car>();
		inputCar(carArr);
		
		 //로봇 데이터 입력
		 ArrayList<Robot> robotArr=new ArrayList<Robot>();
		 inputRobot(robotArr);
		 
		 //인형 데이터 입력
		 ArrayList<Doll> dollArr=new ArrayList<Doll>(); 
		 inputDoll(dollArr);
		 
		 //게임 데이터 입력
		 ArrayList<VideoGame> gameArr=new ArrayList<VideoGame>(); 
		 inputGame(gameArr);
		 
		 //퍼즐 데이터 입력
		 ArrayList<Puzzle> puzzleArr=new ArrayList<Puzzle>(); 
		 inputPuzzle(puzzleArr);
		 
		 System.out.println("---------------------------------------");
		 
		 //종류별 대여수입
		 int sumCar=0;
		 int imsi1=0;
		 for (int i = 0; i < carArr.size(); i++) {
			 imsi1=carArr.get(i).getpPrice();
			 sumCar=sumCar+imsi1;
		}
		 System.out.println("자동차 대여금 합계 : "+sumCar+"원");
		 
		 //종류별 대여수입
		 int sumRobot=0;
		 int imsi2=0;
		 for (int i = 0; i < robotArr.size(); i++) {
			 imsi2=robotArr.get(i).getpPrice();
			 sumRobot=sumRobot+imsi2;
		}
		 System.out.println("로봇 대여금 합계 : "+sumRobot+"원");
		 
		 //종류별 대여수입
		 int sumDoll=0;
		 int imsi3=0;
		 for (int i = 0; i < dollArr.size(); i++) {
			 imsi3=dollArr.get(i).getpPrice();
			 sumDoll=sumDoll+imsi3;
		}
		 System.out.println("인형 대여금 합계 : "+sumDoll+"원");
		 
		 //종류별 대여수입
		 int sumGame=0;
		 int imsi4=0;
		 for (int i = 0; i < gameArr.size(); i++) {
			 imsi4=gameArr.get(i).getpPrice();
			 sumGame=sumGame+imsi4;
		}
		 System.out.println("게임 대여금 합계 : "+sumGame+"원");
		 
		 //종류별 대여수입
		 int sumPuzzle=0;
		 int imsi5=0;
		 for (int i = 0; i < puzzleArr.size(); i++) {
			 imsi5=puzzleArr.get(i).getpPrice();
			 sumPuzzle=sumPuzzle+imsi5;
		}
		 System.out.println("퍼즐 대여금 합계 : "+sumPuzzle+"원");
		 //총 대여수입
		 
		 System.out.println("---------------------------------------");
		 
		 int sum=sumCar+sumRobot+sumDoll+sumGame+sumPuzzle;
		 System.out.println("총 합계는 : "+sum+"원입니다.");
		 
	}

	private static void inputPuzzle(ArrayList<Puzzle> puzzleArr) {
		puzzleArr.add(new Puzzle("tp01","퍼즐","퍼즐1",5000));
		 puzzleArr.add(new Puzzle("tp02","퍼즐","퍼즐2",5000));
		 puzzleArr.add(new Puzzle("tp03","퍼즐","퍼즐3",5000));
		 for (int i = 0; i < puzzleArr.size(); i++) {
            System.out.println(puzzleArr.get(i));
       }
	}

	private static void inputGame(ArrayList<VideoGame> gameArr) {
		gameArr.add(new VideoGame("tg01","게임","게임1",4000));
		 gameArr.add(new VideoGame("tg02","게임","게임2",4000));
		 gameArr.add(new VideoGame("tg03","게임","게임3",4000));
		 for (int i = 0; i < gameArr.size(); i++) {
            System.out.println(gameArr.get(i));
       }
		 System.out.println("---------------------------------------");
	}

	private static void inputDoll(ArrayList<Doll> dollArr) {
		dollArr.add(new Doll("td01","인형","인형1",3000));
		 dollArr.add(new Doll("td02","인형","인형2",3000));
		 dollArr.add(new Doll("td03","인형","인형3",3000));
		 for (int i = 0; i < dollArr.size(); i++) {
            System.out.println(dollArr.get(i));
       }
		 System.out.println("---------------------------------------");
	}

	private static void inputRobot(ArrayList<Robot> robotArr) {
		 robotArr.add(new Robot("tr01","로봇","로봇1",2000));
		 robotArr.add(new Robot("tr02","로봇","로봇2",2000));
		 robotArr.add(new Robot("tr03","로봇","로봇3",2000));
		 for (int i = 0; i < robotArr.size(); i++) {
             System.out.println(robotArr.get(i));
        }
		 System.out.println("---------------------------------------");
	}
	private static void inputCar(ArrayList<Car> carArr) {
		 carArr.add(new Car("tc01","자동차","벤츠1",1000));
		 carArr.add(new Car("tc02","자동차","벤츠2",1000));
		 carArr.add(new Car("tc03","자동차","벤츠3",1000));
		 for (int i = 0; i < carArr.size(); i++) {
            System.out.println(carArr.get(i));
       }
		 System.out.println("---------------------------------------");
	}

}
