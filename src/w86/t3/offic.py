# dfs时间为O(n*32*32)，原因是最多枚举两个int范围的数字，长度时间为32*32，剩下的数字用来验证，因此为32*32*n
class Solution:
    def splitIntoFibonacci(self, x: str) -> List[int]:
        res = list()
        def dfs(st):
            if st == len(x):
                return len(res) >= 3
            c = 0
            for i in range(st, len(x)):
                if i > st and x[st] == '0':
                    break
                c = c * 10 + ord(x[i]) - ord('0')
                if c > 2**31 - 1:
                    break
                if len(res) >= 2:
                    if c < res[-1] + res[-2]:
                        continue
                    elif c > res[-1] + res[-2]:
                        break 
                res.append(c)
                if dfs(i + 1):
                    return True
                res.pop()
            return False
        dfs(0)
        return res