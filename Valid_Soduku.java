class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=0;j<9;j++){
                if(hs.contains(board[i][j]+'0')){
                    return false;
                }
                if(board[i][j]!='.'){
                    hs.add(board[i][j]+'0');
                }
            }
        }
        for(int i=0;i<9;i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=0;j<9;j++){
                if(hs.contains(board[j][i]+'0')){
                    return false;
                }
                if(board[j][i]!='.'){
                    hs.add(board[j][i]+'0');
                }
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                HashSet<Integer> hs = new HashSet<>();
                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        if(hs.contains(board[x][y]+'0')){
                            return false;
                        }
                        if(board[x][y]!='.'){            
                            hs.add(board[x][y]+'0');
                        }
                    }
                }
            }
        }
        return true;
    }
}
