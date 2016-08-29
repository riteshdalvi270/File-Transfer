package third.careercup.linkedin;

import java.util.*;

import static java.util.Collections.sort;

/**
 * Created by ritesh on 1/9/16.
 */
public class Plane {

    public static void main(String args[]) {


        PointsOnThePlane pointsOnThePlane = new PointsOnThePlane();
        pointsOnThePlane.addPoint(new Point(0,1));
        pointsOnThePlane.addPoint(new Point(0,2));
        pointsOnThePlane.addPoint(new Point(0,3));
        pointsOnThePlane.addPoint(new Point(0,4));
        pointsOnThePlane.addPoint(new Point(0,5));

        Collection<Point> nearestPoints = pointsOnThePlane.getNearestPoint(new Point(0, 0), 3);

        for(final Point nearestPoint : nearestPoints) {

            System.out.println("{"+nearestPoint.x+","+nearestPoint.y+"}");
        }

        PointsOnThePlane pointsOnThePlane1 = new PointsOnThePlane();
        pointsOnThePlane1.addPoint(new Point(1,1));
        pointsOnThePlane1.addPoint(new Point(2,2));
        pointsOnThePlane1.addPoint(new Point(3,3));
        pointsOnThePlane1.addPoint(new Point(1,4));
        pointsOnThePlane1.addPoint(new Point(1,3));

        Collection<Point> nearestPoints1 = pointsOnThePlane1.getNearestPoint(new Point(0, 0), 3);

        System.out.println("--------------------------------------------------------------");
        for(final Point nearestPoint : nearestPoints1) {

            System.out.println("{"+nearestPoint.x+","+nearestPoint.y+"}");
        }
    }
}

class PointsOnThePlane {

    final Map<Integer,List<Point>> pointers = new HashMap<>();


    final List<Point> points = new ArrayList<>();
    //final List<Integer> keys = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
        pointers.put(point.x,points);
    }

    public Collection<Point> getNearestPoint(Point center, int m) {

        List<Point> nearestPoints = new ArrayList<>();

        if(pointers.get(center.x) !=null) {

            List<Point> points = pointers.get(center.x);

            sort(points, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return Integer.compare(o1.y,o2.y);
                }
            });

            for(int i =0;i<=m; i++) {

                Point point = points.get(i);

                if(point != null) {
                    nearestPoints.add(point);
                }else {

                    getNeighbors(nearestPoints,m);
                }
            }

            return nearestPoints;
        } else {

            getNeighbors(nearestPoints,m);
        }

        return nearestPoints;
    }

    public void getNeighbors(List<Point> nearestPoints,int m) {

        Set<Integer> integers = pointers.keySet();

        List<Integer> sortedKeys = new ArrayList<Integer>(integers);

        sort(sortedKeys);

        for(int i = 0; i<m ;i++) {

            Integer integer = sortedKeys.get(i);

            if(integer!=null) {
                List<Point> points = pointers.get(integer);

                for(final Point point: points) {
                    nearestPoints.add(point);
                    i++;
                }
            }else {

                m = m+1;
            }
        }
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }
}
