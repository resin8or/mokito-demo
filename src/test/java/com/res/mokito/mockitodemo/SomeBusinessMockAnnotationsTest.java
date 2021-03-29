package com.res.mokito.mockitodemo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.xml.crypto.Data;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationsTest {
    // This class is built using stub tests
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class implementing ....");
    }

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl businessServiceImpl;

    @Test
    public void testFindTheGreatesFromAllData(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 3});

        int result = businessServiceImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

    @Test
    public void testFindTheGreatesFrom2Nums(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {29, 3});

        // simpler version than previous method above
        assertEquals(29, businessServiceImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatesFromNoValues(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});

        // Will return the min value when no value is passed in.
        assertEquals(Integer.MIN_VALUE, businessServiceImpl.findTheGreatestFromAllData());
    }
}

