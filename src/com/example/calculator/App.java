package com.example.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        int result = 0;

        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        while (true) {
            while (true) {
                System.out.print("첫 번째 숫자(양의 정수)를 입력하세요 : ");

                if (sc.hasNextInt()) {
                    num1 = sc.nextInt();
                    if (num1 >= 0) {
                        break;
                    } else {
                        System.out.println("양의 정수를 입력하세요!!");
                    }
                } else {
                    System.out.println("숫자를 입력하세요!!");
                    sc.next();
                }
            }

            while (true) {
                System.out.print("두 번째 숫자(양의 정수)를 입력하세요 : ");

                if (sc.hasNextInt()) {
                    num2 = sc.nextInt();
                    if (num2 >= 0) {
                        break;
                    } else {
                        System.out.println("양의 정수를 입력하세요!!");
                    }
                } else {
                    System.out.println("숫자를 입력하세요!!");
                    sc.next();
                }
            }

            while (true)
            {
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /) : ");

                String lenthCheck = sc.next();

                if (lenthCheck.length() != 1){
                    System.out.println("연산자는 한 글자만 입력하세요.");
                    continue;
                }

                char str = lenthCheck.charAt(0);

                switch (str) {
                    case '+':
                        result = cal.add(num1, num2);
                        break;
                    case '-':
                        result = cal.subtract(num1, num2);
                        break;
                    case '*':
                        result = cal.multiply(num1, num2);
                        break;
                    case '/':
                        result = cal.divide(num1, num2);
                        break;
                    default:
                    {
                        System.out.println("잘못된 연산자입니다.");
                        continue;
                    }
                }
                break;
            }

            System.out.println("결과 : " + result);
            System.out.println("전체 결과 목록 : " + cal.getArrayList());

            System.out.print("저장된 리스트를 강제로 [1,2,3,4,5]로 만드시겠습니까? (yes : 실햄) ");
            sc.nextLine();
            String str1 = sc.nextLine();
            if (str1.equals("yes"))
            {
                ArrayList<Integer> results = new ArrayList<>(Arrays.asList(1,2,3,4,5));
                cal.setArrayList(results);
                System.out.println("전체 결과 목록 : " + cal.getArrayList());
            }

            System.out.print("가장 먼저 저장된 데이터를 삭제하겠습니까? (yes : 실행) ");
            str1 = sc.nextLine();
            if (str1.equals("yes"))
            {
                cal.removeResult();
                System.out.println("전체 결과 목록 : " + cal.getArrayList());
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            str1 = sc.nextLine();
            if (str1.equals("exit"))
                break;
        }
    }
}
