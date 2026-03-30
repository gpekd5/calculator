package com.example.calculator;

public enum OperatorType {
    ADD('+') {
        @Override
        public double calculate(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBTRACT('-'){
        @Override
        public double calculate(double num1, double num2){
            return num1 - num2;
        }
    },
    MULTIPLY('*'){
        @Override
        public double calculate(double num1, double num2){
            return num1 * num2;
        }
    },
    DIVIDE('/'){
        @Override
        public double calculate(double num1, double num2){
            if (num2 == 0)
            {
                throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
            return  num1 / num2;
        }
    };

    private final char type;

    OperatorType(char type){
        this.type = type;
    }

    public abstract double calculate(double num1, double num2);

   /* public static OperatorType searchType(char type){
        switch (type){
            case '+':
                return OperatorType.ADD;
            case '-':
                return OperatorType.SUBTRACT;
            case '*':
                return OperatorType.MULTIPLY;
            case '/':
                return OperatorType.DIVIDE;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");

        }
    }*/

    public static OperatorType searchType(char type){
        return switch(type){
            case '+' -> ADD;
            case '-' -> SUBTRACT;
            case '*' -> MULTIPLY;
            case '/' -> DIVIDE;
            default -> throw new IllegalArgumentException("잘못된 연산자입니다.");
        };
    }
}

