import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] answers) {
        
        int[] m1 = {1, 2, 3, 4, 5};
	int[] m2 = {2, 1, 2, 3, 2, 4, 2, 5};
	int[] m3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // m1의 경우
	int count1 = solve(m1, answers);
		
	// m2의 경우
	int count2 = solve(m2, answers);
		
	// m3의 경우
	int count3 = solve(m3, answers);
        
        // count1, 2, 3 중에 최대값 찾기
	int max = Math.max(count1, count2);
	max = Math.max(max, count3);
		
	List<Integer> list = new ArrayList<>();
	if(max == count1)
		list.add(1);
	if(max == count2)
		list.add(2);
	if(max == count3)
		list.add(3);
        
        return list;
    }
    
    public static int solve(int[] m, int[] answer) {
		int count = 0;
		int n = 0;
		for(int i = 0; i < answer.length; i++,n++) {
			if(answer[i] == m[n]) {
				count++;
			}
			if(n == m.length)
				n = 0;
		}
		return count;
	}
}
