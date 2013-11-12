(ns soap-stings.handler
  (:use [compojure.core]
        [soap-stings.config]
        [soap-stings.core]
        [ring.util.codec :only [url-decode]])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]))

(defroutes app-routes
  (GET "/" []
       "OK")
  (GET "/virtual-servers" []
       (virtual-servers))
  (GET "/pool-names" []
       (pool-names))
  (GET "/draining/:pool-name" [pool-name]
       (draining (url-decode pool-name)))
  (GET "/nodes/:pool" [pool]
       (get-nodes (url-decode pool)))
  (GET "/error-log" []
       (error-log))
  (PUT "/pool/:pool/:node" [pool node]
       (add-node pool node) "Node added")
  (PUT "/drain/:pool/:node" [pool node]
       (drain-node pool node) "Node set to drain connections")
  (DELETE "/pool/:pool/:node" [pool node]
          (remove-node pool node) "Node removed")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))
