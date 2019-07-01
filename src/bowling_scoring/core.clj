(ns bowling-scoring.core
  (:require [bowling-scoring.specs :as specs]))

(defn make-score-card []
  {:frames []})

(specs/check-asserts!)

(defn add-frame [{:keys [frames] :as card} frame]
  (specs/assert-valid-incomplete-game frames)
  (let [new-game-state (conj frames frame)]
    (specs/assert-valid-game new-game-state)
    (assoc card :frames new-game-state)))
