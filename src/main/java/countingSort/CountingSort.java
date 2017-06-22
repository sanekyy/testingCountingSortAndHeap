package countingSort;


import java.util.Scanner;

/**
 * Created by ihb on 19.03.17.
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[100001];
        int n = 0;
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println("Введите количество чисел (от 0 до 10000):");


        while(true){
            try{
                n = Integer.valueOf(in.next());
                if(n<1){
                    throw new Exception();
                }
                break;
            } catch (Exception e){
                System.out.println("Некорректный ввод, повторите ввод");
            }
        }

        System.out.println("Введите " + n + " чисел (от 0 до 100000):");

        for(int i=0; i<n; i++) {
            while(true){
                try{
                    arr[Integer.valueOf(in.next())]++;
                    break;
                } catch (Exception e){
                    System.out.println("Некорректный ввод, повторите ввод");
                }
            }

        }

        System.out.println("Числа в отсортированном порядке:");

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i]; j++){
                System.out.print(i+" ");
            }
        }
    }

}

