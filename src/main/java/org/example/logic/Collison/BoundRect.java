package org.example.logic.Collison;

public class BoundRect {
    private BoundPoint point1;
    private BoundPoint point2;
    private BoundPoint point3;
    private BoundPoint point4;

    public BoundRect(BoundPoint point1, BoundPoint point2, BoundPoint point3, BoundPoint point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public boolean isInside(BoundRect boundRect){
        return checkPointInsideRect(point1, boundRect) || checkPointInsideRect(point2, boundRect) || checkPointInsideRect(point3, boundRect) || checkPointInsideRect(point4, boundRect);
    }

    private boolean checkPointInsideRect(BoundPoint point,BoundRect boundRect) {
        return boundRect.point1.getX()<=point.getX() &&boundRect.point2.getX()>=point.getX() &&
           boundRect.point1.getY()<=point.getY() &&boundRect.point4.getY()>=point.getY();

    }


}
