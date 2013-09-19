package bp.util;

import java.awt.Point;

public class PointHelper {

    /**
     * 
     * @param possiblePoints
     *            - points that can be considered, must be at leats one
     * @param x
     *            - top left x coordinate of element
     * @param y
     *            - top left y coordinate of element
     * @param w
     *            - width of element
     * @param h
     *            - height of element
     * @return
     */
    public static Point findClosestPoint(EdgePoints[] possiblePoints, Integer x, Integer y, Integer eX, Integer eY,
            Integer eW, Integer eH) {
        if (possiblePoints == null || possiblePoints.length == 0) {
            return null;
        }
        if (intNullOrNegative(x) || intNullOrNegative(y) || intNullOrNegative(eX) || intNullOrNegative(eY)
                || intNullOrNegative(eW) || intNullOrNegative(eH)) {
            return null;
        }

        Point currentPoint = new Point(x, y);

        Integer northDistance = null;
        Integer southDistance = null;
        Integer eastDistance = null;
        Integer westDistance = null;
        
        Point northPoint = null;
        Point southPoint = null;
        Point eastPoint = null;
        Point westPoint = null;

        if (hasPointType(possiblePoints, EdgePoints.NORTH)) {
            northPoint = getNorthPoint(eX, eY, eW, eH);
            Double nDistance = currentPoint.distance(northPoint);
            northDistance = nDistance.intValue();
        }
        if (hasPointType(possiblePoints, EdgePoints.SOUTH)) {
            southPoint = getSouthPoint(eX, eY, eW, eH);
            Double sDistance = currentPoint.distance(southPoint);
            southDistance = sDistance.intValue();
        }
        if (hasPointType(possiblePoints, EdgePoints.EAST)) {
            eastPoint = getEastPoint(eX, eY, eW, eH);
            Double eDistance = currentPoint.distance(eastPoint);
            eastDistance = eDistance.intValue();
        }
        if (hasPointType(possiblePoints, EdgePoints.WEST)) {
            westPoint = getWestPoint(eX, eY, eW, eH);
            Double wDistance = currentPoint.distance(westPoint);
            westDistance = wDistance.intValue();
        }

        Integer min = null;
        Point minPoint = null;
        
        if (northDistance != null) {
            min = northDistance;
            minPoint = northPoint;
        }

        if (southDistance != null) {
            if (min != null) {
                if (southDistance < min) {
                    min = southDistance;
                    minPoint = southPoint;
                }
            } else {
                min = southDistance;
                minPoint = southPoint;
            }
        }

        if (eastDistance != null) {
            if (min != null) {
                if (eastDistance < min) {
                    min = eastDistance;
                    minPoint = eastPoint;
                }
            } else {
                min = eastDistance;
                minPoint = eastPoint;
            }
        }

        if (westDistance != null) {
            if (min != null) {
                if (westDistance < min) {
                    min = westDistance;
                    minPoint = westPoint;
                }
            } else {
                min = westDistance;
                minPoint = westPoint;
            }
        }

        return minPoint;
    }

    private static boolean intNullOrNegative(Integer x) {
        if (x == null || x < 0)
            return true;

        return false;
    }

    private static Point getNorthPoint(Integer x, Integer y, Integer w, Integer h) {
        return new Point(x + w / 2, y);
    }

    private static Point getEastPoint(Integer x, Integer y, Integer w, Integer h) {
        return new Point(x + w, y + h / 2);
    }

    private static Point getSouthPoint(Integer x, Integer y, Integer w, Integer h) {
        return new Point(x + w / 2, y + h);
    }

    private static Point getWestPoint(Integer x, Integer y, Integer w, Integer h) {
        return new Point(x, y + h / 2);
    }

    private static boolean hasPointType(EdgePoints[] points, EdgePoints type) {
        for (EdgePoints p : points) {
            if (p.equals(type))
                return true;
        }
        return false;
    }
}
