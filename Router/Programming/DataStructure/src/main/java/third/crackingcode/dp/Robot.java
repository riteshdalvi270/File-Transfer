package third.crackingcode.dp;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by ritesh on 1/5/16.
 */
public class Robot {

    public static void main(String args[]) {

        LinkedList<Point> path = new LinkedList<>();

        robotMove(4,5,path);
        for(final Point point : path) {
            System.out.print("("+point.getX()+","+point.getY()+")");
        }
    }


    // Recursive without followup. It was not a proper solution, I looked into the book. For dp add cache. Hashtable..
    public static Point robotMove(int x, int y, LinkedList<Point> paths) {

        Point p = new Point(x,y);

        if(x == 0 && y == 0) {
            paths.add(p);
            return p;
        }

        if(y > 1) {
            robotMove(x,y-1,paths);
        }else if(x>1) {
            robotMove(x-1,y,paths);
        }

        paths.add(p);

        return p;
    }
}
