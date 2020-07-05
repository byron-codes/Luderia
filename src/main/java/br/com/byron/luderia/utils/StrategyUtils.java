package br.com.byron.luderia.utils;

public class StrategyUtils {

    public static String formatRepositoryName(Class clazz) {
        StringBuilder sb = new StringBuilder();
        sb.append("I");
        sb.append(clazz.getSimpleName());
        sb.append("Repository");
        return sb.toString();
    }

}
