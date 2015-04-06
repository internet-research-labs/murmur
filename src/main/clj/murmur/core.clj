(ns murmur.core
  (:import  [im.svv.murmur Murmur3])
  (:gen-class))

(defn unsigned
  "Returns an unsigned bigint"
  [value]
  (if (> value 0)
    (bigint value)
    (+ (bigint value) 18446744073709551616N)))

(defn as-double-long
  "Returns a Double Long Integer from an array."
  [[left-side right-side]]
  (let [big-left  (bigint left-side)
        big-right (bigint right-side)]
  (+' (*' big-left 18446744073709551616) big-right)))

(defn murmur
  "Returns the Hash-value of a basic type."
  [value seed]
  (->> (Murmur3/murmur2 value seed)
       (unsigned)))

(def murmur-x
  (let [m (com.google.common.hash.Hashing/murmur3_128)]
    (fn ^Long [^String s]
      (-> (doto (.newHasher m)
            (.putString s com.google.common.base.Charsets/UTF_8))
          (.hash)
          (.asLong)))))

(defn -main
  [& args]
  (println (murmur-x "red"))
  (println (murmur "red" 00))
  (println (murmur-x "red2"))
  (println (murmur "red2" 100))
  (println (murmur-x "red"))
  (println (murmur-x "dead"))
  (println (murmur "dead" 100))
  (println (murmur-x "revolver"))
  (println (murmur "revolver" 100))
  (println "whatever"))
