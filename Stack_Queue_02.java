import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 우선순위큐 생성(큰 수 우선으로)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 인쇄목록 추가(내림차순으로 들어가있을 것).
	for(int i = 0; i < priorities.length; i++) {
		pq.offer(priorities[i]);
	}

	while(!pq.isEmpty()){
            // i를 입력으로 주어진 배열 priorities의 길이만큼 증가시키면서
            // pq의 첫번째 값과 같은 값을 가진 priorities[i]를 찾으면
            // (이 경우는 같은 값을 가진 경우임. 위치는 다를 수 있음.)
            // pq의 첫번째 값을 지우고,
            // answer(몇번째로 인쇄되는지 카운트)을 1 증가시킨다.
            // i번째 값과 위치(location)가 같으면 answer을 반환한다.
           for(int i = 0;i<priorities.length;i++){
               if(priorities[i] == pq.peek()){
                   pq.poll();
                   answer++;
                   if(i == location)
                       return answer;
               }
           }
            
       }
       return answer;
   }
}
