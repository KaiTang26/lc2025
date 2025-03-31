package UnionFindTrie;

public class NumberOfProvinces547 {

    public int findCircleNum(int[][] isConnected) {

        UnionFind uf = new UnionFind(isConnected.length);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {

                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;

    }

}

class UnionFind {
    int[] fathers = null;
    public int count = 0;

    public UnionFind(int n) {

        fathers = new int[n];

        for (int i = 0; i < n; i++) {
            fathers[i] = i;
            count++;
        }

    }

    public int find(int index) {

        if (index == fathers[index]) {
            return index;
        }

        return fathers[index] = find(fathers[index]);
    }

    public void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {

            fathers[root_a] = root_b;
            count--;
        }
    }

}
