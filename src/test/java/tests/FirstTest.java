package tests;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {


    @Test
    public void testAddTwoNumbers(){
        int sum = 2 + 3;

        assertEquals(sum, 5);
        assertTrue(sum > 0);
        assertFalse(sum == 6);


    }

    @Test
    public void  testStringOperation(){
        String vlad = "My name is Vlad";
        String olaru = "My name is vlad";
        String name = "name";

        assertTrue(vlad.contains(name));
        //assertTrue(vlad.contains("Olaru"));
        //assertEquals(vlad, olaru);
    }

    @Test
    public void checkArrayForPositiveNumbers(){
        int[] arr = new int[]{0, 1,3,5};
        for(int i = 0; i < arr.length; i++)
        {
            //assertTrue(arr[i] >= 0);
            //assertThat(arr[i], greaterThan(0));
            assertThat(arr[i],greaterThanOrEqualTo(0));
        }
    }



}
