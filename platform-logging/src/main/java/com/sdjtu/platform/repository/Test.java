package com.sdjtu.platform.repository;

import java.io.IOException;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-13 10:27
 */
public class Test {

    public int methodA() throws IOException{
        System.out.println("A");
        throw new IOException();
    }
    public static void main(String[] args) {

        Test tes = new Test();

        try {
            tes.methodA();
        }catch (IOException e) {
            System.out.println("EA");
            throw new IndexOutOfBoundsException();
        }catch (Exception e){
            System.out.println("EB");

        }finally {
            System.out.println("fina");
        }
    }
}
