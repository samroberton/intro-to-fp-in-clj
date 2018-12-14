(ns examples.example2
  (:require [clojure.data.json :as json]
            [data.campaigns :refer [campaigns]]))


;; A simple request handler which just returns the first creative.

(defn handler [request]
  {:status 200
   :body   (json/write-str
            (select-keys (first (:campaign/creatives (first campaigns)))
                         [:creative/id :creative/text]))})


;; This does the same thing, but is a bit more readable.

(defn handler' [request]
  {:status 200
   :body   (-> (first campaigns)
               (:campaign/creatives)
               (first)
               (select-keys [:creative/id :creative/text])
               (json/write-str))})


;; Again, `(run)` will "install" `handler` as the runner's request handler.

(defn run []
  (alter-var-root #'runner/handler (constantly #'handler)))
