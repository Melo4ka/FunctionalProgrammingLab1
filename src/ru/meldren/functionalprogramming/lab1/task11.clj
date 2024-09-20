(ns ru.meldren.functionalprogramming.lab1.task11)

;; Макс. произведение с использованием рекурсии
(defn product-rec [grid x y dx dy count]
  (if (= count 4)
    1
    (let [nx (+ x dx)
          ny (+ y dy)]
      (if (or (>= nx 20) (>= ny 20) (< nx 0) (< ny 0))
        0
        (* (nth (nth grid x) y)
           (product-rec grid nx ny dx dy (inc count)))))))

(defn max-product-rec [grid]
  (let [dirs [[0 1] [1 0] [1 1] [1 -1]]]
    (apply max
           (for [x (range 20) y (range 20)
                 [dx dy] dirs]
             (product-rec grid x y dx dy 0)))))

;; Макс. произведение с использованием хвостовой рекурсии
(defn product-tail-rec [grid x y dx dy count acc]
  (if (= count 4)
    acc
    (let [nx (+ x dx)
          ny (+ y dy)]
      (if (or (>= nx 20) (>= ny 20) (< nx 0) (< ny 0))
        0
        (recur grid nx ny dx dy (inc count) (* acc (nth (nth grid x) y)))))))

(defn max-product-tail-rec [grid]
  (let [dirs [[0 1] [1 0] [1 1] [1 -1]]]
    (apply max
           (for [x (range 20) y (range 20)
                 [dx dy] dirs]
             (product-tail-rec grid x y dx dy 0 1)))))

;; Макс. произведение с использованием свертки и отображения
(defn max-product-lazy-and-reduce [grid]
  (apply max
         (for [sx (range 20) sy (range 20)
               d-yx [[1 0] [1 1] [0 1] [-1 1]]
               :let [indices (for [i (range 4)]
                               [(+ sy (* i (first d-yx))) (+ sx (* i (second d-yx)))])]
               :when (every? (fn [[x y]] (and (>= x 0) (< x 20) (>= y 0) (< y 20))) indices)]
           (reduce * (map (fn [[x y]] (nth (nth grid x) y)) indices)))))
