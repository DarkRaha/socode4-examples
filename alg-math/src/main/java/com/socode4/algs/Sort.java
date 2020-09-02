package com.socode4.algs;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Sort {


    public static void swapInt(@NotNull int[] src, int ind1, int ind2) {
        int t = src[ind1];
        src[ind1] = src[ind2];
        src[ind2] = t;
    }

    public static <T> void swapObj(@NotNull T[] src, int ind1, int ind2) {
        T t = src[ind1];
        src[ind1] = src[ind2];
        src[ind2] = t;
    }

    //----------------------------------------------------------------------------------------
    // bubble sort
    public static void bubble(int[] src, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        int i, j;

        for (i = indStart + 1; i < indEnd; i++) {
            for (j = indStart + 1; j < indEnd; j++)
                if (src[j - 1] > src[j]) {
                    swapInt(src, j, j - 1);
                }
        }
    }

    public static <T> void bubble(T[] src, Comparator<T> cmpr, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        int i, j;

        for (i = indStart + 1; i < indEnd; i++) {
            for (j = indStart + 1; j < indEnd; j++)
                if (cmpr.compare(src[j - 1], src[j]) > 0) {
                    swapObj(src, j, j - 1);
                }
        }
    }


    public static <T> void bubble(List<T> src, Comparator<T> cmpr, int indStart, int indEnd) {
        if (src.size() == 0 || indStart == indEnd) {
            return;
        }

        int i, j;

        for (i = indStart + 1; i < indEnd; i++) {
            for (j = indStart + 1; j < indEnd; j++)
                if (cmpr.compare(src.get(j - 1), src.get(j)) > 0) {
                    Collections.swap(src, j, j - 1);
                }
        }
    }

    public static <T extends Comparable<? super T>> void bubble(List<T> src, int indStart, int indEnd) {
        if (src.size() == 0 || indStart == indEnd) {
            return;
        }

        int i, j;

        for (i = indStart + 1; i < indEnd; i++) {
            for (j = indStart + 1; j < indEnd; j++)
                if (src.get(j - 1).compareTo(src.get(j)) > 0) {
                    Collections.swap(src, j, j - 1);
                }
        }
    }

    public static <T extends Comparable<? super T>> void bubble(T[] src, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        int i, j;

        for (i = indStart + 1; i < indEnd; i++) {
            for (j = indStart + 1; j < indEnd; j++)
                if (src[j - 1].compareTo(src[j]) > 0) {
                    swapObj(src, j, j - 1);
                }
        }
    }

    public static <T> void bubble(T[] src, Comparator<T> cmpr) {
        bubble(src, cmpr, 0, src.length);
    }

    public static <T extends Comparable<? super T>> void bubble(T[] src) {
        bubble(src, 0, src.length);
    }

    public static <T extends Comparable<? super T>> void bubble(List<T> src) {
        bubble(src, 0, src.size());
    }

    public static <T> void bubble(List<T> src, Comparator<T> cmpr) {
        bubble(src, cmpr, 0, src.size());
    }

    public static void bubble(int[] src) {
        bubble(src, 0, src.length);
    }

    //----------------------------------------------------------------------------------------
    // quick sort
    public static void quick(int[] src, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;
        // compute index of middle element
        int m = src[(indEnd + indStart) / 2];
        int i = indStart, j = indEnd;

        do {
            // search element > m from begin
            while (src[i] < m && i < indEnd) i++;

            // search element <= m from end
            while (m < src[j] && j > indStart) j--;

            // if elements on different side
            if (i <= j)
                swapInt(src, i++, j--);
        } while (i <= j);

        if (indStart < j)
            quick(src, indStart, j + 1); // sort left side
        if (i < indEnd)
            quick(src, i, indEnd + 1); // sort right side
    }

    public static <T> void quick(T[] src, Comparator<T> cmpr, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;
        // compute index of middle element
        T m = src[(indEnd + indStart) / 2];
        int i = indStart, j = indEnd;

        do {
            // search element > m from begin
            while (cmpr.compare(src[i], m) < 0 && i < indEnd) i++;

            // search element <= m from end
            while (cmpr.compare(m, src[j]) < 0 && j > indStart) j--;

            // if elements on different side
            if (i <= j)
                swapObj(src, i++, j--);
        } while (i <= j);

        if (indStart < j)
            quick(src, cmpr, indStart, j + 1); // sort left side
        if (i < indEnd)
            quick(src, cmpr, i, indEnd + 1); // sort right side
    }

    public static <T extends Comparable<? super T>> void quick(T[] src, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;
        // compute index of middle element
        T m = src[(indEnd + indStart) / 2];
        int i = indStart, j = indEnd;

        do {
            // search element > m from begin
            while (src[i].compareTo(m) < 0 && i < indEnd) i++;

            // search element <= m from end
            while (m.compareTo(src[j]) < 0 && j > indStart) j--;

            // if elements on different side
            if (i <= j)
                swapObj(src, i++, j--);
        } while (i <= j);

        if (indStart < j)
            quick(src, indStart, j + 1); // sort left side
        if (i < indEnd)
            quick(src, i, indEnd + 1); // sort right side
    }


    public static <T> void quick(List<T> src, Comparator<T> cmpr, int indStart, int indEnd) {
        if (src.size() == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;
        // compute index of middle element
        T m = src.get((indEnd + indStart) / 2);
        int i = indStart, j = indEnd;

        do {
            // search element > m from begin
            while (cmpr.compare(src.get(i), m) < 0 && i < indEnd) i++;

            // search element <= m from end
            while (cmpr.compare(m, src.get(j)) < 0 && j > indStart) j--;

            // if elements on different side
            if (i <= j) Collections.swap(src, i++, j--);
        } while (i <= j);

        if (indStart < j)
            quick(src, cmpr, indStart, j + 1); // sort left side
        if (i < indEnd)
            quick(src, cmpr, i, indEnd + 1); // sort right side
    }

    public static <T extends Comparable<? super T>> void quick(List<T> src, int indStart, int indEnd) {
        if (src.size() == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;
        // compute index of middle element
        T m = src.get((indEnd + indStart) / 2);
        int i = indStart, j = indEnd;

        do {
            // search element > m from begin
            while (src.get(i).compareTo(m) < 0 && i < indEnd) i++;

            // search element <= m from end
            while (m.compareTo(src.get(j)) < 0 && j > indStart) j--;

            // if elements on different side
            if (i <= j)
                Collections.swap(src, i++, j--);

        } while (i <= j);

        if (indStart < j)
            quick(src, indStart, j + 1); // sort left side
        if (i < indEnd)
            quick(src, i, indEnd + 1); // sort right side
    }


    public static void quick(int[] src) {
        quick(src, 0, src.length);
    }

    public static <T> void quick(T[] src, Comparator<T> cmpr) {
        quick(src, cmpr, 0, src.length);
    }

    public static <T extends Comparable<? super T>> void quick(T[] src) {
        quick(src, 0, src.length);
    }

    public static <T> void quick(List<T> src, Comparator<T> cmpr) {
        quick(src, cmpr, 0, src.size());
    }

    public static <T extends Comparable<? super T>> void quick(List<T> src) {
        quick(src, 0, src.size());
    }

    //----------------------------------------------------------------------------------------
    // selection sort

    public static void selection(int[] src, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart; i < indEnd; ++i) {

            int indMin = i; // let the min is the first element

            // search the minimum element in an unsorted part
            for (int j = i + 1; j <= indEnd; ++j)
                if (src[j] < src[indMin]) {
                    indMin = j;
                }

            swapInt(src, i, indMin);
        }
    }


    public static <T> void selection(T[] src, Comparator<T> cmpr, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart; i < indEnd; ++i) {

            int indMin = i;

            for (int j = i + 1; j <= indEnd; ++j)
                if (cmpr.compare(src[indMin], src[j]) > 0) {
                    indMin = j;
                }

            swapObj(src, i, indMin);
        }
    }

    public static <T extends Comparable<? super T>> void selection(T[] src, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart; i < indEnd; ++i) {
            int indMin = i;

            for (int j = i + 1; j <= indEnd; ++j)
                if (src[indMin].compareTo(src[j]) > 0) {
                    indMin = j;
                }

            swapObj(src, i, indMin);
        }
    }

    public static <T> void selection(List<T> src, Comparator<T> cmpr, int indStart, int indEnd) {
        if (src.size() == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart; i < indEnd; ++i) {
            int indMin = i;

            for (int j = i + 1; j <= indEnd; ++j)
                if (cmpr.compare(src.get(indMin), src.get(j)) > 0) {
                    indMin = j;
                }

            Collections.swap(src, i, indMin);
        }

    }

    public static <T extends Comparable<? super T>> void selection(List<T> src, int indStart, int indEnd) {
        if (src.size() == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart; i < indEnd; ++i) {
            int indMin = i;

            for (int j = i + 1; j <= indEnd; ++j)
                if (src.get(indMin).compareTo(src.get(j)) > 0) {
                    indMin = j;
                }

            Collections.swap(src, indMin, i);
        }
    }

    public static void selection(int[] src) {
        selection(src, 0, src.length);
    }

    public static <T> void selection(T[] src, Comparator<T> cmpr) {
        selection(src, cmpr, 0, src.length);
    }

    public static <T extends Comparable<? super T>> void selection(T[] src) {
        selection(src, 0, src.length);
    }

    public static <T> void selection(List<T> src, Comparator<T> cmpr) {
        selection(src, cmpr, 0, src.size());
    }

    public static <T extends Comparable<? super T>> void selection(List<T> src) {
        selection(src, 0, src.size());
    }

    //----------------------------------------------------------------------------------------
    // insertion sort

    public static void insertion(int[] src, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart + 1; i <= indEnd; ++i) {
            int j;
            int t = src[i];

            for (j = i - 1; j >= indStart && t < src[j]; --j)
                src[j + 1] = src[j];

            src[j + 1] = t;
        }
    }


    public static <T> void insertion(T[] src, Comparator<T> cmpr, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart + 1; i <= indEnd; ++i) {
            int j;
            T t = src[i];

            for (j = i - 1; j >= indStart && cmpr.compare(t, src[j]) < 0; --j)
                src[j + 1] = src[j];

            src[j + 1] = t;
        }
    }

    public static <T extends Comparable<? super T>> void insertion(T[] src, int indStart, int indEnd) {
        if (src.length == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart + 1; i <= indEnd; ++i) {
            int j;
            T t = src[i];

            for (j = i - 1; j >= indStart && t.compareTo(src[j]) < 0; --j)
                src[j + 1] = src[j];

            src[j + 1] = t;
        }
    }

    public static <T> void insertion(List<T> src, Comparator<T> cmpr, int indStart, int indEnd) {
        if (src.size() == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;

        for (int i = indStart + 1; i <= indEnd; ++i) {
            int j;
            T t = src.get(i);

            for (j = i - 1; j >= indStart && cmpr.compare(t, src.get(j)) < 0; --j)
                src.set(j + 1, src.get(j));

            src.set(j + 1, t);
        }
    }

    public static <T extends Comparable<? super T>> void insertion(List<T> src, int indStart, int indEnd) {
        if (src.size() == 0 || indStart == indEnd) {
            return;
        }

        --indEnd;
        for (int i = indStart + 1; i <= indEnd; ++i) {
            int j;
            T t = src.get(i);

            for (j = i - 1; j >= indStart && t.compareTo(src.get(j)) < 0; --j)
                src.set(j + 1, src.get(j));

            src.set(j + 1, t);
        }
    }


    public static void insertion(int[] src) {
        insertion(src, 0, src.length);
    }

    public static <T> void insertion(T[] src, Comparator<T> cmpr) {
        insertion(src, cmpr, 0, src.length);
    }

    public static <T extends Comparable<? super T>> void insertion(T[] src) {
        insertion(src, 0, src.length);
    }

    public static <T> void insertion(List<T> src, Comparator<T> cmpr) {
        insertion(src, cmpr, 0, src.size());
    }

    public static <T extends Comparable<? super T>> void insertion(List<T> src) {
        insertion(src, 0, src.size());
    }

    //----------------------------------------------------------------------------------------
    // Shell sort
    // N/2, N/4, …, 1 sequence is used

    public static void shell(int[] src) {
        if (src.length == 0) {
            return;
        }

        int n = src.length;
        int t;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                t = src[i];
                int j = i;
                while (j >= gap && src[j - gap] > t) {
                    src[j] = src[j - gap];
                    j -= gap;
                }
                src[j] = t;
            }
        }
    }

    public static <T> void shell(T[] src, Comparator<T> cmpr) {
        if (src.length == 0) {
            return;
        }

        int n = src.length;
        T t;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                t = src[i];
                int j = i;
                while (j >= gap && cmpr.compare(src[j - gap], t) > 0) {
                    src[j] = src[j - gap];
                    j -= gap;
                }
                src[j] = t;
            }
        }
    }

    public static <T extends Comparable<? super T>> void shell(T[] src) {
        if (src.length == 0) {
            return;
        }

        int n = src.length;
        T t;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                t = src[i];
                int j = i;
                while (j >= gap && src[j - gap].compareTo(t) > 0) {
                    src[j] = src[j - gap];
                    j -= gap;
                }
                src[j] = t;
            }
        }
    }


    public static <T> void shell(List<T> src, Comparator<T> cmpr) {
        if (src.size() == 0) {
            return;
        }

        int n = src.size();
        T t;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                t = src.get(i);
                int j = i;
                while (j >= gap && cmpr.compare(src.get(j - gap), t) > 0) {
                    src.set(j, src.get(j - gap));
                    j -= gap;
                }
                src.set(j, t);
            }
        }
    }

    public static <T extends Comparable<? super T>> void shell(List<T> src) {
        if (src.size() == 0) {
            return;
        }

        int n = src.size();
        T t;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                t = src.get(i);
                int j = i;
                while (j >= gap && src.get(j - gap).compareTo(t) > 0) {
                    src.set(j, src.get(j - gap));
                    j -= gap;
                }
                src.set(j, t);
            }
        }
    }
}
