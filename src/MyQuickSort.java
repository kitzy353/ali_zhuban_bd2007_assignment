public class MyQuickSort<T extends Comparable<? super T>>{
    public void quicksort(T[] array){
        quicksort(array,0,array.length-1);
    }

    private void quicksort(T[] array, int start, int end){
        if(start < end){
            int pi = partition(array, start, end);
            quicksort(array,start,pi );
            quicksort(array, pi+1, end);
        }
    }

    private int partition(T[] array, int start, int end){
        int pivot = (start + end) / 2;
        T pivotElement =  array[pivot];
        start--;
        end++;

        while(true){
            do{
                start++;
            }while(array[start].compareTo(pivotElement)<0);
            do{
                end--;
            }while(array[end].compareTo(pivotElement)>0);

            if(start >= end){
                return end;
            }
            swap(array, start, end);

        }
    }

    private void swap(T[] array,int start, int end){
        T temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public void display(T[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
