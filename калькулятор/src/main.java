import  java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

class calculation {

    static  String probel(String exp)
    {

        char exp2 = ' ';



            // Убираем пробелы в начале
        while(exp.charAt(0) == exp2)
        {

            exp = exp.substring(1);


        }
/*
        // Убираем пробелы в конце
        while(exp.charAt(7) == exp2)
        {

            exp = exp.substring(0,exp.length()-1);


        }

*/
            // Убираем пробелы в середине выражение
        for (int i = 1 ; i < exp.length() ; i++) {
            while (exp.charAt(i) == exp2) {

                String rep1 = exp.substring(0, i );
                String rep2 = exp.substring(i + 1, exp.length());

                exp = rep1.concat(rep2);

            }
        }
        return exp;
    }

    // Все что связано с римскими числами    ==================================================================================================
    //  Преобразование арабского числа в римское число
    public static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
            int matches = Int/entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }
    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    static  String[] Rome = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I" };
    static  int[] Arab = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    static  int[] Num = {0,1,2,3,4,5,6,7,8,9};
        // Преобразование римского числа в арабсое число
    public static int RometoArab(String exp) {

        StringBuffer romeNumber = new StringBuffer(exp);

            int arabNumber = 0, i = 0;
// Проверяем переданную строку на наличие символов
            if (romeNumber.length() > 0) {
                while (true) {
                    do {

                        if (Rome[i].length() <= romeNumber.length()) {
                            // Выделяем из строки подстроку и сравниваем со
                            // значением из массива Arab
                            if (Rome[i].equals(romeNumber.substring(0,
                                    Rome[i].length()))) {
                                // После чего прибавляем число соответствующее
                                // индексу элемента римской цифры из массива Arab
                                arabNumber += Arab[i];
                                // и удаляем из строки римскую цифру
                                romeNumber.delete(0, Rome[i].length());
                                if (romeNumber.length() == 0)
                                    return arabNumber;
                            } else
                                break;
                        } else
                            break;
                    } while (true && romeNumber.length() != 0);
                    i++;
                }
            }
            return arabNumber;

        }

    //=======================================================================================================
        // Основная логика программы
     static String pont(String exp)
   {
        char[] arr ={'+','-','/','*'};

       char simval = ' ' ;

        int numSimval=0, a=0 , b=0 ;

        for(int i = 0 ; i<exp.length();i++)
        {
            for(char t : arr)
            {
                if(t == exp.charAt(i))
                {
                   numSimval = i;
                   simval = exp.charAt(i) ;

                }
            }
        }
            //==========================================
        try {
            a = Integer.parseInt(exp.substring(0, numSimval));
            b=Integer.parseInt(exp.substring(numSimval+1, exp.length()));

            exp = cal( a, b, simval);


                  //Integer.parseInt();

            System.out.println(exp);
        }
        catch (Exception e){
            try
            {
                 a= RometoArab(exp.substring(0, numSimval)) ;
                 b= RometoArab(exp.substring(numSimval+1, exp.length())) ;

                exp = cal( a, b, simval);

                exp = RomanNumerals(Integer.parseInt(exp));
                System.out.println(exp);
            }
            catch (Exception e1){
                System.out.println("Ошибка - возможно вы вели не правильный тип , знак или синтаксис  ");
            }
        }
            //==============================================




        return  exp;
    }


    static String cal(int a , int b , char simval)
    {
        int output=0;

        switch (simval)
        {
            case '+':
              output = a + b;

              break;

            case '-':
                output = a - b;

                break;

            case '/':
                output = a / b;

                break;

            case '*':
                output = a * b;

                break;

            default:

        }

        return Integer.toString(output);
    }



    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        // input - Ввод
        String exp = in.nextLine();

        exp =  probel(exp);
        // устранил ошибку маленьких букв ))))
        exp = exp.toUpperCase();
        exp = pont(exp);

        }
}