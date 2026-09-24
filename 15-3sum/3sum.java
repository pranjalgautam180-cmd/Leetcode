// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {

//         Set<List<Integer>> result = new HashSet<>();

//         for (int i = 0; i < nums.length - 1; i++) {

//             HashSet<Integer> set = new HashSet<>();

//             for (int j = i + 1; j < nums.length; j++) {

//                 int needed = -(nums[i] + nums[j]);

//                 if (set.contains(needed)) {

//                     List<Integer> triplet = Arrays.asList(
//                         nums[i],
//                         nums[j],
//                         needed
//                     );

//                     Collections.sort(triplet);
//                     result.add(triplet);
//                 }

//                 set.add(nums[j]);
//             }
//         }

//         return new ArrayList<>(result);
//     }
// }

// optimal

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){

            if(i > 0 && nums[i] == nums[i-1]) continue; // skip duplicate first elememt

            int left = i+1;
            int right = nums.length -1;

            while(left < right){
                
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    list.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    // skip duplicate
                    while(left < right && nums[left] == nums[left+1])
                    left++;

                    while(left < right && nums[right] == nums[right-1])
                    right--;

                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return list;
    }
}


