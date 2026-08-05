// Hour hand moves 30° per hour + 0.5° per minute, minute hand moves 6° per minute.
// Calculate angle difference and return the smaller angle between both hands.

class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double minuteAngle = minutes * 6;

        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360 - diff);
    }
}