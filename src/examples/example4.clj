(ns examples.example4
  (:require [clojure.data.json :as json]
            [data.campaigns :refer [campaigns]]))


(defn handler [request]
  {:status 200
   :body   (->> campaigns
                (remove :campaign/targetting)
                (mapcat :campaign/creatives)
                (remove :creative/targetting)
                (map #(select-keys % [:creative/id :creative/text]))
                (json/write-str))})


(defn run []
  (alter-var-root #'runner/handler (constantly #'handler)))
