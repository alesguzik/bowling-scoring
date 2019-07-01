(ns bowling-scoring.core-test
  (:require [clojure.test :refer :all]
            [bowling-scoring.core :as bs]))

(deftest adding-frames
  (testing "Valid throws"
    (is (-> (bs/make-score-card)
            (bs/add-frame [0 0])
            (bs/add-frame [10])
            (bs/add-frame [0 0])
            (bs/add-frame [0 0])
            (bs/add-frame [0 0])
            (bs/add-frame [0 0])
            (bs/add-frame [0 0])
            (bs/add-frame [0 0])
            (bs/add-frame [0 0])
            (bs/add-frame [0 0])
            )))

  )
