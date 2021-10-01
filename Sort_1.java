package prog;

public class Sort_1 {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(solution(array, commands));
		
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        
        // 2차열 배열의 길이만큼 반복하다.
        for(int i = 0; i < commands.length; i++) {
        	// array의 값들 중 i번째부터 j번째 까지 자른 숫자를 넣을 임시 배열
        	int [] arr = new int[commands[i][1] - commands[i][0] + 1];
        	int n = 0;
        	// commands의 첫번째 원소~두번째 원소까지 반복
        	for(int j = commands[i][0]; j <= commands[i][1]; j++) {
        		arr[n] = array[j-1];	// -1을 한 이유는 인덱스-1번째 부터 자르기때문
        		n++;
        	}
        	// 정렬
        	bubble(arr.length, arr);
        	
        	//for(int a = 0; a< arr.length; a++ ) {
        	//	System.out.print(arr[a]);
        	//}
        	System.out.println();
        	answer[index] = arr[commands[i][2]-1];
        	index++;
        	
        }
        return answer;
    }

	/*
	 * 버블 솔트
	 */
	static void bubble(int n, int S[]) {
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < (n-1); j++) {
				if (S[j] > S[j+1]){
					int temp = S[j];
					S[j] = S[j+1];
					S[j+1] = temp;
				}
			}
		}
	}

}
