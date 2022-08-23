import java.util.Arrays;
import java.util.Random;

public class main {

    public static void main(String[] args) {

        int[] a = {7, 7, 9, 3, 2, 7, 7};
        int n = a.length;

        //System.out.println(LinearSVD(a, n));
        //System.out.println(LoglinearSVD(a, n));
        //System.out.println(QuadraticSVD(a, n));

        System.out.println("-Algorithm 1 Test-");
        QuadraticTest();

        System.out.println("-Algorithm 2 Test-");
        LoglinearTest();

        System.out.println("-Algorithm 3 Test-");
        LinearTest();

    }

    public static int LinearSVD(int[] a, int n){

        //Finds candidate for svd.
        int index = 0;
        int count = 1;
        for(int i = 1; i < n; i++){

            if(a[index] == a[i]){

                count++;
            }
            else{

                count--;
            }
            if(count == 0){

                count = 1;
                index = i;
            }

        }
        int svd_candidate = a[index];

        //Checks if svd candidate does occur > n/2 times.
        count = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == svd_candidate){

                count++;
            }
        }
        if(count > n/2){

            return svd_candidate;
        }
        return 0;

    }

    public static int LoglinearSVD(int[] a, int n) {

        Arrays.sort(a);
        int i = 0;
        int count = 1;
        while(i < n-1){

            if(a[i] == a[i+1]){
                count++;
                if(count > n/2){
                    return a[i];
                }
            }
            else{
                count = 1;
            }
            i++;

        }
        return 0;
    }

    public static int QuadraticSVD(int[] a, int n){

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){

                if(a[i] == a[j]){

                    count++;
                    if(count > n/2){

                        return a[i];
                    }
                }
            }

        }
        return 0;
    }

    public static void LinearTest(){

        for(int i = 1; i <= 3000; i = i + 10){ //Arrays of size 1 to 3000 in steps of 10.

            long total_time = 0;

            //Generates arrays for testing.
            int[] a = new int[i];
            Random rd = new Random(System.nanoTime());
            for(int j = 0; j < a.length; j++){

                a[j] = rd.nextInt((8 - 1) + 1) + 1; //Fills with a random number between 1 and 8, inclusive.
            }

            for(int j = 0; j < 1000; j++){ //Take 500 readings then calculate average for each value of n.

                long start = System.nanoTime();
                LinearSVD(a, a.length);
                long finish = System.nanoTime();
                total_time = total_time + (finish - start);
            }

            long average_time = total_time / 1000;
            //System.out.println(i);
            //System.out.println(average_time);
            System.out.println(i + " " + average_time);

        }

    }

    public static void LoglinearTest(){

        for(int i = 1; i <= 3000; i = i + 10){ //Arrays of size 1 to 3000 in steps of 10.

            long total_time = 0;

            //Generates arrays for testing.
            int[] a = new int[i];
            Random rd = new Random(System.nanoTime());
            for(int j = 0; j < a.length; j++){

                a[j] = rd.nextInt((8 - 1) + 1) + 1; //Fills with a random number between 1 and 8, inclusive.
            }

            for(int j = 0; j < 1000; j++){ //Take 500 readings then calculate average for each value of n.

                long start = System.nanoTime();
                LoglinearSVD(a, a.length);
                long finish = System.nanoTime();
                total_time = total_time + (finish - start);
            }

            long average_time = total_time / 1000;
            //System.out.println(i);
            //System.out.println(average_time);
            System.out.println(i + " " + average_time);

        }

    }

    public static void QuadraticTest(){

        for(int i = 1; i <= 3000; i = i + 10){ //Arrays of size 1 to 3000 in steps of 10.

            long total_time = 0;

            //Generates arrays for testing.
            int[] a = new int[i];
            Random rd = new Random(System.nanoTime());
            for(int j = 0; j < a.length; j++){

                a[j] = rd.nextInt((8 - 1) + 1) + 1; //Fills with a random number between 1 and 8, inclusive.
            }

            for(int j = 0; j < 1000; j++){ //Take 500 readings then calculate average for each value of n.

                long start = System.nanoTime();
                QuadraticSVD(a, a.length);
                long finish = System.nanoTime();
                total_time = total_time + (finish - start);
            }

            long average_time = total_time / 500;
            //System.out.println(i);
            //System.out.println(average_time);
            System.out.println(i + " " + average_time);

        }
    }


}
