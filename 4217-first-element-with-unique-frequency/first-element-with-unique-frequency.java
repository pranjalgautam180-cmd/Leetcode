class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer>freq = new HashMap<>();

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        HashMap<Integer , Integer>freqCount = new HashMap<>();

        for(int frequency:freq.values()){
            freqCount.put(frequency,freqCount.getOrDefault(frequency,0)+1);
        }
        
        for(int i: nums){
            int frequency = freq.get(i);
            if(freqCount.get(freq.get(i))==1){
                return i;
            }
        }
        return -1;
    }
}