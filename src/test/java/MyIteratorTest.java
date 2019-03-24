import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class MyIteratorTest{
    private static final int SIZE = 20;
    private MyIterator<String> array = new MyIterator<String>(SIZE);

    @Before
    public void before() throws Exception {
        for (int i = 0; i < SIZE; i++) {
            array.put(i, "String " + i);
        }
    }

    @After
    public void after() throws Exception {
        array = null;
    }

    @Test
    public void testPut() {
        array.put(0, "Test");
        assertEquals(array.get(0), "Test");
    }

    @Test
    public void testGet() {
        assertEquals(array.get(0), "String 0");
        assertEquals(array.get(19), "String 19");
    }

    @Test
    public void testIterator() {
        int i = 0;
        for (String str : array) {
            assertEquals(str, "String " + (i++));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutThrowException() throws Exception {
        array.put(20, "String 20");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowException() throws Exception {
        array.get(20);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorThrowException() throws Exception {
        Iterator<String> iterator = array.iterator();
        iterator.remove();
    }
}