(ns murmur.core-test
  (:require [clojure.test :refer :all]
            [murmur.core :refer :all]))

(deftest test-as-double-long
  (testing "as-double-long"
    (testing "should be equal to right-side if left-side is small"
      (is (= 0 (as-double-long [0 0])))
      (is (= 100 (as-double-long [0 100]))))
    (testing "should add to the other"
      (is (= 18446744073709551616 (as-double-long [1 0])))
      (is (=
           340282366920938463463374607431768211455
           (as-double-long [18446744073709551615 18446744073709551615]))))))

(deftest test-core
  (testing "core"
    (testing "should work trivially")))
