/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Master {
 *   public:
 *     int guess(string word);
 * };
 */
class Solution {
public:
    void findSecretWord(vector<string>& words, Master& master) {
        random_device rd;
        mt19937 g(rd());
        auto ss = words;
        while (1) {
            shuffle(ss.begin(), ss.end(), g);
            auto s = ss.back();
            ss.pop_back();
            auto get = master.guess(s);
            if (get == 6) {
                break;
            }
            vector<string> ne;
            for (auto &w : ss) {
                int c = 0;
                for (int i = 0; i < 6; i++) {
                    if (w[i] == s[i]) c++;
                }
                if (c == get) ne.push_back(w);
            }
            ss = ne;
        }
    }
};
// - 每次随机化后取尾部，然后删去
// - 第二是，因为guess(x) == x与secret相同字符个数
// - 因此每次留下所有里面字符与x相同的字符个数为guess(x)的字符串
// - 这也算是缩小答案了吧。