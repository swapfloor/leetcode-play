class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        vector<double> dp(20002), sum(20002);
        // dp[x]表示从x到比赛停止且不超过n的概率
        // sum[x]表示>=x到比赛停止不超过n的概率和
        for (int i = n; i >= 0; i--) {
            if (i >= k) dp[i] = 1;
            else dp[i] = (sum[i + 1] - sum[i + maxPts + 1]) / maxPts;
            sum[i] = sum[i + 1] + dp[i];
        }
        return dp[0];
    }
};