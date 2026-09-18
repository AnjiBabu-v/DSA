class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int count = 0;
        for (List<Integer> pos : map.values()) {
            if (pos.size() == 3) {
                int d1 = pos.get(1) - pos.get(0);
                int d2 = pos.get(2) - pos.get(1);

                if (d1 == d2) {
                    count++;
                }
            }
        }

        return count;
    }
}