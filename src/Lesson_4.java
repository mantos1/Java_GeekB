import java.util.ArrayDeque;
import java.util.List;

public class Lesson_4 {
    public static void main(String[] args) {
//        String path = "/home//foo/../app/";
//        System.out.println(simplifyPath(path));
//        int[][] root = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
//        updateMatrix(root); //System.out.println(updateMatrix(root));
//        int[][] grid = {
//                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}
//                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}
//                , {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
//                , {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}
//                , {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}
//                , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}
//                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}
//                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//        };
//        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = 0;
                    ArrayDeque<int[]> stack = new ArrayDeque<>();
                    stack.push(new int[]{i, j});
                    grid[i][j] = 0;
                    while (!stack.isEmpty()) {
                        int[] point = stack.pop();
                        int rowPoint = point[0];
                        int colPoint = point[1];
                        for (int ii = 0; ii < direction.length; ii++) {
                            int newRow = rowPoint + direction[ii][0];
                            int newCol = colPoint + direction[ii][1];
                            if (newRow >= 0 && newRow < grid.length && newCol >= 0 &&
                                    newCol < grid[0].length && grid[newRow][newCol] == 1) {
                                stack.push(new int[]{newRow, newCol});
                                grid[newRow][newCol] = 0;
                            }
                        }
                        area++;
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static String simplifyPath(String path) {
        String[] words = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<>();
        List<String> exceptions = List.of(".", " ", "", "..");
        for (String word : words) {
            if (!exceptions.contains(word)) {
                stack.push(word);
            }
            if (word.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        String new_path = "";
        while (!stack.isEmpty()) {
        }
        if (new_path.equals("")) new_path = "/";
        return new_path;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root.left);
        stack.push(root.right);

        TreeNode leftT;
        TreeNode rightT;

        while (!stack.isEmpty()) {
            leftT = stack.pop();
            rightT = stack.pop();

            if (leftT.val != rightT.val) {
                return false;
            }

            if (leftT.left != null && rightT.right == null) {
                return false;
            } else if (leftT.left != null && rightT.right != null) {
                stack.push(leftT.left);
                stack.push(rightT.right);
            } else {
                if (rightT.right != null) return false;
            }
            if (leftT.right != null && rightT.left == null) {
                return false;
            } else if (leftT.right != null && rightT.left != null) {
                stack.push(leftT.right);
                stack.push(rightT.left);
            } else {
                if (rightT.left != null) return false;
            }
        }
        return true;
    }

    public static int[][] updateMatrix(int[][] mat) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] steps = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            for (int[] step : steps) {
                int newRow = curRow + step[0];
                int newCol = curCol + step[1];
                if (newRow >= 0 && newRow < mat.length &&
                        newCol >= 0 && newCol < mat[0].length &&
                        mat[newRow][newCol] > mat[curRow][curCol] + 1) {
                    mat[newRow][newCol] = mat[curRow][curCol] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}



