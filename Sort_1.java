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
        
        
        // 2���� �迭�� ���̸�ŭ �ݺ��ϴ�.
        for(int i = 0; i < commands.length; i++) {
        	// array�� ���� �� i��°���� j��° ���� �ڸ� ���ڸ� ���� �ӽ� �迭
        	int [] arr = new int[commands[i][1] - commands[i][0] + 1];
        	int n = 0;
        	// commands�� ù��° ����~�ι�° ���ұ��� �ݺ�
        	for(int j = commands[i][0]; j <= commands[i][1]; j++) {
        		arr[n] = array[j-1];	// -1�� �� ������ �ε���-1��° ���� �ڸ��⶧��
        		n++;
        	}
        	// ����
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
	 * ���� ��Ʈ
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
