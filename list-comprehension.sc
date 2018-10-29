
;  MIT License

;  Copyright syntacticlosure (c) 2018 
         
;  Permission is hereby granted, free of charge, to any person obtaining a copy
;  of this software and associated documentation files (the "Software"), to deal
;  in the Software without restriction, including without limitation the rights
;  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
;  copies of the Software, and to permit persons to whom the Software is
;  furnished to do so, subject to the following conditions:
         
;  The above copyright notice and this permission notice shall be included in all
;  copies or substantial portions of the Software.
         
;  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
;  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
;  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
;  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
;  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
;  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
;  SOFTWARE.





(library (core list-comprehension)
         (export listc)
         (import (chezscheme))
         ;;Usage : (listc (cons x y) [x '(1 2 3)] [y '(4 5 6)] if (< (+ x 2) y))
         ;;(listc (+ x y) [x '(1 2 3)] [y '(4 5 6)])

         (define-syntax listc
           (syntax-rules (if)
             [(_ ret-expr) (list ret-expr)]
             [(_ ret-expr if condition) (if condition
                                            (list ret-expr)
                                            '())]
             [(_ ret-expr [var val] rest ...)
              (apply append (map (lambda (var) (listc ret-expr rest ...))
                                 val))])))
