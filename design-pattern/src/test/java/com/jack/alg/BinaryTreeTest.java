package com.jack.alg;

import com.jack.algorithm.tree.BinaryTreeNode;
import com.jack.algorithm.tree.traverse.BinaryTreeTraverse;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by XijinZeng on 2017/6/19.
 */
public class BinaryTreeTest {


    private BinaryTreeNode root;

    /** this is the binary tree here
     *      1
     *    /   \
     *   2     3
     *  / \   / \
     * 4  5  6   7
     */
    @Before
    public void constructTree(){
        BinaryTreeNode seven = new BinaryTreeNode(7,null,null);
        BinaryTreeNode six   = new BinaryTreeNode(6,null,null);
        BinaryTreeNode five  = new BinaryTreeNode(5,null,null);
        BinaryTreeNode four  = new BinaryTreeNode(4,null,null);

        BinaryTreeNode three = new BinaryTreeNode(3,six,seven);
        BinaryTreeNode two   = new BinaryTreeNode(2,four,five);
        BinaryTreeNode one   = new BinaryTreeNode(1,two,three);

        this.root = one;
    }

    @Test
    public void traverseTest() throws Exception {

        System.out.println("==pre order==");
        BinaryTreeTraverse.preOrder(this.root);

        System.out.println("==in order==");
        BinaryTreeTraverse.inOrder(this.root);

        System.out.println("==post order==");
        BinaryTreeTraverse.postOrder(this.root);

    }

    @Test
    public void notRecursiveTest(){

        System.out.println("==pre order not recursive==");
        BinaryTreeTraverse.preOrderNotRecursive(this.root);

        System.out.println("==in order not recursive==");
        BinaryTreeTraverse.inOrderNotRecursive(root);

        System.out.println("==post order not recursive==");
        BinaryTreeTraverse.postOrderNotRecursive(root);

        System.out.println("==level traverse==");
        BinaryTreeTraverse.levelTraverse(root);
    }
}
