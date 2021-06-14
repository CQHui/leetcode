package com.qihui.medium.design;

import org.junit.Test;

import java.util.*;

/**
 * @author chenqihui
 * @date 6/14/21
 *
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 *  
 *
 * Example 1:
 *
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 *  
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * At most 2 * 105 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 *
 */
public class RandomizedSet {
    private Map<Integer, Integer> hashSet;
    private List<Integer> list;
    private Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.hashSet = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hashSet.containsKey(val)) {
            return false;
        }
        hashSet.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer removeIndex = hashSet.remove(val);
        if (removeIndex == null || removeIndex >= list.size()) {
            return false;
        }
        if (list.size() == 1) {
            list.remove(0);
            return true;
        }
        Integer lastNode = list.get(list.size() - 1);
        hashSet.put(lastNode, removeIndex);
        list.set(removeIndex, lastNode);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    @Test
    public void test() {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.insert(3);
        set.insert(4);
        set.insert(0);
        set.insert(1);
        set.insert(1);
        set.remove(3);
        set.remove(1);
        set.remove(1);
        set.remove(3);
        set.remove(4);
        set.remove(0);
        set.remove(0);



        set.insert(1);
        System.out.println(set.getRandom());
    }
}
