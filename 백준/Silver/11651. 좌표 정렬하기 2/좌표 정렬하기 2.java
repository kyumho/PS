import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Point[] p = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            p[i] = point;
        }

        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.y != p2.y) {
                    return p1.y - p2.y;
                }
                return p1.x - p2.x;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(p[i]);
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
