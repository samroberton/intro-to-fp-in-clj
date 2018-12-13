(ns examples.example6
  (:require [clojure.data.json :as json]
            [data.campaigns :refer [campaigns]]))


(defn targetted? [targetting-rules query-params]
  (letfn [(apply-rule [[target-kw rule-fn]]
            (rule-fn (get query-params (name target-kw))))]
    (every? apply-rule targetting-rules)))



(defn handler [{:keys [query-params]}]
  {:status 200
   :body   (->> campaigns
                (remove #(not (targetted? (:campaign/targetting %) query-params)))
                (mapcat :campaign/creatives)
                (remove #(not (targetted? (:creative/targetting %) query-params)))
                (map #(select-keys % [:creative/id :creative/text]))
                (distinct)
                (json/write-str))})


#_
(handler {:query-params {"eventid" "AUSvNZL"
                         "gender"  "M"
                         "age"     "18-24"}})

(defn run []
  (alter-var-root #'runner/handler (constantly #'handler)))
