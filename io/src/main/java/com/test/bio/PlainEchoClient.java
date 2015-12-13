package com.test.bio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class PlainEchoClient {
    public static void main(String args[]) throws Exception {
        for (int i = 0; i < 1; i++) {// i,20
            startClientThread(i + "name");
        }
    }

    private static void startClientThread(String name) throws UnknownHostException, IOException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    startClient();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, name);
        t.start();
    }

    private static void startClient() throws UnknownHostException, IOException {
        long beforeTime = System.nanoTime();
        String host = "127.0.0.1";
        int port = 8080;
        Socket client = new Socket(host, port);
        // 建立连接后就可以往服务端写数据了
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("Hello Server. from: " + Thread.currentThread().getName());
        writer.flush();
        // 写完以后进行读操作
        Reader reader = new InputStreamReader(client.getInputStream());
        char chars[] = new char[64];// 假设所接收字符不超过64位，just for demo
        int len = reader.read(chars);
        StringBuffer sb = new StringBuffer();
        sb.append(new String(chars, 0, len));
        System.out.println("From server: " + sb);
        writer.close();
        reader.close();
        client.close();
        System.out.println("Client use time: " + (System.nanoTime() - beforeTime) + " ns");
    }
}

