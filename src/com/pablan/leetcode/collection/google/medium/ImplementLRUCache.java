package com.pablan.leetcode.collection.google.medium;

import com.pablan.grokking.patterns.fastslow.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 *  Implement the LRUCache class:
 *
 *  LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 *  int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *  void put(int key, int value) Update the value of the key if the key exists. Otherwise,
 *  add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 *  evict the least recently used key.
 */
public class ImplementLRUCache {

    ListNode head;
    ListNode tail;

    Map<Integer, ListNode> map;
    int capacity;

    public ImplementLRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        setMostRecent(node, true);
        return node.value;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size() >= capacity) {
                removeLeastUsed();
            }

            ListNode newNode = new ListNode(value);
            map.put(value, newNode);
            setMostRecent(newNode, false);
        } else {
            ListNode node = map.get(key);
            setMostRecent(node, true);
        }
    }

    private void setMostRecent(ListNode node, boolean exists) {
        if(exists) {
            ListNode prev = node.prev;
            ListNode next = node.next;

            if(prev != null) {
                prev.next = next;
            }

            if(next != null) {
                next.prev = prev;
            }
        }

        node.prev = null;
        if(head != null) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head = node;
        }
    }


    private void removeLeastUsed() {
        // remove least used item
        ListNode removed = tail;
        if(removed.prev != null) {
            tail = removed.prev;
        }

        map.remove(removed.value);
    }
}
