        .data
x:      .word 0
y:      .word 0
fVal:	.float 3.14

        .text
        .globl main
main:
        li t0, 2
        sw t0, x, t1
        li t0, 134
        sw t0, x, t1
        li t0, 5
        sw t0, y, t1
        flw f1, fVal, t1