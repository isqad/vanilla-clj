(ns vanilla.handler
  (:use [selmer.parser])
  (:require [compojure.route :as route]
            [compojure.core :refer :all]
            [compojure.handler :as handler]))

(defroutes app-routes
  (route/resources "/")
  (route/not-found (render-file "vanilla/views/404.html" {})))

(defn home
  []
  (render-file "vanilla/views/home.html" {}))

(defroutes home-routes
  (GET "/" [] (home))) 

(def app
  (handler/site (routes home-routes app-routes)))

(defn init
  []
  (println "Vanilla started"))

