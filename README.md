Raven Java Examples
===================

This repository contains example Sentry integrations using
[`raven-java`][raven-java] for a variety of different JVM-based libraries and
frameworks.

Many of the examples can be installed, compiled and run with [Maven][maven]:

    mvn install compile exec:java

To report to an existing Sentry installation, set the `SENTRY_DSN` environment
variable:

    SENTRY_DSN=https://public:private@host:port/1 mvn exec:java

To use a specific Raven version such a `SNAPSHOT` release, provide the
`raven.version` property to the Maven invocation:

    mvn -Draven.version=6.0.1-SNAPSHOT exec:java

[maven]: http://maven.apache.org/
[raven-java]: https://github.com/getsentry/raven-java
