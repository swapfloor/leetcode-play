impl Solution {
    pub fn split_into_fibonacci(num: String) -> Vec<i32> {
        let mut a = Vec::new();
        fn dfs(a: &mut Vec<i32>, st: usize, x: &Vec<char>) -> bool {
            if st == x.len() {
                return a.len() >= 3;
            }
            let mut c = 0i64;
            for i in st..x.len() {
                if i != st && x[st] == '0' {
                    break
                }
                c = 10i64 * c + (x[i] as i64) - ('0' as i64);
                if c >= i32::MAX as i64 {
                    break 
                }
                if a.len() >= 2 {
                    let b = a[a.len() - 1] as i64 + a[a.len() - 2] as i64;
                    if c < b {
                        continue
                    }
                    if c > b {
                        break 
                    }
                }
                a.push(c as i32);
                if dfs(a, i + 1, x) {
                    return true 
                }
                a.pop();
            }
            false
        }
        dfs(&mut a, 0, &num.chars().collect());
        a
    }
}