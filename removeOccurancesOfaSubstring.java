class Solution {
    public String removeOccurrences(String s, String part) {
        int n=s.length();
        int k=part.length();
        int index=s.indexOf(part);
        while(index!=-1){
            s=s.substring(0,index)+s.substring(index+k);
            n=s.length();
            index=s.indexOf(part);
        }
        return s;
    }
}

//another approach :
// while(s.contains(part)){
//    s.replaceFirst(part,"")
//}


//approach using stack
// class Solution {
//     public boolean isPatternSame(Stack<Character> charactersStack, String part) {
//         int size = charactersStack.size();
//         int lengthOfPart = part.length();
//         if (size < lengthOfPart) {
//             return false;
//         }
//         for (int i = 0; i < part.length(); i++) {
//             char char1 = charactersStack.get(size - lengthOfPart + i);
//             char char2 = part.charAt(i);
//             if (char1 != char2) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public String removeOccurrences(String s, String part) {
//         Stack<Character> charactersStack = new Stack<>();
//         String res = "";
//         int lengthOfString = s.length();
//         int lengthOfPart = part.length();
//         for (int i = 0; i < lengthOfString; i++) {
//             char tempCharacter = s.charAt(i);
//             if (tempCharacter == part.charAt(lengthOfPart - 1)) {
//                 charactersStack.push(tempCharacter);
//                 if (isPatternSame(charactersStack, part)) {
//                     for (int j = 0; j < lengthOfPart; j++) {
//                         charactersStack.pop();
//                     }
//                 }
//             } else {
//                 charactersStack.push(tempCharacter);
//             }
//         }
//         for (int i = 0; i < charactersStack.size(); i++) {
//             res += charactersStack.get(i);
//         }
//         return res;
//     }
// }
