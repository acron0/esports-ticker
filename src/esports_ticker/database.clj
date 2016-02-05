(ns esports-ticker.database
  (:require [com.stuartsierra.component :as component]
            [clojure.tools.logging :as log]))

(defrecord Database [host port]
  component/Lifecycle
  (start [component]
    (log/info "- Starting database")
    (let [conn 123]
      (assoc component :connection conn)))

  (stop [component]
    (log/info "- Stopping database")
    (assoc component :connection nil)))

(defn make!
  [host port]
  (->Database host port))
