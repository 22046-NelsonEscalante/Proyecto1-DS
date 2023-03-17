(print "Conversion de Farenheit a Celcius")

(print "Ingresa los grados Farenheit: ")

(defvar F)

(setq F (read))

(defun Switch (F)
    (format t "La conversion es igual a: ~D" ( * ( - F 32 ) 0.56 ) )
)

(Switch F)




