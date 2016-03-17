import com.getsentry.raven.logback.SentryAppender
import grails.util.BuildSettings
import grails.util.Environment

// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}

root(ERROR, ['STDOUT'])

appender('Sentry', SentryAppender) // Register the Sentry appender
root(WARN, ['Sentry']) // Send WARN and above to Sentry

def targetDir = BuildSettings.TARGET_DIR
if (Environment.isDevelopmentMode() && targetDir) {
    appender("FULL_STACKTRACE", FileAppender) {
        file = "${targetDir}/stacktrace.log"
        append = true
        encoder(PatternLayoutEncoder) {
            pattern = "%level %logger - %msg%n"
        }
    }
    logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)
}
