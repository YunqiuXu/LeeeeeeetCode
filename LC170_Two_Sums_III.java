/** Yunqiu Xu*/
public class TwoSum {

    /** Initialize your data structure here. */
    private Map<Integer, Integer> map; //<number, count>
    private List<Integer> list; // add all numbers(each once)
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        }
        else{
            map.put(number, 1);
            list.add(number);
        }
    }

    public boolean find(int value) {
        for (int curr : list) {
            int rest = value - curr;
            //两种情况: i == j且哈希表中至少两个这个数字, 或者i != j且这两个数字都在哈希表中
            if ((curr == rest && map.get(curr) > 1) || (curr != rest && map.containsKey(rest))) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
