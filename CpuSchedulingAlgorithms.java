
package cpuschedulingalgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CpuSchedulingAlgorithms {

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            int choice = 0;
            do {

                System.out.println();
                System.out.println("Select cpu scheduling algorithm");
                System.out.println("1 FCFS");
                System.out.println("2 Non-Preemptive SJF");
                System.out.println("3 Preemptive SJF");
                System.out.println("4 Non Preemptive Priority");
                System.out.println("5 Preemptive Priority");
                System.out.println("6 RoundRobin");
                System.out.println("7 sexit");

                choice = Integer.parseInt(in.readLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        try {

                            System.out.print("Enter the number of processes: ");
                            int n = Integer.parseInt(in.readLine());
                            System.out.println();

                            //Process ID's
                            int[] process = new int[n];
                            for (int i = 0; i < process.length; i++) {
                                process[i] = i + 1;
                            }

                            //Burst time of all processes
                            int[] burst_time = new int[n];
                            for (int i = 0; i < burst_time.length; i++) {
                                System.out.printf("Burst time for process %d: ", process[i]);
                                burst_time[i] = Integer.parseInt(in.readLine());
                            }
                            System.out.println();

                            //Finding waiting time of all process
                            int[] waitingTime = FCFSA.wt(n, burst_time);

                            int c;
                            do {
                                System.out.print("Choose 1 to see waiting time 2 to see turnaround time 3 to exit ");
                                c = Integer.parseInt(in.readLine());
                                System.out.println();
                                switch (c) {
                                    case 1:
                                        double average_wt = waitingTime(n, process, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average waiting time is:"
                                                + average_wt);
                                        System.out.println();
                                        break;
                                    case 2:
                                        double average_tat = turnAroundTime(n, process, burst_time, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average turnaround time is:"
                                                + average_tat);
                                        System.out.println();
                                        break;
                                    case 3:
                                        return;
                                    default:
                                        System.out.println("U have chosen wrong choice\n");
                                        break;
                                }
                            } while (c != 3);
                        } catch (IOException e) {
                            System.out.println("Unable to read/write to stream.");
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter the number of processes: ");
                            int n = Integer.parseInt(in.readLine());
                            System.out.println();

                            //Process ID's
                            int[] process = new int[n];
                            for (int i = 0; i < process.length; i++) {
                                process[i] = i + 1;
                            }

                            int[] arrival_time = new int[n];
                            int[] burst_time = new int[n];
                            System.out.println("Enter Arrival time for each process");
                            for (int i = 0; i < arrival_time.length; i++) {
                                System.out.printf("Arrival time for process %d: ", process[i]);
                                arrival_time[i] = Integer.parseInt(in.readLine());
                                System.out.printf("Burst time for process %d: ", process[i]);
                                burst_time[i] = Integer.parseInt(in.readLine());
                            }
                            System.out.println();

                            //Finding waiting time of all process
                            int[] waitingTime = SJR.wt(n, process, burst_time, arrival_time);

                            int c;
                            do {
                                System.out.print("Choose 1 to see waiting time 2 to see turnaround time 3 to exit ");
                                c = Integer.parseInt(in.readLine());
                                System.out.println();

                                switch (c) {
                                    case 1:
                                        double average_wt = waitingTime(n, process, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average waiting time is:"
                                                + average_wt);
                                        System.out.println();
                                        break;
                                    case 2:
                                        double average_tat = turnAroundTime(n, process, burst_time, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average turnaround time is:"
                                                + average_tat);
                                        System.out.println();
                                        break;
                                    case 3:
                                        return;
                                    default:
                                        System.out.println("U have chosen wrong choice\n");
                                        break;
                                }
                            } while (c != 3);
                        } catch (IOException e) {
                            System.out.println("Unable to read/write to stream.");
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Enter the number of processes: ");
                            int n = Integer.parseInt(in.readLine());
                            System.out.println();

                            //Process ID's
                            int[] process = new int[n];
                            for (int i = 0; i < process.length; i++) {
                                process[i] = i + 1;
                            }

                            int[] arrival_time = new int[n];
                            int[] burst_time = new int[n];
                            System.out.println("Enter Arrival time for each process");
                            for (int i = 0; i < arrival_time.length; i++) {
                                System.out.printf("Arrival time for process %d: ", process[i]);
                                arrival_time[i] = Integer.parseInt(in.readLine());
                                System.out.printf("Burst time for process %d: ", process[i]);
                                burst_time[i] = Integer.parseInt(in.readLine());
                            }
                            System.out.println();

                            //Finding waiting time of all process
                            int[] waitingTime = SJF.wt(n, process, burst_time, arrival_time);

                            int c;
                            do {
                                System.out.print("Choose 1 to see waiting time 2 to see turnaround time 3 to exit ");
                                c = Integer.parseInt(in.readLine());
                                System.out.println();

                                switch (c) {
                                    case 1:
                                        double average_wt = waitingTime(n, process, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average waiting time is:"
                                                + average_wt);
                                        System.out.println();
                                        break;
                                    case 2:
                                        double average_tat = turnAroundTime(n, process, burst_time, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average turnaround time is:"
                                                + average_tat);
                                        System.out.println();
                                        break;
                                    case 3:
                                        return;
                                    default:
                                        System.out.println("U have chosen wrong choice\n");
                                        break;
                                }
                            } while (c != 3);
                        } catch (IOException e) {
                            System.out.println("Unable to read/write to stream.");
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Enter the number of processes: ");
                            int n = Integer.parseInt(in.readLine());
                            System.out.println();

                            //Process ID's
                            int[] process = new int[n];
                            for (int i = 0; i < process.length; i++) {
                                process[i] = i + 1;
                            }

                            int[] arrival_time = new int[n];
                            int[] burst_time = new int[n];
                            int[] priority = new int[n];
                            for (int i = 0; i < arrival_time.length; i++) {
                                System.out.printf("Arrival time for process %d: ", process[i]);
                                arrival_time[i] = Integer.parseInt(in.readLine());
                                System.out.printf("Burst time for process %d: ", process[i]);
                                burst_time[i] = Integer.parseInt(in.readLine());
                                System.out.printf("Priority for process %d: ", process[i]);
                                priority[i] = Integer.parseInt(in.readLine());
                                System.out.println();
                            }
                            System.out.println();

                            //Finding waiting time of all process
                            int[] waitingTime = NonPreemptivePriority.wt(n, process,
                                    burst_time, arrival_time, priority);

                            int c;
                            do {
                                System.out.print("Choose 1 to see waiting time 2 to see turnaround time 3 to exit ");
                                c = Integer.parseInt(in.readLine());
                                System.out.println();

                                switch (c) {
                                    case 1:
                                        double average_wt = waitingTime(n, process, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average waiting time is:"
                                                + average_wt);
                                        System.out.println();
                                        break;
                                    case 2:
                                        double average_tat = turnAroundTime(n, process, burst_time, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average turnaround time is:"
                                                + average_tat);
                                        System.out.println();
                                        break;
                                    case 3:
                                        return;
                                    default:
                                        System.out.println("U have chosen wrong choice\n");
                                        break;
                                }
                            } while (c != 3);
                        } catch (IOException e) {
                            System.out.println("Unable to read/write to stream.");
                        }
                        break;
                    case 5:
                        try {
                            int pid; // Process ID 
                            int bt; // Burst Time 
                            int art; // Arrival Time 
                            System.out.print("Enter the number of processes: ");
                            int n = Integer.parseInt(in.readLine());
                            Process proc[] = new Process[n];
                            System.out.println();
                            for (int i = 1; i <= n; i++) {
                                pid = 1;
                                System.out.printf("Arrival time for process %d: ", i);
                                art = Integer.parseInt(in.readLine());
                                System.out.printf("Burst time for process %d: ", i);
                                bt = Integer.parseInt(in.readLine());
                                proc[i - 1] = new Process(pid, bt, art);
                                System.out.println();
                            }

                            PreemptivePriority.findavgTime(proc, proc.length);
                        } catch (Exception e) {
                        }
                        break;
                    case 6:
                        try {
                            System.out.print("Enter the number of processes: ");
                            int n = Integer.parseInt(in.readLine());
                            System.out.println();

                            //Process ID's
                            int[] process = new int[n];
                            for (int i = 0; i < process.length; i++) {
                                process[i] = i + 1;
                            }

                            //Time quantum
                            System.out.print("Enter time quantum: ");
                            int quantum = Integer.parseInt(in.readLine());
                            System.out.println();

                            //Burst time of all processes
                            int[] burst_time = new int[n];
                            for (int i = 0; i < burst_time.length; i++) {
                                System.out.printf("Burst time for process %d: ", process[i]);
                                burst_time[i] = Integer.parseInt(in.readLine());
                            }
                            System.out.println();

                            //Finding waiting time of all process
                            int[] waitingTime = RoundRobin.wt(n, quantum, process, burst_time);

                            int c;
                            do {
                                System.out.print("Choose 1 to see waiting time 2 to see turnaround time 3 to exit ");
                                c = Integer.parseInt(in.readLine());
                                System.out.println();

                                switch (c) {
                                    case 1:
                                        double average_wt = waitingTime(n, process, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average waiting time is:"
                                                + average_wt);
                                        System.out.println();
                                        break;
                                    case 2:
                                        double average_tat = turnAroundTime(n, process, burst_time, waitingTime);
                                        System.out.println("");
                                        System.out.println("The average turnaround time is:"
                                                + average_tat);
                                        System.out.println();
                                        break;
                                    case 3:
                                        return;
                                    default:
                                        System.out.println("U have chosen wrong choice\n");
                                        break;
                                }
                            } while (c != 3);
                        } catch (IOException e) {
                            System.out.println("Unable to read/write to stream.");
                        }
                        break;
                    case 7:
                        return;

                    default:
                        System.out.println("U have chosen wrong choice");
                        break;
                }
            } while (choice != 5);

        } catch (IOException e) {
            System.out.println("Unable to read/write to stream.");
        }

    }

    public static int waitingTime(int n, int[] process, int[] wt) {

        System.out.println("Process ID" + " " + "Waiting time");

        //Displaying the waiting time of all process
        for (int i = 0; i < n; i++) {
            System.out.printf("Process %d  %d%n", process[i], wt[i]);
        }

        //calculate average waiting time
        int total_wt = 0;
        for (int j = 0; j < n; j++) {
            total_wt += wt[j];
        }

        return total_wt / n;
    }

    public static double turnAroundTime(int n, int[] process, int[] bt, int[] wt) {
        int[] tat = new int[n];

        for (int j = 0; j < n; j++) {
            tat[j] = wt[j] + bt[j];
        }

        System.out.println("Process ID" + " " + "Turnaround time");
        System.out.println("----------" + " " + "---------------");

        //Displaying the turn around time of all process
        for (int j = 0; j < n; j++) {
            System.out.printf("Process %d  %d%n", process[j], tat[j]);
        }

        //calculate average turn around time
        double total_tat = 0;
        for (int k = 0; k < n; k++) {
            total_tat += tat[k];
        }
        return total_tat / n;
    }

}

class NonPreemptivePriority {

    public static int[] wt(int n, int[] process, int[] bt, int[] at, int[] pt) {
        Map<Integer, Integer> wtm = new HashMap<>();
        ArrayList<Integer> processList = new ArrayList<>();
        ArrayList<Integer> burstTimeList = new ArrayList<>();
        ArrayList<Integer> arrivalTimeList = new ArrayList<>();
        ArrayList<Integer> priorityList = new ArrayList<>();
        int[] wt = new int[n];

        //Sorting and adding based on arrival and priority time
        for (int i = 1; i < n; i++) {
            int index = i;
            for (int j = 0; j < arrivalTimeList.size(); j++) {
                if (at[index] < arrivalTimeList.get(j)) {
                    index = j;
                    break;
                } else if (at[index] == arrivalTimeList.get(j)
                        && pt[index] < priorityList.get(j)) {
                    index = j;
                    break;
                }
            }

            //Meaning make it the last index
            if (index >= arrivalTimeList.size()) {
                index = arrivalTimeList.size();
            }

            processList.add(index, process[i]);
            burstTimeList.add(index, bt[i]);
            arrivalTimeList.add(index, at[i]);
            priorityList.add(index, (pt[i]));
        }

        wtm.put(process[0], 0);

        int elapsedTime = bt[0];

        // calculate waiting time for all other processes
        while (0 < processList.size()) {
            int currentIndex = 0;
            int currentProcess = processList.get(currentIndex);
            int currentArrivalTime = arrivalTimeList.get(currentIndex);
            int currentBurstTime = burstTimeList.get(currentIndex);
            int currentPriority = priorityList.get(currentIndex);

            for (int j = 0; j < processList.size(); j++) {

                //Means the process isn't yet ready
                if (elapsedTime < arrivalTimeList.get(j)) {
                    continue;
                }

                //Comparing between waiting processes based on priority time
                if (currentPriority > priorityList.get(j)) {
                    currentIndex = j;
                    currentProcess = processList.get(j);
                    currentBurstTime = burstTimeList.get(j);
                    currentArrivalTime = arrivalTimeList.get(j);
                    currentPriority = priorityList.get(j);
                }
            }

            //Removing finished process
            wtm.putIfAbsent(currentProcess, (elapsedTime - currentArrivalTime));
            processList.remove(currentIndex);
            burstTimeList.remove(currentIndex);
            arrivalTimeList.remove(currentIndex);
            priorityList.remove(currentIndex);

            elapsedTime += currentBurstTime;
        }

        for (int i = 0; i < n; i++) {
            int waitingTime = wtm.get(process[i]);
            if (waitingTime < 0) {
                waitingTime = 0;
            }
            wt[i] = waitingTime;
        }

        return wt;
    }
}

class RoundRobin {

    public static int[] wt(int n, int quantum, int[] process, int[] bt) {
        Map<Integer, Integer> wtm = new HashMap<>();
        ArrayList<Integer> processList = new ArrayList<>();
        ArrayList<Integer> burstTimeList = new ArrayList<>();
        ArrayList<Integer> processedBurstList = new ArrayList<>();
        int[] wt = new int[n];

        //Sorting and adding based on arrival and priority time
        for (int i = 0; i < n; i++) {
            processList.add(process[i]);
            burstTimeList.add(bt[i]);
            processedBurstList.add(0);
        }

        int elapsedTime = 0;

        // calculate waiting time for all other processes
        while (0 < processList.size()) {
            for (int j = 0; j < processList.size(); j++) {
                if (burstTimeList.get(j) - quantum <= 0) {
                    wtm.putIfAbsent(processList.get(j), (elapsedTime - processedBurstList.get(j)));

                    elapsedTime += burstTimeList.get(j);

                    //Removing finished process
                    processList.remove(j);
                    burstTimeList.remove(j);
                    processedBurstList.remove(j);
                    j--;
                    continue;
                }

                burstTimeList.set(j, burstTimeList.get(j) - quantum);
                processedBurstList.set(j, processedBurstList.get(j) + quantum);
                elapsedTime += quantum;
            }
        }

        for (int i = 0; i < n; i++) {
            int waitingTime = wtm.get(process[i]);
            if (waitingTime < 0) {
                waitingTime = 0;
            }
            wt[i] = waitingTime;
        }

        return wt;
    }
}

class FCFSA {

    public static int[] wt(int n, int[] bt) {
        int[] wt = new int[n];
        wt[0] = 0;

        // calculate waiting time for all other processes
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }

        return wt;
    }
}

class SJR {

    public static int[] wt(int n, int[] process, int[] bt, int[] at) {
        Map<Integer, Integer> wtm = new HashMap<>();
        ArrayList<Integer> processList = new ArrayList<>();
        ArrayList<Integer> burstTimeList = new ArrayList<>();
        ArrayList<Integer> arrivalTimeList = new ArrayList<>();
        int[] wt = new int[n];

        //Adding processes to list except the first one
        for (int i = 1; i < n; i++) {
            processList.add(process[i]);
            burstTimeList.add(bt[i]);
            arrivalTimeList.add(at[i]);
        }

        wtm.put(process[0], 0);

        int elapsedTime = bt[0];

        // calculate waiting time for all other processes
        while (0 < processList.size()) {
            int firstArrivedIndex = 0;
            for (int k = 0; k < processList.size(); k++) {
                if (arrivalTimeList.get(firstArrivedIndex) > arrivalTimeList.get(k)) {
                    firstArrivedIndex = k;
                }
            }

            int currentProcess = processList.get(firstArrivedIndex);
            int currentArrivalTime = arrivalTimeList.get(firstArrivedIndex);
            int currentBurstTime = burstTimeList.get(firstArrivedIndex);
            int currentIndex = firstArrivedIndex;

            for (int j = 0; j < processList.size(); j++) {

                //Means the process isn't yet ready
                if (elapsedTime < arrivalTimeList.get(j)) {
                    continue;
                }

                //Comparing between waiting processes based on burst time
                if (currentBurstTime > burstTimeList.get(j)) {
                    currentIndex = j;
                    currentProcess = processList.get(j);
                    currentBurstTime = burstTimeList.get(j);
                    currentArrivalTime = arrivalTimeList.get(j);
                }
            }

            //Removing finished process
            wtm.putIfAbsent(currentProcess, (elapsedTime - currentArrivalTime));
            processList.remove(currentIndex);
            burstTimeList.remove(currentIndex);
            arrivalTimeList.remove(currentIndex);

            elapsedTime += currentBurstTime;
        }

        for (int i = 0; i < n; i++) {
            int waitingTime = wtm.get(process[i]);
            if (waitingTime < 0) {
                waitingTime = 0;
            }
            wt[i] = waitingTime;
        }

        return wt;
    }
}

class SJF {

    public static int[] wt(int n, int[] process, int[] bt, int[] at) {
        Map<Integer, Integer> wtm = new HashMap<>();
        ArrayList<Integer> processList = new ArrayList<>();
        ArrayList<Integer> burstTimeList = new ArrayList<>();
        ArrayList<Integer> arrivalTimeList = new ArrayList<>();
        int[] wt = new int[n];

        //Sorting and adding based on arrival and burst time
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = 0; j < arrivalTimeList.size(); j++) {
                if (at[index] < arrivalTimeList.get(j)) {
                    index = j;
                    break;
                } else if (at[index] == arrivalTimeList.get(j)
                        && bt[index] < burstTimeList.get(j)) {
                    index = j;
                    break;
                }
            }
            processList.add(index, process[i]);
            burstTimeList.add(index, bt[i]);
            arrivalTimeList.add(index, at[i]);
        }

        int elapsedTime = 0;

        // calculate waiting time for all other processes
        while (0 < processList.size()) {
            int currentIndex = 0;

            for (int k = 0; k < processList.size(); k++) {
                //If two process are waiting then distinguish them based on burst time
                if (elapsedTime >= arrivalTimeList.get(currentIndex)
                        && elapsedTime >= arrivalTimeList.get(k)
                        && burstTimeList.get(currentIndex) > burstTimeList.get(k)) {
                    currentIndex = k;
                }
            }

            int currentProcess = processList.get(currentIndex);
            int currentArrivalTime = arrivalTimeList.get(currentIndex);
            int currentBurstTime = burstTimeList.get(currentIndex);

            for (int j = 0; j < processList.size(); j++) {

                //Checking for incoming process with burst time less than the remaining
                if (elapsedTime < arrivalTimeList.get(j)
                        && (elapsedTime + currentBurstTime - arrivalTimeList.get(j)) > burstTimeList.get(j)) {

                    int currentElapse = Math.abs(elapsedTime - arrivalTimeList.get(j));

                    //Setting covered portion of the process
                    burstTimeList.set(currentIndex, burstTimeList.get(currentIndex) - currentElapse);
                    arrivalTimeList.set(currentIndex, arrivalTimeList.get(currentIndex) + currentElapse);
                    elapsedTime += currentElapse;

                    currentIndex = j;
                    currentProcess = processList.get(j);
                    currentBurstTime = burstTimeList.get(j);
                    currentArrivalTime = arrivalTimeList.get(j);
                }
            }

            //Removing finished process
            wtm.putIfAbsent(currentProcess, (elapsedTime - currentArrivalTime));
            processList.remove(currentIndex);
            burstTimeList.remove(currentIndex);
            arrivalTimeList.remove(currentIndex);

            elapsedTime += currentBurstTime;
        }

        for (int i = 0; i < n; i++) {
            int waitingTime = wtm.get(process[i]);
            if (waitingTime < 0) {
                waitingTime = 0;
            }
            wt[i] = waitingTime;
        }

        return wt;
    }
}

class Process {

    int pid; // Process ID 
    int bt; // Burst Time 
    int art; // Arrival Time 

    public Process(int pid, int bt, int art) {
        this.pid = pid;
        this.bt = bt;
        this.art = art;
    }
}

class PreemptivePriority {

    // Method to find the waiting time for all 
    // processes 
    static void findWaitingTime(Process proc[], int n,
            int wt[]) {
        int rt[] = new int[n];

        // Copy the burst time into rt[] 
        for (int i = 0; i < n; i++) {
            rt[i] = proc[i].bt;
        }

        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;

        // Process until all processes gets 
        // completed 
        while (complete != n) {

            // Find process with minimum 
            // remaining time among the 
            // processes that arrives till the 
            // current time` 
            for (int j = 0; j < n; j++) {
                if ((proc[j].art <= t)
                        && (rt[j] < minm) && rt[j] > 0) {
                    minm = rt[j];
                    shortest = j;
                    check = true;
                }
            }

            if (check == false) {
                t++;
                continue;
            }

            // Reduce remaining time by one 
            rt[shortest]--;

            // Update minimum 
            minm = rt[shortest];
            if (minm == 0) {
                minm = Integer.MAX_VALUE;
            }

            // If a process gets completely 
            // executed 
            if (rt[shortest] == 0) {

                // Increment complete 
                complete++;
                check = false;

                // Find finish time of current 
                // process 
                finish_time = t + 1;

                // Calculate waiting time 
                wt[shortest] = finish_time
                        - proc[shortest].bt
                        - proc[shortest].art;

                if (wt[shortest] < 0) {
                    wt[shortest] = 0;
                }
            }
            // Increment time 
            t++;
        }
    }

    // Method to calculate turn around time 
    static void findTurnAroundTime(Process proc[], int n,
            int wt[], int tat[]) {
        // calculating turnaround time by adding 
        // bt[i] + wt[i] 
        for (int i = 0; i < n; i++) {
            tat[i] = proc[i].bt + wt[i];
        }
    }

    // Method to calculate average time 
    public static void findavgTime(Process proc[], int n) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Function to find waiting time of all 
        // processes 
        findWaitingTime(proc, n, wt);

        // Function to find turn around time for 
        // all processes 
        findTurnAroundTime(proc, n, wt, tat);

        // Display processes along with all 
        // details 
        System.out.println("Process Id "
                + " Burst time "
                + " Waiting time "
                + " Turn around time");
        System.out.println("---------- "
                + " ---------- "
                + " ------------ "
                + " ----------------");

        // Calculate total waiting time and 
        // total turnaround time 
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.println(" " + proc[i].pid + "\t\t"
                    + proc[i].bt + "\t\t " + wt[i]
                    + "\t\t" + tat[i]);
        }
        System.out.println("");
        System.out.println("Average waiting time = "
                + (float) total_wt / (float) n);
        System.out.println("Average turn around time = "
                + (float) total_tat / (float) n);
        System.out.println("");
    }
}
