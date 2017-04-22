(ns sentry-clojure-example.core
  (:require [clojure.tools.logging :as log]))

(defn -main [& args]
  (log/debug "Debug message")
  (log/info "Info message")
  (log/warn "Warn message")
  (try
    (println (/ 1 0))
    (catch Exception e
      (log/error e "Caught exception!"))))
