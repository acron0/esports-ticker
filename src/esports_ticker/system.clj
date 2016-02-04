(ns esports-ticker.system
  (:require [clojure.tools.logging :as log]
            [clj-logging-config.log4j :as log-config]
            [com.stuartsierra.component :as component]
            ;;
            [esports-ticker.database]))

(defn system
  []
  (component/system-map
   :db (esports-ticker.database/make! "localhost" 6379)))

(defn set-default-root-logger!
  ([]
   (set-default-root-logger! :info))
  ([loglevel]
   (log-config/set-loggers! :root
                            {:level loglevel
                             :pattern "%d (%p) [%c] - %m%n"})))

(defn start
  [system]
  (set-default-root-logger!)
  (log/info "Just a plain logging message, you should see the level at the beginning")
  (component/start-system system))

(defn stop
  [system]
  (component/stop-system system))
