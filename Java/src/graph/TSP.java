package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TSP {
    static class Point{
        int x;
        int y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
    static int getDist(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
    static int cities; // nr of cities
    static int best=Integer.MAX_VALUE;  // global variable recording best distance
    // Matrix of distances (cost to travel) between cities
    static int dist[][];

    static int passedcities[]; // passed cities on a path
    static int bestpath[]; // best path so far
    static List<Point> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine().trim());
        cities = count + 1;
        dist = new int[count + 1][count + 1];
        list.add(new Point(0, 0));
        for (int i = 0; i < count; i++) {
            String temp = scanner.nextLine();
            String[] numberStr = temp.split(",");
            int x = Integer.parseInt(numberStr[0]);
            int y = Integer.parseInt(numberStr[1]);
            list.add(new Point(x, y));
        }
        for (int i = 0; i <= count; i++) {
            for (int j = 0; j <= count; j++) {
                dist[i][j] = getDist(list.get(i), list.get(j));
            }
        }
        // create helper arrays
        passedcities = new int[cities];
        bestpath = new int[cities];
        // search from city 0, with 0 passed and 0 cost of travel so far
        search(0,0,0);
        // print out result
        System.out.println("best cost: "+best);
        System.out.println("best path: ");
        for (int i=0; i<cities; i++) System.out.print(bestpath[i] + " ");

    }

    // The recursive search function
    //
    // city: nr of city just arrived into
    // passed: number of cities passed so far
    // passedlen: length (cost) travelled so far

    static void search(int city, int passed, int passedlen) {
        // store the new passed city in the passed array
        passedcities[passed]=city;
        // maybe we have travelled through all cities - 1?
        if (passed==(cities-1)) {
            // compute the final length (trip to home is left!)
            int length=passedlen+dist[0][city];
            // save the length and path if we are back home
            // and the length found is best so far
            if (length<best) {
                best=length;
                for (int i=0; i<cities; i++) bestpath[i]=passedcities[i];
            }
            // if not all cities have been passed, try all cities
            // not yet passed
        } else  {
            // loop over all cities
            for(int next=0; next<cities; next++) {
                // if the distance will be less
                // than the best distance so far, ONLY THEN GO!
                if (passedlen+dist[city][next] < best) {
                    // check if next is OK (not passed yet)
                    boolean okcity=true;
                    for (int i=0; i<passed+1 && okcity; i++)
                        if (passedcities[i]==next) okcity=false;
                    if (okcity) {   // if ok, continue search
                        search(next,
                                passed+1,
                                passedlen+dist[city][next]);
                    }
                }
            }
        }

    }
}
