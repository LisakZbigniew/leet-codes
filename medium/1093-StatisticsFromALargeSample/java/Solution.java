class Solution {
    public double[] sampleStats(int[] count) {
        int sum = 0;
        for(int i =0 ; i <count.length;i++) sum += count[i];

        int minimum = -1;
        int maximum = -1;
        double meanSum = 0;
        int mode = -1;
        int modeMax = 0;
        double median = -1.0;
        int medianLeft = (sum+1)/2;
        int mediantemp = -1;

        for(int i = 0 ;i <count.length;i++){
            if(minimum == -1 && count[i]!=0){
                minimum = i;
            }
            if(count[i] != 0){
                maximum = i;
            }
            meanSum+= (long)i * count[i];
            if(modeMax < count[i]){
                modeMax = count[i];
                mode = i;
            }
            if(count[i] != 0 && mediantemp != -1 && median == -1.0){
                median = ((double)i + mediantemp)/2;
            }
            if(median == -1.0 && medianLeft <= count[i]){

                if(sum % 2 == 1 || medianLeft < count[i]){
                    median = i;
                } else {
                    mediantemp = i;
                }


            }else if (medianLeft > count[i]){
                medianLeft -= count[i];
            }
        }
        double[] result = new double[5];
        result[0] = minimum;
        result[1] = maximum;
        result[2] = (meanSum)/(double)sum;
        result[3] = median;
        result[4] = mode;
        return result;
        
    }
}