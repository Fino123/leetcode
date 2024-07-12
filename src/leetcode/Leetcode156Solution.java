package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;
import leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode156Solution extends AbstractSolution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder traversal = new StringBuilder();
        int n = preOrderTraversal(root, traversal);
        //inOrderTraversal(root, traversal);
        return traversal.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data) || data == null) return null;
        List<String> lists = new LinkedList<>(Arrays.asList(data.split(",")));
        return getTreeByPreOrderAndInOrderTraversal(lists);
    }

    public int preOrderTraversal(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("None,");
            return 0;
        }
        builder.append(root.val).append(",");
        int left = preOrderTraversal(root.left, builder);
        int right = preOrderTraversal(root.right, builder);
        return left + right + 1;
    }

    public TreeNode getTreeByPreOrderAndInOrderTraversal(List<String> list) {
        if (list.isEmpty()){
            return null;
        }
        String first = list.get(0);
        list.remove(0);
        if ("None".equals(first)){
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.left = getTreeByPreOrderAndInOrderTraversal(list);
            root.right = getTreeByPreOrderAndInOrderTraversal(list);
            return root;
        }
    }

    private int[] splitToArray(String s, String patten){
        String[] strs = s.split(patten);
        int []nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        return nums;
    }

    public void inOrderTraversal(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("None,");
            return;
        }
        inOrderTraversal(root.left, builder);
        builder.append(root.val).append(",");
        inOrderTraversal(root.right, builder);
    }

    @Handler
    public String handler(TreeNode root) {
        String serialize = serialize(root);
        TreeNode node = deserialize(serialize);
        StringBuilder stringBuilder = new StringBuilder();
        preOrderTraversal(node, stringBuilder);
        return stringBuilder.toString();
    }

    @Case
    public TreeNode case1(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }

    @Case
    public TreeNode case2(){
        return new TreeNode(1);
    }

    @Case
    public TreeNode case4(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        return root;
    }

    @Case
    public TreeNode case5(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        return root;
    }
}
