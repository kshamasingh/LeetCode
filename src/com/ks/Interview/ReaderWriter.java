package com.ks.Interview;

import java.io.*;


class TestClass {
    public static void main(String[] args) throws IOException {

        long preProsArr[] = preprocessingOnNumber();

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        ReaderTest rs = new ReaderTest();

        int T = rs.nextInt();
        assert (1 <= T && T <= 1000000);
        for (int t_i = 0; t_i < T; t_i++) {
            int l = rs.nextInt();
            int r = rs.nextInt();
            output.write(preProsArr[r] - preProsArr[l - 1] + "\n");
        }
        output.flush();
    }

    static boolean checkNumber(int u) {
        int cnt = 40;
        while (cnt > 0 && u != 4) {
            int ans = 0;
            while (u > 0) {
                ans += (u % 10) * (u % 10);
                u /= 10;
            }
            u = ans;
            cnt--;
            if (u == 1)
                return true;
        }
        return false;
    }

    static long[] preprocessingOnNumber() {
        long preProsArr[] = new long[1000005];
        for (int num = 1; num <= 1000000; num++) {
            if (checkNumber(num)) {
                preProsArr[num] = num;
            }
        }
        for (int num = 1; num <= 1000000; num++) {
            preProsArr[num] += preProsArr[num - 1];
        }
        return preProsArr;
    }
}

class ReaderTest {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public ReaderTest() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }
}
