import java.util.*;

class Point {
    public int x;
    public int y;
    Point(int _x, int _y){
        x = _x;
        y = _y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
public class Main
{
    public void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = cin.nextLine();
            String[] strs = line.split(" ");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            Point p = new Point(x, y);
            list.add(p);
        }
        list.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });
        List<Point> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean isMax = true;
            // right
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).y > list.get(i).y) {
                    isMax = false;
                    break;
                }
            }
            if (isMax) {
                res.add(list.get(i));
            }
        }
        for (Point p : res) {
            System.out.println(p.toString());
        }
    }
}