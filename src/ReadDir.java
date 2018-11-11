//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadDir {
    public int file_counter;
    public int dir_counter;
    public StringBuilder sb = new StringBuilder();

    public ReadDir() {
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dir");
        String dir = in.next();
        ReadDir readdir = new ReadDir();
        readdir.showDir(dir);
        System.out.println(readdir.sb.toString() + "\nFiles " + readdir.file_counter + ";Dirs " + (readdir.dir_counter - 1));
    }

    public void showDir(String dir) {
        File file = new File(dir);
        System.out.print("\t");

        try {
            String[] paths = file.list();
            String[] var4 = paths;
            int var5 = paths.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                String path = var4[var6];
                if (!(new File(dir + "/" + path)).isDirectory() && (dir + "/" + path).indexOf("RECYCLE.BIN") == -1) {
                    this.sb.append(dir + "/" + path + "\n");
                    ++this.file_counter;
                } else if ((new File(dir + "/" + path)).isDirectory() && (dir + "/" + path).indexOf("RECYCLE.BIN") == -1) {
                    this.showDir(dir + "/" + path);
                    ++this.dir_counter;
                }
            }
        } catch (Exception var8) {
            ;
        }

    }
}
