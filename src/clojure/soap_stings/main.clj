(ns soap-stings.main
  (:gen-class)
  (:require [cheshire.core :refer :all])
  (:use [clojure.tools.cli :only [cli]])
  (:use [soap-stings.core]))

(defn array? [x] (-> x class .isArray))

(defn see [x]
  (if (array? x) (map see x) x))

(defn inspect [x]
  (-> x see generate-string println))

(defn -main [& args]
  (let [command (first args)
        params (rest args)]
    (when (= "list-virtual-servers" command)
      (inspect (list-virtual-servers)))
    (when (= "list-pool-names" command)
      (inspect (list-pool-names)))
    (when (= "list-draining-node" command)
      (inspect (list-draining-node (first params))))
    (when (= "add-node" command)
      (add-node (first params) (last params))
      (inspect (get-nodes (first params))))
    (when (= "get-nodes" command)
      (inspect (get-nodes (first params))))
    (when (= "remove-node" command)
      (remove-node (first params) (last params))
      (inspect (get-nodes (first params))))
    (when (= "drain-node" command)
      (drain-node (first params) (last params))
      (inspect (list-draining-node (first params))))
    (when (= "error-log" command)
      (error-log))))
