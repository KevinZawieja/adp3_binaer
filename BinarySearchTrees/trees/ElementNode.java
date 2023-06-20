package trees;


/**
 * A node for a binary search tree.
 * <br>
 * 
 * @author Axel Schmolitzky 
 * @version 2023
 */
class ElementNode<E extends Comparable<E>>
{
    private E _element;
    private ElementNode<E> _left;
    private ElementNode<E> _right;
        
    /**
     * Initialize a new node with its content. A new node initially
     * has no children.
     * @param elem 
     * @require elem != null
     */
    public ElementNode(E elem)
    {
        _element = elem;
        _left = null;
        _right = null;
    }

    /**
     * Returns the element of this node.
     * @return the element of this node.
     * @ensure result != null
     */
    public E getElement()
    {
        return _element;
    }

    /**
     * Sets the element of this node to the specified element.
     * @param elem the element to set
     * @require elem != null
     */
    public void setElement(E elem)
    {
        _element = elem;
    }
    /**
     * Adds the specified element.
     * @param elem element to be added to this set.
     * @require elem != null && !contains(elem)
     */
    public void add(E elem)
    {
        if (elem.compareTo(_element) < 0)
        {
            if (_left == null)
            {
                _left = new ElementNode(elem);
            }
            else 
            {
                _left.add(elem);
            }
        }
        else
        {
            if (_right == null)
            {
                _right = new ElementNode(elem);
            }
            else 
            {
                _right.add(elem);
            }
        }
     }
    
    /**
     * Returns true if the set of elements that is reachable via
     * this node contains the specified element, false otherwise.
     * @param elem element whose presence in this set is to be tested
     * @require elem != null
     */
    public boolean contains(E elem)
    {
        boolean result = false;
        if (_element.equals(elem))
        {
            result = true;
        }
        else if (elem.compareTo(_element) < 0)
        {
            result = (_left != null) && _left.contains(elem);
        }
        else if (elem.compareTo(_element) > 0)
        {
            result = (_right != null) && _right.contains(elem);
        }
        return result;
    }
    
    /**
     * Returns the left child node of this node.
     * @return the left child node of this node.
     */
    public ElementNode getLeft()
    {
        return _left;
    }
    
    /**
     * Returns the right child node of this node.
     * @return the right child node of this node.
     */
    public ElementNode getRight()
    {
        return _right;
    }

    public void set_left(ElementNode<E> _left) {
        this._left = _left;
    }

    public void set_right(ElementNode<E> _right) {
        this._right = _right;
    }
}

