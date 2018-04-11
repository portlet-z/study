package com.portlet.concurrent.basis;

import lombok.extern.slf4j.Slf4j;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author: 张新征
 * @date: 2018/4/3 下午1:48
 */
@Slf4j
public class Piped {
    public static void main(String[] args) throws Exception{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输出流和输入流进行连接，否则使用时会抛出IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1){
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }

    static class Print implements Runnable{
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1){
                    log.info("{}",(char) receive);
                }
            }catch (Exception e){

            }
        }
    }
}
