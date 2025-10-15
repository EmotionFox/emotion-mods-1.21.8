package fr.emotion.emomodcore.utils;

public class DreamClientData {
    private static long awakening;
    private static long period;
    private static boolean dreaming;

    public static void setAwakening(long value) {
        awakening = value;
    }

    public static void setPeriod(long value){
        period = value;
    }

    public static void setDreaming(boolean value) {
        dreaming = value;
    }

    public static long getAwakening() {
        return awakening;
    }

    public static long getPeriod(){
        return period;
    }

    public static boolean isDreaming() {
        return dreaming;
    }
}
