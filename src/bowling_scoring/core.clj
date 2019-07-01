(ns bowling-scoring.core
  (:require [bowling-scoring.specs :as specs]))

(defn make-score-card []
  {:accept :new-frame ; :new-frame :current-frame :done
   :frames []})

(defn add-throw [card throw-result]
  )

(defn valid-regular-frame? [frame]
  (and
   (= 2 (count frame))
   ))

(defn valid-last-frame? [frame]
  )

(defn valid-frame? [frame-number frame]
  (if (< frame-number 10)
    (valid-regular-frame? frame)
    (valid-last-frame? frame)))

(defn add-frame [{:keys [accept frames] :as card} frame]
  {:pre [(= accept :new-frame)]}
  )

(comment
  (-> (make-score-card)
      (add-throw 1)
      (add-throw 4)
      (add-throw 5)
      (add-throw 2)
      (add-throw 10)
      (add-throw 4)
      ))
