package com.example.demo.business;

import com.example.demo.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SomeBusinessLogicMockitoExtensionTest {

    @InjectMocks
    SomeBusinessLogic business;

    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{10, 20, 30});
        assertEquals(60, business.calculateSumWithADataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{77});
        assertEquals(77, business.calculateSumWithADataService());
    }
    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumWithADataService());
    }

    // Substraction method Tests
    @Test
    public void calculateSubstractionUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{110, 20, 30});
        assertEquals(60, business.calculateSubstractionWithADataService());
    }

    @Test
    public void calculateSubstarctionUsingDataService_OneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{99});
        assertEquals(99, business.calculateSubstractionWithADataService());
    }

    @Test
    public void calculateSubstarctionUsingDataService_Empty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSubstractionWithADataService());
    }

    // Multiple return values
    @Test
    public void calculateSubstarctionUsingDataService_MultipleCases(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{20, 30, 40},
                new int[]{300, 100, 10, 4},
                new int[]{2, 2});
        assertEquals(-50, business.calculateSubstractionWithADataService());
        assertEquals(186, business.calculateSubstractionWithADataService());
        assertEquals(0, business.calculateSubstractionWithADataService());
    }


}
