package com.example.alexhinkle.shuntingyard;

import java.util.Arrays;

/**
 * Created by AlexHinkle on 4/25/16.
 */
public class BloomFilter
{


    public static String convertBinary(int num){
        String answer = "";
        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--)
        {
            answer = answer + binary[i];

        }

        return answer;
    }

    public static void bloomFilter( int one, int two, int three)
    {
        int bitArray[] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        String oneBinary = convertBinary(one);
        System.out.println(oneBinary);

        String twoBinary = convertBinary(two);
        System.out.println(twoBinary);
        String threeBinary = convertBinary(three);
        System.out.println(threeBinary);


        String oneBinaryEven = splitBinaryEven(oneBinary);
        System.out.println(oneBinaryEven + " *****");
        String oneBinaryOdd = splitBinaryOdd(oneBinary);
        System.out.println(oneBinaryOdd);
        String twoBinaryEven = splitBinaryEven(twoBinary);
        System.out.println(twoBinaryEven);
        String twoBinaryOdd = splitBinaryOdd(twoBinary);
        System.out.println(twoBinaryOdd);
        String threeBinaryEven = splitBinaryEven(threeBinary);
        System.out.println(threeBinaryEven);
        String threeBinaryOdd = splitBinaryOdd(threeBinary);
        System.out.println(threeBinaryOdd);


        int decimalOneOne = integerfrmbinary(oneBinaryEven)% 18;
        System.out.println(decimalOneOne);
        int decimalOneTwo = integerfrmbinary(oneBinaryOdd)%18;
        System.out.println(decimalOneTwo);
        int decimalTwoOne = integerfrmbinary(twoBinaryEven)%18;
        System.out.println(decimalTwoOne);
        int decimalTwoTwo = integerfrmbinary(twoBinaryOdd)%18;
        System.out.println(decimalTwoTwo);
        int decimalThreeOne = integerfrmbinary(threeBinaryEven)%18;
        System.out.println(decimalThreeOne);
        int decimalThreeTwo = integerfrmbinary(threeBinaryOdd)%18;
        System.out.println(decimalThreeTwo);

        bitArray[decimalOneOne] = 1;
        bitArray[decimalOneTwo] = 1;
        bitArray[decimalTwoOne] = 1;
        bitArray[decimalTwoTwo] = 1;
        bitArray[decimalThreeOne] = 1;
        bitArray[decimalThreeTwo]= 1;
        System.out.println(Arrays.toString(bitArray));





    }
    public static String splitBinaryEven(String binary)
    {

        String evenBinary = "";

     for(int i = 0; i < binary.length(); i+=2)
     {


             evenBinary = evenBinary + binary.charAt(i);



     }
        return evenBinary;
    }
    public static String splitBinaryOdd(String binary)
    {

        String oddBinary = "";



        for(int i = 1; i < binary.length(); i+=2)
        {


               oddBinary = oddBinary + binary.charAt(i);




        }
        return oddBinary;
    }
    public static int integerfrmbinary(String str){
        double j=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== '1'){
                j=j+ Math.pow(2,str.length()-1-i);
            }

        }

        return (int) j;

    }




}
