# Compiling tst\t1.pfx
	.data
d:
	.space 8
ia:
	.space 40
da:
	.space 160
daa:
	.space 400
const_0:
	.double 1.0
const_1:
	.double 3.14
const_2:
	.double 1.0

	.text
	.global _main
_main:
	jal main
	li a7,10
	ecall
main:
	fld ft0,const_0,t0
	la t0,d
	fsd ft0,(t0)
	li t0,1
	li t1,0
	li t2,4
	mul t1,t1,t2
	la t2,ia
	add t2,t2,t1
	sw t0,(t2)
	li t2,17
	li t0,5
	li t1,4
	mul t0,t0,t1
	la t1,ia
	add t1,t1,t0
	lw t1,(t1)
	add t2,t2,t1
	li t1,2
	li t0,4
	mul t1,t1,t0
	la t0,ia
	add t0,t0,t1
	sw t2,(t0)
	fld ft0,const_1,t0
	li t0,7
	li t2,8
	mul t0,t0,t2
	la t2,da
	add t2,t2,t0
	fld ft1,(t2)
	fadd.d ft0,ft0,ft1
	li t2,3
	li t0,8
	mul t2,t2,t0
	la t0,da
	add t0,t0,t2
	fsd ft0,(t0)
	fld ft0,const_2,t0
	li t0,2
	li t2,4
	mul t0,t0,t2
	la t2,ia
	add t2,t2,t0
	lw t2,(t2)
	li t0,8
	mul t2,t2,t0
	li t0,3
	li t1,80
	mul t0,t0,t1
	la t1,daa
	add t1,t1,t0
	add t1,t1,t2
	fsd ft0,(t1)
	ret
