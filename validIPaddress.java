class Solution {
    List<String> ans;
    private boolean helper(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
    public List<String> restoreIpAddresses(String s) {
        int n=s.length();
        List<String> ans =new ArrayList<>();
        if(s.length()>12) return ans;

        for(int i=1;i<4 && i<n;i++){
            for(int j=i+1;j<i+4 && j<n; j++){
                for(int k = j + 1; k < j + 4 && k < n; k++){
                    String seg1=s.substring(0,i),seg2=s.substring(i,j),seg3=s.substring(j,k),seg4=s.substring(k);

                    if(helper(seg1) && helper(seg2) && helper(seg3) && helper(seg4)){
                        ans.add(seg1 + "." + seg2 + "." + seg3 + "." + seg4);
                    }
                }
            }
        }
        return ans;


    }
}

//ACTUAL METHOD 
// class Solution {
//     public List<String> restoreIpAddresses(String s) {
        
// 		List<String> res = new LinkedList<String>();
		
// 		//if (s.length() < 4 || s.length() > 12) return res;
		
// 		backtr(res, new char[s.length()+3], s, 0, 0);
// 		return res;
//     }

	
// 	private void backtr(List<String> res, char[] addr, String s, int indexString, int numDot) {
// 		if (numDot == 3) {
// 			int remain = s.length() - indexString;
			
// 			 if (remain > 3 || remain == 0) return;//////
// 			 char c1 = s.charAt(indexString);
// 			 if (c1 == '0' && remain != 1) return;
// 			 if (remain == 3) {
// 				if (c1 > '2') return;
// 				if (c1 == '2') {
// 					if (s.charAt(indexString+1) > '5') return;
// 					if (s.charAt(indexString+1) == '5' && s.charAt(indexString+2) > '5') return;
// 				}
// 			 }
			
// 			/// controlla che le ultime sono giuste
// 			for (int i = indexString; i < s.length(); i++) {
// 				addr[i+3] = s.charAt(i);
// 			}
// 			res.add(new String(addr));
// 			return;
// 		}
		
		
		
// 		//if ((s.length() - indexString) / (numDot+1) > 2)
		
// 		//int reamin = (s.length() - indexString) / (4-numDot);
		
// 		//if ((s.length() - indexString + 1) > (4-numDot) * 3) return;//////
// 		//if ((s.length() - indexString + 1) > (numDot*3) + 3) return;//////
		
		
		
// 		if (s.length() == indexString) return;////////
// 		char c1 = s.charAt(indexString);
// 		addr[indexString+numDot] = c1;
// 		if ((s.length() - indexString + 1) <= (4-numDot) * 3) {
// 			addr[indexString+numDot+1] = '.';
// 			backtr(res, addr, s, indexString+1, numDot+1);
// 		}
// 		if (c1 == '0') return;
		
// 		////////////////
			
// 		indexString++;
// 		if (s.length() == indexString) return;////////
// 		char c2 = s.charAt(indexString);
// 		addr[indexString+numDot] = c2;
// 		if ((s.length() - indexString + 1) <= (4-numDot) * 3) {
// 			addr[indexString+numDot+1] = '.';
// 			backtr(res, addr, s, indexString+1, numDot+1);
// 		}
		
// 		////////////////
		
// 		indexString++;
// 		if (s.length() == indexString) return;////////
// 		char c3 = s.charAt(indexString);
// 		if (c1 > '2') return;
// 		if (c1 == '2') {
// 			if (c2 > '5') return;
// 			if (c2 == '5' && c3 > '5') return;
// 		}
// 		addr[indexString+numDot] = c3;
// 		if ((s.length() - indexString + 1) <= (4-numDot) * 3) {
// 			addr[indexString+numDot+1] = '.';
// 			backtr(res, addr, s, indexString+1, numDot+1);
// 		}	
			
		
		
		
		
// 		/*
// 		if (s.length() == indexString) return;////////
// 		char c1 = s.charAt(indexString);
// 		addr[indexString+numDot] = c1;
// 		addr[indexString+numDot+1] = '.';
// 		backtr(res, addr, s, indexString+1, numDot+1);
// 		if (c1 == '0') return;
		
		
// 		indexString++;
// 		if (s.length() == indexString) return;////////
// 		char c2 = s.charAt(indexString);
// 		addr[indexString+numDot] = c2;
// 		addr[indexString+numDot+1] = '.';
// 		backtr(res, addr, s, indexString+1, numDot+1);
		
		
// 		indexString++;
// 		if (s.length() == indexString) return;////////
// 		char c3 = s.charAt(indexString);
// 		if (c1 > '2') return;
// 		if (c1 == '2') {
// 			if (c2 > '5') return;
// 			if (c2 == '5' && c3 > '5') return;
// 		}
// 		addr[indexString+numDot] = c3;
// 		addr[indexString+numDot+1] = '.';
// 		backtr(res, addr, s, indexString+1, numDot+1);*/
// 	}
// }
