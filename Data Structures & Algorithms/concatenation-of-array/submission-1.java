class Solution {
    public int[] getConcatenation(int[] nums) {
        ArrayList<Integer> merged = new ArrayList<>();
        for(int n : nums) {
            merged.add(n);
        }
        for(int n : nums) {
            merged.add(n);
        }
         
        return merged.stream().mapToInt(Integer::intValue).toArray();
    }
}