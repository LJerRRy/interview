package top.wenjiewang.algorithm;

/**
 * Created by jerry on 2017/9/7.
 */
public class ConstructTreeByInOrder {
    private static TreeNode reConstructBinaryTreeCore(int[] a, int[] b,
                                                      int la, int ra,
                                                      int lb, int rb) throws Exception {
//        if (la>ra||lb>rb)return null;
//        if (la==ra&&lb==rb)return new TreeNode(a[la]);
        if (ra - la != rb - lb)throw new Exception("error");

        TreeNode r = new TreeNode(a[la]);
        int i = find(b, a[la], lb, rb);
        if (i==-1)throw new Exception("error");
        int lLen = i - lb;
        if (lLen>0) {
            r.left = reConstructBinaryTreeCore(a, b, la + 1, la + lLen,
                    lb, i - 1);
        }
        if (rb - i>0) {
            r.right = reConstructBinaryTreeCore(a, b, la + lLen + 1, ra, i + 1, rb);
        }
        return r;
    }

    private static int find(int[] b, int target, int lb, int rb) {
        for (int j = lb; j <= rb; j++) {
            if (b[j] == target){
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        int pre[] = {1,2,4,7,3,5,8,9,6};
        int in[]  = {4,7,2,1,8,5,9,3,6};
        TreeNode tree = reConstructBinaryTreeCore(pre, in);
        System.out.print("先序遍历结果:  {");
        preTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("中序遍历结果:  {");
        inTraverseBinTree(tree);
        System.out.println("}");
    }

    private static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in) throws Exception {
        return reConstructBinaryTreeCore(pre, in, 0, pre.length-1, 0, in.length - 1);
    }


    //将二叉树先序遍历，用于测试结果
    public static void preTraverseBinTree(TreeNode node){
        if (node==null) {
            return;
        }
        System.out.print(node.val+",");
        if (node.left!=null) {
            preTraverseBinTree(node.left);
        }
        if(node.right!=null){
            preTraverseBinTree(node.right);
        }
    }

    //将二叉树中序遍历，用于测试结果
    public static void inTraverseBinTree(TreeNode node){
        if (node==null) {
            return;
        }
        if (node.left!=null) {
            inTraverseBinTree(node.left);
        }
        System.out.print(node.val+",");
        if(node.right!=null){
            inTraverseBinTree(node.right);
        }
    }
}
class TreeNode{
    TreeNode left, right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}
