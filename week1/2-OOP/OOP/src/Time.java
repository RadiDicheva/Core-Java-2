import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
	private int hour, minute, second, date, month, year;
	
	public Time() {}

	public Time(int hour, int minute, int second, int date, int month, int year) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.date = date;
		this.month = month;
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second + ":" + date + ":" + month
				+ ":" + year;
	}
	
	public static String now() {
		String timeStamp = new SimpleDateFormat("dd:MM:yyyy:HH:mm:ss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
}
