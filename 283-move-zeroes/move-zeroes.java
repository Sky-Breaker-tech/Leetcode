class Solution {
    public void moveZeroes(int[] nums) {

        int index = 0; // position for next non-zero

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // fill remaining with zeros
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
