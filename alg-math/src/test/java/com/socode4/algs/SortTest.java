package com.socode4.algs;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SortTest {

    public int[] getRandomIntArray(int size, int boundRnd) {
        int[] dst = new int[size];

        if (size > 0) {
            Random rnd = new Random();

            for (int i = 0; i < dst.length; ++i) {
                dst[i] = rnd.nextInt(boundRnd);
            }
        }
        return dst;
    }

    public List<Integer> getRandomIntList(int size, int boundRnd) {
        List<Integer> dst = new ArrayList<>(size);

        if (size > 0) {
            Random rnd = new Random();

            for (int i = 0; i < size; ++i) {
                dst.add(rnd.nextInt(boundRnd));
            }
        }
        return dst;
    }


    @Test
    public void swapInt() {
        int[] src = getRandomIntArray(10, 100);

        if (src[2] == src[8]) {
            src[2] = src[8] - 1;
        }

        int el2 = src[2];
        int el8 = src[8];
        Sort.swapInt(src, 2, 8);
        assertTrue(src[8] == el2);
        assertTrue(src[2] == el8);
    }

    @Test
    public void swapObj() {
        Integer[] src = getRandomIntList(10, 100).toArray(new Integer[10]);
        if (src[2].equals(src[8])) {
            src[2] = src[8] - 1;
        }

        Integer el2 = src[2];
        Integer el8 = src[8];
        Sort.swapObj(src, 2, 8);
        assertEquals(src[8], el2);
        assertEquals(src[2], el8);
    }

    @Test
    public void bubbleIntArray() {
        int[] src = getRandomIntArray(10, 100);
        int [] result = Arrays.copyOf(src, 10);
        Sort.bubble(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));

    }

    @Test
    public void bubbleIntegerArray() {
        Integer[] src = getRandomIntList(10, 100).toArray(new Integer[10]);
        Integer[] result = Arrays.copyOf(src, 10);
        Sort.bubble(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }

    @Test
    public void bubbleIntList() {
        List<Integer> src = getRandomIntList(10, 100);
        List<Integer> result = new ArrayList<>(src);
        Sort.bubble(src);
        Collections.sort(result);
        assertTrue(src.equals(result));
    }

    @Test
    public void quickIntArray() {
        int[] src = getRandomIntArray(10, 100);
        int [] result = Arrays.copyOf(src, 10);
        Sort.quick(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }


    @Test
    public void quickIntegerArray() {
        Integer[] src = getRandomIntList(10, 100).toArray(new Integer[10]);
        Integer[] result = Arrays.copyOf(src, 10);
        Sort.quick(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }

    @Test
    public void quickIntList() {
        List<Integer> src = getRandomIntList(10, 100);
        List<Integer> result = new ArrayList<>(src);
        Sort.quick(src);
        Collections.sort(result);
        assertTrue(src.equals(result));
    }

    @Test
    public void selectionIntArray() {
        int[] src = getRandomIntArray(10, 100);
        int [] result = Arrays.copyOf(src, 10);
        Sort.selection(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }

    @Test
    public void selectionIntegerArray() {
        Integer[] src = getRandomIntList(10, 100).toArray(new Integer[10]);
        Integer[] result = Arrays.copyOf(src, 10);
        Sort.selection(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }

    @Test
    public void selectionIntList() {
        List<Integer> src = getRandomIntList(10, 100);
        List<Integer> result = new ArrayList<>(src);
        Sort.selection(src);
        Collections.sort(result);
        assertTrue(src.equals(result));
    }


    @Test
    public void insertionIntArray() {
        int[] src = getRandomIntArray(10, 100);
        int [] result = Arrays.copyOf(src, 10);
        Sort.insertion(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }
    @Test
    public void insertionIntegerArray() {
        Integer[] src = getRandomIntList(10, 100).toArray(new Integer[10]);
        Integer[] result = Arrays.copyOf(src, 10);
        Sort.insertion(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }

    @Test
    public void insertionIntList() {
        List<Integer> src = getRandomIntList(10, 100);
        List<Integer> result = new ArrayList<>(src);
        Sort.insertion(src);
        Collections.sort(result);
        assertTrue(src.equals(result));
    }

    @Test
    public void shellIntArray() {
        int[] src = getRandomIntArray(10, 100);
        int [] result = Arrays.copyOf(src, 10);
        Sort.shell(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }
    @Test
    public void shellIntegerArray() {
        Integer[] src = getRandomIntList(10, 100).toArray(new Integer[10]);
        Integer[] result = Arrays.copyOf(src, 10);
        Sort.shell(src);
        Arrays.sort(result);
        assertTrue(Arrays.equals(src,result));
    }

    @Test
    public void shellIntList() {
        List<Integer> src = getRandomIntList(10, 100);
        List<Integer> result = new ArrayList<>(src);
        Sort.shell(src);
        Collections.sort(result);
        assertTrue(src.equals(result));
    }
}