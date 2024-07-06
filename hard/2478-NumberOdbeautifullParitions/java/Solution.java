class Solution {

    int mod = 1000_000_007;

    boolean isPrime(char c){
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

    public int beautifulPartitions(String s, int k, int minLength) {
        if(!isPrime(s.charAt(0)) || isPrime(s.charAt(s.length()-1))) return 0;
        int[][] results = new int[k+1][s.length()+1];
        minLength = Math.max(minLength,2);
        results[0][s.length()] = 1;
        List<Integer> posSplit= new ArrayList();
        
        posSplit.add(0);
        for(int i = 1 ; i < s.length();i++){
            if(isPrime(s.charAt(i)) && !isPrime(s.charAt(i-1)))
                posSplit.add(i);
        } 
        posSplit.add(s.length());
        for(int i = 1 ; i <=k; i++){
            for(int start=0; start <posSplit.size()-1;start++){
                int subsum = 0;
                    for(int end = start + 1; end < posSplit.size(); end++){
                        if(posSplit.get(end)-posSplit.get(start) >= minLength){
                            subsum = (subsum + results[i-1][posSplit.get(end)]) % mod;
                        }
                    }
                results[i][posSplit.get(start)] = subsum;
            }
        }
        return results[k][0];
    }

}