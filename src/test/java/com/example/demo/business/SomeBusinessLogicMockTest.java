
package com.example.demo.business;

import com.example.demo.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SomeBusinessLogicMockTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        // Arrange
        SomeBusinessLogic business = new SomeBusinessLogic();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{10, 20, 30});
        business.setSomeDataService(dataServiceMock);
        int expectedResult = 60;

        // Act
        int actualResult = business.calculateSumWithADataService();

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        // Arrange
        SomeBusinessLogic business = new SomeBusinessLogic();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{50});
        business.setSomeDataService(dataServiceMock);
        int expectedResult = 50;

        // Act
        int actualResult = business.calculateSumWithADataService();

        // Assert
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void calculateSumUsingDataService_empty() {

        // Arrange
        SomeBusinessLogic business = new SomeBusinessLogic();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        business.setSomeDataService(dataServiceMock);
        int expectedResult = 0;

        // Act
        int actualResult = business.calculateSumWithADataService();

        // Assert
        assertEquals(expectedResult, actualResult);

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumWithADataService());
    }



}
