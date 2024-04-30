package util;

import java.util.Deque;
import java.util.ArrayDeque;

public class Registers {
    private static Deque<Register>  freeGPs;
    private static Deque<Register>  freeFPs;

    static {
        freeGPs = new ArrayDeque<Register>();
        freeGPs.addLast(new Register.GP("t0"));
        freeGPs.addLast(new Register.GP("t1"));
        freeGPs.addLast(new Register.GP("t2"));
        freeGPs.addLast(new Register.GP("t3"));
        freeGPs.addLast(new Register.GP("t4"));
        freeGPs.addLast(new Register.GP("t5"));
        freeGPs.addLast(new Register.GP("t6"));
        freeGPs.addLast(new Register.GP("s0"));
        freeGPs.addLast(new Register.GP("s1"));
        freeGPs.addLast(new Register.GP("s2"));
        freeGPs.addLast(new Register.GP("s3"));
        freeGPs.addLast(new Register.GP("s4"));
        freeGPs.addLast(new Register.GP("s5"));
        freeGPs.addLast(new Register.GP("s6"));
        freeGPs.addLast(new Register.GP("s7"));
        freeGPs.addLast(new Register.GP("s8"));
        freeGPs.addLast(new Register.GP("s9"));
        freeGPs.addLast(new Register.GP("s10"));
        freeGPs.addLast(new Register.GP("s11"));
        freeGPs.addLast(new Register.GP("a0"));
        freeGPs.addLast(new Register.GP("a1"));
        freeGPs.addLast(new Register.GP("a2"));
        freeGPs.addLast(new Register.GP("a3"));
        freeGPs.addLast(new Register.GP("a4"));
        freeGPs.addLast(new Register.GP("a5"));
        freeGPs.addLast(new Register.GP("a6"));
        freeGPs.addLast(new Register.GP("a7"));

        freeFPs = new ArrayDeque<Register>();
        freeFPs.addLast(new Register.FP("ft0"));
        freeFPs.addLast(new Register.FP("ft1"));
        freeFPs.addLast(new Register.FP("ft2"));
        freeFPs.addLast(new Register.FP("ft3"));
        freeFPs.addLast(new Register.FP("ft4"));
        freeFPs.addLast(new Register.FP("ft5"));
        freeFPs.addLast(new Register.FP("ft6"));
        freeFPs.addLast(new Register.FP("ft7"));
        freeFPs.addLast(new Register.FP("ft8"));
        freeFPs.addLast(new Register.FP("ft9"));
        freeFPs.addLast(new Register.FP("ft10"));
        freeFPs.addLast(new Register.FP("ft11"));
        freeFPs.addLast(new Register.FP("fs0"));
        freeFPs.addLast(new Register.FP("fs1"));
        freeFPs.addLast(new Register.FP("fs2"));
        freeFPs.addLast(new Register.FP("fs3"));
        freeFPs.addLast(new Register.FP("fs4"));
        freeFPs.addLast(new Register.FP("fs5"));
        freeFPs.addLast(new Register.FP("fs6"));
        freeFPs.addLast(new Register.FP("fs7"));
        freeFPs.addLast(new Register.FP("fs8"));
        freeFPs.addLast(new Register.FP("fs9"));
        freeFPs.addLast(new Register.FP("fs10"));
        freeFPs.addLast(new Register.FP("fs11"));
        freeFPs.addLast(new Register.FP("fa0"));
        freeFPs.addLast(new Register.FP("fa1"));
        freeFPs.addLast(new Register.FP("fa2"));
        freeFPs.addLast(new Register.FP("fa3"));
        freeFPs.addLast(new Register.FP("fa4"));
        freeFPs.addLast(new Register.FP("fa5"));
        freeFPs.addLast(new Register.FP("fa6"));
        freeFPs.addLast(new Register.FP("fa7"));
    }

    public static Register getGP() {
        Register r = freeGPs.removeFirst();
        return r;
    }

    public static Register getFP() {
        Register r = freeFPs.removeFirst();
        return r;
    }

    public static void release(Register r) {
        if (r instanceof Register.GP) {
            freeGPs.addFirst(r);
        }
        else if (r instanceof Register.FP) {
            freeFPs.addFirst(r);
        }
    }
}
