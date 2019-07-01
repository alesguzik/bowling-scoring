(ns bowling-scoring.score-test
  (:require [clojure.test :refer :all]
            [bowling-scoring.score :as score]))

(deftest score-test
  (testing "Scoring"
    (are [frames score] (= score (score/score-frames frames))
      [[10 10 10]]      #_=> 30
      [[10] [10 10 10]] #_=> 60
      [[8 2] [0 1]]     #_=> 11
      [[8 2] [10 1 0]]  #_=> 31
      [[10] [4 3] [8 1] [3 7] [1 4] [10] [4 3] [8 1] [3 7] [1 4]] #_=> 98
      [[10] [7 3] [7 2] [9 1] [10] [10] [10] [2 3] [6 4] [7 3 3]] #_=> 168
      [[10] [10] [10] [10] [10] [10] [10] [10] [10] [10 10 10]] #_=> 300
      )
    )
  )
