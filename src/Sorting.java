public class Sorting
{
    public static void selectionSort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++)
            {
                if (array[j] < min)
                {
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    public static void insertionSort(int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j])
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }

    public static void bubbleSort(int[] array)
    {
        boolean sorted = false;
        int temp;
        while(!sorted)
        {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i] > array[i+1])
                {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    static int partition(int[] array, int begin, int end)
    {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++)
        {
            if (array[i] < array[pivot])
            {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quicksort(int[] array, int begin, int end)
    {
        if (end <= begin)
            return;
        int pivot = partition(array, begin, end);
        quicksort(array, begin, pivot-1);
        quicksort(array, pivot+1, end);
    }
}
