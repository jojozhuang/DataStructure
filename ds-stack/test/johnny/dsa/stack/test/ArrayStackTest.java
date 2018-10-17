package johnny.dsa.stack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.stack.ArrayStack;

public class ArrayStackTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testArrayStack() throws Exception {
        System.out.println("testArrayStack");
        ArrayStack stack = new ArrayStack(100);

        assertEquals(true, stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // random access
        assertEquals(1, stack.get(0));
        assertEquals(2, stack.get(1));
        assertEquals(3, stack.get(2));
        
        assertEquals(false, stack.isEmpty());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(false, stack.isEmpty());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.peek());
        assertEquals(false, stack.isEmpty());
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(false, stack.isEmpty());
        assertEquals(1, stack.pop());
        assertEquals(true, stack.isEmpty());
    }

}
