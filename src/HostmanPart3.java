/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Basket
 */
//Part 3.1 - "Simple program"
public class HostmanPart3 {

    public static void main(String[] args) {
        System.out.println("Basket from Last Move Crew");
//Part 3.2 - "Comment"

// Однострочный комментарий
/* Многострочный 
      комментарий */
//Part 3.4 Типы данных
// Целочисленные
        // Максимальные значения
        byte b = 127; // 1 байт 2^(8-1) (-128..127)
        short sint = 32767; // 2 байта 2^(16-1) (-32768..32767)
        int i = 2147483647; // 4 байт 2^(32-1) (-2147483648..2147483647) 
        long lint = 9223372036854775807L; // 8 байт (2^61) (-9223372036854775808..9223372036854775807)
        System.out.println("Max byte=" + b);
        System.out.println("Max short=" + sint);
        System.out.println("Max int=" + i);
        System.out.println("Max long=" + lint);
        // Минимальные значения       
        b = -128;
        sint = -32768;
        i = -2147483648;
        lint = -9223372036854775808L;
        System.out.println("Min byte=" + b);
        System.out.println("Min short=" + sint);
        System.out.println("Min int=" + i);
        System.out.println("Min long=" + lint);

/* C плавающей точкой
   Все операции над числами с плавающей точкой производятся по стандарту IEEE 754.*/ 
        // Максимальные значения
        float f = 340282349999999999999999999999999999999f; // 4 байта  ±3,40282347E+38F (6-7 значащих чисел)
        double d = 179769313486231579000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d;// ±1,7976931348623157E+308F (15 значащих десятичных цифр) 
        System.out.println("Max float=" + f);
        System.out.println("Max double=" + d);
        // Минимальные значения
        f = -340282349999999999999999999999999999999f;
        d = -179769313486231579000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d;
        System.out.println("Min float=" + f);
        System.out.println("Min double=" + d);
        f = 1f;// целые типа float числа можно писать без суффикса
        f = 1.1f;// дробные числа типа float нужно писатьс суффиксом F(или f)
        d = 1;
        d = 1D; // целые и дпробные числа типа double можно писать как с суффиксом D(или d), так и без него
        System.out.println(f / 3);
        System.out.println(d / 3);
        // в научной интерпритации
        f = 11.1e2f;
        System.out.println(f * 1.1);
//Константы для неопределённых чисел Float b Double      
        d = 0;
        f = 0;
        if (Double.isNaN(d / 0)) {
            System.out.println("Double isNaN");
        };
        if (Float.isNaN(f / 0)) {
            System.out.println("Float isNaN");
        }
//Все операции над числами с плавающей точкой производятся по стандарту IEEE 754. 
        System.out.println(Float.BYTES);
        System.out.println(Float.MAX_EXPONENT);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_EXPONENT);
        System.out.println(Float.MIN_NORMAL);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.SIZE);
        System.out.println(Float.TYPE);

        System.out.println(Double.BYTES);
        System.out.println(Double.MAX_EXPONENT);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_EXPONENT);
        System.out.println(Double.MIN_NORMAL);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.SIZE);
        System.out.println(Double.TYPE);
      
        System.out.println(Double.BYTES);
        System.out.println(Double.MAX_EXPONENT);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_EXPONENT);
        System.out.println(Double.MIN_NORMAL);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.SIZE);
        System.out.println(Double.TYPE);
    }
;

}
