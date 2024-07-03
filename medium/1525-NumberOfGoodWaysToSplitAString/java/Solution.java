class Solution {
    public int numSplits(String s) {
        Map<Character,Integer> left = new HashMap<>();
        Map<Character,Integer> right = new HashMap<>();
        
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(!left.containsKey(c)){
                left.put(c,0);
            }
            left.put(c,left.get(c)+1);
        }

        int total = 0;

        for(int i = s.length()-1; i > 0; i--){
            char c = s.charAt(i);
            if(!right.containsKey(c)){
                right.put(c,0);
            }
            right.put(c,right.get(c) + 1);
            left.put(c,left.get(c) - 1);
            if(left.get(c)==0){
                left.remove(c);
            }

            if(left.size() == right.size()){
                total++;
            }

        }

        return total;
        


    }
}