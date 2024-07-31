class Solution {
    int totalBooks;
    int newShelfWidth;
    public int findMinHeight(int bookIndex, int books[][], int curShelfWidth,int curShelfHeight,int dp[][]){
        int maxHeight=Math.max(curShelfHeight,books[bookIndex][1]);
        if(bookIndex==totalBooks-1){
            //same shelf
            if(books[bookIndex][0]<=curShelfWidth) return maxHeight;
            //new shelf
            return curShelfHeight +books[bookIndex][1];
        }
        //if it is already solved , tyhen return 
        if(dp[bookIndex][curShelfWidth]!=0){
            return dp[bookIndex][curShelfWidth];
        }
        //case 1:
        int sameShelf=Integer.MAX_VALUE; //cond
        if(books[bookIndex][0]<=curShelfWidth){
            sameShelf= findMinHeight(bookIndex+1,books,curShelfWidth-books[bookIndex][0],maxHeight,dp);
        }
        int newShelf= curShelfHeight+findMinHeight(bookIndex+1,books,newShelfWidth-books[bookIndex][0],books[bookIndex][1],dp);
        return dp[bookIndex][curShelfWidth]=Math.min(sameShelf,newShelf);
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        totalBooks=books.length;
        newShelfWidth=shelfWidth;
        int dp[][]=new int[totalBooks][newShelfWidth+1];
        return findMinHeight(0,books,shelfWidth,0,dp);
    }
}
