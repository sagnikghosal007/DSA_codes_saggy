class Solution {
    public int[][] sortMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                mp.putIfAbsent(key,new ArrayList<>());
                mp.get(key).add(matrix[i][j]);
            }
        }
        //sorting each diagonal: negative keys (upperb)
        //positive(lower diagonals in descending order)
        for(Map.Entry<Integer,List<Integer>> entry:mp.entrySet()){
            List<Integer> values=entry.getValue();
            if(entry.getKey()<0){
                Collections.sort(values);
            }
            else{
                values.sort(Collections.reverseOrder());
            }
        }

         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                matrix[i][j]=mp.get(key).remove(0);
            }
         }
        return matrix;
    }
}
