题目链接

- w84/t4 https://leetcode.cn/problems/sum-of-distances-in-tree/ 
  - 树形dp典中典，x是y的父亲，则有`dp[y]=dp[x]+n-2*size[y]`。
- 310 https://leetcode.cn/problems/minimum-height-trees
  - 这道题也是树的直径模板题，这里可以使用一个名为"剥洋葱"技巧的拓扑排序做。