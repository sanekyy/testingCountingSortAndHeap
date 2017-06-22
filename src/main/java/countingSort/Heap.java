package countingSort;


import java.util.Scanner;

/**
 * Created by ihb on 21.06.17.
 */
public class Heap {
    private long A[];
    private int size = 0;

    private Heap(int capacity) {
        A = new long[capacity];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;

        System.out.println("Введите количество команд:");
        while (true) {
            try {
                N = Integer.valueOf(in.next());
                if (N <= 0 || N > 1000) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Некорректный ввод, повторите ввод");
            }
        }
        int command;
        int number;
        Heap A = new Heap(N);

        for (int i = 0; i < N; i++) {
            System.out.println("Введите команду и параметры:");
            while (true) {
                try {
                    command = Integer.valueOf(in.next());
                    if (command != 0 && command != 1) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Некорректный ввод, повторите ввод");
                }
            }
            switch (command) {
                case 0:
                    while (true) {
                        try {
                            number = Integer.valueOf(in.next());
                            if (number < 0 || number > 1000) {
                                throw new Exception("");
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Некорректный ввод, повторите ввод");
                        }
                    }
                    A.Insert(number);
                    break;
                case 1:
                    try {
                        System.out.println("Извлечённый элемент кучи:");
                        A.Extract();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Куча пустая");
                    }
            }
        }
    }

    private void Insert(long num) {
        size++;
        A[size - 1] = num;
        SiftUp(size - 1);
    }

    private void Extract() {
        if(size == 0)
            throw new ArrayIndexOutOfBoundsException();
        System.out.println(A[0]);
        A[0] = A[--size];
        SiftDown(0);
    }

    private void SiftUp(int i) {
        while (A[i] > A[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }

    }

    private void SiftDown(int i) {
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if (right < size && A[right] > A[left])
                j = right;
            if (A[i] >= A[j])
                break;
            swap(i, j);
            i = j;
        }
    }

    private void swap(int i, int j) {
        long temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }
}
