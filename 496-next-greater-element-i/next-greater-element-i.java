class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Map to store: element -> next greater element
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        // Monotonic decreasing stack
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Process nums2 to find next greater for every element
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Remaining elements have no next greater
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
