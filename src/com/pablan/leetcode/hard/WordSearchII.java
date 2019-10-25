package com.pablan.leetcode.hard;

import com.pablan.leetcode.medium.Trie;
import com.pablan.leetcode.medium.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        Trie prefixTree = new Trie();

        for(String word : words) {
            prefixTree.insert(word);
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, visited, new StringBuilder(), i, j, prefixTree, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, boolean[][] visited, StringBuilder prefix, int row, int column, Trie dictionary, List<String> result) {
        int rows = board.length;
        int columns = board[0].length;

        // out of bounds check
        if(row < 0 || column < 0 || row >= rows || column >= columns || visited[row][column] == true) {
            return;
        }

        // visit
        prefix.append(board[row][column]);
        visited[row][column] = true;

        TrieNode node = dictionary.searchPrefix(prefix.toString());
        if(node != null) {
            if(node.isEnd() && !result.contains(prefix.toString())) {
                // Found a word
                result.add(prefix.toString());
            }

            // Generate posibilities
            // Up
            dfs(board, visited, prefix, row - 1, column, dictionary, result);
            // Left
            dfs(board, visited, prefix, row, column - 1, dictionary, result);
            // Right
            dfs(board, visited, prefix, row, column + 1, dictionary, result);
            // Down
            dfs(board, visited, prefix, row + 1, column, dictionary, result);
        }

        // backtrack
        prefix.deleteCharAt(prefix.length() - 1);
    }
}
