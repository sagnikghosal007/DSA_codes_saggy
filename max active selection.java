
class Solution{
    int maxActiveSectionsAfterTrade(String s) {
    int oneCount = 0, convertedOne = 0, curZeroCount = 0, lastZeroCount = 0;
    for(int i = 0; i < s.length(); ++i){
        if(s.charAt(i) == '0') curZeroCount++;
        else{
            if(curZeroCount != 0) lastZeroCount = curZeroCount;
            curZeroCount = 0;
            oneCount++;
        }
        convertedOne = Math.max(convertedOne, curZeroCount + lastZeroCount);
    }
    if(convertedOne == curZeroCount || convertedOne == lastZeroCount) return oneCount;    // corner case 
    return oneCount + convertedOne;
}
}
