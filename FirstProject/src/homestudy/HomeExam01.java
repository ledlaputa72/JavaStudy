package homestudy;

import java.util.Scanner;

public class HomeExam01 {

	public static void main(String[] args) {

		/*//수자 더하기 
		 * int[] num= new int[10];
		 * Scanner sc=new Scanner(System.in);
		 * 
		 * int sum=0;
		 * for (int i = 0; i < num.length; i++) {
		 * System.out.println((i+1)+"번째 숫자를 입력하세요");
		 * num[i]=sc.nextInt();
		 * sum+=num[i];
		 * System.out.println("sum: "+sum);
		 * }
		 */
		
		//학생 수 입력 받아 그만큼의 배열을 만들고, 
		// 국어, 영어, 수학의 점수를 받고 이를 출력한다. 
		
		Scanner sc=new Scanner(System.in);
		System.out.print("작성할 학생 수를 입력하세요. : ");
		
		String[] arr1; // 학생 배열 (이름으로 String) 
		int stNumber=sc.nextInt(); // 학생수 입력 
		arr1=new String[stNumber]; // 학생 배열에 입력한 학생 수 적용 
		
		int[][] arr2=new int[stNumber][6]; // 점수 배열 (점수로 int), 각 점수와 합계,평균,순위를 제공 
		
		String name;
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("input name of #"+(i+1)+" student.");
			name = sc.next();
			arr1[i]=name;
			
			for (int j = 0; j < 6; j++) {
				if (j<3) {
					switch (j) {
					case 0:
						System.out.print("input Kor's score of #"+arr1[i]);
						break;
					case 1:
						System.out.print("input Eng's score of #"+arr1[i]);
						break;
					case 2:
						System.out.print("input Mat's score of #"+arr1[i]);
						break;
					default:
						break;
					}
					arr2[i][j] = sc.nextInt();
				}
				else if(j==3) { //합계 구하기 
					arr2[i][j]=arr2[i][j-1]+arr2[i][j-2]+arr2[i][j-3];
//					System.out.println(arr2[i][j]);
				}
				else if(j==4) { //평균 구하기 
					arr2[i][j]=arr2[i][j-1]/3;
//					System.out.println(arr2[i][j]);
				}
				else if(j==5) { //순위 비교 
//					System.out.println(arr1[i]+"의 랭킹은");
					
				}
				
			}
			
		}
		
		
		// 지금까지 입력된 정보 출력 
		System.out.println("----------------------------------------------------");
		System.out.println("name \t"+"Kor \t"+"Eng \t"+"Mat \t"+"Sum \t"+"Avg \t"+"Rank");
		System.out.println("====================================================");
		for (int i = 0; i < stNumber; i++) {
			System.out.print(arr1[i]+"\t");
			for (int k = 0; k < 6; k++) {
				System.out.print(arr2[i][k]+"\t");
			}
			System.out.println();
			System.out.println("----------------------------------------------------");
		}
		
	} // main end

} //class end