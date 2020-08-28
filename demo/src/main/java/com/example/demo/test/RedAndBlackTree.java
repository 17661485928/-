package com.example.demo.test;

/**
 * @author kafei
 * @Title:
 * @Package
 * @Description: 红黑树
 * @date 2020/8/24 11:36
 */
public class RedAndBlackTree {

    private Node root;

    class Node {

        /**
         * 存放节点的值
         */
        private int value;

        /**
         * 左节点
         */
        private Node left;

        /**
         * 右节点
         */
        private Node right;

        /**
         * 父节点
         */
        private Node parent;

        /**
         * 节点颜色
         */
        private ColorEnum coler;

    }

    public void insert(int value) {
        if (root == null) {
            //开始封装根节点
            Node node = new Node();
            //父节点为null
            node.parent = null;
            //根节点一定是黑色
            node.coler = ColorEnum.black;
            //存放值
            node.value = value;
            //指定根节点
            root = node;
        } else {
            //已存在根节点
            Node node = insertValue(value);
            //开始节点的是否旋转，或者变色
            repairTreeColor(node);
        }
    }

    private Node insertValue(int value) {
        return getPosition(root, value);
    }

    //数据插入
    private Node getPosition(Node node, int value) {
        if (value > node.value) {
            //右子树
            if (node.right == null) {
                //判断根节点下的的右子节点是否以存放值
                //开始封装根节点下右子节点
                Node nodeRight = new Node();
                //根节点下右子节点为node
                nodeRight.parent = node;
                //根节点下红色
                nodeRight.coler = ColorEnum.red;
                //存放值
                nodeRight.value = value;
                //指定根节点下的右节点
                node.right = nodeRight;
                return nodeRight;
            } else {
                return getPosition(node.right, value);
            }
        } else {
            //左子树
            if (node.left == null) {
                //开始封装根节点下左子节点
                Node nodeLeft = new Node();
                //根节点下左子节点为node
                nodeLeft.parent = node;
                //根节点下红色
                nodeLeft.coler = ColorEnum.red;
                //存放值
                nodeLeft.value = value;
                //指定根节点下的左节点
                node.left = nodeLeft;
                return nodeLeft;
            } else {
                return getPosition(node.left, value);
            }
        }
    }

    //修复红黑树
    private void repairTreeColor(Node node) {
        if (node.parent.coler.equals(ColorEnum.red)) {
            Node g = node.parent.parent;
            Node p = node.parent;
            //红黑树变色修复  根据规则当前节点的父节点为红色，其祖父的另一个子节点也是红色时，
            // 1.将父节点变为黑色，将祖父的另一个子节点也变为黑色，将祖父节点变为红色
            if ((g.left != null && g.left.coler.equals(ColorEnum.red)) && (g.right != null && g.right.coler.equals(ColorEnum.red))) {
                g.left.coler = ColorEnum.black;
                g.right.coler = ColorEnum.black;
                if (g != root) {
                    g.coler = ColorEnum.red;
                }
                return;
            }
            //左旋规则：当期那父节点为红色，其祖父的另一个节点为黑色或是空的情况下，切当前节点为右子树，
            // 则发生左旋，左旋以父节点作为左旋，1.将父节点变为黑色，2.将祖父节点变为红色，
            if ((g.left == null || ColorEnum.red.equals(g.left.coler) && (p.right == node))) {
                //左旋
                leftRotate(g);
                //修复颜色 将父节点变为黑色 降租父节点变为红色
                g.coler = ColorEnum.red;
                p.coler = ColorEnum.black;
            } else if ((g.right == null || ColorEnum.red.equals(g.right.coler) && (p.left == node))) {
                //右旋
                rightRotate(g);
                g.coler = ColorEnum.red;
                p.coler = ColorEnum.black;
            }
        }

    }

    //右旋
    private void rightRotate(Node g) {
        Node p = g.left;
        g.left = p.right;
        if (p.right != null) {
            p.right.parent = g;
        }
        if (g.parent == null) {
            root = p;
        } else {
            if (g.parent.right == g) {
                g.parent.right = p;
            } else {
                g.parent.left = p;
            }
        }
        p.right = g;
        g.parent = p;
    }

    //左旋
    private void leftRotate(Node g) {
        Node c = g.right; //c=2
        g.right = c.left;  //2=null
        if (c.left != null) {
            c.left.parent = g;
        }
        if (g.parent == null) {
            root = c;
        } else {
            if (g.parent.left == g) {
                g.parent.left = c;
            } else {
                g.parent.right = c;
            }
        }
        c.left = g;
        g.parent = c;
    }
    public static void main(String[] args) {
        RedAndBlackTree redAndBlackTree = new RedAndBlackTree();
        redAndBlackTree.insert(4);
        redAndBlackTree.insert(5);
        redAndBlackTree.insert(3);
        redAndBlackTree.insert(2);
        redAndBlackTree.insert(1);
    }
}
