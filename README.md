JEP 277 Enhanced Deprecation
============================

* [JEP 277 Enhanced Deprecation](http://openjdk.java.net/jeps/277)
* [Dr. Deprecator Prescriptions: important things that you should know about obsolete Java API](https://stokito.wordpress.com/2014/11/10/deprecated-java/)



Revamp the deprecation annotation and provide tools to strengthen the tail end of the feature life cycle.


Goals
-----

* Provide better information about the status and intended disposition of APIs in the specification.
* Enhance the runtime to emit warnings so that an application's dynamic usage of deprecated APIs can be logged.
* Provide a tool to generate static information about an application's usage of deprecated APIs.
* Clarify the policies of Java SE and the JDK with regard to feature life cycle, in particular, requirements around annotating features as deprecated, and the amount of notice that needs to be given before a feature is removed. This should allow defunct features to be removed in a more timely fashion.


About this library
------------------
This library is based on code from article [What Might a New @Deprecated Look Like?](https://dzone.com/articles/what-might-a-new-deprecated-look-like)
