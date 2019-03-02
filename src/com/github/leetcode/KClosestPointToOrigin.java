package com.github.leetcode;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/*
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *(Here, the distance between two points on a plane is the Euclidean distance.)
 *You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *@author Yogesh Prabhukhanolkar
 *Problem Statement: https://leetcode.com/problems/k-closest-points-to-origin/ 
 */

public class KClosestPointToOrigin {
	 private class Point implements Comparable<Point>{
         private int xCoordinate;
         private int yCoordinate;
         private double distance;

         public Point(int a, int b, double c){
             this.xCoordinate = a;
             this.yCoordinate = b;
             this.distance = c;
         }

        @Override
        public int compareTo(Point pointB) {
            if(this.distance < pointB.distance){
                return -1;
            }
            else if(this.distance == pointB.distance){
                return 0;
            }
            else{
                return 1;
            }  
        }

        @Override
        public String toString(){
            return "x:"+this.xCoordinate+" y"+this.yCoordinate+" distance"+this.distance;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        List<Point>pointList = new ArrayList<Point>();

        if(points.length <= K) {
            return points; //Base case where given points are less than K
        }
        for(int index = 0; index < points.length;index++) {
            int [] point = points[index];
            double distanceFromOrigin = Math.sqrt(point[0]*point[0]+point[1]*point[1]);
            pointList.add(new Point(point[0],point[1],distanceFromOrigin));
        }
        Collections.sort(pointList); //Sort the points with increasing distnaces from origin
        //System.out.println(pointList);
        int[][] closestPoints = new int [K][]; //New array to hold K closest points
        for(int i=0;i<K;i++){
            Point p = pointList.get(i);
            closestPoints[i] = new int[]{p.xCoordinate,p.yCoordinate}; //Copy from pointList to array
        }
        return closestPoints;
    }
    
    public static void main(String[] args) {
		//Create and execute test cases by calling kClosest method.
	}
    
}
