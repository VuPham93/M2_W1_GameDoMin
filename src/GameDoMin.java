public class GameDoMin {
    public static void main(String[] args) {
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {".", "*", ".", ".", "."},
                {".", "*", ".", "*", "."},
                {".", ".", "*", ".", "*"}
        };
        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;

        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];

        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                String currentCell = map[y][x];
                System.out.print(currentCell + "\t");
                if (currentCell.equals("*")) {
                    mapReport[y][x] = "*";
                }
                else {
                    final int[][] NEIGHBOURS_ORDINATE = {
                            {y - 1, x - 1}, {y - 1, x}, {y - 1, x + 1},
                            {y, x - 1}, {y, x + 1},
                            {y + 1, x - 1}, {y + 1, x}, {y + 1, x + 1},
                    };

                int minesAround = 0;

                    for (int[] neighbourOrdinate : NEIGHBOURS_ORDINATE) {
                        int xOfNeighbour = neighbourOrdinate[1];
                        int yOfNeighbour = neighbourOrdinate[0];

                        boolean isOutOfMapNeighbour = xOfNeighbour < 0
                                || xOfNeighbour == MAP_WIDTH
                                || yOfNeighbour < 0
                                || yOfNeighbour == MAP_HEIGHT;
                        if (isOutOfMapNeighbour) continue;

                        boolean isMineOwnerNeighbour = map[yOfNeighbour][xOfNeighbour].equals("*");
                        if (isMineOwnerNeighbour) minesAround++;
                    }
                    mapReport[y][x] = String.valueOf(minesAround);
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
                String currentCellReport = mapReport[yOrdinate][xOrdinate];
                System.out.print(currentCellReport + "\t");
            }
            System.out.println();
        }
    }
}
