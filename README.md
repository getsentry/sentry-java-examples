Sentry Java Examples
===================

This repository contains example Sentry integrations using
[`sentry-java`][sentry-java] for a variety of different JVM-based libraries and
frameworks.

Many of the examples can be installed, compiled and run with [Maven][maven]:

    mvn install compile exec:java

To report to an existing Sentry installation, set the `SENTRY_DSN` environment
variable:

    SENTRY_DSN=https://public:private@host:port/1 mvn exec:java

To use a specific Sentry version such a `SNAPSHOT` release, provide the
`sentry.version` property to the Maven invocation:

    mvn -Dsentry.version=1.0.0 exec:java

[maven]: http://maven.apache.org/
[sentry-java]: https://github.com/getsentry/sentry-java
