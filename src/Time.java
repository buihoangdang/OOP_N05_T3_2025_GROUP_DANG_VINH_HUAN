public class Time {
    // Method to convert seconds to hours, minutes, and seconds
    public static String convertToHoursMinutesSeconds(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;
        
        return hours + " hours, " + minutes + " minutes, " + remainingSeconds + " seconds";
    }
}
