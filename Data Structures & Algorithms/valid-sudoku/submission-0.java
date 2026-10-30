class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Initialize the sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Check every cell
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];

                // Ignore empty cells
                if (num == '.') {
                    continue;
                }

                // Find the 3x3 box
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check for duplicates
                if (rows[r].contains(num) || cols[c].contains(num)
                    || boxes[boxIndex].contains(num)) {
                    return false;
                }

                // Add number to all three sets
                rows[r].add(num);
                cols[c].add(num);
                boxes[boxIndex].add(num);
            }
        }

        return true;
    }
}