import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("writetest.txt");
        PrintWriter results = new PrintWriter("results.txt");

        System.out.printf("***************%d MB characters write test***************\n", 64);
        results.printf("***************%d MB characters write test***************\n", 64);
        writeTests(64, file, results);
        writeTestsBuffer(64, file, 1, results);
        writeTestsBuffer(64, file, 2, results);
        writeTestsBuffer(64, file, 4, results);
        writeTestsBuffer(64, file, 8, results);
        writeTestsBuffer(64, file, 16, results);
        writeTestsBuffer(64, file, 32, results);
        writeTestsBuffer(64, file, 64, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters write test***************\n", 128);
        results.printf("***************%d MB characters write test***************\n", 128);
        writeTests(128, file, results);
        writeTestsBuffer(128, file, 1, results);
        writeTestsBuffer(128, file, 2, results);
        writeTestsBuffer(128, file, 4, results);
        writeTestsBuffer(128, file, 8, results);
        writeTestsBuffer(128, file, 16, results);
        writeTestsBuffer(128, file, 32, results);
        writeTestsBuffer(128, file, 64, results);
        writeTestsBuffer(128, file, 128, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters write test***************\n", 256);
        results.printf("***************%d MB characters write test***************\n", 256);
        writeTests(256, file, results);
        writeTestsBuffer(256, file, 2, results);
        writeTestsBuffer(256, file, 4, results);
        writeTestsBuffer(256, file, 8, results);
        writeTestsBuffer(256, file, 16, results);
        writeTestsBuffer(256, file, 32, results);
        writeTestsBuffer(256, file, 64, results);
        writeTestsBuffer(256, file, 128, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters write test***************\n", 512);
        results.printf("***************%d MB characters write test***************\n", 512);
        writeTests(512, file, results);
        writeTestsBuffer(512, file, 4, results);
        writeTestsBuffer(512, file, 8, results);
        writeTestsBuffer(512, file, 16, results);
        writeTestsBuffer(512, file, 32, results);
        writeTestsBuffer(512, file, 64, results);
        writeTestsBuffer(512, file, 128, results);
        writeTestsBuffer(512, file, 256, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters write test***************\n", 1024);
        results.printf("***************%d MB characters write test***************\n", 1024);
        writeTests(1024, file, results);
        writeTestsBuffer(1024, file, 8, results);
        writeTestsBuffer(1024, file, 16, results);
        writeTestsBuffer(1024, file, 32, results);
        writeTestsBuffer(1024, file, 64, results);
        writeTestsBuffer(1024, file, 128, results);
        writeTestsBuffer(1024, file, 256, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d integers write test***************\n", 64 * 1024 * 1024);
        results.printf("***************%d integers write test***************\n", 64 * 1024 * 1024);
        writeTestsInteger(64 * 1024 * 1024, file, results);
        writeTestsIntegerBuffer(64 * 1024 * 1024, file, 1, results);
        writeTestsIntegerBuffer(64 * 1024 * 1024, file, 2, results);
        writeTestsIntegerBuffer(64 * 1024 * 1024, file, 4, results);
        writeTestsIntegerBuffer(64 * 1024 * 1024, file, 8, results);
        writeTestsIntegerBuffer(64 * 1024 * 1024, file, 16, results);
        writeTestsIntegerBuffer(64 * 1024 * 1024, file, 32, results);
        writeTestsIntegerBuffer(64 * 1024 * 1024, file, 64, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d integers write test***************\n", 128 * 1024 * 1024);
        results.printf("***************%d integers write test***************\n", 128 * 1024 * 1024);
        writeTestsInteger(128 * 1024 * 1024, file, results);
        writeTestsIntegerBuffer(128 * 1024 * 1024, file, 1, results);
        writeTestsIntegerBuffer(128 * 1024 * 1024, file, 2, results);
        writeTestsIntegerBuffer(128 * 1024 * 1024, file, 4, results);
        writeTestsIntegerBuffer(128 * 1024 * 1024, file, 8, results);
        writeTestsIntegerBuffer(128 * 1024 * 1024, file, 16, results);
        writeTestsIntegerBuffer(128 * 1024 * 1024, file, 32, results);
        writeTestsIntegerBuffer(128 * 1024 * 1024, file, 64, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d integers write test***************\n", 256 * 1024 * 1024);
        results.printf("***************%d integers write test***************\n", 256 * 1024 * 1024);
        writeTestsInteger(256 * 1024 * 1024, file, results);
        writeTestsIntegerBuffer(256 * 1024 * 1024, file, 2, results);
        writeTestsIntegerBuffer(256 * 1024 * 1024, file, 4, results);
        writeTestsIntegerBuffer(256 * 1024 * 1024, file, 8, results);
        writeTestsIntegerBuffer(256 * 1024 * 1024, file, 16, results);
        writeTestsIntegerBuffer(256 * 1024 * 1024, file, 32, results);
        writeTestsIntegerBuffer(256 * 1024 * 1024, file, 64, results);
        writeTestsIntegerBuffer(256 * 1024 * 1024, file, 128, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d floats write test***************\n", 64 * 1024 * 1024);
        results.printf("***************%d floats write test***************\n", 64 * 1024 * 1024);
        writeTestsFloat(64 * 1024 * 1024, file, results);
        writeTestsFloatBuffer(64 * 1024 * 1024, file, 1, results);
        writeTestsFloatBuffer(64 * 1024 * 1024, file, 2, results);
        writeTestsFloatBuffer(64 * 1024 * 1024, file, 4, results);
        writeTestsFloatBuffer(64 * 1024 * 1024, file, 8, results);
        writeTestsFloatBuffer(64 * 1024 * 1024, file, 16, results);
        writeTestsFloatBuffer(64 * 1024 * 1024, file, 32, results);
        writeTestsFloatBuffer(64 * 1024 * 1024, file, 64, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d floats write test***************\n", 128 * 1024 * 1024);
        results.printf("***************%d floats write test***************\n", 128 * 1024 * 1024);
        writeTestsFloat(128 * 1024 * 1024, file, results);
        writeTestsFloatBuffer(128 * 1024 * 1024, file, 1, results);
        writeTestsFloatBuffer(128 * 1024 * 1024, file, 2, results);
        writeTestsFloatBuffer(128 * 1024 * 1024, file, 4, results);
        writeTestsFloatBuffer(128 * 1024 * 1024, file, 8, results);
        writeTestsFloatBuffer(128 * 1024 * 1024, file, 16, results);
        writeTestsFloatBuffer(128 * 1024 * 1024, file, 32, results);
        writeTestsFloatBuffer(128 * 1024 * 1024, file, 64, results);
        writeTestsFloatBuffer(128 * 1024 * 1024, file, 128, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d floats write test***************\n", 256 * 1024 * 1024);
        results.printf("***************%d floats write test***************\n", 256 * 1024 * 1024);
        writeTestsFloat(256 * 1024 * 1024, file, results);
        writeTestsFloatBuffer(256 * 1024 * 1024, file, 2, results);
        writeTestsFloatBuffer(256 * 1024 * 1024, file, 4, results);
        writeTestsFloatBuffer(256 * 1024 * 1024, file, 8, results);
        writeTestsFloatBuffer(256 * 1024 * 1024, file, 16, results);
        writeTestsFloatBuffer(256 * 1024 * 1024, file, 32, results);
        writeTestsFloatBuffer(256 * 1024 * 1024, file, 64, results);
        writeTestsFloatBuffer(256 * 1024 * 1024, file, 128, results);
        writeTestsFloatBuffer(256 * 1024 * 1024, file, 256, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters read test***************\n", 64);
        results.printf("***************%d MB characters read test***************\n", 64);
        readTests(64, file, results);
        readTestsBuffer(64, file, 1, results);
        readTestsBuffer(64, file, 2, results);
        readTestsBuffer(64, file, 4, results);
        readTestsBuffer(64, file, 8, results);
        readTestsBuffer(64, file, 16, results);
        readTestsBuffer(64, file, 32, results);
        readTestsBuffer(64, file, 64, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters read test***************\n", 128);
        results.printf("***************%d MB characters read test***************\n", 128);
        readTests(128, file, results);
        readTestsBuffer(128, file, 1, results);
        readTestsBuffer(128, file, 2, results);
        readTestsBuffer(128, file, 4, results);
        readTestsBuffer(128, file, 8, results);
        readTestsBuffer(128, file, 16, results);
        readTestsBuffer(128, file, 32, results);
        readTestsBuffer(128, file, 64, results);
        readTestsBuffer(128, file, 128, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters read test***************\n", 256);
        results.printf("***************%d MB characters read test***************\n", 256);
        readTests(256, file, results);
        readTestsBuffer(256, file, 2, results);
        readTestsBuffer(256, file, 4, results);
        readTestsBuffer(256, file, 8, results);
        readTestsBuffer(256, file, 16, results);
        readTestsBuffer(256, file, 32, results);
        readTestsBuffer(256, file, 64, results);
        readTestsBuffer(256, file, 128, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters read test***************\n", 512);
        results.printf("***************%d MB characters read test***************\n", 512);
        readTests(512, file, results);
        readTestsBuffer(512, file, 4, results);
        readTestsBuffer(512, file, 8, results);
        readTestsBuffer(512, file, 16, results);
        readTestsBuffer(512, file, 32, results);
        readTestsBuffer(512, file, 64, results);
        readTestsBuffer(512, file, 128, results);
        readTestsBuffer(512, file, 256, results);
        System.out.println();
        results.println();

        System.out.printf("***************%d MB characters read test***************\n", 1024);
        results.printf("***************%d MB characters read test***************\n", 1024);
        readTests(1024, file, results);
        readTestsBuffer(1024, file, 8, results);
        readTestsBuffer(1024, file, 16, results);
        readTestsBuffer(1024, file, 32, results);
        readTestsBuffer(1024, file, 64, results);
        readTestsBuffer(1024, file, 128, results);
        readTestsBuffer(1024, file, 256, results);
        System.out.println();
        results.println();

        results.close();
    }

    /*
    Write tests
     */

    private static void printResults(double testTime, String test, long testSize, String testType, String ioClass,
                                     double rate) {
        System.out.printf("Took %.5f seconds to %s %d %s file with %s. Rate: %.1f MB/s\n",
                testTime, test, testSize, testType, ioClass, rate);
    }

    private static void printResults(double testTime, String test, long testSize, String testType, String ioClass,
                                     int mbBufferSize, String buffer, double rate) {
        System.out.printf("Took %.5f seconds to %s %d %s file with %s and %d MB %s. Rate: %.1f MB/s\n",
                testTime, test, testSize, testType, ioClass, mbBufferSize, buffer, rate);
    }

    private static void writeResults(double testTime, String test, long testSize, String testType, String ioClass,
                                     double rate, PrintWriter results) {
        results.printf("Took %.5f seconds to %s %d %s file with %s. Rate: %.1f MB/s\n",
                testTime, test, testSize, testType, ioClass, rate);
    }

    private static void writeResults(double testTime, String test, long testSize, String testType, String ioClass,
                                     int mbBufferSize, String buffer, double rate, PrintWriter results) {
        results.printf("Took %.5f seconds to %s %d %s file with %s and %d MB %s. Rate: %.1f MB/s\n",
                testTime, test, testSize, testType, ioClass, mbBufferSize, buffer, rate);
    }

    private static void writeTests(int mbNum, File file, PrintWriter results) throws IOException {
        long fileLength;
        long startTimer;
        long endTimer;
        double writeTime;
        double rate;

        startTimer = System.nanoTime();
        writeFileWriter(mbNum * 1024 * 1024, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "FileWriter", rate);
        writeResults(writeTime, "write", fileLength, "MB", "FileWriter", rate, results);

        startTimer = System.nanoTime();
        writePrintWriterPrint(mbNum * 1024 * 1024, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "PrintWriter.print()", rate);
        writeResults(writeTime, "write", fileLength, "MB", "PrintWriter.print()", rate, results);

        startTimer = System.nanoTime();
        writePrintWriterWrite(mbNum * 1024 * 1024, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "PrintWriter.write()", rate);
        writeResults(writeTime, "write", fileLength, "MB", "PrintWriter.write()", rate, results);

        startTimer = System.nanoTime();
        writeBufferedWriter(mbNum * 1024 * 1024, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "BufferedWriter", rate);
        writeResults(writeTime, "write", fileLength, "MB", "BufferedWriter", rate, results);
    }

    private static void writeTestsBuffer(int mbNum, File file, int mbBufferSize, PrintWriter results) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        long fileLength;
        long startTimer;
        long endTimer;
        double writeTime;
        double rate;

        startTimer = System.nanoTime();
        writeFileWriterBuffer(mbNum * 1024 * 1024, file, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "FileWriter", mbBufferSize,
                "StringBuilder", rate);
        writeResults(writeTime, "write", fileLength, "MB", "FileWriter", mbBufferSize,
                "StringBuilder", rate, results);

        startTimer = System.nanoTime();
        writePrintWriterPrintBuffer(mbNum * 1024 * 1024, file, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "PrintWriter.print()", mbBufferSize,
                "StringBuilder", rate);
        writeResults(writeTime, "write", fileLength, "MB", "PrintWriter.print()", mbBufferSize,
                "StringBuilder", rate, results);

        startTimer = System.nanoTime();
        writePrintWriterWriteBuffer(mbNum * 1024 * 1024, file, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "PrintWriter.write()", mbBufferSize,
                "StringBuilder", rate);
        writeResults(writeTime, "write", fileLength, "MB", "PrintWriter.write()", mbBufferSize,
                "StringBuilder", rate, results);

        startTimer = System.nanoTime();
        writeBufferedWriterBufAppend(mbNum * 1024 * 1024, file, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "BufferedWriter.append()", mbBufferSize,
                "buffer", rate);
        writeResults(writeTime, "write", fileLength, "MB", "BufferedWriter.append()", mbBufferSize,
                "buffer", rate, results);

        startTimer = System.nanoTime();
        writeBufferedWriterBufWrite(mbNum * 1024 * 1024, file, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "BufferedWriter.write()", mbBufferSize,
                "buffer", rate);
        writeResults(writeTime, "write", fileLength, "MB", "BufferedWriter.write()", mbBufferSize,
                "buffer", rate, results);

        startTimer = System.nanoTime();
        writeFileChannel(mbNum * 1024 * 1024, raf, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", fileLength, "MB", "FileChannel", mbBufferSize,
                "buffer", rate);
        writeResults(writeTime, "write", fileLength, "MB", "FileChannel", mbBufferSize,
                "buffer", rate, results);
    }

    private static void writeTestsInteger(int intNum, File file, PrintWriter results) throws IOException {
        long fileLength;
        long startTimer;
        long endTimer;
        double writeTime;
        double rate;

        startTimer = System.nanoTime();
        writeFileWriterInteger(intNum, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in",
                "FileWriter", rate);
        writeResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in",
                "FileWriter", rate, results);

        startTimer = System.nanoTime();
        writePrintWriterPrintInteger(intNum, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in",
                "PrintWriter.print()", rate);
        writeResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in",
                "PrintWriter.print()", rate, results);

        startTimer = System.nanoTime();
        writePrintWriterWriteInteger(intNum, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in",
                "PrintWriter.write()", rate);
        writeResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in",
                "PrintWriter.write()", rate, results);

        startTimer = System.nanoTime();
        writeBufferedWriterInteger(intNum, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in",
                "BufferedWriter", rate);
        writeResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in",
                "BufferedWriter", rate, results);
    }

    private static void writeTestsIntegerBuffer(int intNum, File file, int mbBufferSize, PrintWriter results) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        long fileLength;
        long startTimer;
        long endTimer;
        double writeTime;
        double rate;

        startTimer = System.nanoTime();
        writeFileChannelInteger(intNum, raf, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in", "FileChannel",
                mbBufferSize, "buffer", rate);
        writeResults(writeTime, "write", intNum, "integers(" + fileLength + " MB) in", "FileChannel",
                mbBufferSize, "buffer", rate, results);
    }

    private static void writeTestsFloat(int floatNum, File file, PrintWriter results) throws IOException {
        long fileLength;
        long startTimer;
        long endTimer;
        double writeTime;
        double rate;

        startTimer = System.nanoTime();
        writeFileWriterFloat(floatNum, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in",
                "FileWriter", rate);
        writeResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in",
                "FileWriter", rate, results);

        startTimer = System.nanoTime();
        writePrintWriterPrintFloat(floatNum, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in",
                "PrintWriter.print()", rate);
        writeResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in",
                "PrintWriter.print()", rate, results);

        startTimer = System.nanoTime();
        writePrintWriterWriteFloat(floatNum, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in",
                "PrintWriter.write()", rate);
        writeResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in",
                "PrintWriter.write()", rate, results);

        startTimer = System.nanoTime();
        writeBufferedWriterFloat(floatNum, file);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in",
                "BufferedWriter", rate);
        writeResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in",
                "BufferedWriter", rate, results);
    }

    private static void writeTestsFloatBuffer(int floatNum, File file, int mbBufferSize, PrintWriter results) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        long fileLength;
        long startTimer;
        long endTimer;
        double writeTime;
        double rate;

        startTimer = System.nanoTime();
        writeFileChannelFloat(floatNum, raf, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        writeTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / writeTime;
        printResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in", "FileChannel",
                mbBufferSize, "buffer", rate);
        writeResults(writeTime, "write", floatNum, "floats(" + fileLength + " MB) in", "FileChannel",
                mbBufferSize, "buffer", rate, results);
    }

    private static void writeFileWriter(int dataSize, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (int i = 0; i < dataSize / 2; i++) {
            writer.write('ӣ');
        }
        writer.close();
    }

    private static void writeFileWriterInteger(int intNum, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (int i = 0; i < intNum; i++) {
            writer.write(1);
        }
        writer.close();
    }

    private static void writeFileWriterFloat(int intNum, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (int i = 0; i < intNum; i++) {
            writer.write(Float.toString(3.14f));
        }
        writer.close();
    }

    private static void writeFileWriterBuffer(int dataSize, File file, int bufferSize) throws IOException {
        FileWriter writer = new FileWriter(file);
        StringBuilder sb = new StringBuilder("");
        int bufClearNum = dataSize / bufferSize;
        for (int i = 0; i < bufClearNum; i++) {
            for (int j = 0; j < bufferSize / 2; j++) {
                sb.append('ӣ');
            }
            writer.write(sb.toString());
            sb.delete(0, bufferSize);
        }
        writer.close();
    }

    private static void writePrintWriterPrint(int dataSize, File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < dataSize / 2; i++) {
            writer.print('ӣ');
        }
        writer.close();
    }

    private static void writePrintWriterPrintInteger(int intNum, File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < intNum; i++) {
            writer.print(1);
        }
        writer.close();
    }

    private static void writePrintWriterPrintFloat(int floatNum, File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < floatNum; i++) {
            writer.print(3.14f);
        }
        writer.close();
    }

    private static void writePrintWriterPrintBuffer(int dataSize, File file, int bufferSize) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        StringBuilder sb = new StringBuilder("");
        int bufClearNum = dataSize / bufferSize;
        for (int i = 0; i < bufClearNum; i++) {
            for (int j = 0; j < bufferSize / 2; j++) {
                sb.append('ӣ');
            }
            writer.print(sb.toString());
            sb.delete(0, bufferSize);
        }
        writer.close();
    }

    private static void writePrintWriterWrite(int dataSize, File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < dataSize / 2; i++) {
            writer.write('ӣ');
        }
        writer.close();
    }

    private static void writePrintWriterWriteInteger(int intNum, File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < intNum; i++) {
            writer.write(1);
        }
        writer.close();
    }

    private static void writePrintWriterWriteFloat(int floatNum, File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < floatNum; i++) {
            writer.write(Float.toString(3.14f));
        }
        writer.close();
    }

    private static void writePrintWriterWriteBuffer(int dataSize, File file, int bufferSize) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        StringBuilder sb = new StringBuilder("");
        int bufClearNum = dataSize / bufferSize;
        for (int i = 0; i < bufClearNum; i++) {
            for (int j = 0; j < bufferSize / 2; j++) {
                sb.append('ӣ');
            }
            writer.write(sb.toString());
            sb.delete(0, bufferSize);
        }
        writer.close();
    }

    private static void writeBufferedWriter(int dataSize, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < dataSize / 2; i++) {
            writer.write('ӣ');
        }
        writer.close();
    }

    private static void writeBufferedWriterInteger(int intNum, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < intNum; i++) {
            writer.write(1);
        }
        writer.close();
    }

    private static void writeBufferedWriterFloat(int floatNum, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < floatNum; i++) {
            writer.write(Float.toString(3.14f));
        }
        writer.close();
    }

    private static void writeBufferedWriterBufWrite(int dataSize, File file, int bufferSize) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file), bufferSize);
        for (int i = 0; i < dataSize / 2; i++) {
            writer.write('ӣ');
        }
        writer.close();
    }

    private static void writeBufferedWriterBufAppend(int dataSize, File file, int bufferSize) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file), bufferSize);
        int bufClearNum = dataSize / bufferSize;
        for (int i = 0; i < bufClearNum; i++) {
            for (int j = 0; j < bufferSize / 2; j++) {
                writer.append('ӣ');
            }
            writer.flush();
        }
        writer.close();
    }

    private static void writeFileChannel(int dataSize, RandomAccessFile raf, int bufferSize) throws IOException {
        FileChannel fileChannel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);
        int bufClearNum = dataSize / bufferSize;
        for (int i = 0; i < bufClearNum; i++) {
            buffer.clear();
            for (int j = 0; j < bufferSize / 2; j++) {
                buffer.putChar('ӣ');
            }
            buffer.flip();
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
        }
        fileChannel.close();
    }

    private static void writeFileChannelInteger(int intNum, RandomAccessFile raf, int bufferSize) throws IOException {
        FileChannel fileChannel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);
        int bufClearNum = 4 * intNum / bufferSize;
        for (int i = 0; i < bufClearNum; i++) {
            buffer.clear();
            for (int j = 0; j < bufferSize / 4; j++) {
                buffer.putInt(1);
            }
            buffer.flip();
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
        }
        fileChannel.close();
    }

    private static void writeFileChannelFloat(int floatNum, RandomAccessFile raf, int bufferSize) throws IOException {
        FileChannel fileChannel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);
        int bufClearNum = 4 * floatNum / bufferSize;
        for (int i = 0; i < bufClearNum; i++) {
            buffer.clear();
            for (int j = 0; j < bufferSize / 4; j++) {
                buffer.putFloat(3.14f);
            }
            buffer.flip();
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
        }
        fileChannel.close();
    }

    /*
    Read tests
     */

    private static void readTests(int mbNum, File file, PrintWriter results) throws IOException {
        long fileLength;
        long startTimer;
        long endTimer;
        double readTime;
        double rate;

        generateReadFileTest(mbNum * 1024 * 1024, file);

        startTimer = System.nanoTime();
        readFileReader(file);
        endTimer = System.nanoTime() - startTimer;
        readTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / readTime;
        printResults(readTime, "read", fileLength, "MB", "FileReader", rate);
        writeResults(readTime, "read", fileLength, "MB", "FileReader", rate, results);

        startTimer = System.nanoTime();
        readScannerLine(file);
        endTimer = System.nanoTime() - startTimer;
        readTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / readTime;
        printResults(readTime, "read", fileLength, "MB", "Scanner.nextLine()", rate);
        writeResults(readTime, "read", fileLength, "MB", "Scanner.nextLine()", rate, results);

        startTimer = System.nanoTime();
        readScannerDelim(file);
        endTimer = System.nanoTime() - startTimer;
        readTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / readTime;
        printResults(readTime, "read", fileLength, "MB", "Scanner.useDelimiter(\"\\n\")", rate);
        writeResults(readTime, "read", fileLength, "MB", "Scanner.useDelimiter(\"\\n\")", rate, results);

        startTimer = System.nanoTime();
        readBufferedReader(file);
        endTimer = System.nanoTime() - startTimer;
        readTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / readTime;
        printResults(readTime, "read", fileLength, "MB", "BufferedReader", rate);
        writeResults(readTime, "read", fileLength, "MB", "BufferedReader", rate, results);
    }

    private static void readTestsBuffer(int mbNum, File file, int mbBufferSize, PrintWriter results) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        long fileLength;
        long startTimer;
        long endTimer;
        double readTime;
        double rate;

        generateReadFileTest(mbNum * 1024 * 1024, file);

        startTimer = System.nanoTime();
        readFileReaderBuffer(file, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        readTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / readTime;
        printResults(readTime, "read", fileLength, "MB", "FileReader", mbBufferSize, "buffer",
                rate);
        writeResults(readTime, "read", fileLength, "MB", "FileReader", mbBufferSize, "buffer",
                rate, results);

        startTimer = System.nanoTime();
        readBufferedReaderBuffer(file, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        readTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / readTime;
        printResults(readTime, "read", fileLength, "MB", "BufferedReader", mbBufferSize, "buffer",
                rate);
        writeResults(readTime, "read", fileLength, "MB", "BufferedReader", mbBufferSize, "buffer",
                rate, results);

        startTimer = System.nanoTime();
        readFileChannel(raf, mbBufferSize * 1024 * 1024);
        endTimer = System.nanoTime() - startTimer;
        readTime = endTimer / 1e9;
        fileLength = file.length() >> 20;
        rate = fileLength / readTime;
        printResults(readTime, "read", fileLength, "MB", "FileChannel", mbBufferSize, "buffer",
                rate);
        writeResults(readTime, "read", fileLength, "MB", "FileChannel", mbBufferSize, "buffer",
                rate, results);
    }

    private static void generateReadFileTest(int dataSize, RandomAccessFile raf) throws IOException {
        FileChannel fileChannel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(2048);
        char[] chars = new char[1024];
        int bufClearNum = dataSize / 2048;
        Arrays.fill(chars, 'ӣ');
        chars[1023] = '\n';
        for (int i = 0; i < bufClearNum; i++) {
            buffer.clear();
            for (int j = 0; j < 1024; j++) {
                buffer.putChar(chars[j]);
            }
            buffer.flip();
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
        }
        fileChannel.close();
    }

    private static void generateReadFileTest(int dataSize, File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        char[] chars = new char[1023];
        Arrays.fill(chars, 'ӣ');
        for (int i = 0; i < dataSize / 2048; i++) {
            writer.println(chars);
        }
        writer.close();
    }

    private static void readScannerLine(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        scanner.close();
    }

    private static void readScannerDelim(File file) throws IOException {
        Scanner scanner = new Scanner(file).useDelimiter("\n");
        while (scanner.hasNext()) {
            scanner.next();
        }
        scanner.close();
    }

    private static void readBufferedReader(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null);
        reader.close();
    }

    private static void readBufferedReaderBuffer(File file, int bufferSize) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file), bufferSize);
        while (reader.readLine() != null);
        reader.close();
    }

    private static void readFileReader(File file) throws IOException {
        FileReader reader = new FileReader(file);
        while (reader.read() != -1);
        reader.close();
    }

    private static void readFileReaderBuffer(File file, int bufferSize) throws IOException {
        FileReader reader = new FileReader(file);
        char[] buffer = new char[bufferSize / 2];
        while(reader.read(buffer) != -1);
        reader.close();
    }

    private static void readFileChannel(RandomAccessFile raf, int bufferSize) throws IOException {
        FileChannel fileChannel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);
        int bytesRead = 0;
        while (bytesRead != -1) {
            bytesRead = fileChannel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                buffer.getChar();
            }
            buffer.clear();
        }
        fileChannel.close();
    }
}
