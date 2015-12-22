package com.github.stokito.jep277;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static com.github.stokito.jep277.Deprecated.Reason.*;

/**
 * Demonstrates how new and improved @Deprecated might be used.
 */
@Deprecated(value = {SUPERSEDED, CONDEMNED}, since = "1.5", anticipatedRemoval = "1.9", replacement = "com.github.stokito.jep277.NewClass")
public class DeprecatedClass {
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Deprecated(value = {DANGEROUS}, since = "1.0", replacement = "java.text.SimpleDateFormat#SimpleDateFormat")
    public DateFormat getDateFormatter() {
        return dateFormat;
    }
}