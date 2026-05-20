public class HeapInfo {
    public static void main(String[] args) {
        HeapInfo.PrintHeapInfo();
    }

    public static void PrintHeapInfo() {
        //get the number of available threads. The name processors is for historic reasons
        int cores = Runtime.getRuntime().availableProcessors();

        //get max memory converted into Megabytes
        long maxMemoryMB = Runtime.getRuntime().maxMemory() / (1024 * 1024);

        System.out.println("Available CPU-Threads for the JVM: " + cores);
        System.out.println("Maximum Heap-Size for JVM: " + maxMemoryMB + "MB");
    }
}
