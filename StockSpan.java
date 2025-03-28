//this is a implementation based problem 
class StockSpanner {
    Stack<Integer> st;
    Stack<Integer> p;


    public StockSpanner() {
        st=new Stack<>();
        p=new Stack<>();
    }


    
    public int next(int price) {
        if(st.isEmpty()){
            st.push(price);
            p.push(1);
            return 1;
        }
        else if(st.peek()>price){
            st.push(price);
            p.push(1);
            return 1;
        }
        else{
            int temp=1;
            while(!st.isEmpty() && st.peek()<=price){
                st.pop();
                temp+=p.peek();
                p.pop();
            }
            st.push(price);
            p.push(temp);
            return temp;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
