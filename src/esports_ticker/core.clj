(ns esports-ticker.core
  (:require [clojure.tools.logging :as log]
            [clj-logging-config.log4j :as log-config]
            [com.stuartsierra.component :as component]
            ;;
            [esports-ticker.database]))
