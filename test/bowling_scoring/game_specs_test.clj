(ns bowling-scoring.game-specs-test
  (:require [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [bowling-scoring.game-specs :as specs]))

(deftest game-spec-test
  (testing "Incomplete games"
    (are [is-valid game] (= is-valid (s/valid? ::specs/incomplete-game game))
      true []
      false [[0]]
      false [[90 0]]
      true [[0 0]]
      true [[1 4]]
      true [[10] [10]]
      true [[10] [1 4]]
      true  [[10] [4 3] [8 1] [3 7] [1 4]]
      ))

  (testing "Complete games"
    (are [is-valid game] (= is-valid (s/valid? ::specs/complete-game game))
      false (repeat 10 [])
      false (repeat 10 [0])
      false (repeat 10 [10])
      false (repeat 10 [2 8])
      true (repeat 10 [2 7])
      false [[0]]
      false [[0 0]]
      false [[1 4]]
      false [[10] [10]]
      false [[10] [1 4]]
      false [[10] [4 3] [8 1] [3 7] [1 4]]
      true [[10] [4 3] [8 1] [3 7] [1 4] [10] [4 3] [8 1] [3 7] [1 4]]
      ))
  )
