Printing the string "Factorial y Serie Fibonacci" to the screen.
(print "Factorial y Serie Fibonacci")

Defining two variables called num and opc.
(defvar num)
(defvar opc)

Printing the options to the user and then reading the user's input.
(print "Ingresa la opcion que desees realizar: ")
(print "1. Factorial")
(print "2. Serie Fibonacci")
(setq opc (read))

Printing a message to the user and then reading the user's input.
(print "Ingresa el numero a operar: ")
(setq num (read))

Defining a function called Fac that takes a number as an argument. The function will return 1 if the number is 0, otherwise it will return the number multiplied by the result of the function Fac with the number minus 1.
(defun Fac (num)
    (if (= num 0)
        1
    (* num (Fac (- num 1)))
    )
)

Defining a function called Fib that takes a number as an argument. The function will return 0 if the number is 0, 1 if the number is 1, otherwise it will return the sum of the result of the function Fib with the number minus 1 and the result of the function Fib with the number minus 2.
(defun Fib (num)
  (cond 
    ( (= num 0) 0)
    ( (= num 1) 1)
    (t (+ (fib (- num 1)) (fib (- num 2)))))
)


Checking if the value of opc is equal to 1, if it is, it will print the result of the function Fac with the value of num.
(if (eq opc 1)
    (format t "El resultado es: ~D" (Fac num))
)

Checking if the value of opc is equal to 2, if it is, it will print the result of the function Fib with the value of num. If it is not, it will print a message to the user.
(if (eq opc 2)
    (format t "El resultado es: ~D" (Fib num))
    (print "Ingresa una opcion correcta.")
)

;;;; Serie Fibonacci inspirada por https://gist.github.com/khreez/4256073

