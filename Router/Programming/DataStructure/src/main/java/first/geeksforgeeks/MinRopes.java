package first.geeksforgeeks;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class MinRopes
{
    public static class HeapNodes
    {
        int data;

        HeapNodes left;
        HeapNodes right;

        public HeapNodes() {

        }

        public HeapNodes(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class MinHeaps {

        int capacity;
        HeapNodes []array;

        public MinHeaps(int data[]) {
            this.capacity = data.length;
            array = new HeapNodes[data.length+1];
            for(int i = 1;i <=data.length;i++) {
                array[i] = new HeapNodes(data[i]);
            }
        }
    }

    public static int parent(int i) {
        return i/2;
    }

    public static int left(int i) {
        return 2*i;
    }

    public static int right(int i) {
        return 2*i+1;
    }

    public static void exchange(HeapNodes array[], int i, int smallest) {

        HeapNodes temp = array[i];
        array[i] = array[smallest];
        array[smallest] = temp;
    }

    public static void minHeapify(MinHeaps minHeaps, int i) {

        int left = left(i);
        int right = right(i);
        int smallest = i;

        if(left<=minHeaps.capacity && minHeaps.array[i].data > minHeaps.array[left].data) {
            smallest = left;
        }

        if(right<=minHeaps.capacity && minHeaps.array[i].data > minHeaps.array[right].data) {
            smallest = right;
        }

        if(smallest!=i) {
            exchange(minHeaps.array,i,smallest);
            minHeapify(minHeaps,smallest);
        }
    }

    public static void buildMinHeap(MinHeaps minHeaps) {

        int length = minHeaps.capacity;
        for(int i=length/2;i>=1;i--) {
            minHeapify(minHeaps,i);
        }
    }

    public int minHeap(MinHeaps minHeaps) {
        return minHeaps.array[1].data;
    }

    public static void increaseMinHeap(MinHeaps minHeaps,int i, int key) {

       HeapNodes heapNode =  minHeaps.array[i];
        heapNode.data = key;

        while(i > 1 && minHeaps.array[parent(i)].data >  minHeaps.array[i].data) {
            exchange(minHeaps.array,parent(i),i);
            i = parent(i);
        }
    }

    public static void insertMinHeap(MinHeaps minHeaps, int key) {
        minHeaps.capacity = minHeaps.capacity+1;

        increaseMinHeap(minHeaps,minHeaps.capacity,key);
    }

    public static int extractMinHeap(MinHeaps minHeaps) {

        int data = minHeaps.array[1].data;
        minHeaps.array[1].data = minHeaps.array[minHeaps.capacity].data;
        minHeaps.capacity = minHeaps.capacity - 1;

        minHeapify(minHeaps,1);

        return data;
    }

    public static class NRopes {

        MinHeaps minHeaps;

        HeapNodes leftHeapNode;
        HeapNodes rightHeapNode;

        int sum = 0;

        public NRopes() {

        }

        public void buildAndCreateNRopes(int data[]) {

            minHeaps = new MinHeaps(data);
            buildMinHeap(minHeaps);
        }

        public int joinWithLessCost() {

            // extract two min heap nodes.
            int left  = extractMinHeap(minHeaps);
            int right = extractMinHeap(minHeaps);

            sum = sum + left+right;

            // Insert back into the heap.
            insertMinHeap(minHeaps,sum);

            return sum;
        }
    }

    public static void main(String args[]) {

        NRopes ropes = new NRopes();
        int data[] = {4,3,2,6};
        ropes.buildAndCreateNRopes(data);

        int sum = 0;

        // call until heap size is 1;
        for(int i = 1;i<=data.length;i++) {
            sum = ropes.joinWithLessCost();
        }

        System.out.println(sum);

    }
}
