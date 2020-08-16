package net.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import net.sf.zipme.GZIPInputStream;
import net.sf.zipme.GZIPOutputStream;

public class GZIPTest {
    private static final String NOCLEANUP_OPT = "--no-cleanup";
    private static File fileToZip = new File("../zipme/src-tests/net/sf/zipme/Teste.txt");
    private static File zipFile = new File("../zipme/src-tests/net/sf/zipme/Teste.txt.gz");
    private static File unzipFile = new File("../zipme/src-tests/net/sf/zipme/Teste-Copy.txt");

    public static void main(String[] argv) throws IOException {
        if (!fileToZip.exists()) {
            System.err.println("Error: The working directory must be a directory containing a '" + fileToZip.getName() + "' file.");
            System.exit(1);
        }
        if (zipFile.exists()) {
            System.err.println("Error: '" + zipFile.getName() + "' file exists already.");
            System.exit(1);
        }
        if (unzipFile.exists()) {
            System.err.println("Error: '" + unzipFile.getName() + "' file exists already.");
            System.exit(1);
        }

        zip(fileToZip, zipFile);
        unzip(zipFile, unzipFile);
        if (argv.length == 1) {
            if (argv[0].equals(NOCLEANUP_OPT)) {
                ; // nop
            } else {
                System.err.println("Error: unknown option: " + argv[0]);
                System.exit(1);
            }
        } else if (argv.length > 1) {
            System.err.println("Error: multiple options.  Only one option is accepted: " + NOCLEANUP_OPT);
        } else {
            cleanup();
        }
    }

    public static void zip(File in, File out) throws IOException {
        FileInputStream inStream = new FileInputStream(in);
        GZIPOutputStream outStream =
            new GZIPOutputStream(new FileOutputStream(out));
        byte[] buffer = new byte[0xFFFF];
        for (int len; (len = inStream.read(buffer)) != -1;) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        outStream.close();
//        System.out.println("Zipping file: Success");
    }

    public static void unzip(File in, File out) throws IOException {
        GZIPInputStream inStream = new GZIPInputStream(new FileInputStream(in));
        FileOutputStream outStream = new FileOutputStream(out);
        byte[] buffer = new byte[0xFFFF];
        for (int len; (len = inStream.read(buffer)) != -1;) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        outStream.close();
//        System.out.println("Unzipping file: Success");
    }

    public static void cleanup() {
        zipFile.delete();
        unzipFile.delete();
//        System.out.println("Test files " + zipFile.getName() + " and " + unzipFile.getName() + " have been deleted.  Run ZipMETest with --no-cleanup option to leave the test files.");
    }
}
