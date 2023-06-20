package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ADSortedSetImplTest {
    private ADSortedSet<Integer> set;

    @BeforeEach
    public void setUp() {
        set = new ADSortedSetImpl<>();
    }

    @Test
    public void testAdd() {
        assertTrue(set.add(10));
        assertTrue(set.add(5));
        assertTrue(set.add(15));
        assertFalse(set.add(10)); // Adding duplicate element
        assertFalse(set.add(5)); // Adding duplicate element
        assertFalse(set.add(15)); // Adding duplicate element
    }

    @Test
    public void testContains() {
        set.add(10);
        set.add(5);
        set.add(15);

        assertTrue(set.contains(10));
        assertTrue(set.contains(5));
        assertTrue(set.contains(15));
        assertFalse(set.contains(20));
    }

    @Test
    public void testRemove() {
        set.add(10);
        set.add(5);
        set.add(15);

        assertTrue(set.remove(10));
        assertFalse(set.contains(10));

        assertFalse(set.remove(20)); // Removing non-existent element

        assertTrue(set.remove(5));
        assertFalse(set.contains(5));

        assertTrue(set.remove(15));
        assertFalse(set.contains(15));

        assertTrue(set.size() == 0);
    }

    @Test
    public void testSize() {
        assertEquals(0, set.size());

        set.add(10);
        set.add(5);
        set.add(15);

        assertEquals(3, set.size());

        set.remove(10);
        set.remove(5);

        assertEquals(1, set.size());

        set.clear();
        assertEquals(0, set.size());
    }

    @Test
    public void testFirstAndLast() {
        set.add(10);
        set.add(5);
        set.add(15);
        set.add(2);
        set.add(12);

        assertEquals(2, set.first());
        assertEquals(15, set.last());
    }
}
