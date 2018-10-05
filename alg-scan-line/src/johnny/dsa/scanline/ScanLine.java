package johnny.dsa.scanline;

public class ScanLine {
    // brute force, O(p*y), p is the number of people, y is the year range.
    public int getMostPopulationYear2(int[][] people) {
        if (people == null || people.length == 0) {
            return 0;
        }
        
        int yearStart = Integer.MAX_VALUE, yearEnd = Integer.MIN_VALUE;
        for (int[] person : people) {
            yearStart = Math.min(yearStart, person[0]);
            yearEnd = Math.max(yearEnd, person[1]);
        }
        
        int max = 0;
        int[] years = new int[yearEnd-yearStart + 1];
        for (int i = 0; i < years.length; i++) {
            for (int j = 0; j < people.length; j++) {
                if ((people[j][0] <= i + yearStart) && 
                    (people[j][1] > i + yearStart)) {
                    years[i]++;
                }
            }
            max = Math.max(max, years[i]);
        }

        return max;
    }
    // timeline, add 1 if born, minus 1 if dead, count the maximum of the timeline. O(p+y)
    public int getMostPopulationYear(int[][] people) {
        if (people == null || people.length == 0) {
            return 0;
        }
        
        int yearStart = Integer.MAX_VALUE, yearEnd = Integer.MIN_VALUE;
        for (int[] person : people) {
            yearStart = Math.min(yearStart, person[0]);
            yearEnd = Math.max(yearEnd, person[1]);
        }
        
        int[] years = new int[yearEnd-yearStart + 1];
        for (int i = 0; i < people.length; i++) {
            years[people[i][0] - yearStart]++;
            years[people[i][1] - yearStart]--;
        }
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < years.length; i++) {
            count += years[i];
            max = Math.max(max, count);
        }
        
        return max;
    }
}
