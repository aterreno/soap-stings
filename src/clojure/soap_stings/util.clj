(ns soap-stings.util)

(defn array? [x] (-> x class .isArray))

(defn see [x]
  (if (array? x) (map see x) x))
