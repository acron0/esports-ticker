(ns esports-ticker.core
  (:require [clojure.tools.logging :as log]
            [clj-logging-config.log4j :as log-config]))

(defn set-default-root-logger!
  ([]
   (set-default-root-logger! :info))
  ([loglevel]
   (log-config/set-loggers! :root
                            {:level loglevel
                             :pattern "%d (%p) [%c] - %m%n"})))

(defn -main
  []
  (set-default-root-logger!)
  (log/info "Just a plain logging message, you should see the level at the beginning"))
