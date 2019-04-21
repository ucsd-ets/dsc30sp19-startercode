import java.util.ArrayList;

public class Sorts<T extends Comparable<? super T>> {

    public void InsertionSort(ArrayList<T> list, int start, int end) {

        for (int i = start + 1; i <= end; i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }


    public void MergeSort(ArrayList<T> list, int start, int end) {

        if (start < end)
        {
            int mid = start + (end - start) / 2;
            MergeSort(list, start, mid);
            MergeSort(list , mid + 1, end);

            merge(list, start, mid, end);
        }
    }


    private void merge(ArrayList<T> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<T> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            }
            else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    public void QuickSort(ArrayList<T> list, int start, int end) {

        if (start < end)
        {
            int p = partition(list, start, end);

            QuickSort(list, start, p);
            QuickSort(list, p + 1, end);
        }

    }

    private int partition(ArrayList<T> arr, int l, int h) {

        T pivot = arr.get(l + (h - l) / 2);

        while (true) {
            while (arr.get(l).compareTo(pivot) < 0) l++;
            while (arr.get(h).compareTo(pivot) > 0) h--;
            if (l >= h) break;
            else {
                T temp = arr.get(l);
                arr.set(l, arr.get(h));
                arr.set(h, temp);
                l++;
                h--;
            }
        }

        return h;
    }

}
