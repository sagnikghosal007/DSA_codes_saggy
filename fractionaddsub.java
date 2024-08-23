class Solution {
    public String fractionAddition(String expression) {
       int num=0;
       int deno=1;
       int n=expression.length();
       int i=0;
       while(i<n){
        int currNum=0;
        int currDeno=0;

        boolean isNeg=(expression.charAt(i)=='-');

        if(expression.charAt(i)=='+' ||  expression.charAt(i)=='-'){
            i++;
        }
        //build the current numerator
        while(i<n &&  Character.isDigit(expression.charAt(i))){
            int val=expression.charAt(i)-'0';
            currNum=(currNum*10)+val;
            i++;
        }
        i++;

        if(isNeg==true){
            currNum*=-1;    
        }
         while(i<n &&  Character.isDigit(expression.charAt(i))){
            int val=expression.charAt(i)-'0';
            currDeno=(currDeno*10)+val;
            i++;
         }
         num=num*currDeno + currNum*deno;
         deno=deno*currDeno;

       }
       int gcdVal = gcd(Math.abs(num), deno);
        num /= gcdVal;
        deno /= gcdVal;


       return Integer.toString(num) + "/" + Integer.toString(deno);



    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
} /*String res="";
        String numerator="0";
        String denominator="1";
        for(int i=0;i<n;i++){
            if(expression.charAt(i)=='/'){
                numerator+=expression.charAt(i-1);
                denominator+=expression.charAt(i+1);
            }
        }*/
