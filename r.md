`git push origin main`

`git push -u origin main -f`

w83 没有发现

w84

- t4 834. 树中距离之和
  - 树形dp典中典，x是y的父亲，则有`dp[y]=dp[x]+n-2*size[y]`。

w85

- t3 837. 新 21 点
  - 概率dp的运用 `f[x]=(f[x+1]+...+f[x+w])/w`，这里可以通过边计算和，或者使用`+1 -1`技巧。
- t4 839. 相似字符串组
  - 并查集的运用

310 https://leetcode.cn/problems/minimum-height-trees
- 这道题也是树的直径模板题，这里可以使用一个名为"剥洋葱"技巧的拓扑排序做。

399 https://leetcode.cn/problems/evaluate-division
- 带权并查集应用