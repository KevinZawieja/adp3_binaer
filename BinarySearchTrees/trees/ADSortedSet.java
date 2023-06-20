package trees;


import java.util.NoSuchElementException;

/**
 * This is a shortened version of the interface SortedSet
 * in the Java Collections Framework. 
 * The sets specified here do not allow null elements.
 *  
 * @author Axel Schmolitzky 
 * @version 2023
 */

interface ADSortedSet<E extends Comparable<E>>
{
    /** 
     * Adds the specified element to this set if it is not already present.
     * More formally, adds the specified element to this set if the set 
     * contains no element e2 such that element.equals(e2). 
     * If this set already contains the element, the call leaves the set 
     * unchanged and returns false. 
     * 
     * @param element the element to be added
     * @require element != null
     * @throws IllegalArgumentException
     */
    public boolean add(E element);
    
    /**
     * Removes all of the elements from this set.
     */
    public void clear();
    
    /**
     * Returns true if this set contains the specified element.
     * @param element element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     * @throws IllegalArgumentException
     */
    public boolean contains(E element);
    
    /**
     * Removes the specified element from this set if it is present.
     * More formally, removes an element e2 such that element.equals(e2), 
     * if this set contains such an element. 
     * Returns true if this set contained the element.
     * This set will not contain the element once the call returns.
     * 
     * @param element the element to be removed, if present
     * @require element != null
     * @throws IllegalArgumentException
     */
    public boolean remove(E element);
    
    /**
     * Returns the number of elements in this set (its cardinality).
     */
    public int size();
    
    /**
     * Returns the first (lowest) element currently in this set.
     * @throws NoSuchElementException if this set is empty
     */
    E first();

    /**
     * Returns the last (highest) element currently in this set.
     * @throws NoSuchElementException if this set is empty
     */
    E last();

    int getPathLength(E key);
}
