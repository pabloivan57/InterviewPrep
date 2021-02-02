package com.pablan.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Pablo's notes: Two key concepts that you must remember
 *
 * 1.- hash table is just a list of buckets that have a linked list of objects
 *  * Hashtable is no more than an array of linked lists each one of them give to an specific bucket
 *  * To avoid collisions we use chaining... which is using linked lists for a bucket
 *  * When a key is provided... we take the hashCode() from java which gives us an integer
 *  * Then we divide for the module of the number of buckets, the resulting number tells us
 *  * which bucket this will go on
 *  * In that bucket, we search for the value if it exist otherwise we just add a new node in there
 *
 * 2.- To keep the HashMap efficient we keep track of a "load factor". Every time we approach a load
 * factor of 0.7 for example.. we double the hash map. To double the hashmap
 * we simply create a new map with n * 2 buckets and we add each one of the old values in there
 *
 */
public class HashMap {

    List<HashMapNode> buckets;

    int numBuckets;

    int size = 0;

    /** Initialize your data structure here. */
    public HashMap() {
        buckets = new ArrayList<>();
        numBuckets = 5;

        // initialize buckets
        for(int i = 0 ; i < numBuckets; i++) {
            buckets.add(i, null);
        }
        size = 0;
    }

    public int getBucketIndex(Object key) {
        int hashCode = key.hashCode();
        int bucketIndex = hashCode % numBuckets;
        return bucketIndex;
    }

    /** value will always be non-negative. */
    public void put(Object key, Object value) {
        int bucketIndex = getBucketIndex(key);

        HashMapNode head = buckets.get(bucketIndex);
        HashMapNode current = head;
        while(current != null) {
            if(current.key.equals(key)) {
                break;
            }
        }

        if(current != null) {
            current.value = value;
        } else {
            HashMapNode newNode = new HashMapNode(bucketIndex, value);
            newNode.next = head;
            buckets.add(bucketIndex, newNode);
            size++;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public Object get(Object key) {
        int bucketIndex = getBucketIndex(key);

        HashMapNode head = buckets.get(bucketIndex);
        HashMapNode current = head;
        while(current != null) {
            if(current.key.equals(key)) {
                return current.value;
            }
        }

        return null;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(Object key) {
        int bucketIndex = getBucketIndex(key);

        HashMapNode head = buckets.get(bucketIndex);
        HashMapNode prev = null;
        HashMapNode current = head;
        while(current != null) {
            if(current.key.equals(key)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if(prev != null) {
            prev.next = current.next;
            size--;
        } else {
            buckets.add(bucketIndex, current.next);
            size--;
        }
    }

    private class HashMapNode {
        Object key;
        Object value;

        HashMapNode next;

        public HashMapNode(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
