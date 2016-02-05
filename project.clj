(defproject esports-ticker "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.taoensso/carmine "2.12.2"]
                 [com.stuartsierra/component "0.3.1"]
                 [org.clojure/tools.logging "0.3.1"]
                 [clj-logging-config "1.9.12"]]
  :source-paths ["src"
                 "src/ext/abios-clj/src"] ;; for abios-clj
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.3"]
                                  [org.clojure/java.classpath "0.2.0"]]}})
