package com.example.effectivejavanote;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName Item9
 * @Description: try-with-resources 优先于 try-finally
 * @Author yann
 * @Date 2019/11/6
 * @Version V1.0
 **/
public class Item9 {

    /**
     * try-finally
     *
     * @throws FileNotFoundException
     */
    public void readFileBeforeJava7() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("test"));
            System.out.println(inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * try-with-resources
     * <p>
     * Format:
     * try( ...resource... ){
     * ...
     * }
     * <p/>
     *
     * @throws FileNotFoundException
     */
    public void readFileAfterJava7() {
        try (FileInputStream inputStream = new FileInputStream(new File("test"))) {
            System.out.println(inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
