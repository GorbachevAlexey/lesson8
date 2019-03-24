import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class MyIteratorTest{
    private static final int SIZE = 20;
    MyIterator<String> array1 = new MyIterator<String>(SIZE);
    MyIterator<Integer> array2 = new MyIterator<Integer>(0);

    @Before
    public void before() throws Exception {
        for (int i = 0; i < SIZE; i++) {
            array1.put(i, "String " + i);
        }
    }

    @After
    public void after() throws Exception {
        array1 = null;
    }

    @Test
    public void testPut() {
        array1.put(0, "Test");
        assertEquals(array1.get(0), "Test");
        array1.put(0, "String 0");
        assertEquals(array1.get(0), "String 0");
    }

    @Test
    public void testGet() {
        assertEquals(array1.get(0), "String 0");
        assertEquals(array1.get(19), "String 19");
    }

    @Test
    public void testIterator() {
        int i = 0;
        for (String str : array1) {
            assertEquals(str, "String " + (i++));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void put() throws Exception {
        array2.put(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void get() throws Exception {
        array2.get(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator() throws Exception {
        Iterator<Integer> iterator = array2.iterator();
        iterator.remove();
    }
}