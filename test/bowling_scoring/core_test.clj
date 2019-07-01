(ns bowling-scoring.core-test
  (:require [clojure.test :refer :all]
            [bowling-scoring.core :as bs]))

(deftest adding-frames
  (testing "Valid flow"
    (let [game0 (bs/make-score-card)
          _ (is (not (bs/complete-game? game0)))
          game3 (-> game0
                   (bs/add-frame [0 0])
                   (bs/add-frame [10])
                   (bs/add-frame [0 0]))
          _ (is (not (bs/complete-game? game3)))
          game9 (-> game3
                   (bs/add-frame [0 0])
                   (bs/add-frame [3 0])
                   (bs/add-frame [0 0])
                   (bs/add-frame [4 5])
                   (bs/add-frame [6 4])
                   (bs/add-frame [10]))
          _ (is (not (bs/complete-game? game9)))
          game10-a (bs/add-frame game9 [10 2 5])
          _ (is (bs/complete-game? game10-a))
          game10-b (bs/add-frame game9 [10 10 10])
          _ (is (bs/complete-game? game10-b))
          game10-c (bs/add-frame game9 [9 1 5])
          _ (is (bs/complete-game? game10-c))
          game10-d (bs/add-frame game9 [0 0])
          _ (is (bs/complete-game? game10-d))
          ]
      (is (= 81 (bs/calculate-score game10-a)))
      (is (= 102 (bs/calculate-score game10-b)))
      (is (= 77 (bs/calculate-score game10-c)))
      (is (= 52 (bs/calculate-score game10-d)))
      )))
