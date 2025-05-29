import java.util.Scanner;

class Hippie {
    private int[] heap;
    private int size;
    private int capacity;

    public Hippie(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }
    public void insert(int k) {
        if (size == capacity) {
            throw new IllegalStateException();
        }
        heap[size] = k;
        size++;
        heapifyUp(size - 1);
    }
    public int extract() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;
        if (leftChildIndex < size && heap[leftChildIndex] > heap[largest]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < size && heap[rightChildIndex] > heap[largest]) {
            largest = rightChildIndex;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Hippie maxHeap = new Hippie(N);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int command = scanner.nextInt();
            if (command == 0) { // Insert(k)
                int number = scanner.nextInt();
                maxHeap.insert(number);
            } else if (command == 1) { // Extract
                output.append(maxHeap.extract()).append("\n");
            }
        }
        System.out.print(output);
        scanner.close();
    }
}