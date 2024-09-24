(ns ru.meldren.functionalprogramming.lab1.task20)

;; Факториал с использованием рекурсии
(defn factorial-rec [n]
  (if (= n 1)
    1
    (* n (factorial-rec (dec n)))))

;; Факториал с использованием хвостовой рекурсии
(defn factorial-tail-rec-acc [n acc]
  (if (= n 1)
    acc
    (recur (dec n) (* n acc))))

(defn factorial-tail-rec [n]
  (factorial-tail-rec-acc n 1))

;; Факториал с использованием свертки
(defn factorial-reduce [n]
  (reduce *' (range 1 (inc n))))

;; Факториал с использованием ленивых вычислений
(defn factorial-lazy [n]
  (reduce *' (take n (iterate inc 1))))

;; Функция для нахождения суммы цифр числа
(defn digit-sum [n]
  (->> (str n)
       (map #(Character/digit ^char % 10))
       (reduce +)))
