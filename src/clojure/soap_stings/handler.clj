(ns soap-stings.handler
  (:use compojure.core)
  (:use soap-stings.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]))

(defroutes app-routes
  (GET "/" [] {:server "OK"})
  (GET "/virtual-servers" [] (list-virtual-servers))
  (GET "/pool-names" [] (list-pool-names))
  (GET "/draining-node" [pool-name] (list-draining-nodes pool-name))
  (GET "/nodes" [pool] (get-nodes (ring.util.codec/url-decode pool) ))
  (GET "/error-log" [] (error-log))

  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))
