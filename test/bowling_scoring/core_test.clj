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
                   (bs/add-frame [0 0])
                   (bs/add-frame [0 0])
                   (bs/add-frame [0 0])
                   (bs/add-frame [0 0])
                   (bs/add-frame [0 0]))
          _ (is (not (bs/complete-game? game9)))
          game10-a (-> game9 (bs/add-frame [0 0]))
          _ (is (bs/complete-game? game10-a))]
      )))

  )
