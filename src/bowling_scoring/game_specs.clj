(ns bowling-scoring.game-specs
  (:require [clojure.spec.alpha :as s]
            [bowling-scoring.frame-specs :as fs]))

(s/def ::incomplete-game
  (s/and (s/cat :regular-frames (s/* ::fs/regular-frame))
         #(<= (count (:regular-frames %)) 9)))

(s/def ::complete-game
  (s/and (s/cat :regular-frames (s/* ::fs/regular-frame) :final-frame ::fs/last-frame)
         #(= (count (:regular-frames %)) 9)))

(s/def ::game
  (s/or :complete-game ::complete-game
        :incomplete-game ::incomplete-game))
