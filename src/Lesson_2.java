import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lesson_2 {
    public static int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {
                    max = dfs(i, j, grid);
                    if (max > count) {
                        count = max;
                    }
                }
            }
        }
        return count;
    }

    private static int dfs(int i, int j, int[][] grid) {
        int a = -1;
        int cnt = 0;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            a = 0;
        }
        if (a == -1) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0;
                cnt = 1 + dfs(i - 1, j, grid)
                        + dfs(i + 1, j, grid)
                        + dfs(i, j - 1, grid)
                        + dfs(i, j + 1, grid);
            }
        }
        return cnt;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int main_color = image[sr][sc];
        if (main_color == color) return image;
        return painting(image, sr, sc, color, main_color);
    }

    private static int[][] painting(int[][] image, int sr, int sc, int new_color, int main_color) {
        int a = -1;
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != main_color) {
            a = 0;
        }
        if (a == -1) {
            if (image[sr][sc] == main_color) {
                image[sr][sc] = new_color;
                painting(image, sr - 1, sc, new_color, main_color);
                painting(image, sr + 1, sc, new_color, main_color);
                painting(image, sr, sc - 1, new_color, main_color);
                painting(image, sr, sc + 1, new_color, main_color);
            }
        }
        return image;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return check_dfs(root.left, root.right);
    }

    private static boolean check_dfs(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        return leftTree.val == rightTree.val && check_dfs(leftTree.left, rightTree.right) && check_dfs(leftTree.right, rightTree.left);
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,1,1},{1,1,0},{1,0,1}}; //{{0,0,0},{0,0,0}}; //
//        int[][] new_grid = floodFill(grid, 1,1, 2);//floodFill(grid, 0,0, 0);//
//        for (int i = 0; i < new_grid.length; i++) {
//            System.out.println(Arrays.toString(new_grid[i]));
//        }
        //int[][] grid =
////                        {1,1,0,0,0}
////                        ,{1,1,0,0,0}
////                        ,{0,0,0,1,1}
////                        ,{0,0,0,1,1}
////                        {0,0,0,0,0,0,0,0,0,0,0,0,0}
//                        {0,0,1,0,0,0,0,1,0,0,0,0,0}
//                        ,{0,0,0,0,0,0,0,1,1,1,0,0,0}
//                        ,{0,1,1,0,1,0,0,0,0,0,0,0,0}
//                        ,{0,1,0,0,1,1,0,0,1,0,1,0,0}
//                        ,{0,1,0,0,1,1,0,0,1,1,1,0,0}
//                        ,{0,0,0,0,0,0,0,0,0,0,1,0,0}
//                        ,{0,0,0,0,0,0,0,1,1,1,0,0,0}
//                        ,{0,0,0,0,0,0,0,1,1,0,0,0,0}
//                        };
//        System.out.print(maxAreaOfIsland(grid));
    }
}