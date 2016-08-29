package second.crackingcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class Robot
{
    public List<Point> moveRobot(int x,int y, List<Point> path) {

        if(x<0 && y<0) {
            return new ArrayList();
        }

        if(x==0 && y==0) {
            return path;
        }

        if(x==0 && y <0) {
            path.add(new Point(x,y));
            moveRobot(x, y - 1, path);
        } else if(x<0 && y==0) {
            path.add(new Point(x-1,y));
            moveRobot(x - 1, y, path);
        } else if(x >0 && y > 0) {
            path.add(new Point(x-1,y));
            moveRobot(x-1,y-1,path); // this is wrong, it can go either up or down.
        }

        return path;
    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
