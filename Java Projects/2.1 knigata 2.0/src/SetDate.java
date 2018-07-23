import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class SetDate {
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a date(format dd-mm-yyyy): ");
        String date = scanner.nextLine();
        try {
            calendar.setTime(sdf.parse(date));
            calendar.add(Calendar.DATE, 1000);
            date = sdf.format(calendar.getTime());//removable
            System.out.println("the date after 1000 days will be: " + date);
        }catch (ParseException e) {
            System.out.print("Unparsable using" + sdf);
        }

    }
}
