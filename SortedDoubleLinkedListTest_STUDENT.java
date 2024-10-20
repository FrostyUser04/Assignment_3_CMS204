import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SortedDoubleLinkedListTest_STUDENT {

    // List instances for Integer and Character data types
    SortedDoubleLinkedList<Integer> listI;
    SortedDoubleLinkedList<Character> listC;

    // Comparators for Integer and Character types
    IntegerComparator comparatorI;
    CharacterComparator comparatorC;

    // Test data for Characters
    Character a = 'a', b = 'b', c = 'c', d = 'd', e = 'e', f = 'f';

    // Test data for Integers
    Integer zero = 0, one = 1, two = 2, three = 3, four = 4, five = 5;
    Integer six = 6, seven = 7, eight = 8, nine = 9, ten = 10;

    // Setup method to initialize lists and comparators before each test
    @Before
    public void setUp() {
        comparatorI = new IntegerComparator();
        comparatorC = new CharacterComparator();
        listI = new SortedDoubleLinkedList<>(comparatorI);
        listC = new SortedDoubleLinkedList<>(comparatorC);
    }

    // Tear down method to clean up after each test
    @After
    public void tearDown() {
        comparatorI = null;
        comparatorC = null;
        listI = null;
        listC = null;
    }

    // Test for the add() method to ensure correct sorted insertion
    @Test
    public void addTest() {
        listI.add(ten).add(two).add(five).add(one).add(four);
        assertEquals("[1, 2, 4, 5, 10]", listI.toArrayList().toString());

        listC.add(c).add(b).add(a).add(f);
        assertEquals("[a, b, c, f]", listC.toArrayList().toString());
    }

    // Test to verify UnsupportedOperationException is thrown by addToFront()
    @Test
    public void addToFrontTest() {
        assertThrows(UnsupportedOperationException.class, () -> listI.addToFront(one));
        assertThrows(UnsupportedOperationException.class, () -> listC.addToFront(a));
    }

    // Test to verify UnsupportedOperationException is thrown by addToEnd()
    @Test
    public void addToEndTest() {
        assertThrows(UnsupportedOperationException.class, () -> listI.addToEnd(one));
        assertThrows(UnsupportedOperationException.class, () -> listC.addToEnd(a));
    }

    // Test to verify elements are correctly removed using the comparator
    @Test
    public void removeTest() {
        listI.add(ten).add(two).add(five).add(one).add(four);
        listI.remove(five, comparatorI);
        assertEquals("[1, 2, 4, 10]", listI.toArrayList().toString());

        listC.add(c).add(b).add(a).add(f);
        listC.remove(c, comparatorC);
        assertEquals("[a, b, f]", listC.toArrayList().toString());
    }

    // Comparator for Characters
    private class CharacterComparator implements Comparator<Character> {
        @Override
        public int compare(Character c1, Character c2) {
            return c1.compareTo(c2);
        }
    }

    // Comparator for Integers
    private class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    }
}
