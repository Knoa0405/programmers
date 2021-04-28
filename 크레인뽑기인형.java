import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Integer> resultQueue = new ArrayList<Integer>();
        int answer = 0;
        
        for(int i = 0; i < moves.length; i++) {
            int location = moves[i] - 1;
            for(int j = 0; j < board[location].length; j++) {
                if(board[j][location] != 0) {
                    resultQueue.add(board[j][location]);
                    board[j][location] = 0;
                    break;
                }
            }
        }

        while(true) {
            int prevAnswer = answer;
            for(int k = 1; k < resultQueue.size(); k++){
            if(resultQueue.get(k) == resultQueue.get(k-1)){
                resultQueue.remove(k);
                resultQueue.remove(k-1);
                answer++;
                break;
                }
            }        
            if(answer == prevAnswer) {
                break;
            }
        }

        return answer * 2;
    }
}

// 생각은 제대로 했는데 인덱스 길이 생각을 못해서
// 시간이 좀 더 걸림 (생각대로 로직은 맞는데 안풀리면 처음부터 다시 생각해볼 것! 무조건 빠뜨리고 있는게 있다)