import java.util.*;


public class MergerOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int n = intervals.size();
        ArrayList<Interval> result = new ArrayList<>(intervals);
        Collections.sort(result, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return ((Integer)b.start).compareTo((Integer)a.start) > 0 ? -1 : 1;
            }  
        });
        // printIntervals(result);
        for (int i=0; i<n-1; ) {
            Interval tmp = new Interval(result.get(i).start, result.get(i).end);
            Interval tmp_next = new Interval(result.get(i+1).start, result.get(i+1).end);
            int l1 = tmp.end;
            int f2 = tmp_next.start;
            int l2 = tmp_next.end;
            if (l1 >= f2) {
                tmp.end = l2 > l1 ? l2 : l1;
                result.remove(i);
                result.add(i, tmp);
                result.remove(i+1);
                n--;
            }
            else i++;
        }
        return result;
    }

    void printIntervals(ArrayList<Interval> tmp) {
        System.out.print("\n");
        for (int i=0; i<tmp.size(); i++) {
            System.out.print("(" + tmp.get(i).start +", "+ tmp.get(i).end+") ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> A = new ArrayList<>();
        A.add(new Interval(6, 7));
        A.add(new Interval(1, 7));
        A.add(new Interval(8, 9));
        A.add(new Interval(0, 2));
        A.add(new Interval(5, 8));
        A.add(new Interval(6, 8));
        A.add(new Interval(7, 21));
        A.add(new Interval(9, 11));
        A.add(new Interval(23, 24));
        A.add(new Interval(45, 57));
        A.add(new Interval(6, 21));
        A.add(new Interval(8, 11));
        A.add(new Interval(9, 21));
        MergerOverlappingIntervals obj = new MergerOverlappingIntervals();
        ArrayList<Interval> B = obj.merge(A);
        obj.printIntervals(B);
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}