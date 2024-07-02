class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index != -1){
            StringBuilder result = new StringBuilder(word);
            String reversedSubstring = new StringBuilder(word.substring(0,index+1))
                                        .reverse().toString();
            result.replace(0,index+1,reversedSubstring);
            word = result.toString();
        }
        return word;
    }
}