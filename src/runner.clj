(ns runner
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.params :as params]))


(declare handler)
(declare server)


(defn run []
  (alter-var-root #'server
                  (fn [_]
                    (jetty/run-jetty (params/wrap-params (fn [req]
                                                           (handler req)))
                                     {:port  8080
                                      :join? false}))))

(.addShutdownHook (Runtime/getRuntime)
                  (Thread. (fn []
                             (some-> server (.stop)))))
