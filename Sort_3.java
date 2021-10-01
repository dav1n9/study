package prog;

public class Sort_3 {

	public static void main(String[] args) {

		int[] numbers = {3, 0, 6, 1, 5};
		System.out.println(solution(numbers));

	}
	public static int solution(int[] numbers) {

		int answer = 0;
		// 과학자가 발표한 논문의 수
		int n = numbers.length;

		// 인덱스 0: 1회이상 이용된 논문
		// 인덱스 1: 2회이상 이용된 논문
		// ...
		// 인덱스 n-1: n회이상 이용된 논문 
		int[] arr1 = new int[n];

		// ... n-1: n회 이하 이용된 논문
		int[] arr2 = new int[n];

		int num = 0;
		// 몇 회 이상인지
		for(int i = 1; i <= n; i++) {
			// 배열[j]가 i번 이상 인용되었는가.
			for(int j = 0; j < n; j++) {
				if(numbers[j] >= i) {
					num++;
				}
			}
			arr1[i-1] = num;	
			num=0;
		}

		int num2 = 0;
		// 몇 회 이상인지
		for(int i = 1; i <= n; i++) {
			// 배열[j]가 i번 이하 인용되었는가.
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
