import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Path
{
    private ArrayList<Intersection> intersections;

    public Path()
    {
        this.intersections = new ArrayList<>();
    }

    public void addHead(Intersection toAdd)
    {
        if (intersections.size() == 0)
        {
            intersections.add(toAdd);
            return;
        }
        else
        {
            Intersection head = intersections.get(0);
            if (toAdd.goEast().equals(head)||toAdd.goNorth().equals(head))
            {
                intersections.add(0,toAdd);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public void addTail(Intersection toAdd)
    {
        if (intersections.size() == 0)
        {
            intersections.add(toAdd);
            return;
        }
        else
        {
            Intersection last = intersections.get(length()-1);
            if (last.goEast().equals(toAdd)||last.goNorth().equals(toAdd))
            {
                intersections.add(toAdd);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Intersection getHead()
    {
        if (intersections.size()==0)
            throw new NoSuchElementException();
        else
            return intersections.get(0);
    }

    public Intersection getTail()
    {
        if (intersections.size()==0)
            throw new NoSuchElementException();
        else
            return intersections.get(length()-1);
    }

    public int length()
    {
        return intersections.size();
    }

    public void removeTail()
    {
        if (intersections.size()==0)
            return;
        else
            intersections.remove(length() - 1);
    }

    public Intersection getIntersection(int i)
    {
        return intersections.get(i);
    }

    @Override
    public String toString()
    {
        if (length()==0)
            return "";
        String ret = "";
        for (int i=0;i<intersections.size()-1;i++)
        {
            ret += intersections.get(i) + "->";
        }
        ret += intersections.get(length() - 1);
        return ret;
    }
}
