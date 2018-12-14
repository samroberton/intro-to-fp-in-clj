;; This form at the top of each file is just a namespace declaration which you
;; can mostly ignore.

(ns examples.example1
  (:require [ring.adapter.jetty :as jetty]
            [runner]))



;; Pretty much the simplest possible web request handler.

(defn handler [request]
  {:status 200
   :body   "Hello, world!"})



;; Each of these "example" namespaces has a `run` function at the bottom which
;; just installs this namespace's `handler` function as the one in use by the
;; `runner` namespace.  This is not very elegant, but it's convenient for
;; switching around between examples in a REPL.
;;
;; So, execute `(examples.example1/run)`, and you'll "install" this request
;; handler as the operative one.  You need to have run `(runner/run)` once since
;; starting up your REPL in order to start up the web handler, too.

(defn run []
  (alter-var-root #'runner/handler (constantly #'handler)))
