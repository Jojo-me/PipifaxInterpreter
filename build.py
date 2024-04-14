import os.path
import os

def ex(cmd):
    print(cmd)
    os.system(cmd)

print("====================================================================================")
os.chdir("src")
if not os.path.exists("PfxParser.java") or os.path.getmtime("Pfx.g4") > os.path.getmtime("PfxParser.java"):
    ex("java -jar ..\\..\\antlr-4.13.1-complete.jar -no-listener -visitor Pfx.g4")
os.chdir("..")

dirs = ["ast", "util"]
dir_list = "src\\*.java"
for d in dirs:
    dir_list = dir_list + " src\\" + d + "\\*.java"
ex("javac -Xlint:unchecked -d dst -cp ..\\antlr-4.13.1-complete.jar;dst " + dir_list)

# java -cp ..\lib\antlr-4.13.1-complete.jar;dst Main test1.pfx
# ~ tests = [ "test1", "var_more_than_once" ]
# ~ tests = [ "test1", "test2" ]
tests = [ "t1" ]
for t in tests:
    fn = "tst\\" + t + ".pfx"
    ex("java -cp ..\\antlr-4.13.1-complete.jar;dst Main " + fn)
    # ~ ex("java -cp ..\\lib\\antlr-4.12.0-complete.jar;dst Dump " + fn)

# java -cp ..\antlr-4.13.1-complete.jar;dst org.antlr.v4.gui.Interpreter src\Pfx.g4 program -gui test1.pfx
# os.system("java -cp ..\\antlr-4.13.1-complete.jar;dst org.antlr.v4.gui.Interpreter src\\Pfx.g4 program -gui test1.pfx")
