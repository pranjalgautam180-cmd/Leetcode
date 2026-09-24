class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //HashMap banao
        HashMap<Integer , Integer> mpp = new HashMap<>();

        //Array traverse karo
        for(int i=0; i<nums.length; i++){

            int needed = target - nums[i]; //Needed element nikalo

            if(mpp.containsKey(needed)){ // Check karo needed HashMap mein hai?
                return new int[]{mpp.get(needed),i}; // if yes
            }
            mpp.put(nums[i] ,i);   //Check karo needed HashMap mein hai?
        }
        return new int[]{};
    }
}