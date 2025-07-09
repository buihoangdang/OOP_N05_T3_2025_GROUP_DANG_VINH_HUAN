public class Time {
    // Method to convert seconds to hours, minutes, and seconds
    public static String convertToHoursMinutesSeconds(int giay) {
        int sogio = giay / 3600;
        int sophut = (giay % 3600) / 60;
        int sogiayconlai = giay % 60;
        
        return sogio + " gio, " + sophut + " phut, " + sogiayconlai + " giay";
    }
}
