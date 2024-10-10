class BrowserHistory {
    Stack<String> history=new Stack<>();
    Stack<String> future=new Stack<>();

    public BrowserHistory(String homepage) {
        history.push(homepage);
    }
    
    public void visit(String url) {
        while(!future.isEmpty()) future.pop();
        history.push(url);
    }
    
    public String back(int steps) {
        while(history.size()>1 && steps>0){
            future.push(history.peek());
            history.pop();
            steps--;
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        while(!future.isEmpty() && steps>0){
            history.push(future.peek());
            future.pop();
            steps--;
        }
        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
