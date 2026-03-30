package com.example.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        double num1 = 0.0;
        double num2 = 0.0;
        double result = 0.0;

        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> arithmeticCal = new ArithmeticCalculator<Double>();

        while (true) {
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요 : ");

                if (!sc.hasNextDouble()) {
                    System.out.println("숫자를 입력하세요!!");
                    sc.next();
                    continue;
                }
                num1 = sc.nextDouble();
                break;
            }


            while (true) {
                System.out.print("두 번째 숫자를 입력하세요 : ");

                if (!sc.hasNextDouble()) {
                    System.out.println("숫자를 입력하세요!!");
                    sc.next();
                    continue;
                }
                num2 = sc.nextDouble();
                break;
            }

            while (true) {
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /) : ");

                String lengthCheck = sc.next();

                if (lengthCheck.length() != 1) {
                    System.out.println("연산자는 한 글자만 입력하세요.");
                    continue;
                }

                char str = lengthCheck.charAt(0);

                //enum에서 throw로 "에러 메세지"를 던지고 catch로 받아서 출력
                try {
                    OperatorType type = OperatorType.searchType(str);
                    result = type.calculate(num1, num2);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("결과 : " + result);
            System.out.println("전체 결과 목록 : " + arithmeticCal.getArrayList());

            System.out.print("저장된 리스트를 강제로 [1,2,3,4,5]로 만드시겠습니까? (yes : 실햄) ");
            sc.nextLine();
            String str1 = sc.nextLine();
            if (str1.equals("yes")) {
                ArrayList<Double> results = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
                arithmeticCal.setArrayList(results);
                System.out.println("전체 결과 목록 : " + arithmeticCal.getArrayList());
            }

            System.out.print("가장 먼저 저장된 데이터를 삭제하겠습니까? (yes : 실행) ");
            str1 = sc.nextLine();
            if (str1.equals("yes")) {
                arithmeticCal.removeResult();
                System.out.println("전체 결과 목록 : " + arithmeticCal.getArrayList());
            }

            System.out.print("저장된 연산 결과 중 입력받은 값보다 큰 결과값을 출력하겠습니까? (숫자 입력 시 실행) ");
            if ((sc.hasNextDouble())) {
                double filter = sc.nextDouble();
                System.out.println("전체 결과 목록 : " + arithmeticCal.getArrayList());
                arithmeticCal.filter(filter);
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            sc.nextLine();
            str1 = sc.nextLine();
            if (str1.equals("exit"))
                break;
        }
    }
}
