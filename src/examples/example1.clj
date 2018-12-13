(ns examples.example1
  (:require [ring.adapter.jetty :as jetty]
            [runner :as runner]))


(defn handler [request]
  {:status 200
   :body   "Hello, world!"})


(defn run []
  (alter-var-root #'runner/handler (constantly #'handler)))
