import java.util.ArrayList;

public class PathUtils
{
    private static int count;
    private static boolean[][] flag;
    private static ArrayList<Path> paths;
    private static Path path;
    public static int countPaths(Intersection start, Intersection end)
    {
        if (start.getX()<0||start.getY()<0)
            return 0;
        if (start.getX()>end.getX()&&start.getY()>end.getY())
            return 0;
        count = 0;
        flag = new boolean[100][100];

        countDfs(start, end);

        return count;
    }

    public static ArrayList<Path> findAllPaths(Intersection start,Intersection end)
    {
        if (start.getX()<0||start.getY()<0)
            return new ArrayList<>();
        if (start.getX()>end.getX()&&start.getY()>end.getY())
            return new ArrayList<>();
        path = new Path();
        paths = new ArrayList<>();
        flag = new boolean[100][100];
        pathsDfs(start, end);
        for (int i=0;i<paths.size();i++)
        {
            paths.get(i).addHead(start);
        }
        return paths;
    }

    private static void countDfs(Intersection start,Intersection end)
    {
        int x1 = start.getX();
        int y1 = start.getY();
        if (start.equals(end))
        {
            count++;
        }
        else
        {
            if (!flag[x1+1][y1]&&x1+1<= end.getX())// east
            {
                flag[x1+1][y1] = true;
                countDfs(start.goEast(),end);
            }
            if (!flag[x1][y1+1]&&y1+1<=end.getY())
            {
                flag[x1][y1+1] = true;
                countDfs(start.goNorth(),end);
            }
        }
        flag[x1][y1] = false;
    }

    private static void pathsDfs(Intersection start,Intersection end)
    {
        int x1 = start.getX();
        int y1 = start.getY();
        if (start.equals(end))
        {
            Path toAdd = new Path();
            for(int i=path.length()-1;i>=0;i--)
            {
                Intersection intersection = new Intersection(path.getIntersection(i).getX(),path.getIntersection(i).getY());
                toAdd.addHead(intersection);
            }
            paths.add(toAdd);
        }
        else
        {
            if (!flag[x1+1][y1]&&x1+1<= end.getX())// east
            {
                flag[x1+1][y1] = true;
                path.addTail(new Intersection(x1+1,y1));
                pathsDfs(start.goEast(),end);
            }
            if (!flag[x1][y1+1]&&y1+1<=end.getY())// north
            {
                flag[x1][y1+1] = true;
                path.addTail(new Intersection(x1,y1+1));
                pathsDfs(start.goNorth(),end);
            }
        }
        flag[x1][y1] = false;
        path.removeTail();
    }
}
