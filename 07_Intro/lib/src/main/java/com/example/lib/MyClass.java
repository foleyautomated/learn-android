package com.example.lib;

public class MyClass {
//    Comment one line using ctrl + /
    /*
    * Comment
    * multiple
    * lines
    * using
    * ctrl + shift + /
    *
    *
    * */

    public static void main(String[] args) {
        byte mybite = 1;
        short y = 7777;
        long l = 4312431431223L;

        //32 bit
        float pi = 3.14F;
        //64 bit (more than float)
        double pi2 = 3.14159F;

        boolean isRaining = true;

        char oneSingleSymbol = 'A'; //
        char myNumber = '7';
        char mySymbol = '$';
        char newLine = '\n';
        char tab = '\t';

        //Casting
        //Implicit (from smaller data type to larger (by storage) data type)
        int numInt = 10;
        double numDouble = numInt; //Now, it's 10.00

        //Explicit (Larger to small, or when there is potential for data loss)
        double pi3 = 3.14;
        int intPi = (int)pi3;

        //Casting between types
        int myInt2 = 5;
        char myChar2 = (char) (myInt2 + 'A');
        System.out.print("This will print the ASCI Table value of A + myInt2 and then go back to the table, resulting in F: " + myChar2);

        //Operators in Java
        //Arithmetic + - * / %
        //Logical && || !

        //strings
        String myString = "David";
        System.out.print(myString.length());

        //Switch Statement
        int dayOfWeek = 1;
        switch(dayOfWeek) {
            case 1:
                System.out.print(1);
                break;
            case 2:
                System.out.print(2);
                break;
            default:
                System.out.print(3);

        }

        //Break and Continue Key Words

        //Break = exit the loop
        //Continue = restart the loop at the next iteration

        int[] MyArray = {1, 2, 3, 4, 5};
        for(int ele : MyArray) {
            System.out.println(ele);
        }

        int[][] multidimensionalArray= {{1,2},{3,4} };

    }

}