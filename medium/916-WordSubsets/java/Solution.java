class Solution {

    public Integer max(int a ,int b){
        return a < b ? b : a;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character,Integer> neededLetters = new HashMap<>() ;
        for(String s : words2){
            Map<Character,Integer> neededLettersHere = new HashMap<>();
            for(int i =0; i< s.length();i++){
                neededLettersHere.putIfAbsent(s.charAt(i),0);
                neededLettersHere.put(s.charAt(i),neededLettersHere.get(s.charAt(i))+1);
            }

            for(char c : neededLettersHere.keySet()){
                neededLetters.putIfAbsent(c,0);
                neededLetters.put(c,max(neededLetters.get(c),neededLettersHere.get(c)));
            }
        }

        List<String> result = new ArrayList<>();

        for(String s : words1){
            Map<Character,Integer> reqs = new HashMap<>();
            reqs.putAll(neededLetters);
            for(int i = 0;i<s.length();i++){
                if(reqs.containsKey(s.charAt(i))){
                    int newNeeded = reqs.get(s.charAt(i)) -1;
                    if(newNeeded == 0){
                        reqs.remove(s.charAt(i));
                    }else{
                        reqs.put(s.charAt(i),newNeeded);
                    }
                }
            }
            if(reqs.isEmpty()){
                result.add(s);
            }
        }


        return result;
    }
}