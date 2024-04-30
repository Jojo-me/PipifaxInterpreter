# Compiling tst\t1.pfx
	.data
var_g1:
	.space 4
var_g2:
	.space 4

	.text
_main:
	jal func_main
	li a7,10
	ecall

func_f1:
	addi sp,sp,-4
	sw ra,0(sp)
	la t0,var_g1
	lw t0,(t0)
	li t1,2
	add t0,t0,t1
	la t1,var_g2
	sw t0,(t1)
	lw ra,0(sp)
	addi sp,sp,4
	ret

func_main:
	addi sp,sp,-4
	sw ra,0(sp)
	li t1,1
	la t0,var_g1
	sw t1,(t0)
	jal func_f1
	lw ra,0(sp)
	addi sp,sp,4
	ret
