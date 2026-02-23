import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            // If element already in window
            if (window.contains(nums[right])) {
                return true;
            }

            window.add(nums[right]);

            // Shrink window if size exceeds k
            if (right - left >= k) {
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
