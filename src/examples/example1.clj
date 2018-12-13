(ns examples.example1
  (:require [ring.adapter.jetty :as jetty]))


(defn handler [request]
  {:status 200
   :body   "Hello, world!"})


(defn run []
  (jetty/run-jetty #'handler {:port 8080 :join? false}))
