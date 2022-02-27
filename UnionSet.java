package Model;

// 并查集示例
/**
 * 声明parent数组，parent[i] = i
 *  find()方法：寻找根结点；参数：parent数组，和i
 *  union()方法：两个元素的祖先根节点不同，将其合并，并且每次合并count （len(parent)）都要--
 *              最后的count就是集合的个数
 * */

public class UnionSet {
    public int findCircleNum(int[][] isConnected) {
        int arrLen = isConnected.length;
        int count = arrLen;

        // 声明parent数组
        int[] parent = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < arrLen - 1; i++) {
            for (int j = i+1; j < arrLen; j++) {
                if (isConnected[i][j] == 1) {
                    count = union(parent, i, j, count);
                }
            }
        }

        return count;
    }

    public int find(int[] parent, int i) {
        int root = i;

        // 先找到i对应的根结点，根结点的特点就是parent[i] = i，所以只要parent[i] != i就一直往上找
        while(parent[root] != root) {
            root = parent[root];
        }

        // 压缩路径
        while (i != parent[i]) {
            int x = i;
            parent[x] = root;   //原来的父亲变成祖先
            i = parent[i];      //依次向上寻找每一个父元素
        }

        return root;
    }


    public int union(int[] parent, int i, int j, int count) {
        int p1 = find(parent, i);
        int p2 = find(parent, j);

        // 父节点是同一个
        if(p1 == p2)
            return count;

        parent[p1] = p2;

        // 合并一次，就有一个元素减少
        count--;
        return count;
    }

}
