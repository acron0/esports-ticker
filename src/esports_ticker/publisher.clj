(ns esports-ticker.publisher
  (:require [com.stuartsierra.component :as component]
            [clojure.tools.logging :as log]))

(defrecord Publisher [host port]
  component/Lifecycle
  (start [component]
    (log/info "- Starting publisher")
    (let [conn 123]
      (assoc component :connection conn)))

  (stop [component]
    (log/info "- Stopping publisher")
    (assoc component :connection nil)))

(defn make!
  [host port]
  (->Publisher host port))
