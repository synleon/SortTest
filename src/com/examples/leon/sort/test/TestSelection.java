package com.examples.leon.sort.test;

import com.examples.leon.sort.Selection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestSelection{

    private int[] copy1, copy2, copy3, copy4;

    @Before
    public void setUp() throws Exception{
        copy1 = Arrays.copyOf( AllTests.array1[0], AllTests.array1[0].length);
        copy2 = Arrays.copyOf( AllTests.array2[0], AllTests.array2[0].length);
        copy3 = Arrays.copyOf( AllTests.array3[0], AllTests.array3[0].length);
        copy4 = Arrays.copyOf( AllTests.array4[0], AllTests.array4[0].length);
    }

    @After
    public void tearDown() throws Exception{
        copy1 = null;
        copy2 = null;
        copy3 = null;
        copy4 = null;
    }

    @Test
    public void testBubble(){
        Selection.sort( copy1, copy1.length);
        assertArrayEquals( AllTests.array1[1], copy1);
        Selection.sort( copy2, copy2.length);
        assertArrayEquals( AllTests.array2[1], copy2);
        Selection.sort( copy3, copy3.length);
        assertArrayEquals( AllTests.array3[1], copy3);
        Selection.sort( copy4, copy4.length);
        assertArrayEquals( AllTests.array4[1], copy4);
    }

    @Test
    public void testRandomBubble(){
        for( int i = 0; i < AllTests.RANDOM_TEST_COUNT; i++){
            copy1 = AllTests.generateRandomArray( AllTests.RANDOM_ARRAY_LENGHT, AllTests.RANDOM_LARGEST_NUMBER);
            copy2 = Arrays.copyOf( copy1, AllTests.RANDOM_ARRAY_LENGHT);
            Arrays.sort( copy1);
            Selection.sort( copy2, copy2.length);
            assertArrayEquals( copy1, copy2);
        }
    }
}

