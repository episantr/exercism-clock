import java.time.LocalTime;

public class Clock {

    private int hour;
    private int minute;

    public Clock(int hour, int minute) {
        int totalMinutes = expressAsMinutesOfADay(hour, minute, 0);
        this.hour = (totalMinutes / 60) % 24;
        this.minute = totalMinutes % 60;
    }

    private int expressAsMinutesOfADay(int hour, int minute, int minutesToAdd) {
        int totalMinutes = hour * 60 + minute + minutesToAdd;

        int minutesOfADay = totalMinutes % (24 * 60);

        if (minutesOfADay < 0) {
            minutesOfADay = 24 * 60 + minutesOfADay;
        }
        return minutesOfADay;
    }

    public void add(int minutes) {

        int totalMinutes = expressAsMinutesOfADay(this.hour, this.minute, minutes);

        this.hour = (totalMinutes / 60) % 24;
        this.minute = totalMinutes % 60;

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
