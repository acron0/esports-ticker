(ns esports-ticker.aggregator
  (:require [com.stuartsierra.component :as component]
            [clojure.tools.logging :as log]))

(defrecord Aggregator [host port]
  component/Lifecycle
  (start [component]
    (log/info "- Starting aggregator")
    (let [conn 123]
      (assoc component :connection conn)))

  (stop [component]
    (log/info "- Stopping aggregator")
    (assoc component :connection nil)))

(defn make!
  [host port]
  (->Aggregator host port))
