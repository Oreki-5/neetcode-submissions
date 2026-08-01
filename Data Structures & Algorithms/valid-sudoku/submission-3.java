
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;
// import java.util.Set;


class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Integer>> rowsMap = new HashMap<>();
        Map<Integer, Set<Integer>> colsMap = new HashMap<>();

        Map<String, Set<Integer>> matrixMap = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {
                    continue;
                }
                System.out.printf("Current iteration: r: %d c: %d\n", r, c);
                // System.out.printf("Current Element : r: %d\n",
                // Integer.valueOf(Character.toString(board[r][c])));
                // System.out.println("row condtipn: " + (!rowsMap.isEmpty() &&
                // rowsMap.getOrDefault(r, new HashSet<>())
                // .contains(Integer.valueOf(Character.toString(board[r][c])))));
                // System.out.println("col condtipn: " + (!colsMap.isEmpty() &&
                // colsMap.getOrDefault(c, new HashSet<>())
                // .contains(Integer.valueOf(Character.toString(board[r][c])))));
                // System.out.println("matrix condtipn: " + ((!matrixMap.isEmpty())
                // && (matrixMap.getOrDefault(Integer.toString(r / 3) + Integer.toString(c / 3),
                // new HashSet<>())
                // .contains(Integer.valueOf(Character.toString(board[r][c]))))));

                // System.out.println("Before checking: "+ matrixMap.entrySet());
                if ((!rowsMap.isEmpty() && rowsMap.getOrDefault(r, new HashSet<>())
                        .contains(Integer.valueOf(Character.toString(board[r][c]))))
                        ||
                        (!colsMap.isEmpty()
                                && colsMap.getOrDefault(c, new HashSet<>())
                                        .contains(Integer.valueOf(Character.toString(board[r][c]))))
                        ||
                        ((!matrixMap.isEmpty()) && (matrixMap
                                .getOrDefault(Integer.toString(r / 3) + Integer.toString(c / 3), new HashSet<>())
                                .contains(Integer.valueOf(Character.toString(board[r][c])))))) {
                    return false;
                }
                // System.out.println("after checking: " + matrixMap.entrySet());

                int element = Integer.parseInt(Character.toString(board[r][c]));

                System.out.println("rpws map beofre mapping" + rowsMap.entrySet());
                // System.out.println("matric map bfore row mapping: " + matrixMap.entrySet());
                Set<Integer> existingVal = rowsMap.get(r);
                if (existingVal == null) {
                    Set<Integer> currentElement = new HashSet<>();
                    currentElement.add(element);
                    rowsMap.put(r, currentElement);
                } else {
                    // System.out.println(existingVal);
                    existingVal.add(element);
                    // System.out.println(existingVal);

                }
                System.out.println("AFter row mapping: " + rowsMap.entrySet());
                // System.out.println("matric map after row mapping: " + matrixMap.entrySet());

                existingVal = colsMap.get(c);
                if (existingVal == null) {
                    Set<Integer> currentElement = new HashSet<>();
                    currentElement.add(element);
                    colsMap.put(c, currentElement);
                } else {
                    existingVal.add(element);
                }

                // System.out.println("Before mapping: "+ matrixMap.entrySet());

                if (matrixMap.get(Integer.toString(r / 3) + Integer.toString(c / 3)) == null) {
                    Set<Integer> currentElement = new HashSet<>();
                    currentElement.add(element);
                    // System.out.println("key of matrixMap : " + Integer.toString(r / 3) + Integer.toString(c / 3));
                    matrixMap.put(Integer.toString(r / 3) + Integer.toString(c / 3), currentElement);
                } else {
                    // System.out.println("key of matrixMap : " + Integer.toString(r / 3) + Integer.toString(c / 3));
                    matrixMap.get(Integer.toString(r / 3) + Integer.toString(c / 3)).add(element);
                }
                // System.out.println("after mapping: "+ matrixMap.entrySet());

            }
        }

        return true;
    }

}

/*
 * 
 * [["1","2",".",".","3",".",".",".","."],
 * ["4",".",".","5",".",".",".",".","."],
 * [".","9","8",".",".",".",".",".","3"],
 * ["5",".",".",".","6",".",".",".","4"],
 * [".",".",".","8",".","3",".",".","5"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".",".",".",".",".",".","2",".","."],
 * [".",".",".","4","1","9",".",".","8"],
 * [".",".",".",".","8",".",".","7","9"]]
 */
