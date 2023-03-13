(print "Factorial y Serie Fibonacci")


(defvar num)
(defvar opc)

(print "Ingresa la opcion que desees realizar: ")
(print "1. Factorial")
(print "2. Serie Fibonacci")
(setq opc (read))

(print "Ingresa el numero a operar: ")
(setq num (read))

(defun Fac (num)
    (if (= num 0)
        1
    (* num (Fac (- num 1)))
    )
)

(defun Fib (num)
  (cond 
    ( (= num 0) 0)
    ( (= num 1) 1)
    (t (+ (fib (- num 1)) (fib (- num 2)))))
)

(if (eq opc 1)
    (format t "El resultado es: ~D" (Fac num))
)

(if (eq opc 2)
    (format t "El resultado es: ~D" (Fib num))
    (print "Ingresa una opcion correcta.")
)

;;;; Serie Fibonacci inspirada por https://gist.github.com/khreez/4256073

