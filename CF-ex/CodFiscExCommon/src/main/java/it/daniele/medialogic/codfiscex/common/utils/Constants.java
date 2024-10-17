package it.daniele.medialogic.codfiscex.common.utils;

import java.util.HashMap;
import java.util.List;

public class Constants {

    public static class Regex {

        public static final String CF_REGEXP = "^[A-Z]{6}\\d{2}[ABCDEHLMPRST]\\d{2}[A-Z]\\d{3}[A-Z]$";
    }

    public static class UtilityConstants{

        public static final HashMap<String, Integer> CF_MONTHS_MAP = new HashMap<>() {{
                                                                        put("A", 1);
                                                                        put("B", 2);
                                                                        put("C", 3);
                                                                        put("D", 4);
                                                                        put("E", 5);
                                                                        put("H", 6);
                                                                        put("L", 7);
                                                                        put("M", 8);
                                                                        put("P", 9);
                                                                        put("R", 10);
                                                                        put("S", 11);
                                                                        put("T", 12);
                                                                    }};
    }

    public static class Messages {

        public static final String CF_CHECK_KO  = "Il codice fiscale inserito non è valido.";
        public static final String CF_ASSENTE   = "Non è stato inserito il codice fiscale.";
        public static final String DATE_KO = "Data di nascita inserita non valida";
    }

}
