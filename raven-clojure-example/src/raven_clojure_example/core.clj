(ns raven-clojure-example.core
  (:require [clojure.tools.logging :as log]))

(defn -main [& args]
  (try
    (println (/ 1 0))
    (catch Exception e
      (log/error e "Caught exception!"))))
