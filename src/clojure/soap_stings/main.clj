(ns soap-stings.main
  (:gen-class)
  (:require [soap-stings.handler :as handler])
  (:use ring.adapter.jetty))

(defn -main [& args]
  (run-jetty handler/app {:port 8080}))
