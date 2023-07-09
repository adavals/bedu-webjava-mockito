package com.example.demo.business;

import com.example.demo.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{10, 20, 30};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneElementStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{50};
    }
}

class SomeBusinessLogicStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessLogic business = new SomeBusinessLogic();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumWithADataService();
        int expectedResult = 60;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessLogic business = new SomeBusinessLogic();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int actualResult = business.calculateSumWithADataService();//new int[] {}
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessLogic business = new SomeBusinessLogic();
        business.setSomeDataService(new SomeDataServiceOneElementStub());
        int actualResult = business.calculateSumWithADataService();
        int expectedResult = 50;
        assertEquals(expectedResult, actualResult);
    }
}
