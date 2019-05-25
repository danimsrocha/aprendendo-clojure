(ns cipher.core)

(defn g
  [x y]
  (+ (* x 5) y))

(defn to-int
  "recebe uma letra minúscola e retorna sua posição no alfabeto: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))

(defn to-char
  [number]
  (if (and (> number 96)(< number 105))
    (char number)))

(defn to-chartes
  [number]
  (if (and (> number 96)(< number 105))
    (char number)))