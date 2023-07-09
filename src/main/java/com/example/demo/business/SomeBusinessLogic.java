package com.example.demo.business;

import com.example.demo.data.SomeDataService;

public class SomeBusinessLogic {
    private SomeDataService someDataService;
    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }


    public int calculateSumWithADataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value:data) {
            sum += value;
        }

        return sum;
    }

    public int calculateSubstractionWithADataService(){

        int[] data = someDataService.retrieveAllData();

        int sub = 0;
        if(data.length>0)
            sub = data[0];

        if(data.length>1) {
            for(int pos=1; pos<data.length; pos++) {
                sub -= data[pos];
            }
        }
        return sub;
    }
}

