class Solution {
    public int romanToInt(String s) {
        
        int total = 0;
        
        Map<Character,Integer> numerals = new HashMap<>();
        numerals.put('I',1);
        numerals.put('V',5);
        numerals.put('X',10);
        numerals.put('L',50);
        numerals.put('C',100);
        numerals.put('D',500);
        numerals.put('M',1000);
        
        for(int i = 0; i<s.length() - 1; i++){
            
            int now = numerals.get(s.charAt(i));
            int next = numerals.get(s.charAt(i+1));
            if(now>=next){
                total += now;
            }else{
                total -= now;
            }
        }
        
        total += numerals.get(s.charAt(s.length()-1));
        return total;
    }
}