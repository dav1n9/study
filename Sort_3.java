package prog;

public class Sort_3 {

	public static void main(String[] args) {

		int[] numbers = {3, 0, 6, 1, 5};
		System.out.println(solution(numbers));

	}
	public static int solution(int[] numbers) {

		int answer = 0;
		// �����ڰ� ��ǥ�� ���� ��
		int n = numbers.length;

		// �ε��� 0: 1ȸ�̻� �̿�� ��
		// �ε��� 1: 2ȸ�̻� �̿�� ��
		// ...
		// �ε��� n-1: nȸ�̻� �̿�� �� 
		int[] arr1 = new int[n];

		// ... n-1: nȸ ���� �̿�� ��
		int[] arr2 = new int[n];

		int num = 0;
		// �� ȸ �̻�����
		for(int i = 1; i <= n; i++) {
			// �迭[j]�� i�� �̻� �ο�Ǿ��°�.
			for(int j = 0; j < n; j++) {
				if(numbers[j] >= i) {
					num++;
				}
			}
			arr1[i-1] = num;	
			num=0;
		}

		int num2 = 0;
		// �� ȸ �̻�����
		for(int i = 1; i <= n; i++) {
			// �迭[j]�� i�� ���� �ο�Ǿ��°�.
			for(int j = 0; j < n; j++) {
				if(numbers[j] <= i) {
					num2++;
				}
			}
			arr2[i-1] = num2;	
			num2=0;
		}

		for(int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();


		for(int i = 0; i < n; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();


		for(int i = 0; i < n; i++) {

			if(arr1[i] >= (i+1)) {
				if(arr2[i] <= (i+1)) {
					answer = i+1;
				}
			}
		}

		return answer;
	}

}
