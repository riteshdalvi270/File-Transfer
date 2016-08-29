package third.careercup.linkedin;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Copied from career cup.
 */
public class PointsOnAPlaneImpl {

    ArrayList<PointImpl> points = new ArrayList<PointImpl>();

    public void addPoint(PointImpl point) {
        points.add(point);

    }

    public ArrayList<PointImpl> findNearest(PointImpl center, int m) {
// TODO Auto-generated method stub
        PriorityQueue<PointImpl> q = new PriorityQueue<PointImpl>();
        for (PointImpl p : points) {
            double dist = Math.abs((center.getX() - p.getX())) + Math.abs((center.getY() - p.getY()));
            p.setDistFromCenter(dist);
            q.add(p);
        }
        ArrayList<PointImpl> nearestPoints = new ArrayList<PointImpl>();
        for (int i = 0; i < m; i++) {
            nearestPoints.add(q.poll());
        }
        return nearestPoints;
    }

    public static void main(String[] args) {
        PointsOnAPlaneImpl p = new PointsOnAPlaneImpl();
// (0, 1) (0, 2) (0, 3) (0, 4) (0, 5)
        p.addPoint(new PointImpl(0, 1));
        p.addPoint(new PointImpl(0, 2));
        p.addPoint(new PointImpl(0, 3));
        p.addPoint(new PointImpl(0, 4));
        p.addPoint(new PointImpl(0, 5));

        ArrayList<PointImpl> nearestPoints = p.findNearest(new PointImpl(0, 0), 3);

        for (PointImpl point : nearestPoints) {
            System.out.println(point.getX() + "," + point.getY());
        }
    }
}

class PointImpl implements Comparable {
    double x;
    double y;
    Double distFromCenter = null;

    public Double getDistFromCenter() {
        return distFromCenter;
    }

    public void setDistFromCenter(double distFromCenter) {
        this.distFromCenter = distFromCenter;
    }

    public PointImpl(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int compareTo(Object y) {
        Double y_distFromCenter = ((PointImpl) y).getDistFromCenter();
        if (distFromCenter != null && y_distFromCenter != null) {
            if (distFromCenter == y_distFromCenter) {
                return 0;
            } else if (distFromCenter > y_distFromCenter) {
                return 1;
            } else {
                return -1;
            }
        } else
            return 0;
    }
}
