package com.jack.algorithm.tree.traverse;

import com.jack.algorithm.tree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by XijinZeng on 2017/6/19.
 */
public class BinaryTreeTraverse {

    public static void visit(BinaryTreeNode node){
        if(node != null){
            System.out.println(node.getData());
        }
    }

    /**
     * DLR Date-Left-Right
     * @param root
     */
    public static void preOrder(BinaryTreeNode root){
        if(root != null){
            visit(root);
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * LDR Left-Data-Right
     * @param root
     */
    public static void inOrder(BinaryTreeNode root){
        if(root != null){
            inOrder(root.getLeft());
            visit(root);
            inOrder(root.getRight());
        }
    }

    /**
     * LRD Left-Right-Data
     * @param root
     */
    public static void postOrder(BinaryTreeNode root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            visit(root);
        }
    }

    /**
     * visit data->push all the left nodes to stack
     * ->pop the left nodes->visit all the right nodes data
     * @param root
     */
    public static void preOrderNotRecursive(BinaryTreeNode root){
        if(root == null ) return;

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode tempNode     = root;
        while (true) {
            while (tempNode != null) {
                visit(tempNode);
                stack.push(tempNode);
                tempNode = tempNode.getLeft();
            }

            //exit while loop
            if (stack.isEmpty())
                break;

            tempNode = stack.pop();
            tempNode = tempNode.getRight();
        }
    }

    /**
     * push left nodes->pop nodes->visit data->process right nodes
     * @param root
     */
    public static void inOrderNotRecursive(BinaryTreeNode root){
        if(root == null) return;

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode tempNode     = root;

        while (true){
            while (tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.getLeft();
            }

            //exit while loop
            if(stack.isEmpty())
                break;

            tempNode = stack.pop();
            visit(tempNode);
            tempNode = tempNode.getRight();
        }
    }

    /**
     * 利用2个栈，首先以逆序访问节点，将访问结果存储在中间栈，中间栈的输出就是结果
     * @param root
     */
    public static void postOrderNotRecursive(BinaryTreeNode root){
        if (root == null) return;

        BinaryTreeNode tempNode = root;
        Stack<BinaryTreeNode> visitStack  = new Stack<>();
        Stack<BinaryTreeNode> outputStack = new Stack<>();

        while (true){
            while (tempNode != null){
                visitStack.push(tempNode);
                outputStack.push(tempNode);
                tempNode = tempNode.getRight();
            }

            // exit while loop
            if(visitStack.isEmpty())
                break;

            tempNode = visitStack.pop();
            tempNode = tempNode.getLeft();
        }

        while (!outputStack.isEmpty()){
            visit(outputStack.pop());
        }
    }

    /**
     * use queue to visit all nodes
     * add each level nodes to queue, and visit data
     * 层级遍历
     * @param root
     */
    public static void levelTraverse(BinaryTreeNode root){
        if(root == null) return;

        BinaryTreeNode tempNode = root;
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.add(tempNode);

        while (!queue.isEmpty()){
            tempNode = queue.poll();
            visit(tempNode);

            if(tempNode.getLeft() != null){
                queue.add(tempNode.getLeft());
            }

            if(tempNode.getRight() != null){
                queue.add(tempNode.getRight());
            }
        }
    }

}
