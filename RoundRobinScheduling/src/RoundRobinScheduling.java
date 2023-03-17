import java.util.*;

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] rem_bt = new int[n];
        System.out.println("Enter the burst time for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            rem_bt[i] = bt[i];
        }
        System.out.print("Enter the time quantum: ");
        int quantum = sc.nextInt();
        int t = 0;
        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (rem_bt[i] > 0) {
                    done = false;
                    if (rem_bt[i] > quantum) {
                        t += quantum;
                        rem_bt[i] -= quantum;
                    } else {
                        t += rem_bt[i];
                        wt[i] = t - bt[i];
                        rem_bt[i] = 0;
                    }
                }
            }
            if (done == true) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }
        float avg_wt = 0, avg_tat = 0;
        for (int i = 0; i < n; i++) {
            avg_wt += wt[i];
            avg_tat += tat[i];
        }
        avg_wt /= n;
        avg_tat /= n;
        System.out.println("Average waiting time: " + avg_wt);
        System.out.println("Average turnaround time: " + avg_tat);
    }
}
