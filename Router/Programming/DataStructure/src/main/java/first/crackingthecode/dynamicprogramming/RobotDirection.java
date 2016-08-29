package first.crackingthecode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class RobotDirection
{

    public boolean moveRobot(int x, int y, ArrayList<Point> path, Hashtable<Point,Boolean> cache) {

        if(x >0 || y > 0) {
            return false;
        }

        Point point = new Point(x, y);

        if(cache.contains(point)) {
            return cache.get(point);
        }

        boolean isOrigin = x==0 && y==0;
        boolean success = false;

        if(isOrigin || moveRobot(x-1,y,path,cache) || moveRobot(x,y-1,path,cache)) {
            path.add(point);
            success = true;
        }

        cache.put(point,success);

        return success;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {

        }
    }
}
