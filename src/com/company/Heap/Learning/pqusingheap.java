package com.company.Heap.Learning;

import java.util.List;

public class pqusingheap {
   //add,remove - o(logn)
    //size - o(n)
        public static int pop(List<Integer> heap) {
            swap(0,heap.size()-1,heap);
            int val = heap.remove(heap.size()-1);
            if(!heap.isEmpty())  downheapify(0,heap);


            return val;


        }

        public static  void downheapify(int i,List<Integer> heap) {
            int max =i;
            int li = 2 * i+1;
            if(li < heap.size() && heap.get(li) > heap.get(max)){
                max =li;
            }

            int ri = 2 * i+2;
            if(ri < heap.size() && heap.get(ri) > heap.get(max)){
                max = ri;
            }

            if(i != max){
                swap(i,max,heap);
                downheapify(max,heap);
            }

        }

        public static  void swap(int i, int j, List<Integer> heap) {
            int temp = heap.get(j);
            heap.set(j,heap.get(i));
            heap.set(i,temp);


        }

    // Code Snippet of the push function:
    // public static void push(List<Integer> heap, int x) {
    //         heap.add(x);
    //
    //         // Position of the current inserted element.
    //         int pos = heap.size() - 1;
    //
    //         // Shifting the element up until it reaches the topmost node if it is larger than its parent.
    //         while (pos > 0) {
    //             int parent = (pos - 1) / 2;
    //             if (heap.get(pos) > heap.get(parent)) {
    //                 // Swapping the elements.
    //                 int temp = heap.get(parent);
    //                 heap.set(parent, heap.get(pos));
    //                 heap.set(pos, temp);
    //                 pos = parent;
    //             } else {
    //                 // As parent is larger, the element is now in its correct position.
    //                 break;
    //             }
    //         }
    //     }

    }
