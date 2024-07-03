import java.util.*;

class Solution {

    @SuppressWarnings("unchecked")
    public String arrangeWords(String text) {

        char[] letters = text.toCharArray();
        letters[0] = Character.toLowerCase(letters[0]);
        List<String>[] words = new ArrayList[text.length()];
        for (int i = 0; i < words.length; i++) {
            words[i] = new ArrayList<String>();
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != ' ') {
                sb.append(letters[i]);
            } else {
                String word = sb.toString();
                sb.setLength(0);
                words[word.length()].add(word);
            }
        }
        String tempWord = sb.toString();
        words[tempWord.length()].add(tempWord);

        sb.setLength(0);
        for (int i = 0; i < words.length; i++) {
            for (String word : words[i]) {
                sb.append(word).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        return sb.toString();
    }
}