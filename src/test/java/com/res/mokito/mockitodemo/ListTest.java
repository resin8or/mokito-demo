package com.res.mokito.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListTest {

    @Test
    public void test(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10);
        assertEquals(10, listMock.size());
    }

    @Test
    public void testMultipleReturns(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, listMock.size());
        assertEquals(20, listMock.size());
    }

    @Test
    public void testGetMethodAndReturns(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("something").thenReturn("out of values");
        assertEquals("something", listMock.get(0));
        assertEquals("out of values", listMock.get(0));
        //assertEquals(20, listMock.size());
    }

    @Test
    public void testGenericParam(){
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("something");
        assertEquals("something", listMock.get(0));
        assertEquals("something", listMock.get(4));
    }
}


