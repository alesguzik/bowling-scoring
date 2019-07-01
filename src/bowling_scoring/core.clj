(ns bowling-scoring.core
  (:require
   [bowling-scoring.specs :as specs]
   [bowling-scoring.score :as score]))

(defn make-score-card []
  "Create empty score card"
  {:frames []})

(specs/check-asserts!)

(defn add-frame [{:keys [frames] :as card} frame]
  "Adds frame to a score card. First argument is the score card.
Second argument is a frame - a vector of rolls (e.g. [3 4] or [10])."
  (specs/assert-valid-incomplete-game frames)
  (let [new-game-state (conj frames frame)]
    (specs/assert-valid-game new-game-state)
    (assoc card :frames new-game-state)))

(defn complete-game? [{:keys [frames] :as card}]
  "Returns true if a score card is complete and ready for scoring"
  (boolean (specs/conform-complete-game frames)))

(defn calculate-score [{:keys [frames] :as card}]
  "Calculates the score of the score card"
  {:pre [(complete-game? card)]}
  (score/score-frames frames))
