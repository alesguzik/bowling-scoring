(ns bowling-scoring.score
  (:require [bowling-scoring.specs :as specs]))

(defn score-last-frame [frame]
  {:score (apply + frame) :throws frame})

(defn score-regular-frame [frame next-throws]
  (let [frame-sum (apply + frame)
        [kind data] (specs/conform-regular-frame frame)
        frame-score (case kind
                      :open-frame frame-sum
                      :spare (+ frame-sum (first next-throws))
                      :strike (apply + frame-sum (take 2 next-throws)))]
    {:score frame-score
     :throws (concat frame next-throws)}))

(defn score-frames [game]
  (let [[last-frame & regular-frames] (reverse game)
        {last-score :score last-throws :throws} (score-last-frame last-frame)]
    (loop [frames regular-frames
           next-score last-score
           next-throws last-throws]
      (if (seq frames)
        (let [{:keys [score throws]} (score-regular-frame (first frames) next-throws)]
          (recur (rest frames) (+ next-score score) throws))
        next-score))))
