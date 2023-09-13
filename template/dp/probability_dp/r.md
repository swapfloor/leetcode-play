# 概率dp

简单情况，比如只能增加，在`1~n`中随机选取数字。

有两种dp方法。

- `dp[x]`表示x到结束时的概率，初始化`dp[结束]=1`，转移`dp[x]=(dp[x+1]+...+dp[x+n])/n`。
- `dp[x]`表示开始到x时的概率，初始化`dp[开始]=1`，转移`dp[x]=(dp[x-1]+...+dp[x-n])/n`。

做法

- 顺序求，途中计算前缀和或者后缀和，则`dp[x]=(dp[x+1]+...+dp[x+n])/n=>dp[x]=(suf[x+1]-suf[x+n+1])/n`，`dp[x]=(dp[x-1]+...+dp[x-n])/n=>dp[x]=(pre[x-1]-pre[x-n-1])/n`。
- `+-1`技巧，初始化`dp[开始]=1,dp[开始+1]=-1`，然后记录一个sum，`sum=dp[x-1]+...+dp[x-n]`，此时我们令`dp[i+1]+=sum/n,dp[i+n+1]-=sum/n`。dp为差分数组。
- 树状数组，略。

题目链接

- w85/t3 https://leetcode.cn/problems/new-21-game