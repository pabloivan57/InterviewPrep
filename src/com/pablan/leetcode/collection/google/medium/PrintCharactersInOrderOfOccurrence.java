package com.pablan.leetcode.collection.google.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PrintCharactersInOrderOfOccurrence {

    /**
     *  Using Binary Tree, print characters and their frequencies in order of occurrence.
     *
     *  Input: "parallel", Output: "pa2rl3e"
     *  Input: "aloha", Output: "a2loh"
     */
    public void print(String str) {
        CharacterTreeNode root = new CharacterTreeNode(str.charAt(0));
        for(int i = 1; i < str.length(); i++) {
            add(root, str.charAt(i));
        }

        print(root);
    }

    private void print(CharacterTreeNode root) {
        Queue<CharacterTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // level order traversal
            for (int i = 0; i < levelSize; i++) {
                CharacterTreeNode current = queue.poll();
                if(current.count < 2) {
                    System.out.print(String.valueOf(current.letter));
                } else {
                    System.out.print(String.valueOf(current.letter) + current.count);
                }
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }

    private void add(CharacterTreeNode root, Character letter) {
        Queue<CharacterTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            // level order traversal
            for(int i = 0; i < levelSize; i++) {
                CharacterTreeNode current = queue.poll();

                if(current.letter.equals(letter)) {
                    current.count++;
                    return;
                }

                if(current.left == null) {
                    current.left = new CharacterTreeNode(letter);
                    current.count++;
                    queue.offer(current.left);
                    return;
                } else if(current.right == null) {
                    current.right = new CharacterTreeNode(letter);
                    current.count++;
                    queue.offer(current.right);
                    return;
                } else {
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
        }
    }


    private class CharacterTreeNode {
        Character letter;
        CharacterTreeNode left;
        CharacterTreeNode right;
        int count;

        CharacterTreeNode(Character letter) {
            this.letter = letter;
        }
    }
}