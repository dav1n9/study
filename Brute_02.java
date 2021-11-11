import java.util.ArrayList;
import java.util.List;

class Solution {
  public int solution(String numbers) {
    
    // 소수의 개수를 카운트 하여 반환할 것.
    int answer = 0;
    
    // numbers값을 가지는 스트링빌더 생성(문자 하나하나를 배열에 넣기 위해)
    StringBuilder str = new StringBuilder(numbers);
    // String타입 배열 arr에 numbers를 문자 단위로 쪼갠 값들이 저장된다.
    String[] arr = new String[str.length()];
      for(int i = 0; i < arr.length; i++) {
        arr[i] = str.substring(i, i+1);
      }
        
    // 리스트 생성(가능한 모든 경우)
    List<String> result = new ArrayList<>();
    // 순열을 이용해 만들수 있는 경우의 수를 result에 저장한다.
    for(int i = 1; i<= arr.length; i++) {
      permutation(arr, new String[i], new boolean[arr.length], 0, i, result);
    }
    
    // result에 저장된 수가 소수인지 판단 한다.
    for(int i = 0; i < result.size(); i++) {
      // result에 저장된 값은 String 타입이기 때문에, int형으로 변환해준다.
      int a = Integer.parseInt(result.get(i));
      // a가 소수이면 answer를 1증가시킨다.
      if(checkPrime(a)) {
        answer++;
      }
    }
    return answer;
  }
    
  /*
  * 순열
  *
  * 참고: https://velog.io/@cgw0519/알고리즘-순열-중복순열-조합-중복조합-총정리
  */
  public static void permutation(String[] arr, String[] out, boolean[] visited, int depth, int r, List<String> result){
    if(depth == r){
      print(out, result);
      return;
     }
    for(int i=0; i<arr.length; i++){
      if(!visited[i]){
        visited[i] = true;
        out[depth] = arr[i];
        permutation(arr, out, visited, depth+1, r, result);
        visited[i] = false;
      }
    }
  }
	
  /*
  * 배열 arr에 저장된 문자들을 합쳐서 하나의 문자열로 만들고,
  * 리스트에 저장한다.
  */
  static void print(String[] arr, List<String> result) {
    StringBuilder str = new StringBuilder();
		
      for (int i = 0; i < arr.length; i++) {
        // 0으로 시작하는 경우는 제외한다.(0으로 시작되는 경우 str에 아무것도 저장되지 않아서 68째 줄 if문의 조건이 만족되지 않을 것.)
        if(arr[0].equals("0"))
          break;
          str.append(arr[i]);
        }
        
        //str값이 이미 result에 저장되어있지 않고, str에 값이 저장되어 있을 때
        if(!result.contains(str.toString()) && str.length() >0)
          result.add(str.toString());
  }
	
	
  /*
  * n이 소수인지, 아닌지를 판단한다.
  * 소수일 경우 true를 반환한다.
  */
  static boolean checkPrime(int n) {
    // 1은 소수가 아니다.
    if( n <= 1 )
      return false;
	  // 2는 소수이다.
    if(n == 2)
      return true;
	  // 짝수는 소수가 아니다.
    if( n%2 == 0) 
      return false;
    // 3부터 sqrt(n)까지의 홀수로 나눴을 때
    for(int i=3; i<= Math.sqrt(n); i += 2) {
      // 나누어 떨어지면 소수가 아니다.
      if( n % i == 0)
        return false;
      }
    // 나머지는 모두 소수.
    return true; 
  }
}
