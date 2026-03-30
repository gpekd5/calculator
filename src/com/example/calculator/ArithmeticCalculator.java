package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private List<Double> resultList = new ArrayList<>();

    public void filter(double num1) {
        if (!resultList.isEmpty()) {
            //ArrayList를 사용하면 Collectors.toList() 이것과 타입이 안맞으므로 오류가 생긴다
            List<Double> filter = resultList.stream()
                    .filter(x -> x > num1)
                    .map(x -> x * 10)
                    .collect(Collectors.toList());
            System.out.println("필터 후 목록 : " + filter);
        } else
            System.out.println("목록에 데이터가 없습니다.");

    }

    public List<Double> getList() {
        return this.resultList;
    }

    public void setList(List<Double> resultList) {
        this.resultList = resultList;
    }

    public void removeResult() {
        //리스트가 비어있지 않을 경우에만 제거!
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        } else {
            System.out.println("목록에 데이터가 없습니다.");
        }
    }
}

