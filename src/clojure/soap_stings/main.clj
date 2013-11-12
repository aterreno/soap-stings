(ns soap-stings.main
  (:gen-class)
  (:require [soap-stings.handler :as handler]
            [cconf.core :as cfg])
  (:use [ring.adapter.jetty]
        [soap-stings.config]))

(defn -main [& args]
  (let [env (first args)]
    (reset! settings (cfg/file (str "config-" env ".json")))
    (run-jetty handler/app {:port 6174})))
