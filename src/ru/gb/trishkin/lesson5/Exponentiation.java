package ru.gb.trishkin.lesson5;

public class Exponentiation {
    public static void main(String[] args) {
        System.out.println(exponentiation(6, 4));
    }

    private static int exponentiation(int num, int degree) {
        if(num == 0){
            if (degree > 0){
                return 0;
            }
            else{
                throw new IllegalArgumentException("Invalid degree" + degree + "for number = 0");
            }
        }
        if (degree < 0 ){
            throw new IllegalArgumentException("Please insert positive degree");
        }
        if(degree == 0){
            return 1;
        }
        return num * exponentiation(num, degree - 1);
    }
}
