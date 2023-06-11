package com.example.preparation.thread;


public class PrintEvenAndOdd {
    int count = 1;
    static int N;
    public static void main(String args[]){
        N = 15;
        PrintEvenAndOdd printEvenAndOdd =  new PrintEvenAndOdd();

        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                System.out.println("inside thread 1");
                printEvenAndOdd.printEvenNumber();

            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                System.out.println("inside thread 2");
                printEvenAndOdd.printOddNumber();
            }
        });

        t2.start();
        t1.start();
    }

    private void printOddNumber() {
        synchronized (this) {
            while (count < N) {
                if (count % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.print(" thread 1 ----" + count);
                count++;
                notify();
            }
        }
    }

    private void printEvenNumber() {
        synchronized (this) {
            while (count < N) {
                if (count % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.print(" thread 2-----" + count);
                count++;
                notify();
            }
        }
    }
}
