import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList<Integer> listI;
	BasicDoubleLinkedList<Character> listC;
	
	IntegerComparator comparatorI;
	CharacterComparator comparatorC;
	
	Character a = new Character('a');
	Character b = new Character('b');
	Character c = new Character('c');
	Character d = new Character('d');
	Character e = new Character('e');
	Character f = new Character('f');
	
	Integer zero = new Integer(0);
	Integer one = new Integer(1);
	Integer two = new Integer(2);
	Integer three = new Integer(3);
	Integer four = new Integer(4);
	Integer five = new Integer(5);
	Integer six = new Integer(6);
	Integer seven = new Integer(7);
	Integer eight = new Integer(8);
	Integer nine = new Integer(9);
	Integer ten = new Integer(10);

    @Before
	public void setUp() throws Exception {
		listI = new BasicDoubleLinkedList<>();
		listC = new BasicDoubleLinkedList<>();
		
		comparatorI = new IntegerComparator();
		comparatorC = new CharacterComparator();
	}

    @After
	public void tearDown() throws Exception {
		listI = null;
		listC = null;
		comparatorI = null;
		comparatorC = null;
	}
    
    @Test
	public void addToEndTest() {
		listI.addToEnd(one);
		assertEquals(one, listI.getLast());
		listI.addToEnd(two);
		assertEquals(two, listI.getLast());
		listI.addToFront(three);
		assertEquals(two, listI.getLast());
		listI.addToEnd(four);
		listI.addToEnd(five);
		listI.addToEnd(six);
		assertEquals(six, listI.getLast());
		
		listC.addToEnd(a);
		listC.addToEnd(b);
		listC.addToFront(c);
		listC.addToFront(d);
		assertEquals(b, listC.getLast());
		listC.addToEnd(e);
		listC.addToEnd(f);
		assertEquals(f, listC.getLast());
	}

    @Test
	public void addToFrontTest() {
		listI.addToEnd(ten);
		assertEquals(ten, listI.getFirst());
		listI.addToFront(three);
		assertEquals(three, listI.getFirst());
		listI.addToEnd(six);
		listI.addToEnd(two);
		assertEquals(three, listI.getFirst());
		
		listC.addToFront(f);
		assertEquals(f, listC.getFirst());
		listC.addToEnd(e);
		listC.addToEnd(a);
		listC.addToFront(c);
		assertEquals(c, listC.getFirst());
		listC.addToFront(b);
		assertEquals(b, listC.getFirst());
	}

    @Test
	public void getFirstTest() {
		listI.addToFront(three);
		assertEquals(three, listI.getFirst());
		listI.addToEnd(eight);
		listI.addToEnd(seven);
		assertEquals(three, listI.getFirst());
		
		listC.addToFront(b);
		listC.addToFront(c);
		assertEquals(c, listC.getFirst());
		listC.addToEnd(f);
		listC.addToFront(a);
		listC.addToEnd(e);
		assertEquals(a, listC.getFirst());
	}

    @Test
	public void getLastTest() {
		listI.addToFront(nine);
		listI.addToFront(two);
		assertEquals(nine, listI.getLast());
		listI.addToFront(six);
		listI.addToEnd(five);
		assertEquals(five, listI.getLast());
		
		listC.addToFront(a);
		assertEquals(a, listC.getLast());
		listC.addToFront(f);
		assertEquals(a, listC.getLast());
		listC.addToEnd(e);
		assertEquals(e, listC.getLast());
		listC.addToEnd(c);
		assertEquals(c, listC.getLast());
	}

    @Test
	public void getSizeTest() {
		listI.addToFront(two);
		listI.addToEnd(three);
		assertEquals(2, listI.getSize());
		listI.addToEnd(five);
		assertEquals(3, listI.getSize());
		listI.remove(two, comparatorI);
		assertEquals(2, listI.getSize());
		
		listC.addToFront(c);
		listC.addToEnd(b);
		listC.remove(b, comparatorC);
		assertEquals(1, listC.getSize());
		listC.addToEnd(f);
		listC.addToEnd(a);
		assertEquals(3, listC.getSize());
	}

    @Test
	public void retrieveFirstElementTest() {
		listI.addToEnd(two);
		listI.addToEnd(three);
		listI.addToEnd(four);
		listI.addToEnd(five);
		listI.addToEnd(six);
		assertEquals(two, listI.retrieveFirstElement());
		assertEquals(three, listI.retrieveFirstElement());
		assertEquals(four, listI.retrieveFirstElement());
		assertEquals(five, listI.retrieveFirstElement());
		assertEquals(six, listI.retrieveFirstElement());
		
		
		listC.addToEnd(a);
		listC.addToEnd(b);
		listC.addToEnd(c);
		listC.addToEnd(d);
		listC.addToEnd(e);
		listC.addToEnd(f);
		assertEquals(a, listC.retrieveFirstElement());
		assertEquals(b, listC.retrieveFirstElement());
		assertEquals(c, listC.retrieveFirstElement());
		assertEquals(d, listC.retrieveFirstElement());
		assertEquals(e, listC.retrieveFirstElement());
		assertEquals(f, listC.retrieveFirstElement());
	}

    @Test
	public void retrieveLastElementTest() {
		listI.addToEnd(two);
		listI.addToEnd(three);
		listI.addToEnd(four);
		listI.addToEnd(five);
		listI.addToEnd(six);
		assertEquals(six, listI.retrieveLastElement());
		assertEquals(five, listI.retrieveLastElement());
		assertEquals(four, listI.retrieveLastElement());
		assertEquals(three, listI.retrieveLastElement());
		assertEquals(two, listI.retrieveLastElement());
		
		listC.addToEnd(a);
		listC.addToEnd(b);
		listC.addToEnd(c);
		listC.addToEnd(d);
		listC.addToEnd(e);
		listC.addToEnd(f);
		assertEquals(f, listC.retrieveLastElement());
		assertEquals(e, listC.retrieveLastElement());
		assertEquals(d, listC.retrieveLastElement());
		assertEquals(c, listC.retrieveLastElement());
		assertEquals(b, listC.retrieveLastElement());
		assertEquals(a, listC.retrieveLastElement());
	}

    @Test
	public void removeTest() {
		listI.addToEnd(three);
		listI.addToFront(five);
		listI.addToEnd(two);
		listI.addToEnd(eight);
		listI.remove(five, comparatorI);
		assertTrue("[3, 2, 8]".equals(listI.toArrayList().toString()));
		
		listC.addToFront(c);
		listC.addToFront(d);
		listC.addToFront(e);
		listC.addToFront(a);
		listC.remove(a, comparatorC);;
		assertTrue("[e, d, c]".equals(listC.toArrayList().toString()));
	}

    @Test
	public void toArrayListTest() {
		listI.addToFront(ten);
		listI.addToFront(one);
		listI.addToFront(nine);
		listI.addToFront(two);
		listI.addToFront(eight);
		listI.addToFront(three);
		listI.addToFront(seven);
		listI.addToFront(four);
		listI.addToFront(six);
		listI.addToFront(five);
		assertTrue("[5, 6, 4, 7, 3, 8, 2, 9, 1, 10]".equals(listI.toArrayList().toString()));
		
		listC.addToFront(a);
		listC.addToEnd(f);
		listC.addToEnd(c);
		assertTrue("[a, f, c]".equals(listC.toArrayList().toString()));
	}

    private class CharacterComparator implements Comparator<Character>
	{

		@Override
		public int compare(Character arg0, Character arg1) {
			return arg0.compareTo(arg1);
		}
		
	}

    private class IntegerComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg0.compareTo(arg1);
		}
		
	}

}