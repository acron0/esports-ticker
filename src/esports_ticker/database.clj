(ns esports-ticker.database
  (:require [com.stuartsierra.component :as component]))

(defrecord Database [host port]
  component/Lifecycle

  (start [component]
    (println ";; Starting database")
    (let [conn 123]
      (assoc component :connection conn)))

  (stop [component]
    (println ";; Stopping database")
    (assoc component :connection nil)))
