package util;

import java.io.PrintStream;

public class Asm {
    private PrintStream out;

    public Asm(String fileName) throws java.io.FileNotFoundException {
        this.out = new PrintStream(fileName + ".asm");
        comment("Compiling " + fileName);
    }

    public void println(String s) {
        out.println(s);
    }

    public void nl() {
        out.println();
    }

    public void comment(String s) {
        println("# "+ s);
    }

    public void line(String s) {
        println("\t" + s);
    }

    public void label(String l) {
        println(l + ":");
    }

    public void finish() {
    }

    public void li(Register r, int val) {
        li(r, Integer.toString(val));
    }

    public void li(Register r, String val) {
        line("li " + r + "," + val);
    }

    public void la(Register r, String val) {
        line("la " + r + "," + val);
    }

    public void lw(Register rt, Register ra) {
        line("lw " + rt + ",(" + ra + ")");
    }

    public void sw(Register rt, Register ra) {
        line("sw " + rt + ",(" + ra + ")");
    }

    public void fld(Register f, String label, Register t) {
        line("fld " + f + "," + label + "," + t);
    }

    public void fsd(Register rt, Register ra) {
        line("fsd " + rt + ",(" + ra + ")");
    }

    public void fld(Register f, Register ra) {
        line("fld " + f + ",(" + ra + ")");
    }

    public void add(Register rt, Register rs1, Register rs2) {
        op3r("add", rt, rs1, rs2);
    }

    public void fadd(Register rt, Register rs1, Register rs2) {
        op3r("fadd.d", rt, rs1, rs2);
    }

    public void mul(Register rt, Register rs1, Register rs2) {
        op3r("mul", rt, rs1, rs2);
    }

    private void op3r(String op, Register rt, Register rs1, Register rs2) {
        line(op + " " + rt + "," + rs1 + "," + rs2);
    }
}
