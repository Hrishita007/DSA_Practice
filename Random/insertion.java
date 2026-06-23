public class insertion {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int key=i;
            while(key>0 && arr[key-1]>arr[key]){
                //swap
                int temp=arr[key];
                arr[key]=arr[key-1];
                arr[key-1]=temp;
                key--;
            }
        }
    }
    
}

