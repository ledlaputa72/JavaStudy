package java003;

public class SortTest {

	public static void main(String[] args) {

		int[] k= {10,30,24,78,9}; //정렬한 배열 
		
		for (int i = 0; i < 4; i++) { //행 비교를 위해 4번을 비교  
			for (int j = 0; j < 4; j++) { // 열 비교를 위해 4번을 비교 
				if(k[j]<k[j+1]) { //앞에가 크거나 작으면 안바꾸나, 뒤가 크면 자리를 바꾼다. 
					int tmp=k[j]; //swap하기 위해 변수 tmp 생성
					k[j]=k[j+1];
					k[j+1]=tmp;
				}// if end
			}// for j end, if 비교를 4번(열)
		}//for i end, if 비교를 4*4번(행)
		
		//정렬된 배열 출력
		for (int i = 0; i < k.length; i++) {
			System.out.print(k[i]+"\t");
		}
		System.out.println();
	}// main end

}// class end
