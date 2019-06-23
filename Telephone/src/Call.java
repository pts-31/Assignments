import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Call{
	String name;
	long phno;
	String duration;
	short type;
	Date date;
	
	Call(String n, long no, Date t1, Date t2,short type)
	{
	this.name=n;
	this.phno=no;
	this.duration=getDuration(t1, t2);
	this.type=type;
	//type: 0-made, 1-received, 2-missed
	}
	
	public String getDuration(Date t1, Date t2)
	{
		String ans="";
		//calculate duration
		long difference=t2.getTime()-t1.getTime();
		final long hr = TimeUnit.MILLISECONDS.toHours(difference);
		final long min = TimeUnit.MILLISECONDS.toMinutes(difference)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(difference));
		final long sec = TimeUnit.MILLISECONDS.toSeconds(difference)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(difference));
		
		ans=String.valueOf(hr)+":"+String.valueOf(min)+":"+String.valueOf(sec);
		return ans;
	}
}