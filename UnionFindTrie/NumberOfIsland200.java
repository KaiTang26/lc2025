package UnionFindTrie;

public class NumberOfIsland200 {

    public int numIslands(char[][] grid) {

        UnionFind un = new UnionFind(grid);

        int sizeX = grid.length;
        int sizeY = grid[0].length;

        int[] deltaX = { 1, 0, -1, 0 };
        int[] deltaY = { 0, 1, 0, -1 };

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {

                if (grid[x][y] == '1') {
                    grid[x][y] = '0';

                    for (int i = 0; i < 4; i++) {
                        int newX = x + deltaX[i];
                        int newY = y + deltaY[i];

                        if (isInbound(newX, sizeX) && isInbound(newY, sizeY) && grid[newX][newY] == '1') {

                            int index_a = x * sizeY + y;
                            int index_b = newX * sizeY + newY;
                            un.union(index_a, index_b);

                        }

                    }

                }

            }
        }

        return un.islandCount;

    }

    private boolean isInbound(int newIndex, int upperBound) {
        return newIndex >= 0 && newIndex < upperBound;
    }

}

class UnionFind {

    int[] father = null;
    public int islandCount = 0;

    public UnionFind(char[][] grid) {
        int sizeX = grid.length;
        int sizeY = grid[0].length;

        this.father = new int[sizeX * sizeY];

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                int index = x * sizeY + y;
                father[index] = index;

                if (grid[x][y] == '1') {
                    islandCount++;
                }

            }
        }

    }

    public int find(int x) {
        if (this.father[x] == x) {
            return x;
        }

        return this.father[x] = find(father[x]);
    }

    public void union(int x, int y) {

        int root_x = find(x);
        int root_y = find(y);

        if (root_x != root_y) {
            this.father[root_x] = root_y;
            this.islandCount--;
        }
    }

}
