import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] result = {};
        
        // 큐 생성
        Queue<Integer> q = new LinkedList<>();
        // 며칠 후에 작업이 완료되어 배포가 가능한지 기록한다.
	for(int i = 0; i < progresses.length; i++) {
          	// 나머지가 0이 아닌경우 1을 추가하여 기록(반올림 효과)
		if ((100-progresses[i])%speeds[i] != 0)
			q.offer(((100-progresses[i])/speeds[i])+1);
		else
			q.offer((100-progresses[i])/speeds[i]);
			
	}
        //리스트 생성(출력할 배열의 크기를 알 수 없어서 리스트를 생성하였음)
	List<Integer> answer = new ArrayList<>();
        // 일수를 카운트할 변수 count 생성. 초기값 1.
	int count = 1;
        // 큐에 첫번째 값을 temp에 저장해두고, 삭제.
        // temp의 값과 큐의 새로운 첫번째 값과 비교
        // temp가 작으면 temp값을 큐의 새로운 첫번째 값으로 업데이트하고,
        // 첫번째 값 삭제. 그리고 리스트(answer)에 count값 저장하고,
        // count는 1로 초기화.
        // temp가 크거나, temp와 같으면 
        // 큐의 첫번째 값 삭제하고, count 1증가시킨다.
        // while문이 종료된 후, count값을 리스트에 추가한다.
        int temp = q.poll();
	while(!q.isEmpty()) {
        	if(temp < q.peek()) {
			temp = q.poll();
			answer.add(count);
			count = 1;
		}
		else {
			q.poll();
			count++;
		}
	}
        answer.add(count);
        
        // 리스트에 저장된 값을 배열에 옮긴다.
        result = new int[answer.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
