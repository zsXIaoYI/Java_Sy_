package cn.zsza.data_structure;

/**
 * Created by ZhangSong on 2016/8/13.
 * 二叉树遍历
 */


//当建立好二叉树类后可以创建二叉树实例，并实现二叉树的先根遍历，中根遍历，后根遍历，代码如下：
public class BinaryTreeCreate {

    public static void preOrder(Node root) {  //先根遍历
        if (root != null) {
            System.out.print(root.data + "-");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root) {     //中根遍历

        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "--");
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root) {    //后根遍历

        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "---");
        }
    }

    public static void main(String[] str) {
//        int[] array = {12, 76, 35, 22, 16, 48, 90, 46, 9, 40};
        int[] array = {12, 76, 35, 22, 16, 9};
        Node root = new Node(array[0]);   //创建二叉树
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]);       //向二叉树中插入数据
        }
        System.out.println("先根遍历：");
        preOrder(root);
        System.out.println();
        System.out.println("中根遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后根遍历：");
        postOrder(root);

        System.out.println(".........search.........");

        System.out.println(root.search(root,135));
    }

    /**
     * 面向对象的思想，二叉树节点:Node
     * 属性:int data
     *      Node left;
     *      Node right;
     */
    public  static class Node {
        int data;       //根节点数据
        Node left;     //左子树
        Node right;    //右子树

        public Node(int data)  {  //实例化二叉树类
            this.data = data;
            left = null;
            right = null;
        }

        /**
         * 12作为根节点
         *  76进来,比根节点12大,放到根节点的右子树上,放到右子树上之前,先判断根节点的右子树是否为空,如果为空,直接把
         *  该节点作为12的右子树节点;
         *  35进来,比当前根节点大,也是放到右子树上,然后这时判断根节点的右子树不为空,则root.right作为根节点,
         *  递归调用insert(root.right,data)
         * @param root
         * @param data
         */
        public void insert(Node root,int data){     //向二叉树中插入子节点
            if(data > root.data)  {                            //插入的节点比根节点大
                if(root.right==null){
                    root.right = new Node(data);
                }else{
                    this.insert(root.right, data);
                }
            }else {                                              //插入的节点比比根节点小
                if(root.left==null){
                    root.left = new Node(data);
                }else{
                    this.insert(root.left, data);
                }
            }
        }

        public Node search(Node root,int data){
            if (root == null || root.data == data)
                return root;
            if (data < root.data){
                return search(root.left,data);
            }
            if (data > root.data){
                return search(root.right,data);
            }

            return null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}