class DynamicArray {
    int[] array;
    int capacity;
    int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[capacity];
    }

    public int get(int i) {
        return this.array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if (capacity == size)
            resize();
        array[size] = n;
        size++;
    }

    public int popback() {
        size--;
        return array[size];
    }

    private void resize() {
        int[] newArray = new int[capacity * 2];
        for (int i = 0; i < size; i++) newArray[i] = array[i];
        capacity *= 2;
        array = newArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
