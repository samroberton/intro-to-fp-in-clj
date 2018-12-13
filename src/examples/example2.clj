(ns examples.example2
  (:require [clojure.data.json :as json]
            [data.campaigns :refer [campaigns]]))


(defn handler [request]
  {:status 200
   :body   (json/write-str (select-keys (first (:campaign/creatives (first campaigns)))
                                        [:creative/id :creative/text]))})


(defn handler' [request]
  {:status 200
   :body   (-> (first campaigns)
               (:campaign/creatives)
               (first)
               (select-keys [:creative/id :creative/text])
               (json/write-str))})


(defn run []
  (alter-var-root #'runner/handler (constantly #'handler)))
