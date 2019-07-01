(ns bowling-scoring.specs
  (:require
   [bowling-scoring.frame-specs :as fs]
   [bowling-scoring.game-specs :as gs]
   [clojure.spec.alpha :as s]))

(defn validate [spec data]
  (let [result (s/conform spec data)]
    (when (not= result ::s/invalid)
      result)))

(defn conform-regular-frame [data] (validate ::fs/regular-frame data))

(defn assert-valid-incomplete-game [data] (s/assert ::gs/incomplete-game data))
(defn assert-valid-game [data] (s/assert ::gs/game data))

(defn conform-complete-game [data] (validate ::gs/complete-game data))
(defn check-asserts! [] (s/check-asserts true))
