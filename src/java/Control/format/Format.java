package Control.format;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

    public String formatDate(String sdate) {
        String originalStringFormat = "yyyy-MM-dd";
        String desiredStringFormat = "dd/MM/yyyy";

        SimpleDateFormat readingFormat = new SimpleDateFormat(originalStringFormat);
        SimpleDateFormat outputFormat = new SimpleDateFormat(desiredStringFormat);
        String stdate = null;
        try {
            Date date = readingFormat.parse(sdate);
            outputFormat.format(date);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            stdate = dateFormat.format(date);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return stdate;
    }

    public String formatTime(String stime) {
        String time = stime.substring(0, 5);
        return time;
    }

// Only for IntelliJ
    public String addTwoDays(String sdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(sdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 2);
        String dateAfter = sdf.format(cal.getTime());
        return dateAfter;
    }

    public String formatPrice(String price) {
        String c = ",";
        int l = price.length();
        if (l >= 4) {
            price = price.substring(0, price.length() - 2);
            if (price.length() == 6) {
                price = price.substring(0, 3) + c + price.substring(3, price.length());
            } else {
                price = price.charAt(0) + c + price.substring(1, 4) + c + price.substring(4, price.length());
            }
        }
        return price;
    }
    
    
}
