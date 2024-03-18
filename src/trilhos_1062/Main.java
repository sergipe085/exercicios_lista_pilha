package trilhos_1062;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int tamanho = -1;

        while (tamanho != 0) {
            tamanho = sc.nextInt();
            if (tamanho == 0) {
                break;
            }
            sc.nextLine();

            String trem = "";
            while (true) {
                trem = sc.nextLine();
                if (trem.equals("0")) {
                    break;
                }
                int[] trem_arr  = StringArrToIntArr(trem.split(" "));
    
                if (check(trem_arr)) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
            

            // while (trem_arr.length != tamanho) {
            //     trem = sc.nextLine();
            //     trem_arr  = StringArrToIntArr(trem.split(" "));
            // }
        }
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
           result[i] = Integer.parseInt(s[i]);
        }
        return result;
     }

    public static Boolean check(int[] arr) {
        return check(arr, false) || check(arr, true);
    }

    public static Boolean check(int[] arr, Boolean crescente) {
        Boolean t = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] >= arr[i + 1] && crescente == true) || (arr[i] <= arr[i + 1] && crescente == false)) {
                t = false;
                break;
            }
        }

        return t;
    }

    public static void checDecrescente(int[] arr) {

    }
}
