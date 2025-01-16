class Solution {
    public int minimizeXor(int num1, int num2) {
        int x=num1;  
        //counting the set bits in a number in Java
        int reqBitCount=Integer.bitCount(num2); 
        int currBitCount=Integer.bitCount(x);
        int bit=0;
        if(currBitCount<reqBitCount){
            while(currBitCount<reqBitCount){
                if(!isSet(x,bit)){
                    x=setBit(x,bit);
                    currBitCount++;
                }
                bit++;
            }
        }
        else if(currBitCount>reqBitCount){
            while(currBitCount>reqBitCount){
                if(isSet(x,bit)){
                    x=unsetBit(x,bit);
                    currBitCount--;
                }
                bit++;
            }
        }

        return x;
    }
    //procedure to check if a bit set or not 
    public boolean isSet(int x, int bit){
        return ((x&(1<<bit))!=0);
    }
    //procedure to set a bit 
    public int setBit(int x, int bit){
        return (x|(1<<bit));
    }
    //precedure to unset a bit 
    public int unsetBit(int x, int bit){
        return (x& ~(1<<bit));
    }
}
