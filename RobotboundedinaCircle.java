class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0,y=0;
        char d='N';
        for(char i:instructions.toCharArray()){
            if(i=='G'){
                if(d=='N'){y++;}
                else if(d=='E'){x++;}
                else if(d=='S'){
                    y--;
                }
                else{
                    x--;
                }
            }
            else if(i=='L'){
                if(d=='N'){d='W';}
                else if(d=='E') { d='N';}
                else if(d=='W'){ d='S';}
                else d='E';
            }
            else{
                if(d=='N'){d='E';}
                else if(d=='E'){d='S';}
                else if(d=='S'){d='W';}
                else d='N';
            }
        }
        if(x==0 && y==0 || d!='N') return true;
        else return false;
    }
}
