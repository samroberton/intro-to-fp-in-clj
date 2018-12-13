(ns examples.example3
  (:require [clojure.data.json :as json]
            [data.campaigns :refer [campaigns]]))


(defn handler [request]
  {:status 200
   :body   (->> campaigns
                (mapcat :campaign/creatives)
                (map #(select-keys % [:creative/id :creative/text]))
                (json/write-str))})


(defn run []
  (alter-var-root #'runner/handler (constantly #'handler)))
