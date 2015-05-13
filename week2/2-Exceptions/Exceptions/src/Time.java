import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
	private int hour, minute, second, date, month, year;

	public Time() {
	}

	public Time(int hour, int minute, int second, int date, int month, int year) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.date = date;
		this.month = month;
		this.year = year;
		
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("Invalid hour");
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("Invalid minute");
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("Invalid second");
		if (getMonth() == 1 || getMonth() == 3 || getMonth() == 5 || getMonth() == 7 || getMonth() == 8
				|| getMonth() == 10 || getMonth() == 12) {
			if (date < 1 || date >= 32)
				throw new IllegalArgumentException("Invalid date");
		} else if (getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11) {
			if (date < 1 || date >= 31)
				throw new IllegalArgumentException("Invalid date");
		} else if (getMonth() == 2) {
			if (getYear() % 4 == 0) {
				if (date < 1 || date >= 30)
					throw new IllegalArgumentException("Invalid date");
			} else {
				if (date < 1 || date >= 29)
					throw new IllegalArgumentException("Invalid date");
			}
		}
		if (month < 1 || month >= 13)
			throw new IllegalArgumentException("Invalid month");
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
		String timeStamp = new SimpleDateFormat("dd:MM:yyyy:HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	
	public static void main(String[] args) {
		Time time = new Time(14, 3, 25, 24, 2, 2015);
		System.out.println(time.toString());
		
		Time curTime = new Time();
		System.out.println(curTime.now());
	}
}