(ns bowling-scoring.core)

(defn make-score-card []
  {:accept :new-frame ; :new-frame :current-frame :done
   :frames []})

(defn add-throw [card throw-result]
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
