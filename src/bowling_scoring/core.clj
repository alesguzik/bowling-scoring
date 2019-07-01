(ns bowling-scoring.core
  (:require
   [bowling-scoring.specs :as specs]
   [bowling-scoring.score :as score]))

(defn make-score-card []
  {:frames []})

(specs/check-asserts!)

(defn add-frame [{:keys [frames] :as card} frame]
  (specs/assert-valid-incomplete-game frames)
  (let [new-game-state (conj frames frame)]
    (specs/assert-valid-game new-game-state)
    (assoc card :frames new-game-state)))

(defn complete-game? [{:keys [frames] :as card}]
  (specs/conform-complete-game frames))

(defn calculate-score [{:keys [frames] :as card}]
  {:pre [(complete-game? card)]}
  (score/score-frames frames))
