/**
 * This class contains methods for Knapsack problem in decreasing order of P/W ratio
 * DAA-E3-Q2
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package Year2;

import java.util.Scanner;

public class Knapsack2 {

    static void bubble_sort(double[] r, double[] w, double[] p) { //r = ratio w = weights p = profit
        int size = r.length;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < (size - i); j++) {
                if (r[j - 1] < r[j]) {
                    double temp_r = r[j - 1];
                    r[j - 1] = r[j];
                    r[j] = temp_r;

                    double temp_w = w[j - 1];
                    w[j - 1] = w[j];
                    w[j] = temp_w;

                    double temp_p = p[j - 1];
                    p[j - 1] = p[j];
                    p[j] = temp_p;

                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] weights;
        double[] profit;
        double[] ratio;
        double[] x;
        double total_w; //to store sum of weights
        int n; //to store size

        //Inputs
        System.out.print("Enter size: ");
        n = sc.nextInt();
        weights = new double[n];
        profit = new double[n];
        ratio = new double[n];
        x = new double[n];

        System.out.print("Enter total weight: ");
        total_w = sc.nextInt();

        System.out.println("\n>>>>Input Weights & Profits<<<<\n");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight " + (i + 1) + ": ");
            weights[i] = sc.nextInt();
            System.out.print("Enter profit " + (i + 1) + ": ");
            profit[i] = sc.nextInt();
            System.out.println();
        }

        //Calculating P/W ratio
        for (int i = 0; i < n; i++) {
            ratio[i] = profit[i] / weights[i];
        }

        //Sorting P & W arrays according to decreasing order of P/W ratio
        bubble_sort(ratio, weights, profit);

        //Knapsack Greedy Algo
        int j = 0;
        double sum_w = 0;
        while (sum_w < total_w) {
            if (weights[j] + sum_w < total_w) {
                x[j] = 1;
                sum_w += weights[j];
            } else {
                x[j] = (total_w - sum_w) / weights[j]; //(double) Math.round(((total_w-sum_w)/weights[j])*100)/100;
                sum_w = total_w;
                break;
            }
            j++;
        }

        //Calculating Profits
        double total_profit = 0;
        for(int i=0;i<n;i++){
            total_profit = profit[i]*x[i];
        }

        //Output
        System.out.print("Value of x: ");
        for (int i = 0; i < n; i++) {
            System.out.print(x[i] + "\t\t");
        }
        System.out.println("\nTotal profit: "+total_profit);
    }
}
