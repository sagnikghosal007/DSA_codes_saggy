//step 1 initialize the array and the queue 
//step2: perform the dfs
//step3 : if Ib reach the end then simply return min_rolls[x]+1

//Now understanding the problem design 
/*
Now let's see how our code works this through,
Initially Queue: [1]
1.) Dequeue x = 1 (min_rolls[1] = 0).
Try i = 1...6 → t = 2...7 :
t = 2 → board[9][1] = 38 (ladder), so y = 38. Set min_rolls[38] = 1, enqueue 38.
t = 3...7 have no ladder / snake, so y = 3, 4, 5, 6, 7
Set min_rolls[3] = 1, 4 = 1, 5 = 1, 6 = 1, 7 = 1 and enqueue 3, 4, 5, 6, 7
Queue: [38, 3, 4, 5, 6, 7]
Dequeue x = 38 (min_rolls[38] = 1).
i = 1...6 → t = 39...44 :
All t = 39...44 map to board cells with –1 (no snake / ladder), so y = 39...44.
Set min_rolls[39..44] = 2 and enqueue 39, 40, 41, 42, 43, 44.
Queue: [3, 4, 5, 6, 7, 39, 40, 41, 42, 43, 44]
Dequeue x = 3 (min_rolls[3] = 1).
i = 1...6 → t = 4...9 :
t = 4...7 already have min_rolls=1, skip.
t = 8 → board[9][7] = 31 (ladder), but min_rolls[31] was set earlier, so skip.
t = 9 → no ladder, so y = 9. Set min_rolls[9] = 2, enqueue 9.
Queue: [4, 5, 6, 7, 39, 40, 41, 42, 43, 44, 9]
Dequeue x = 4 (min_rolls[4] = 1).
i = 1...6 → t = 5...10 :
t = 5...9 already have min_rolls = 1 or 2, skip.
t = 10 → y = 10. Set min_rolls[10] = 2, enqueue 10.
Queue: [5, 6, 7, 39, 40, 41, 42, 43, 44, 9, 10]
Dequeue x = 5, 6, 7 in turn (each has min_rolls = 1). Each gives us exactly one new square:
From x = 5 : t = 11 → y = 11, set min_rolls[11] = 2, enqueue 11.
From x = 6 : t = 12 → y = 12, set min_rolls[12] = 2, enqueue 12.
From x = 7: t = 13 → y = 13, set min_rolls[13] = 2, enqueue 13.
Queue after processing 5, 6, 7: [39, 40, 41, 42, 43, 44, 9, 10, 11, 12, 13]
At this point we’ve discovered all squares reachable in 2 rolls:
{39, 40, 41, 42, 43, 44, 9, 10, 11, 12, 13} each has min_rolls = 2.
Continue BFS in the same way. Each time you dequeue x (with min_rolls[x] = R), we try t = x + 1…x + 6, map t to (row, col), check board[row][col] for a snake / ladder → final y. If y unvisited, set min_rolls[y] = R + 1 and enqueue y.
Eventually, at some x with min_rolls[x] = 6, we will find a die roll i so that t = x + i = 100 (and board cell is –1), so y = 100. At that moment the code returns min_rolls[x] + 1 = 7.
So Final Answer for this board is 7.
*/
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n =board.length;
        //initializing distances and queues
        int[] min_rolls=new int[n*n+1];
        Arrays.fill(min_rolls,-1);
        Queue<Integer> q=new LinkedList<>();
        min_rolls[1]=0;
        q.offer(1);
        //perform the bfs
        while(!q.isEmpty()){
            int x=q.poll();
            for(int i=1;i<=6 && x+i<=n*n;i++){
                int t=x+i;
                int row=(t-1)/n;
                int col=(t-1)%n;
                int v=board[n-1-row][(row%2==1)?(n-1-col):col];
                int y=(v>0? v:t);
                //when my y reached to the end i.e 100 or n*n
                if(y==n*n) return min_rolls[x]+1;
                if(min_rolls[y]==-1){
                    min_rolls[y] = min_rolls[x] + 1;
                    q.offer(y);
                }
            }
        }
        return -1;
    }
}
