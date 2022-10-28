import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Date {
  private int sec;
  private int min;
  private int hour;
  private int day;
  private int month;
  private int year;

  public Date(int sec, int min, int hour, int day, int month, int year) {
    this.sec = sec;
    this.min = min;
    this.hour = hour;
    this.day = day;
    this.month = month;
    this.year = year;
  }
}
