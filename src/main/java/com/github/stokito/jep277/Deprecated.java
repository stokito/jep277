package com.github.stokito.jep277;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Conceptual improvement on standard @java.lang.Deprecated annotation
 * based on preliminary discussion related to JEP 277 and on
 * desire to include context details with deprecation annotation
 * rather than relying on presence of Javadoc's @deprecated.
 * <p/>
 * Javadoc comments in this annotation definition are largely
 * based on descriptions in JEP 277 (http://openjdk.java.net/jeps/277).
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecated {
    /**
     * JEP 277-defined reasons and associated explanations.
     */
    enum Reason {
        /**
         * This API has been deprecated without any reason having been given.
         * This is the default value; everything that's deprecated today
         * implicitly has a deprecation reason of UNSPECIFIED.
         */
        UNSPECIFIED,
        /**
         * This API is earmarked for removal in a future JDK release. Note,
         * the use of the word "condemned" here is used in the sense of a
         * structure that is intended to be torn down. The term is not mean
         * to imply any moral censure.
         */
        CONDEMNED,
        /**
         * Use of this API can lead to data loss, deadlock, security
         * vulnerability, incorrect results, or loss of JVM integrity.
         */
        DANGEROUS,
        /**
         * This API is no longer necessary, and usages should be removed.
         * No replacement API exists. Note that OBSOLETE APIs might or
         * might not be marked CONDEMNED.
         */
        OBSOLETE,
        /**
         * This API has been replaced by a newer API, and usages should be
         * migrated away from this API to the newer API. Note that SUPERSEDED
         * APIs might or might not be marked CONDEMNED.
         */
        SUPERSEDED,
        /**
         * Calling this has no effect or will unconditionally throw an exception.
         */
        UNIMPLEMENTED,
        /**
         * This API is not a stable part of the specification, and it may
         * change incompatibly or disappear at any time.
         */
        EXPERIMENTAL;
    }

    /**
     * Provides any combination of one or more of the enum constants,
     * although not all combinations make sense. It is syntactically possible,
     * though perverse, to provide an empty array. Such a case should be
     * treated as if UNSPECIFIED were present.
     *
     * @return One or more Reasons for deprecation; default value is the enum
     * constant UNSPECIFIED and absence of values should be treated as such.
     */
    Reason[] value();

    /**
     * Provides Strings representing any APIs that replace this API.
     * This should not specify any replacements if reason is OBSOLETE.
     *
     * @return Strings returned by this method should be links to replacement
     * APIs for the API being deprecated. Each string should be in the same
     * format as the @link Javadoc tag.
     */
    String[] replacement();

    /**
     * Provides the release in which the API was deprecated.
     *
     * @return Release number at which this API became deprecated
     * in a free-form syntax String with the release numbering
     * following the same scheme as the @since Javadoc tag.
     */
    String since();

    /**
     * Provides the anticipated complete removal of this deprecated API
     * if any known date or version is anticipated for the API's removal.
     * This value is most likely to be set for reasons of CONDEMNED,
     * OBSOLETE, and SUPERSEDED. This value is NOT described in JEP 277.
     *
     * @return Date or version in which it is anticipated that this
     * API will be removed altogether.
     */
    String anticipatedRemoval() default "Not Planned";
}
