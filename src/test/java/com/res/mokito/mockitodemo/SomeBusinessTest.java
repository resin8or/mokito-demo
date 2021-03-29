package com.res.mokito.mockitodemo;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessTest {
    // This class is built using stub tests
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class implementing ....");
    }

    @Test
    public void testFindTheGreatesFromAllData(){
        SomeBusinessImpl someBusinessImpl
                = new SomeBusinessImpl(new DataServiceStub());
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }
}

class DataServiceStub implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {24,6,15};
    }

}