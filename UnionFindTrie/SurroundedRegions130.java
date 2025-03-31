package UnionFindTrie;

public class SurroundedRegions130 {

    public void solve(char[][] board) {

    }

}

class UnionFind {

    public int[] fathers = null;

    public UnionFind(char[][] board) {
        int sizeX = board.length;
        int sizeY = board[0].length;

        fathers = new int[sizeX * sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {

                int index = i * sizeY + j;

                fathers[index] = index;
            }
        }

    }

    public int find(int index) {

        if (index == fathers[index]) {
            return index;
        }

        return this.fathers[index] = find(fathers[index]);

    }

    public void Union(int a, int b) {

        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {
            this.fathers[root_a] = root_b;
        }

    }

}
