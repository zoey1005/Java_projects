
public class Intersection
{
    private final int x;
    private final int y;

    public Intersection(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return x == that.x && y == that.y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Intersection goEast()
    {
        return new Intersection(x + 1, y);
    }

    public Intersection goNorth()
    {
        return new Intersection(x, y+1);
    }

    public Intersection goSouth()
    {
        return new Intersection(x, y-1);
    }

    public Intersection goWest()
    {
        return new Intersection(x-1, y);
    }

    @Override
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}
