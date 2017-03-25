package dbnizar.com.dbnizar.dbnizarbase.util;

import android.os.Build;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import dbnizar.com.dbnizar.BuildConfig;


public class ConstantValue {

    private String TAG = "ConstantValue";

    public static final int RC_SIGN_IN = 9001;


    public static final String header_content_type = "Content-Type: application/json";

    public static final String header_api_version = "app-version: " + BuildConfig.VERSION_NAME;

    public static final String header_device_model = "RO-MODEL: android";

    public static final String header_device_os_info = "RO-OS-INFO: " + Build.MODEL;

    public static final String baseURLForImageLoading = "http://54.244.69.187/requesto/storage/";

    public static final String header_device_token = "RO-TOKEN: sfjwoerj9203mdswjoi";


    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;


    public int convert24To12(int hourOfDay) {

        //Make the 24 hour time format to 12 hour time format
        int currentHour;
        if (hourOfDay > 11) {
            currentHour = hourOfDay - 12;
        } else {
            currentHour = hourOfDay;
        }
        return currentHour;
    }

    public String formatTimeString(String inputDate) {
        String output = null;
        if (inputDate != null && !inputDate.isEmpty()) {

            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            DateFormat outputformat = new SimpleDateFormat("hh:mm aaa");
            Date date = null;

            try {
                //Conversion of input String to date
                date = df.parse(inputDate);
                //old date format to new date format
                output = outputformat.format(date);
                System.out.println(output);
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        return output;
    }

    public String formatDateWithDay(String inputDate) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, MMM dd");//EEE dd MMM//MMM dd
        String formatDate = null;
        try {
            Date d = simpleDateFormat.parse(inputDate);
            formatDate = simpleDateFormat2.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    public String formatDateWithYear(String inputDate) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE dd MMM,yyyy");
        String formatDate = null;
        try {
            Date d = simpleDateFormat.parse(inputDate);
            formatDate = simpleDateFormat2.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    public String formatDateWithDayandYear(String inputDate) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM dd,EEE,yyyy");
        String formatDate = null;
        try {
            Date d = simpleDateFormat.parse(inputDate);
            formatDate = simpleDateFormat2.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    public long timeAgo(String timeAgo) {
        long milliseconds = 0;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = f.parse(timeAgo);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return milliseconds;
    }


    public String convertTimeAgo(String serverTime) {

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date past = format.parse(serverTime);
            Date now = new Date();
            long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
            long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());

            if (seconds < 60) {
                System.out.println(seconds + " seconds ago");

                return seconds + " seconds ago";

            } else if (minutes < 60) {

                System.out.println(minutes + " minutes ago");
                return minutes + " minutes ago";

            } else if (hours < 24) {

                System.out.println(hours + " hours ago");
                return hours + " hours ago";

            } else if (hours < 48) {

                return "Yesterday";

            } else if (days < 7) {

                System.out.println(days + " days ago");
                return days + " days ago";

            } else if (days == 7) {

                return " 1 week ago";

            } else {
                SimpleDateFormat format1 = new SimpleDateFormat("dd MMM", Locale.getDefault());

                System.out.println("Date" + format1.format(past));

                return format1.format(past);

            }
        } catch (Exception j) {
            j.printStackTrace();
        }

        return "";
    }


    public String formatPhoneNo(long phoneNo) {

        String finalFormatPhoneNo = null;
        DecimalFormat decimalFormat = new DecimalFormat("000000000");
        String phoneRawString = decimalFormat.format(phoneNo);
        MessageFormat messageFormat = new MessageFormat("({0}){1}-{2}");
        String[] phoneNumArr = {phoneRawString.substring(0, 3), phoneRawString.substring(3, 6), phoneRawString.substring(6)};
        finalFormatPhoneNo = messageFormat.format(phoneNumArr);
        return finalFormatPhoneNo;
    }


}
