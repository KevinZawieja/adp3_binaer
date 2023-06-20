package trees;

import java.util.NoSuchElementException;

public class ADSortedSetImpl<E extends Comparable<E>> implements ADSortedSet<E> {

    private ElementNode<E> root;
    private int size;

    public ADSortedSetImpl() {
        root = null;
        size = 0;
    }

    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        if (contains(element)) {
            return false; // Element already exists in the set
        }

        if (root == null) {
            root = new ElementNode<>(element);
        } else {
            root.add(element);
        }

        size++;
        return true;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        return (root != null) && root.contains(element);
    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        if (!contains(element)) {
            return false; // Element does not exist in the set
        }

        root = removeNode(root, element);
        size--;
        return true;
    }

    private ElementNode<E> removeNode(ElementNode<E> node, E element) {
        if (node == null) {
            return null;
        }

        int cmp = element.compareTo(node.getElement());
        if (cmp < 0) {
            node.set_left(removeNode(node.getLeft(), element));
        } else if (cmp > 0) {
            node.set_right(removeNode(node.getRight(), element));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                // who gets to be the new fatherknot
                ElementNode<E> successor = findMinimum(node.getRight());
                node.setElement(successor.getElement());
                node.set_right(removeNode(node.getRight(), successor.getElement()));
            }
        }
        return node;
    }

    private ElementNode<E> findMinimum(ElementNode<E> node) {
        ElementNode<E> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E first() {
        if (root == null) {
            throw new NoSuchElementException("Set is empty");
        }

        return findMinimum(root).getElement();
    }

    @Override
    public E last() {
        if (root == null) {
            throw new NoSuchElementException("Set is empty");
        }

        ElementNode<E> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getElement();
    }

    public ElementNode<E> getRoot() {
        return root;
    }

    @Override
    public int getPathLength(E key) {
        if (root == null) {
            return 0;
        }

        return getPathLength(root, key);
    }

    private int getPathLength(ElementNode<E> node, E key) {
        if (node == null) {
            return 0;
        }

        int cmp = key.compareTo(node.getElement());
        if (cmp < 0) {
            return getPathLength(node.getLeft(), key) + 1;
        } else if (cmp > 0) {
            return getPathLength(node.getRight(), key) + 1;
        } else {
            return 1;
        }
    }

}
