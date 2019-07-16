package com.jack.leetcode.char2d;

/**
 * @author xijin.zeng created on 2019/7/12
 * 每个字符只能匹配一次，只能垂直或者相邻的搜索（使用回溯递归法）
 * For example,
 * Given board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch2D {

    public static void dump(char[][] data) {
        if (data == null || data.length == 0) return;
        int rows = data.length;
        int cols = data[0].length;

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 复杂度，最差情况：O(m*n*word.length)
     * 这个实现是错的，没有考虑只能垂直或水平搜索匹配-DFS
     * @param data
     * @param word
     * @return
     */
    private static boolean search(char[][] data, String word) {
        if (data == null || data.length == 0 || word == null || word.length() == 0) return false;

        int rows = data.length;
        int cols = data[0].length;

        boolean[][] flag = new boolean[rows][cols];
        int matchCount = 0;

        for (int k=0; k < word.length(); k++) {
            rematch:
            for (int i=0; i < rows; i++) {
                for (int j=0; j < cols; j++) {
                    // found match
                    if (word.charAt(k) == data[i][j] && !flag[i][j]) {
                        matchCount++;
                        flag[i][j] = true;
                        // all match, just return
                        if (matchCount == word.length()) {
                            return true;
                        }

                        break rematch;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] data = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        dump(data);

        System.out.println(search(data, "ABCCED"));
        System.out.println(search(data, "SEE"));
        System.out.println(search(data, "ABCB"));

    }
}
