package com.example.jdk11experience;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class Jdk11ExperienceApplicationTests {

    @Test
    void contextLoads() {
        //本地变量类型推断
        var str = "  woshidage  ";
        boolean isBlank = str.isBlank();  //判断字符串是空白
        boolean isEmpty = str.isEmpty();  //判断字符串是否为空
        String result1 = str.strip();  //去掉空白
        String result2 = str.stripTrailing();  //去除尾部空白
        String result3 = str.stripLeading();  //去除首部空白
        String copyStr = str.repeat(2);  //复制几遍字符串
        long lineCount = str.lines().count();  //行数统计

        System.out.println(isBlank);
        System.out.println(isEmpty);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(copyStr);
        System.out.println(lineCount);
    }

    //同步调用
    @Test
    public void test2() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, handler);
        String body = response.body();
        System.out.println(body);
    }

    //异步调用
    @Test
    public void test3() throws IOException, InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, handler);
        HttpResponse<String> result = response.get();
        String body = result.body();
        System.out.println(body);
    }
}
