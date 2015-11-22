(ns vanilla.handler
  (:use [selmer.parser])
  (:require [compojure.route :as route]
            [compojure.core :refer :all]
            [ring.util.anti-forgery :refer [anti-forgery-field]]
            [ring.middleware.defaults :refer :all]
            [compojure.handler :as handler]))

(add-tag! :csrf-field (fn [_ _] (anti-forgery-field)))

(defroutes app-routes
  (route/resources "/")
  (route/not-found (render-file "vanilla/views/404.html" {})))

(defn home
  []
  (render-file "vanilla/views/home.html" {}))

(defn sessions-new
  []
  (render-file "vanilla/views/sessions/new.html" {}))

(defn sessions-create
  [request]
  (str request))

(defroutes home-routes
  (GET "/" [] (home))
  (GET "/sessions/new" [] (sessions-new))
  (POST "/sessions" request (sessions-create request)))

; Эта перeменная хранит handler - ф-я сформированная из цепочки ф-ий высшего порядка
; handler один на все приложение, это концепция ring
; аргумент для handler'а - request - простой map
(def app
  (-> 
    (routes home-routes app-routes)
    (wrap-defaults site-defaults)))

(defn init
  []
  (println "Vanilla started"))

