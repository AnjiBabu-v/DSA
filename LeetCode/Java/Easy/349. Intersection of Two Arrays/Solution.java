class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != nums1[i])
                    res.add(nums1[i]);           // skip duplicates
                i++; j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}