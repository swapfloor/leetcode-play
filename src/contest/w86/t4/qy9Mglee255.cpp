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
            auto id = g() % ss.size();
            auto get = master.guess(ss[id]);
            if (get == 6) {
                break;
            }
            vector<string> ne;
            for (auto &w : ss) {
                int c = 0;
                for (int i = 0; i < 6; i++) {
                    if (w[i] == ss[id][i]) c++;
                }
                if (c == get) ne.push_back(w);
            }
            ss = ne;
        }
    }
};