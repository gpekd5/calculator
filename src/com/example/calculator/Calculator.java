package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        char str;
        boolean test = false;

        Scanner sc = new Scanner(System.in);

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

                str = sc.next().charAt(0);

                switch (str) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            continue;
                        } else
                        {
                            result = num1 / num2;
                            break;
                        }
                    default:
                    {
                        System.out.println("잘못된 연산자입니다.");
                        //sc.next();
                        continue;
                    }
                }
                break;
            }


            System.out.println("결과 : " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            sc.nextLine();
            String str1 = sc.nextLine();

            if (str1.equals("exit"))
                break;
        }
    }
}
