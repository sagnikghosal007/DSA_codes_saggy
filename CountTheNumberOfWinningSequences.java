public static long rec(String s, int r,int lst,int pnt) {
        if (r== s.length()) {
            return pnt>0?1:0;
        }
        int nrml=pnt+s.length();
        if(dp[r][lst][nrml]!=null) return dp[r][lst][nrml];
        char a = s.charAt(r);
        long ways=0;
        if(lst!=0){
            ways=(ways+rec(s,r+1,0,update(pnt,a,'F')))%mod;
        }
        if(lst!=1){
            ways=(ways+rec(s,r+1,1,update(pnt,a,'E')))%mod;
        }
        if(lst!=2){
            ways=(ways+rec(s,r+1,2,update(pnt,a,'W')))%mod;
        }
        dp[r][lst][nrml]=ways;
        return ways;
    }
    public static int update(int pnt,char a,char b){
        if(b=='F'&&a=='E'){
            return pnt+1;
        }else if(b=='E'&&a=='W'){
            return pnt+1;
        }else if(b=='W'&&a=='F'){
            return pnt+1;
        }else if(a==b) return pnt;
        else return pnt-1;
    }      
