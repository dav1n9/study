import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        map.put(participant[0], 1);
        for(int i = 1; i < participant.length; i++) {
            int num = 1;
            if (map.containsKey(participant[i])) {
                num = map.get(participant[i]);
                num++;
            }
            map.put(participant[i], num);
        }

        // 중복된 키 업데이트 될 것.
        for(int i = 0; i < completion.length; i++) {
            int newValue = map.get(completion[i]);
            map.put(completion[i], --newValue);
        }


        for(int i = 0; i < participant.length; i++) {
            if(map.get(participant[i]) != 0)
                answer = participant[i];
        }

        return answer;
    }
}
