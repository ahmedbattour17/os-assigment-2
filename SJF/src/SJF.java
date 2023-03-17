import java.util.*;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int[] burstTimes = new int[n];
        int[] waitingTimes = new int[n];
        int[] turnaroundTimes = new int[n];
        int totalWaitingTime = 0, totalTurnaroundTime = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the burst time for process " + (i+1) + ": ");
            burstTimes[i] = sc.nextInt();
        }

        // Sort processes by burst time
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (burstTimes[j] > burstTimes[j+1]) {
                    int temp = burstTimes[j];
                    burstTimes[j] = burstTimes[j+1];
                    burstTimes[j+1] = temp;
                }
            }
        }

        // Calculate waiting and turnaround times
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                waitingTimes[i] = 0;
            } else {
                waitingTimes[i] = waitingTimes[i-1] + burstTimes[i-1];
            }
            turnaroundTimes[i] = waitingTimes[i] + burstTimes[i];
            totalWaitingTime += waitingTimes[i];
            totalTurnaroundTime += turnaroundTimes[i];
        }

        // Print results
        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "\t\t" + burstTimes[i] + "\t\t" + waitingTimes[i] + "\t\t" + turnaroundTimes[i]);
        }
        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}
