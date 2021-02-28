import java.time.LocalTime;

public class Clock {

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int MINUTES_PER_DAY = MINUTES_PER_HOUR * HOURS_PER_DAY;

    private int hour;
    private int minute;

    public Clock(int hour, int minute) {
        int totalMinutes = expressAsMinutesOfADay(hour, minute, 0);
        this.hour = (totalMinutes / MINUTES_PER_HOUR) % HOURS_PER_DAY;
        this.minute = totalMinutes % MINUTES_PER_HOUR;
    }

    private int expressAsMinutesOfADay(int hour, int minute, int minutesToAdd) {
        int totalMinutes = hour * MINUTES_PER_HOUR + minute + minutesToAdd;

        int minutesOfADay = totalMinutes % MINUTES_PER_DAY;

        if (minutesOfADay < 0) {
            minutesOfADay = MINUTES_PER_DAY + minutesOfADay;
        }
        return minutesOfADay;
    }

    public void add(int minutes) {

        int totalMinutes = expressAsMinutesOfADay(this.hour, this.minute, minutes);

        this.hour = (totalMinutes / MINUTES_PER_HOUR) % HOURS_PER_DAY;
        this.minute = totalMinutes % MINUTES_PER_HOUR;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clock clock = (Clock) o;

        if (minute != clock.minute) return false;
        return hour == clock.hour;
    }

    @Override
    public int hashCode() {
        int result = minute;
        result = 31 * result + hour;
        return result;
    }

    @Override
    public String toString() {
        LocalTime time = LocalTime.of(this.hour, this.minute);
        return time.toString();
    }
}
