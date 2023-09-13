/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * struct Master;
 * impl Master {
 *     fn guess(word:String)->int;
 * };
 */

 impl Solution {
    pub fn find_secret_word(words: Vec<String>, master: &Master) {
        use rand::random;
        let mut ws = words;
        loop {
            for i in (0..ws.len()).rev() {
                ws.swap(i, random::<usize>() % (i + 1))
            }
            let id = random::<usize>() % ws.len();
            let get = master.guess(ws[id].clone());
            if get == 6 {
                break;
            }
            let mut ne = Vec::new();
            for w in ws.clone() {
                let c: i32 = (0..6).map(|x| {
                    if w.chars().nth(x).unwrap() == ws[id].chars().nth(x).unwrap() {
                        1
                    } else {
                        0
                    }
                }).sum();
                if c == get {
                    ne.push(w);
                }
            }
            // println!("{:?}", ne);
            ws = ne.clone()
        }
    }
}