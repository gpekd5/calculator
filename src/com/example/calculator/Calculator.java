package com.example.calculator;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> resultList = new ArrayList<>();
    int result;

    public ArrayList<Integer> getArrayList(){
        return this.resultList;
    }

    public void setArrayList(ArrayList<Integer> resultList)
    {

        this.resultList = resultList;
    }

    public int calculate(int a, int b, char str){
        switch (str) {
            case '+':
                result = a + b;
                resultList.add(result);
                return result;
            case '-':
                result = a - b;
                resultList.add(result);
                return result;
            case '*':
                result = a * b;
                resultList.add(result);
                return result;
            case '/':
                if (b == 0)
                {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return 0;
                }
                result = a/b;
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
    }

}

