import java.util.Arrays;

public class MyMergeSort<T extends Comparable<? super T>> {
     public void sort(T[] array){
        sort(array,0,array.length-1);
     }

     private void sort(T[] array, int start, int end){
        if(start < end){
            int mid = start +(end - start) / 2;
            sort(array, start, mid);
            sort(array, mid+1, end);
            merge(array, start, mid, end);
        }
     }

     private void merge(T[] array, int start, int mid, int end){
         int size_left = mid - start + 1;
         int size_right = end - mid;
         T[] a = (T[]) new Comparable[size_left];
         T[] b = (T[]) new Comparable[size_right];

         for(int i = 0; i < size_left; i++){
            a[i] = array[start + i];
         }
         for(int i = 0; i < size_right; i++){
            b[i] = array[mid+1+i];
         }

         int l = 0, r = 0;
         int current = start;
         while(l<a.length && r < b.length){
             if(a[l].compareTo(b[r]) > 0){
                 array[current] = b[r];
                 r++;
             }else{
                 array[current] = a[l];
                 l++;
             }
             current++;
         }
         while(l<a.length){
             array[current] = a[l];
             current++;
             l++;
         }
         while(r<b.length){
             array[current] = b[r];
             current++;
             r++;
         }
     }

     public void display(T[] array){
         for(int i = 0; i < array.length; i++){
             System.out.print(array[i]+" ");
         }
     }
}
