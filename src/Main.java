import com.sun.jdi.request.DuplicateRequestException;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Main
{
    public static int SIZE = Integer.MAX_VALUE/10000;
    public static int[] array = new int[SIZE];

    public static Instant start;
    public static Instant end;
    public static long durationS;
    public static long durationMs;
    public static long durationNs;

    public static void main(String[] args)
    {
        initializeArray();
        selectionSortTiming();
        insertionSortTiming();
        bubbleSortTiming();
        quicksortTiming();
        javaNativeSortTiming();
    }

    public static void initializeArray()
    {
        Instant start = Instant.now();
        System.out.println("Populating array...");
        Random random = new Random();
        for(int i = 0; i < array.length; i++)
            array[i] = random.nextInt(SIZE);
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        long durationNano = Duration.between(start, end).toNanos();
        System.out.printf("Array populated in %d ms%n", duration);
        System.out.printf("Array populated in %d ns%n", durationNano);
    }

    public static void selectionSortTiming()
    {
        System.out.println("==== Selection sort ====");
        int[] arrayToSort = new int[SIZE];
        System.arraycopy(array, 0, arrayToSort, 0, SIZE);
        start = Instant.now();
        Sorting.selectionSort(arrayToSort);
        end = Instant.now();
        printTiming();
    }

    public static void insertionSortTiming()
    {
        System.out.println("==== Insertion sort ====");
        int[] arrayToSort = new int[SIZE];
        System.arraycopy(array, 0, arrayToSort, 0, SIZE);
        start = Instant.now();
        Sorting.insertionSort(arrayToSort);
        end = Instant.now();
        printTiming();
    }

    public static void bubbleSortTiming()
    {
        System.out.println("==== Bubble sort ====");
        int[] arrayToSort = new int[SIZE];
        System.arraycopy(array, 0, arrayToSort, 0, SIZE);
        start = Instant.now();
        Sorting.bubbleSort(arrayToSort);
        end = Instant.now();
        printTiming();
    }

    public static void quicksortTiming()
    {
        System.out.println("==== Quicksort ====");
        int[] arrayToSort = new int[SIZE];
        System.arraycopy(array, 0, arrayToSort, 0, SIZE);
        start = Instant.now();
        Sorting.quicksort(arrayToSort, 0, SIZE - 1);
        end = Instant.now();
        printTiming();
    }

    public static void javaNativeSortTiming()
    {
        System.out.println("==== Arrays.sort() ====");
        int[] arrayToSort = new int[SIZE];
        System.arraycopy(array, 0, arrayToSort, 0, SIZE - 1);
        start = Instant.now();
        Arrays.sort(arrayToSort);
        end = Instant.now();
        printTiming();
    }

    private static void printTiming()
    {
        durationS = Duration.between(start,end).toSeconds();
        durationMs = Duration.between(start, end).toMillis();
        durationNs = Duration.between(start, end).toNanos();
        System.out.printf("Array sorted in %d s%n", durationS);
        System.out.printf("Array sorted in %d ms%n", durationMs);
        System.out.printf("Array sorted in %d ns%n", durationNs);
    }
}