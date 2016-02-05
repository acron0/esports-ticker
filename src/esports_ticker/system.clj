(ns esports-ticker.system
  (:require [clojure.tools.logging :as log]
            [clj-logging-config.log4j :as log-config]
            [com.stuartsierra.component :as component]
            ;;
            [esports-ticker.database]
            [esports-ticker.aggregator]
            [esports-ticker.publisher]))

(defn system
  []
  (component/system-map
   :db         (esports-ticker.database/make!   "localhost" 6379)
   :aggregator (esports-ticker.aggregator/make! "localhost" 6379)
   :publisher  (esports-ticker.publisher/make!  "localhost" 6379)))

(defn set-default-root-logger!
  ([]
   (set-default-root-logger! :info))
  ([loglevel]
   (log-config/set-loggers! :root
                            {:level loglevel
                             :pattern "%d (%p) [%-25c] - %m%n"})))

(defn start
  [system]
  (set-default-root-logger!)
  (log/info "eSports ticker is starting...")
  (let [result (component/start-system system)]
    (log/info "eSports ticker has started.")
    result))

(defn stop
  [system]
  (log/info "eSports ticker is stopping...")
  (let [result (component/stop-system system)]
    (log/info "eSports ticker has stopped.")
    result))
