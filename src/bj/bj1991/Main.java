// 백준 트리순회(1991) https://www.acmicpc.net/problem/1991

package bj.bj1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class Node<E> {
    public E value;
    public Node<E> left;
    public Node<E> right;
    public Node<E> parent;

    public Node(E value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
}

class TreeOrder {

    private Node<?> root;
    private StringBuilder orderStringBuilder;

    public TreeOrder(Node<?> root) {
        this.root = root;
        orderStringBuilder = new StringBuilder();
    }

    public String preOrder() {
        orderStringBuilder = new StringBuilder();
        preOrder(root);
        return orderStringBuilder.toString();
    }

    private void preOrder(Node<?> currentNode) {
        if  (currentNode != null)  {
            orderStringBuilder.append(currentNode);
            preOrder(currentNode.left);
            preOrder(currentNode.right);
        }
    }

    public String inOrder() {
        orderStringBuilder = new StringBuilder();
        inOrder(root);
        return orderStringBuilder.toString();
    }

    private void inOrder(Node<?> currentNode) {
        if  (currentNode != null)  {
            inOrder(currentNode.left);
            orderStringBuilder.append(currentNode);
            inOrder(currentNode.right);
        }
    }

    public String postOrder() {
        orderStringBuilder = new StringBuilder();
        postOrder(root);
        return orderStringBuilder.toString();
    }

    private void postOrder(Node<?> currentNode) {
        if  (currentNode != null)  {
            postOrder(currentNode.left);
            postOrder(currentNode.right);
            orderStringBuilder.append(currentNode);
        }
    }

}

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            HashMap<String, Node<String>> hashMap  = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                String[] tokens = br.readLine().split(" ");
                for (String token : tokens) {
                    if  ((!token.equals(".")) && (hashMap.get(token) == null)) {
                        hashMap.put(token, new Node<>(token));
                    }
                }

                Node<String> head = hashMap.get(tokens[0]);

                if (!tokens[1].equals(".")) {
                    Node<String> left = hashMap.get(tokens[1]);
                    head.left = left;
                    left.parent = head;
                }
                if (!tokens[2].equals(".")) {
                    Node<String> right = hashMap.get(tokens[2]);
                    head.right = right;
                    right.parent = head;
                }
            }
            TreeOrder treeOrder = new TreeOrder(hashMap.get("A"));
            bw.write(treeOrder.preOrder()+"\n");
            bw.write(treeOrder.inOrder()+"\n");
            bw.write(treeOrder.postOrder()+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
