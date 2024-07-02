class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int xOverlap = 0;

        if(!(ax2<=bx1 || bx2<=ax1)){
            xOverlap = ax2 - ax1;
            if(bx1 > ax1){
                xOverlap -= bx1-ax1;
            }
            if(bx2 < ax2){
                xOverlap -= ax2 - bx2;
            }
        }

        int yOverlap = 0;

        if(!(ay2<=by1 || by2<=ay1)){
            yOverlap = ay2 - ay1;
            if(by1 > ay1){
                yOverlap -= by1-ay1;
            }
            if(by2 < ay2){
                yOverlap -= ay2 - by2;
            }
        }

        int aX = ax2 - ax1;
        int aY = ay2 - ay1;
        int bX = bx2 - bx1;
        int bY = by2 - by1;
    
        return aX * aY + bX * bY - xOverlap * yOverlap;

    }
}