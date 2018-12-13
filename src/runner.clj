(ns runner
  (:require [ring.adapter.jetty :as jetty]))


(declare handler)
(declare server)


(defn run []
  (alter-var-root #'server (fn [_]
                             (jetty/run-jetty #'handler {:port 8080 :join? false}))))
