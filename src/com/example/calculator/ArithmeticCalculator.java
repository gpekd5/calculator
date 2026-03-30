package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator{

    private List<Number> resultList = new ArrayList<>();

    public void filter(Number data) {
        if (!resultList.isEmpty()) {
            List<Number> filter = resultList.stream()
                    .filter(x -> x.doubleValue() > data.doubleValue())
                    .map(x -> x.doubleValue() * 10)
                    .collect(Collectors.toList());
            System.out.println("필터 후 목록 : " + filter);
        } else
            System.out.println("목록에 데이터가 없습니다.");

    }

    //다른 타입 조합으로도 실행이 되어야 하므로 U, V 사용
    public <U extends Number, V extends  Number> Number calculator(U num1, V num2, OperatorType type ){

        Number result;

        if (num1 instanceof Integer && num2 instanceof  Integer){
            result = type.calculate(num1.intValue(), num2.intValue());
        }else {
            result = type.calculate(num1.doubleValue(), num2.doubleValue());
        }

        resultList.add(result);
        return result;
    }


    public List<Number> getList() {
        return this.resultList;
    }

    public void setList(List<Number> resultList) {
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

