import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
public class Temperature {
    public static class Pair {
        int day;
        int temperature;
        Pair(int day, int temperature) {
            this.day = day;
            this.temperature = temperature;
        }
        Pair() {
            this.day = 0;
            this.temperature = 0;
        }
    }

    static void getTemperatures(ArrayList<Integer> temperatures) {
        Stack<Pair> st = new Stack<Pair>();
        ArrayList<Integer> sol = new ArrayList<Integer>(temperatures.size());
        for(int i = 0; i < temperatures.size(); i++) {
            sol.add(0);
        }
        for(int i = temperatures.size() - 1; i >= 0; i--) {
            if(st.empty()) {
                sol.set(i, 0);   
                //sol[i] = 0
                st.add(new Pair(i + 1, temperatures.get(i)));
            } else {
                if(st.peek().temperature > temperatures.get(i)) {
                    sol.set(i, st.peek().day);
                    st.add(new Pair(i + 1, temperatures.get(i)));
                } else {
                    while(!st.empty() && st.peek().temperature <= temperatures.get(i)) {
                        st.pop();
                    }
                    if(st.empty()) {
                        sol.set(i, 0);   
                        //sol[i] = 0
                        st.add(new Pair(i + 1, temperatures.get(i)));
                    } else {
                        sol.set(i, st.peek().day);
                        st.add(new Pair(i + 1, temperatures.get(i)));
                    }
                }
            }
        }
        for(int i = 0; i < sol.size(); i++) {
            System.out.printf("element at day %d with next greater day %d \n", i + 1, sol.get(i));
        }
        return;
    }
    public static void main(String[] args) {
        Scanner scin = new Scanner(System.in);
        int N = scin.nextInt();
        
        ArrayList<Integer> temperatures = new ArrayList<Integer>(N);

        for(int i = 0; i < N; i++) {
            temperatures.add(scin.nextInt());
        }
        getTemperatures(temperatures);

        scin.close();
    }
}