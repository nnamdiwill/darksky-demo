package framework;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public String  currentDate(int num){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf  = new SimpleDateFormat("Ha");


        String todayDate =  sdf.format(cal.getInstance());
        cal.setTime(new Date());
        cal.add(Calendar.HOUR,num);



        return sdf.format(cal.getTime());

    }

}
