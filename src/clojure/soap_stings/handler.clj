(ns soap-stings.handler
  (:use [compojure.core]
        [soap-stings.core]
        [ring.util.codec :only [url-decode]])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]))

(defroutes app-routes
  (GET "/" [] "OK")
  (GET "/virtual-servers" [] (list-virtual-servers))
  (GET "/pool-names" [] (list-pool-names))
  (GET "/draining-node/:pool-name" [pool-name] (list-draining-node (url-decode pool-name)))
  (GET "/nodes/:pool" [pool] (get-nodes (url-decode pool)))
  (GET "/error-log" [] (error-log))

  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      middleware/wrap-json-body
      middleware/wrap-json-response))
