import java.util.Objects;

/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle
{
    private Point location;
    private double height;
    private double width;

    private void init(Point location, double height,double width){
        this.height = height; 
        this.width = width;
        this.location = new Point(location);
    }

    public Rectangle(double height,double width)
    {
        init(new Point(), height, width);
    }

    public Rectangle(Point location, double height,double width)
    {
        init(location, height, width);
    }

    /**
     * Returns the width of this rectangle.
     * @return The width of this rectangle.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Returns the height of this rectangle
     * @return The height of this rectangle
     */
    public double getHeight()
    {
       return height;
    }

    /**
     * Returns the location of this rectangle.
     * @return an instance of Point with the coordinates of the location of this rectangle.
     */
    public Point getLocation()
    {
        return new Point(location);
    }

    /**
     * Sets the new width of this rectangle.
     * @param width the width of this rectangle.
     */
    public void setWidth(double width)
    {
        this.width = width;
    }

    /**
     * Sets the new height of this rectangle.
     * @param height the height of this rectangle.
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /** 
     *   Changes the location of this rectangle.
     *   @param location an instance of Point providing the 2-dimensional location.
     */
    public void setLocation(Point location)
    {
        this.location = new Point(location);
    }

    /**
     * Scales the width and height by the factors provided by scaleWidth and scaleHeight.
     * @param scaleWidth Value by which to scale the width.
     * @param scaleHeight Value by which to scale the height.
     */
    public void scale(double scaleWidth, double scaleHeight)
    {
        width = width * scaleWidth;
        height = height * scaleHeight;
    }

    /**
     * Returns true if the point is located inside this rectangle; False otherwise
     * @param point an instance of Point providing the 2-dimensional location
     * @return true if the point is located inside this rectangle; false otherwise
     */
    public boolean containsPoint(Point point)
    {
        double xp = point.getX();
        double yp = point.getY();
        double xl = location.getX();
        double xr = xl + width;
        double yt = location.getY();
        double yb = yt + height;
        
        return (xp > xl) && (xp < xr) && (yp > yt) && (yp < yb);
    }

    public boolean intersects(Rectangle aRectangle) {
        Point ptl = new Point(location);
        Point pbl = new Point(location.getX(), location.getY()+height);
        Point ptr = new Point(location.getX() + width, location.getY());
        Point pbr = new Point(location.getX() + width, location.getY()+height);
        
        Point aRectLocation = aRectangle.getLocation();
        Point qtl = new Point(aRectLocation);
        Point qbl = new Point(aRectLocation.getX(), aRectLocation.getY()+height);
        Point qtr = new Point(aRectLocation.getX() + width, aRectLocation.getY());
        Point qbr = new Point(aRectLocation.getX() + width, aRectLocation.getY()+height);
        
        return containsPoint(qtl) ||containsPoint(qbl) ||
                containsPoint(qtr) || containsPoint(qbr) ||
                aRectangle.containsPoint(ptl) ||
                aRectangle.containsPoint(pbl) ||
                aRectangle.containsPoint(ptr) ||
                aRectangle.containsPoint(pbr);
    }
    /**
     * Returns a string representation of this rectangle.
     * @return a string representation of this rectangle.
     */
    public String toString()
    {
        // [height, width]@(x,y)
        return "[" + height + "," + width + "]@" + location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle)o;
        return Double.compare(rectangle.height, height) == 0 &&
                Double.compare(rectangle.width, width) == 0 &&
                Objects.equals(location, rectangle.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, height, width);
    }
}
