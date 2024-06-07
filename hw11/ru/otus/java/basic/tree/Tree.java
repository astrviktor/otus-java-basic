package hw11.ru.otus.java.basic.tree;

import java.util.*;

public class Tree<T extends Comparable <T>> implements SearchTree<T> {
    private Node<T> rootNode;

    public Tree() {
        rootNode = null;
    }

    public void insert(T element) {
        Node<T> node = new Node<>();
        node.setValue(element);
        if (rootNode == null) {
            rootNode = node;
            return;
        }
        Node<T> currentNode = rootNode;
        Node<T> parentNode;
        while (true) {
            parentNode = currentNode;
            if(element.equals(currentNode.getValue())) {
                return;
            }
            if (element.compareTo(currentNode.getValue()) < 0) {
                currentNode = currentNode.getLeftChild();
                if (currentNode == null) {
                    parentNode.setLeftChild(node);
                    return;
                }
            } else {
                currentNode = currentNode.getRightChild();
                if (currentNode == null) {
                    parentNode.setRightChild(node);
                    return;
                }
            }
        }
    }

    private T findWithNode(T element, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (element.equals(node.getValue())) {
            return element;
        }
        if (element.compareTo(node.getValue()) < 0) {
            return findWithNode(element, node.getLeftChild());
        } else {
            return findWithNode(element, node.getRightChild());
        }
    }

    public T find(T element) {
        return findWithNode(element, rootNode);
    }


    private List<T> getSortedListWithNode(Node<T> node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<T> leftList = null;
        List<T> rightList = null;
        if (node.getLeftChild() != null) {
            leftList = getSortedListWithNode(node.getLeftChild());
        }
        T value = node.getValue();
        if (node.getRightChild() != null) {
            rightList = getSortedListWithNode(node.getRightChild());
        }

        List<T> result = new ArrayList<>();
        if (leftList != null) {
            result.addAll(leftList);
        }
        result.add(value);
        if (rightList != null) {
            result.addAll(rightList);
        }

        return result;
    }

    public List<T> getSortedList() {
        return getSortedListWithNode(rootNode);
    }
}
