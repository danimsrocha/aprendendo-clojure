(ns cipher.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn g
  [x y]
  (+ (* x 5) y))

(defn to-int
  "recebe uma letra minúscola e retorna sua posição no alfabeto: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))

(defn to-char
  "recebe um número e retorna a letra correspondete ao Código ASCII"
  [number]
  (if(> number 0)
    (if (< number 25)
      (char number))))