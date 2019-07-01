(ns bowling-scoring.specs
  (:require
   [bowling-scoring.frame-specs :as fs]
   [bowling-scoring.game-specs :as gs]
   [clojure.spec.alpha :as s]))

(defn validate [spec data]
  (let [result (s/conform spec data)]
    (when (not= result ::s/invalid)
      result)))

(defn regular-frame? [data] (validate ::fs/regular-frame data))
(defn last-frame? [data] (validate ::fs/last-frame data))

(defn assert-valid-incomplete-game [data] (s/assert ::gs/incomplete-game data))
(defn assert-valid-game [data] (s/assert ::gs/game data))

(defn check-asserts! [] (s/check-asserts true))

(defn conform-game [data] (validate ::gs/game data))
