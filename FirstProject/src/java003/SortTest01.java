package java003;

public class SortTest01 {

	public static void main(String[] args) {

		int[] ki= {175, 180, 174, 185, 165, 160, 174, 181, 179, 169};
		
		//원본 데이터 
		for (int i = 0; i < ki.length; i++) {
			System.out.print(ki[i]+"\t");	
		}
		System.out.println();
		
		// 정렬
		for (int i = 0; i < ki.length-1; i++) {
			for (int j = 0; j < ki.length-1-i; j++) {
				if(ki[j]>ki[j+1]) { // 오름차순으로 부호 바꿈
					int tmp=ki[j];
					ki[j]=ki[j+1];
					ki[j+1]=tmp;
				}//if end
			}// for j end
		}// for i end
		System.out.println();
		
		//정렬 데이터 
		for (int i = 0; i < ki.length; i++) {
			System.out.print(ki[i]+"\t");	
		}
		System.out.println();
		
	}// main end

}// class end
