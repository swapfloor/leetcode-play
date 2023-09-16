// https://leetcode.cn/problems/house-robber
impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        if nums.len() == 1 {
            return nums[0];
        }
        let mut first = nums[0];
        let mut second = nums[0].max(nums[1]);
        for i in 2..nums.len() {
            let temp = second;
            second = second.max(first + nums[i]);
            first = temp;
        }
        second
    }
}