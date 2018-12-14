(ns examples.example4
  (:require [clojure.data.json :as json]
            [data.campaigns :refer [campaigns]]))


;; Ok, returning all of them is a bit much. We should probably apply the
;; targetting rules.  That sounds hard, though, so how about we just guarantee
;; that we don't show creatives whose targetting isn't met by just removing all
;; campaigns and creatives with targetting rules?


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
