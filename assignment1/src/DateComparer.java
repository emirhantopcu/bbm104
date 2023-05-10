import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class DateComparer {
    public DateComparer() {
    }                                                       //Compares if the target date is between the given two dates
    public static boolean isBetween(String startDate, String endDate, String targetDate){
        SimpleDateFormat sdformat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date d1 = sdformat.parse(startDate);
            Date d2 = sdformat.parse(endDate);
            Date dT = sdformat.parse(targetDate);
            if (dT.compareTo(d1) > 0 && dT.compareTo(d2) < 0){
                return true;
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
