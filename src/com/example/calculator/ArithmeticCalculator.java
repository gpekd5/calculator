package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private ArrayList<Double> resultList = new ArrayList<>();

    public void filter(double num1)
    {
        if (!resultList.isEmpty()) {
            //ArrayList를 사용하면 Collectors.toList() 이것과 타입이 안맞으므로 오류가 생긴다
            List<Double> filter = resultList.stream()
                    .filter(x -> x > num1)
                    .map(x -> x * 10)
                    .collect(Collectors.toList());
            System.out.println("필터 후 목록 : " + filter);
        }
        else
            System.out.println("목록에 데이터가 없습니다.");

    }

    public ArrayList<Double> getArrayList()
    {
        return this.resultList;
    }

    public void setArrayList(ArrayList<Double> resultList)
    {
        this.resultList = resultList;
    }

    public double calculate(T a, T b, EnumClass.OperatorType type){

        //제네릭 매개변수는 직접적으로 연산을 할 수가 없어서 해당 메서드 사용.
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();
        double result;

        switch (type) {
            case ADD:
                result = num1 + num2;
                resultList.add(result);
                return result;

            case SUBTRACT:
                result = num1 - num2;
                resultList.add(result);
                return result;

            case MULTIPLY:
                result = num1 * num2;
                resultList.add(result);
                return result;

            case DIVIDE:
                if (num2 == 0)
                {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return 0;
                }
                result = num1/num2;
                resultList.add(result);
                return result;

            default:
                return 0;
        }
    }

    public void removeResult(){
        //리스트가 비어있지 않을 경우에만 제거!
        if (!resultList.isEmpty()){
            resultList.remove(0);
        }
        else {
            System.out.println("목록에 데이터가 없습니다.");
        }
    }



}

