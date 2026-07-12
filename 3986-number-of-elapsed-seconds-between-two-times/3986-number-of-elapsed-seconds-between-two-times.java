class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int start = convert(startTime);
        int end = convert(endTime);

        return end - start;
    }

    public int convert(String time){
        String[] parts = time.split(":");

        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }
}