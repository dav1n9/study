import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] answers) {
        
	// 수포자 1, 2, 3이 찍는 방식을 배열에 저장하였다.
	// 수포자 1, 2, 3은 각각 해당 배열안에 있는 값 순서대로 반복하여 문제를 찍는다.
        int[] m1 = {1, 2, 3, 4, 5};
	int[] m2 = {2, 1, 2, 3, 2, 4, 2, 5};
	int[] m3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // m1가 맞힌 문제의 개수
	int count1 = solve(m1, answers);
		
	// m2가 맞힌 문제의 개수
	int count2 = solve(m2, answers);
		
	// m3가 맞힌 문제의 개수
	int count3 = solve(m3, answers);
        
        // count1, 2, 3 중에 최대값 찾기
	int max = Math.max(count1, count2);
	max = Math.max(max, count3);
		
	// 리스트를 만들고, 가장 높은 점수 max와 같은 같은 가진 수포자들 번호를 추가한다.
	List<Integer> list = new ArrayList<>();
	if(max == count1)
		list.add(1);
	if(max == count2)
		list.add(2);
	if(max == count3)
		list.add(3);
        
        return list;
    }
    
	/*
	* 맞힌 문제의 개수를 카운트하여 반환한다.
	*/
	public static int solve(int[] m, int[] answer) {
		int count = 0;
		int n = 0;
		// 문제의 정답이 들어있는 배열 answer의 크기만큼 반복.
		for(int i = 0; i < answer.length; i++,n++) {
			// 문제의 정답과, m이 찍은 정답이 같으면 count 1증가.
			if(answer[i] == m[n]) {
				count++;
			}
			// n이 m의 크기와 같아지면, 0으로 초기화한다.
			if(n == m.length)
				n = 0;
		}
		return count;
	}
}
