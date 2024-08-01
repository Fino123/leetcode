package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;
import leetcode.entity.TreeNode;

import java.util.*;

public class Leetcode107Solution extends AbstractSolution{

    @Handler
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null) return new ArrayList<>();
        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> arr1 = new LinkedList<>();
        List<TreeNode> arr2 = new LinkedList<>();
        arr1.add(root);
        while(!arr1.isEmpty() || !arr2.isEmpty()){
            List<TreeNode> now = arr1.isEmpty()? arr2 : arr1;
            List<TreeNode> next = arr1.isEmpty()? arr1: arr2;
            List<Integer> temp = new ArrayList<>();
            while(!now.isEmpty()){
                TreeNode cur = now.remove(0);
                temp.add(cur.val);
                if (cur.left!=null)
                    next.add(cur.left);
                if (cur.right!=null)
                    next.add(cur.right);
            }
            result.add(temp);
        }
        Collections.reverse(result);
        return result;
    }

    @Case
    public TreeNode case1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    @Override
    public String outputArgumentToString(Object o){
        List<List<Integer>> arr = (List<List<Integer>>) o;
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : arr){
            sb.append(list.toString()).append("\n");
        }
        return sb.toString();
    }
}
