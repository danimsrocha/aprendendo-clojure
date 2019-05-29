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
  "recebe um número entre 0 e 25, e retorna sua posição no alfabeto: 0 = a, 1 = b, etc."
  [number]
  (if (and (>= number 0)(<= number 25))
    (let [number-ascii(+ number (int \a))]
      (char number-ascii))))

(defn shift
  [?letter-char number]
  (let [number-ascii(to-int ?letter-char)]
    (let [sum (+ number-ascii number)]
      (to-char (mod sum 26)))))

(defn caesar-encrypt
  "encriptando uma palavra w com uma chave k utilizanado a cifra de César"
  [?word key]
  (apply str (mapv #(shift % key) ?word)))

(defn caesar-decrypt
  [?word-encrypt key]
  (let [key-negative(* key -1)]
    (apply str(mapv #(shift % key-negative) ?word-encrypt))))

(defn get-letters
  [?word]
  (let [?word-lowercase (clojure.string/lower-case ?word)]
    (apply str (filterv #(Character/isLetter %) ?word-lowercase))))

(defn encrypt
  [?word key]
  (caesar-encrypt (get-letters ?word) key))