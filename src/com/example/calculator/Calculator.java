package com.example.calculator;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> resultList = new ArrayList<>();

    public ArrayList<Integer> getArrayList(){
        return this.resultList;
    }

    public void setArrayList(ArrayList<Integer> resultList)
    {

        this.resultList = resultList;
    }

    public int add(int a, int b)
    {
        int result = a + b;
        resultList.add(result);
        return result;
    }

    public int subtract(int a, int b)
    {
        int result = a - b;
        resultList.add(result);
        return result;
    }

    public int multiply(int a, int b)
    {
        int result = a * b;
        resultList.add(result);
        return result;
    }

    public int divide(int a, int b)
    {
        if (b == 0)
        {
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            return 0;
        }
        int result = a/b;
        resultList.add(result);
        return result;
    }

    public void removeResult(){
        resultList.remove(0);
    }

}

