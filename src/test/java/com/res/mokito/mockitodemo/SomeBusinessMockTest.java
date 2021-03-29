package com.res.mokito.mockitodemo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {
    // This class is built using stub tests
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class implementing ....");
    }

    @Test
    public void testFindTheGreatesFromAllData(){

        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 3});

        SomeBusinessImpl someBusinessImpl
                = new SomeBusinessImpl(dataServiceMock);
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

    @Test
    public void testFindTheGreatesFrom2Nums(){

        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {29, 3});

        SomeBusinessImpl someBusinessImpl
                = new SomeBusinessImpl(dataServiceMock);
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(29, result);
    }
}

