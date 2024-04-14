	.data
int_variable:	.space 4
double_variable:	.space 8
i:	.space 4
d:	.space 8
const_0:	.double 3.14
const_1:	.double 2.78e-2

	.text
	.global main
main:
	li t0,1
	sw t0,int_variable,t1
	fld ft0,const_0,t0
	fsd ft0,double_variable,t0
	lw t0,int_variable
	sw t0,i,t1
	li t0,1
	li t1,2
	add t0,t0,t1
	lw t1,int_variable
	add t0,t0,t1
	sw t0,i,t1
	fld ft0,double_variable,t0
	fld ft1,const_1,t0
	fadd.d ft0,ft0,ft1
	fsd ft0,d,t0
