package hw13.ru.otus.java.basic.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket client = serverSocket.accept();
        System.out.println("Client connected");
        printStartInfo(client);
        while(processRequest(client)) {}
    }

    public static void printStartInfo(Socket client) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        out.writeUTF("available math operations: +,-,*,/ enter exit for exit\n");
        out.writeUTF("example: 1 + 2\n");
        out.flush();
    }

    public static boolean processRequest(Socket client) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String userInput = in.readLine();
        if (Objects.equals(userInput, "exit")) {
            return false;
        }
        System.out.println("Original: " + userInput);
        String result = makeMath(userInput);
        System.out.println("Result: " + result);
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        out.writeUTF(result);
        out.flush();
        return true;
    }

    private static String makeMath(String expression) {
        String[] parts = expression.split(" ");
        if (parts.length != 3) {
            return "input error\n";
        }
        try {
            int n1 = Integer.parseInt(parts[0]);
            String operation = parts[1];
            int n2 = Integer.parseInt(parts[2]);

            if (Objects.equals(operation, "+")) {
                return (n1 + n2) + "\n";
            }
            if (Objects.equals(operation, "-")) {
                return (n1 - n2) + "\n";
            }
            if (Objects.equals(operation, "*")) {
                return (n1 * n2) + "\n";
            }
            if (Objects.equals(operation, "/")) {
                return (n1 / n2) + "\n";
            }
            return "input error\n";
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return "input error\n";
    }
}
