package data;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        boolean ugly = isUgly(100);
        System.out.println(ugly);
    }

    public static boolean isUgly(int num){
        if(num>0){
           if(num%2==0){
               return  isUgly(num/=2);
           }

            if(num%3==0){
                return  isUgly(num/=3);
            }

            if(num%5==0){
                return  isUgly(num/=5);
            }
        }
        return num==1;
    }
}
