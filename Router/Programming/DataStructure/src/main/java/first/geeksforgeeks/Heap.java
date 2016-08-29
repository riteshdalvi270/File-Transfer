package first.geeksforgeeks;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class Heap
{

    public int parent(int i)
    {
        return i/2;
    }

    public int left(int i) {
     return 2*i;
    }

    public int right(int i) {
        return 2*i+1;
    }

    public void exchange(MinHeap minHeap,int i, int smallest) {

        HeapNode tempNode;

        tempNode = minHeap.array[i];
        minHeap.array[i] = minHeap.array[smallest];
        minHeap.array[smallest] = tempNode;
    }

    public void minHeapify(MinHeap minHeap, int i) {

        int left = left(i);
        int right = right(i);

        int smallest=i;

        if(i <  minHeap.capacity && (minHeap.array[left].data.compareToIgnoreCase(minHeap.array[i].data) < 0)) {
            smallest = left;
        }

        if(i< minHeap.capacity && (minHeap.array[right].data.compareToIgnoreCase(minHeap.array[i].data) < 0)) {
            smallest = right;
        }

        if(smallest!=i) {
            exchange(minHeap,i,smallest);
            minHeapify(minHeap,smallest);
        }
    }

    public void buildMinHeap(MinHeap minHeap) {

        int n = minHeap.capacity;

        for(int i = n/2; i> 1; i--) {
            minHeapify(minHeap,i);
        }
    }

    public String heapMin(MinHeap minHeap) {
        return minHeap.array[1].data;
    }

    public String extractMinHeap(MinHeap minHeap) {

        String min = minHeap.array[1].data;

        minHeap.array[1].data = minHeap.array[minHeap.capacity].data;

        minHeap.capacity = minHeap.capacity - 1;

        minHeapify(minHeap,1);

        return min;
    }

    public void minHeapInsert(MinHeap minHeap, String key) {

        minHeap.capacity = minHeap.capacity+1;
        minHeap.array[minHeap.capacity] = null;

        heapIncreaseKey(minHeap,minHeap.capacity,key);
    }

    public void heapIncreaseKey(MinHeap minHeap,int i, String key) {

        minHeap.array[i].data = key;

        while(i > 1 && (minHeap.array[parent(i)].data.compareToIgnoreCase(minHeap.array[i].data) < 0)) {
            exchange(minHeap,parent(i),i);
            i = parent(i);
        }
    }

    public class HeapNode
    {
        String data;

        //For huffman
        int frequency;

        HeapNode left;
        HeapNode right;
    }

    public class MinHeap {

        int capacity; // total capacity

        HeapNode[] array;
    }
}
