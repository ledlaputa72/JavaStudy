package homestudy;

import java.util.Scanner;

public class HomeExam01 {

	public static void main(String[] args) {

		/*//���� ���ϱ� 
		 * int[] num= new int[10];
		 * Scanner sc=new Scanner(System.in);
		 * 
		 * int sum=0;
		 * for (int i = 0; i < num.length; i++) {
		 * System.out.println((i+1)+"��° ���ڸ� �Է��ϼ���");
		 * num[i]=sc.nextInt();
		 * sum+=num[i];
		 * System.out.println("sum: "+sum);
		 * }
		 */
		
		//�л� �� �Է� �޾� �׸�ŭ�� �迭�� �����, 
		// ����, ����, ������ ������ �ް� �̸� ����Ѵ�. 
		
		Scanner sc=new Scanner(System.in);
		System.out.print("�ۼ��� �л� ���� �Է��ϼ���. : ");
		
		String[] arr1; // �л� �迭 (�̸����� String) 
		int stNumber=sc.nextInt(); // �л��� �Է� 
		arr1=new String[stNumber]; // �л� �迭�� �Է��� �л� �� ���� 
		
		int[][] arr2=new int[stNumber][6]; // ���� �迭 (������ int), �� ������ �հ�,���,������ ���� 
		
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
				else if(j==3) { //�հ� ���ϱ� 
					arr2[i][j]=arr2[i][j-1]+arr2[i][j-2]+arr2[i][j-3];
//					System.out.println(arr2[i][j]);
				}
				else if(j==4) { //��� ���ϱ� 
					arr2[i][j]=arr2[i][j-1]/3;
//					System.out.println(arr2[i][j]);
				}
				else if(j==5) { //���� �� 
//					System.out.println(arr1[i]+"�� ��ŷ��");
					
				}
				
			}
			
		}
		
		
		// ���ݱ��� �Էµ� ���� ��� 
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