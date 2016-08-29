package second.crackingcode.dynamicprogramming;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class PaintFill
{

    public void paintFill(Point[][] screen, int x, int y, String originalColor,String newColor) {

        if(x<0 && y < 0) {
            return;
        }

        Point point = screen[x][y];
        boolean colorChanged = point.originalColor == originalColor ? true:false;

        if(colorChanged)
        {
            point.setOriginalColor(newColor);
            paintFill(screen,x-1,y,originalColor,newColor);
            paintFill(screen,x+1,y,originalColor,newColor);
            paintFill(screen,x,y-1,originalColor,newColor);
            paintFill(screen,x,y+1,originalColor,newColor);
        } else {
            return;
        }
    }

    public class Point {

        private String originalColor;

        public String getOriginalColor() {
            return originalColor;
        }

        public void setOriginalColor(String originalColor) {
            this.originalColor = originalColor;
        }

    }

}
